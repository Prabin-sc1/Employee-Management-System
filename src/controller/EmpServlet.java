package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmpServiceImpl;
import service.EmployeeService;

@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService es = new EmpServiceImpl();

	public EmpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		Integer id = Integer.parseInt(request.getParameter("id"));

		if (action.equals("delete")) {
			out.print("delete" + id);
			es.deleteEmpById(id);
			request.setAttribute("msg", "Data deleted successfully");
			RequestDispatcher rd = request.getRequestDispatcher("pages/list.jsp");
			rd.forward(request, response);
		} else if (action.equals("update")) {
			out.print("update" + id);
			Employee emp = es.getEmpById(id);
			System.out.println(emp.getId());
			request.setAttribute("empDetail", emp);
			RequestDispatcher rd = request.getRequestDispatcher("pages/edit.jsp");
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("This is add section");
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String email = request.getParameter("email");
		Integer age = Integer.parseInt(request.getParameter("age"));
		Double salary = Double.parseDouble(request.getParameter("salary"));

		Employee e = new Employee();
		e.setAge(age);
		e.setFirstName(fName);
		e.setLastName(lName);
		e.setSalary(salary);
		e.setEmail(email);

		es.saveEmp(e);

		System.out.println("Data saved from servlet...");
		request.setAttribute("msg", "Data inserted successfully");
		RequestDispatcher rd = request.getRequestDispatcher("pages/list.jsp");
		rd.forward(request, response);

	}
}
