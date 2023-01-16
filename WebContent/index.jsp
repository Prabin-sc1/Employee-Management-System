<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${msg}</h2>
	<form action="<%=request.getContextPath()%>/login" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password"></td>
			</tr>

			<tr>
				<td colspan ="2" align="center"><input type="submit"
					name="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>