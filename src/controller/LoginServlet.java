package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("password");


		if (userName.equals("ram") && pwd.equals("ram")) {
			HttpSession session = request.getSession();
			session.setAttribute("sun", userName);
			session.setAttribute("sp", pwd);
			RequestDispatcher rd = request.getRequestDispatcher("pages/menu.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg", "Invalid login");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

	}
}
