<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de productos</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />

</head>
<body>


	<table id="top" width="500" align="center">
		<tr class="blk">
			<td colspan="5" align="center">
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

		<tr>
			<td colspan="5" align="center">
				<h2 align="center">ORDENES DE COMPRA</h2>

				<table id="productos">
					<tr>
						<th>Orden N°</th>
						<th>Usuario</th>
						<th>Fecha</th>
						<th>Total</th>
						<th>Estado</th>
						<th colspan="2">Opciones</th>
						<th></th>
					</tr>
					<c:forEach items="${lista}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.usuario.nombre}</td>
							<td>${item.fechaDeCompra}</td>
							<td>${item.total}</td>
							<td></td>
							<td></td>
							<td><a href="#"><img alt="Detalle" src="img/detalle.png"
									width="15" height="15"></a></td>
							<td><a href="#"><img alt="Eliminar"
									src="img/eliminar.png" width="15" height="15"></a></td>
						</tr>
					</c:forEach>
					<tr>
						<td align="right"><a href="#"><img alt="Actualizar"
								src="img/actualizar.png" width=70 height="80"></a></td>
					</tr>
				</table>
				<table id="top" align="center">
					<tr>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Cantidad</th>
					<th>Total</th>
					</tr>
					<c:forEach items="${listadetalle}" var="item2">
					<tr>
						<td>${item2.producto.descripcion}</td>

					</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr class="blk" align="center">
			<td colspan="5">Copyright © tiendaonline.com</td>
		</tr>
	</table>

</body>
</html>