<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Lista de productos</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
</head>

<h1>Catalogo de productos</h1>

<table>
	<c:forEach items="${lista}" var="item">

		<tr>
			<td>Imagen1</td>
			<td>
				<table>
					<tr>
						<td>Nombre:</td>
						<td><c:out value="${item.prddsc}" /></td>
					</tr>
					<tr>
						<td>Precio:</td>
						<td>10.000</td>
					</tr>
					<tr>
						<td colspan="2">Disponible</td>
					</tr>
					<tr>
						<td colspan="2"><a href="#">Ver detalle</a></td>
					</tr>
				</table>
			</td>
		</tr>

	</c:forEach>

</table>

</html>