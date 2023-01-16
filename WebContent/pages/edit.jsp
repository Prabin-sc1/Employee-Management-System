<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add</title>
</head>
<body>
	<h2>${msg}</h2>
	<form action="<%=request.getContextPath()%>/editEmpUrl" method="post">
		<table>
			<tr>
				<td>First name</td>
				<input type="hidden" name="id" value="${empDetail.getId()}">
				<td><input type="text" name="fname"
					value="${empDetail.getFirstName()}"></td>
			</tr>

			<tr>
				<td>Last name</td>
				<input type="hidden" name="id" value="${empDetail.getId()}">
				<td><input type="text" name="lname"
					value="${empDetail.getLastName()}"></td>
			</tr>

			<tr>
				<td>Salary</td>
				<input type="hidden" name="id" value="${empDetail.getId()}">
				<td><input type="text" name="salary"
					value="${empDetail.getSalary()}"></td>
			</tr>

			<tr>
				<td>Age</td>
				<input type="hidden" name="id" value="${empDetail.getId()}">
				<td><input type="text" name="age" value="${empDetail.getAge()}"></td>
			</tr>

			<tr>
				<td>Email</td>
				<input type="hidden" name="id" value="${empDetail.getId()}">
				<td><input type="text" name="email"
					value="${empDetail.getEmail()}"></td>
			</tr>

			<tr>

				<td colspan="2" align="right"><input type="submit"
					name="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>