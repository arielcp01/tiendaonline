<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="carritoCompra.js"></script>
<link rel="stylesheet" type="text/css" href="css/common.css" />

<title>Carrito de Compras</title>
</head>
<body>

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
			<td><a href="listaCarrito"><img src="img/carrito.png"></a></td>
			<td><a href="ordenDeCompra"><img
					src="img/ordenes_compra.png"></a></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<h2 align="center">Carrito de Compras</h2>

				<table>
					<tr>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Cantidad</th>
						<th>Impuesto</th>
						<th>Total</th>
						<th>Opciones</th>
					</tr>

					<c:forEach items="${listaCarrito}" var="item">
						<tr>
							<td>${item.producto.descripcion}</td>
							<td>${item.producto.precio}</td>
							<td>${item.cantidad}</td>
							<td>${item.totalImpuesto}</td>
							<td>${item.total}</td>
							<td><a href="eliminarCarrito?productoId=${item.producto.id}">Eliminar
									de Carrito</a></td>
						</tr>
					</c:forEach>
				</table> 
				<table>
					<tr>
						<td>Total</td>
						<td>${total}</td>
					</tr>
					<tr>
						<td>IVA</td>
						<td>${totalIva}</td>
					</tr>
					<tr>
						<td>Total + IVA</td>
						<td>${granTotal}</td>
					</tr>
				</table>
				<button style="visibility:${finalizarVisible}"> <a href="finalizarCompra">Finalizar Compra</a></button>
				<button> <a href="listaProductos">Continuar Comprando</a></button>
		</tr>

		<tr class="blk" align="center">
			<td colspan="4">Copyright © tiendaonline.com</td>
		</tr>
	</table>


</body>
</html>