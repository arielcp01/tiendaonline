<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de productos</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />

</head>
<body>


	<table id="top" width="500" align="center">
		<tr class="blk">
			<td colspan="4" align="center">
				<h1><img alt="tiendaOnLine" src="img/logo.png"></h1>
			</td>
		<tr class="blk"  align="center">
			<td><a href="listaProductos"><img src="img/home.png"></a></td>
			<td><a href="listaProductos"><img src="img/catalogo.png"></a></td>
			<td><a href="#"><img src="img/carrito.png"></a></td>
			<td><a href="ordenDeCompra"><img src="img/ordenes_compra.png"></a></td>
		</tr>

		<tr>
			<td colspan="4" align="center"> 
				<h2 align="center">CATALOGO DE PRODUCTOS</h2>

				<table id="productos">
					<c:forEach items="${lista}" var="item">
						<tr class="alt">
							<td rowspan="4" align="center"><img alt="${item.descripcion}" src="img/productos/${item.id}.jpg" width="120" height="100"></td>
							<td>Nombre:</td>
							<td>${item.descripcion}</td>
						</tr>
						<tr>
							<td>Precio:</td>
							<td>${item.precio}</td>
						</tr>
						<tr class="alt">
							<td>Disponible:</td>
							<td>${item.cantidad}</td>
						</tr>
						<tr>
							<td align="right" colspan="3"><a
								href="detalleProductos?productoId=${item.id}"><img alt="Detalle" src="img/detalle.png"width="30" height="30" ></a></td>
						</tr>
					</c:forEach>
				</table>

			</td>
		</tr>

		<tr class="blk" align="center">
			<td colspan="4">Copyright © tiendaonline.com</td>
		</tr>
	</table>

</body>
</html>