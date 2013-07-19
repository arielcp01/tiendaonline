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
				<h2 align="center">ABM USUARIOS</h2>
				<a href="abmUsuarioDetalle?usuarioId=0&mode=INS">Agregar Nuevo Usuario</a>
				<table>
					<tr>
						<th>Id</th>
						<th>Estado</th>
						<th>Nivel</th>
						<th>Nombre</th>
						<th colspan="2">Opciones</th>
					</tr>

					<c:forEach items="${lista}" var="item">
						<tr>
							<td>${item.id}</td>
							<td>${item.estado}</td>
							<td>${item.nivel}</td>
							<td>${item.nombre}</td>
							<td><a href="abmUsuarioDetalle?usuarioId=${item.id}&mode=UPD">Modificar</a></td>
							<td><a href="abmUsuario?usuarioId=${item.id}&mode=DLT">Eliminar</a></td>
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