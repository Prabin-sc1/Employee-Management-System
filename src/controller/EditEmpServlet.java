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

@WebServlet("/EditEmpServlet")
public class EditEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService es = new EmpServiceImpl();
       
    public EditEmpServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("This is add section");
		Integer id = Integer.parseInt(request.getParameter("id")); 
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String email = request.getParameter("email");
		Integer age = Integer.parseInt(request.getParameter("age"));
		Double salary = Double.parseDouble(request.getParameter("salary"));

		Employee e = new Employee();
		e.setId(id);
		e.setFirstName(fName);
		e.setLastName(lName);
		e.setSalary(salary);
		e.setAge(age);
		e.setEmail(email);

		es.updateEmp(e);
		System.out.println("Data updated from servlet...");
		request.setAttribute("msg", "Data updated successfully");
		RequestDispatcher rd = request.getRequestDispatcher("pages/list.jsp");
		rd.forward(request, response);
		
	}

}
