<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h2>Seleccione la acción que quiere realizar</h2>

	<table>
		<tr>
			<td>Para insertar</td>
			<td><input type="button" value="Agregar datos"
				onclick="window.location.href='Insert.jsp'" />
			</td>
		</tr>
		<tr>
			<td>Para Eliminar</td>
			<td><input type="button" value="Eliminar datos"
				onclick="window.location.href='Delete.jsp'" />
			</td>
		</tr>
		<tr>
			<td>Para Ver los datos</td>
			<td><input type="button" value="Ver datos"
				onclick="window.location.href='Select.jsp'" />
			</td>
		</tr>
	</table>

</body>
</html>