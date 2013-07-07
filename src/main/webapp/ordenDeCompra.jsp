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
			<td><a href="#"><img src="img/carrito.png"></td>
			<td><a href="ordenDeCompra"><img src="img/ordenes_compra.png"></a></td>
		</tr>

		<tr>
			<td colspan="4" align="center"> 
				<h2 align="center">ORDENES DE COMPRA</h2>

				<table id="productos">
					<tr class="alt">
							<td><h4>Orden N°</h4></td>
							<td><h4>Usuario</h4></td>
							<td><h4>Fecha</h4></td>
							<td><h4>Total</h4></td>
							<td><h4>Estado</h4></td>
							<td><h4>Opciones</h4></td>
					</tr>
					<c:forEach items="${lista}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.usuario.nombre}</td>
							<td>${item.fechaDeCompra}</td>
							<td>${item.total}</td>
							<td></td>
							<td></td>
							<td><a href="#"><img alt="Detalle" src="img/detalle.png" width="15" height="15"></a>
							<a href="#"><img alt="Eliminar" src="img/eliminar.png" width="15" height="15"></a>
							</td>
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