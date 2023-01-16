<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Page</title>
</head>
<body>
<h1>Welcome</h1>
<h3>Logged In User :: <%=session.getAttribute("sun") %></h3>
<a href ="pages/add.jsp">Add Employee</a><br>
<a href ="pages/list.jsp">List Employee</a><br>
<a href ="pages/search.jsp">Search Employee</a>

</body>
</html>