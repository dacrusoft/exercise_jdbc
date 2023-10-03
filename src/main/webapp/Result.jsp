<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Detalle</h2>

	<form>
		<input type="hidden" name="estId"
			value="<%=request.getParameter("id")%>">

		<table>
			<tr>
				<td>ID:</td>
				<td><%=request.getParameter("id")%></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><%=request.getParameter("nombre")%></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><%=request.getParameter("email")%></td>
			</tr>
			<tr>
				<td>Teléfono:</td>
				<td><%=request.getParameter("telefono")%></td>
			</tr>
			<tr />
		</table>
		<br />
	</form>
	<br />
	<input type="button" value="Actualizar" onclick="update()" />
	<br />
	<input type="button" value="Regresar"
		onclick="window.location.href='Home.jsp'" />

</body>

<script language="javascript" type="text/javascript">
	function update() {
		var estId = document.forms[0].elements['estId'].value;
		window.location.href = "Update.jsp?id=" + estId;
	}
</script>
</html>