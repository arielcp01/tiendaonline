<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de productos</title>
<link rel="stylesheet" type="text/css" href="css/common.css"/>

</head>
<body>

<table  width="1000" border="0"  align="center">
<tr>
<td colspan="4" style="background-color:#FFA500;" align="center">
<h1>TiendaOnLine</h1>
</td>
<tr style="background-color:#FFA500;" align="center">
<td><a href="#">Home</a></td>
<td><a href="#">Catalogo</a></td>
<td><a href="#">Carrito</a></td>
<td><a href="#">Ordenes de Compra</a></td>
</tr>
</tr>

<tr>
<td colspan="4" style="background-color:#EEEEEE;height:200px;width:400px;">
<h1 align="center">Catalogo de Productos</h1>

<table align="center" width="500" border="0">
	<c:forEach items="${lista}" var="item">

		<tr>
			<td>Imagen1</td>
			<td>
				<table border="0" padding: 5px;>
					<tr>
						<td>Nombre:</td>
						<td>${item.descripcion}</td>
					</tr>
					<tr>
						<td>Precio:</td>
						<td>${item.precio}</td>
					</tr>
					<tr>
						<td>Disponible:</td>
						<td>${item.cantidad}</td>
					</tr>
					<tr>
						<td align="right" colspan="2"><a href="verProducto?productoId=${item.id}" target="contenido">Ver
								detalle</a></td>
					</tr>
				</table>
			</td>
		</tr>

	</c:forEach>
</table>

</td>
</tr>

<tr>
<td colspan="4" style="background-color:#FFA500;text-align:center;">
Copyright © tiendaonline.com</td>
</tr>
</table>

</body>
</html>