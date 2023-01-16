<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="service.EmployeeService"%>
<%@ page import="service.EmpServiceImpl"%>
<%@ page import="model.Employee"%>

<h2>List Page:</h2>

<%
	EmployeeService e = new EmpServiceImpl();
	List<Employee> list = e.getEmployee();
%>



<h3>Employee List :: ${msg}</h3>
<table width="100%" border="1">
	<tr>
		<td>Id</td>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Salary</td>
		<td>Age</td>
		<td>Email</td>
		<td>Action</td>
		
	</tr>

	<%
		for (Employee ed : list) {
	%>

	<tr>
		<td><%=ed.getId()%></td>
		<td><%=ed.getFirstName()%></td>
		<td><%=ed.getLastName()%></td>
		<td><%=ed.getSalary()%></td>
		<td><%=ed.getAge()%></td>
		<td><%=ed.getEmail()%></td>
		<td>
		<a	href="<%=request.getContextPath()%>/actUrl?action=delete&id=<%=ed.getId()%>">Delete</a>
		<a	href="<%=request.getContextPath()%>/actUrl?action=update&id=<%=ed.getId()%>">Update</a>
		</td>
	</tr>
	<%
		}
	%>

</table>