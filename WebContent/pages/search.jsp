<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="service.EmployeeService"%>
<%@ page import="service.EmpServiceImpl"%>
<%@ page import="model.Employee"%>


<form action="<%=request.getContextPath()%>/searchEmpUrl" method="post">
	<table>
		<tr>
			<td>Search here</td>
			<td><input type="text" name="firstName"></td>
			<td><input type="submit" name="search" value="Search"></td>
		</tr>

	</table>
</form>

<%
	List<Employee> list = (List<Employee>) request.getAttribute("list");
	//out.print(request.getAttribute("list"));
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
		if (list != null) {
			for (Employee ed : list) {
	%>

	<tr>
		<td><%=ed.getId()%></td>
		<td><%=ed.getFirstName()%></td>
		<td><%=ed.getLastName()%></td>
		<td><%=ed.getAge()%></td>
		<td><%=ed.getSalary()%></td>
		<td><%=ed.getEmail()%></td>
		<td><a
			href="<%=request.getContextPath()%>/actUrl?action=delete&id=<%=ed.getId()%>">Delete</a>
			<a
			href="<%=request.getContextPath()%>/actUrl?action=update&id=<%=ed.getId()%>">Update</a>
		</td>
	</tr>
	<%
		}
		}
	%>

</table>