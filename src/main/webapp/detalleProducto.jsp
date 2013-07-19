<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Detalle del producto</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />

</head>
<body>
	<form method="post" id="detalleproducto"
		action="agregarCarrito?productoId=${producto.id}">
		<table id="top" width="500" align="center">
			<tr class="blk">
				<td colspan="4" align="center">
					<h1>
						<img alt="tiendaOnLine" src="img/logo.png">
					</h1>
				</td>
			<tr class="blk" align="center">
				<td><a href="listaProductos"><img src="img/home.png"></a></td>
				<td><a href="listaProductos"><img src="img/catalogo.png"></a></td>
				<td><a href="#"><img src="img/carrito.png"></a></td>
				<td><a href="ordenDeCompra"><img
						src="img/ordenes_compra.png"></a></td>

			</tr>
			<td colspan="4" align="center">
			<table>
			<tr>
				<td><h2 align="center">PRODUCTO</h2></td>
			</tr>
			<tr>
				<td > <img alt="${producto.descripcion}"
					src="img/productos/${producto.id}.jpg" width="120" height="100">
				</td>
			</tr>
			<tr>
				<td>Codigo:</td>
				<td><c:out value="${producto.id}" /></td>
			</tr>
			<tr>
				<td>Nombre:</td>
				<td><c:out value="${producto.descripcion}" /></td>
			</tr>
			<tr>
				<td>Precio:</td>
				<td><c:out value="${producto.precio}" /></td>
			</tr>
			<tr>
				<td>Cantidad:</td>
				<td><c:out value="${producto.cantidad}" /></td>
			</tr>
			<tr>
				<td>Observacion:</td>
				<td><c:out value="${producto.observaciones}" /></td>
			</tr>
			<tr>
				<td colspan="2">Disponible</td>
				<td><SELECT id="cantidad" name="Cantidad"
					form="detalleproducto" size="0" style="height: 20px;">
						<c:forEach begin="1" end="${producto.cantidad}" varStatus="status"
							step="1">
							<OPTION>
								<c:out value="${status.count}" />
							</OPTION>
						</c:forEach>

				</SELECT></td>
			</tr>

			<tr>
				<td><input id="summit" type="submit" value="Agregar Carrito" />
				</td>
			<tr>
				<td colspan="2"><a href="listaProductos">Volver</a></td>
			</tr>
			</table>
			</td>
			<tr class="blk" align="center">
				<td colspan="4">Copyright © tiendaonline.com</td>
			</tr>
		</table>


	</form>

</body>
</html>
