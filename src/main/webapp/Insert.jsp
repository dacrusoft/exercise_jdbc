<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="InsertDetails" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id" maxlength="6" size="7" /></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="nombre" maxlength="30" size="25" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email" maxlength="40" size="35" /></td>
			</tr>
			<tr>
				<td>Telefono:</td>
				<td><input type="text" name="telefono" maxlength="10" size="11" /></td>
			</tr>
			<tr />
		</table>
		<br /> <input type="submit" value="Insertar Datos" />

	</form>
	<br />
	<input type="button" value="Regresar"
		onclick="window.location.href='Home.jsp'" />

</body>
</html>