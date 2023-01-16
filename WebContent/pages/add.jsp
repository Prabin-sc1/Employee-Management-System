<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add</title>
</head>
<body>
	<h2>Add Employee:</h2>
	<h2>${msg}</h2>
	<form action="<%=request.getContextPath()%>/addEmpUrl" method="post">
		<table>
			<tr>
				<td>First name</td>
				<td><input type="text" name="fname"></td>
			</tr>

			<tr>
				<td>Last name</td>
				<td><input type="text" name="lname"></td>
			</tr>

			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary"></td>
			</tr>

			<tr>
				<td>Age</td>
				<td><input type="text" name="age"></td>
			</tr>

			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>

			<tr>

				<td colspan="2" align="right"><input type="submit"
					name="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>