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
				<form method="post" id="abmUsuario"
						action="abmUsuario?mode=INS">
					<table>
						<tr>
							<td>Nombre Usuario</td>
							<td><input type="text" id="nombre" name="nombre" /></td>
						</tr>
						<tr>
							<td>Estado</td>
							<td><select id="estado" name="estado" >
								<option value="A">Activo</option>
								<option value="I">Inactivo</option>
								<option value="B">Baja</option>
								</select>
							</td>
							<td>Nivel</td>
							<td><select id="nivel" name="nivel" >
								<c:forEach begin="1" end="9" varStatus="status"
									step="1">
									<OPTION>
										<c:out value="${status.count}" />
									</OPTION>
								</c:forEach>
								</select>
							</td>
						</tr>
					</table>
					<input type="submit" value="Cargar Usuario" >
				</form>
			</td>
		</tr>

		<tr class="blk" align="center">
			<td colspan="4">Copyright © tiendaonline.com</td>
		</tr>
	</table>

</body>
</html>