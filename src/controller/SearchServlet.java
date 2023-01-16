package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmpServiceImpl;
import service.EmployeeService;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService s = new EmpServiceImpl();
	List<Employee> list = new ArrayList<Employee>();

	public SearchServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchName = request.getParameter("firstName");
		List<Employee> list = s.searchEmp(searchName);
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("pages/search.jsp");
		rd.forward(request, response);

	}

}
