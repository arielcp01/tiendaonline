<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de productos</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" href="jqwidgets/styles/jqx.base.css"
	type="text/css" />
<script type="text/javascript" src="scripts/jquery-1.10.1.js"></script>
<script type="text/javascript" src="scripts/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="jqwidgets/jqxcore.js"></script>
<script type="text/javascript" src="jqwidgets/jqxdata.js"></script>
<script type="text/javascript" src="jqwidgets/jqxbuttons.js"></script>
<script type="text/javascript" src="jqwidgets/jqxscrollbar.js"></script>
<script type="text/javascript" src="jqwidgets/jqxmenu.js"></script>
<script type="text/javascript" src="jqwidgets/jqxgrid.js"></script>
<script type="text/javascript" src="jqwidgets/jqxgrid.edit.js"></script>
<script type="text/javascript" src="jqwidgets/jqxgrid.selection.js"></script>
<script type="text/javascript" src="jqwidgets/jqxgrid.aggregates.js"></script>
<script type="text/javascript" src="jqwidgets/jqxcheckbox.js"></script>
<script type="text/javascript" src="jqwidgets/jqxdropdownlist.js"></script>
<script type="text/javascript" src="jqwidgets/jqxnumberinput.js"></script>
<script type="text/javascript" src="jqwidgets/jqxwindow.js"></script>
<script type="text/javascript" src="jqwidgets/jqxlistbox.js"></script>
<script type="text/javascript" src="jqwidgets/jqxcombobox.js"></script>
<script type="text/javascript" src="jqwidgets/jqxinput.js"></script>
<script type="text/javascript" src="scripts/gettheme.js"></script>
<script type="text/javascript" src="./js/generatedata.js"></script>
<script>
	$(document).ready(function() {

		$("#actualizar").click(function() {
			//console.log("Entra actualizar el click");
			cargarDatos();

		});

		$("#eliminar").click(function() {
			console.log("Eliminar a el click");
			eliminaDatos();

		});
	});
</script>

</head>

<body class='default' onload="cargarDatos();">

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
				<div id='detallecompra'>
					<table id="productos">
						<tr>
							<td colspan="5" align="left"><a href="#"><img
									alt="Actualizar" id="actualizar" src="img/actualizar.png"
									width=70 height="80"></a></td>
						</tr>
					</table>
				</div>

				<table id="gridUsuarios" align="center">
					<tr>
						<td>
							<div id='jqxWidget'>
								<div id="grid"></div>
							</div>
							<div id="popupWindow" style.display=" ">
								<div>Mantenimiento</div>
								<div style="overflow: hidden;">
									<table>
										<tr>
											<td align="right">Orden Nro:</td>
											<td align="left"><input id="orden" /></td>
										</tr>
										<tr>
											<td align="right">Usuario:</td>
											<td align="left"><input id="usuario" /></td>
										</tr>
										<tr>
											<td align="right">Fecha:</td>
											<td align="left"><input id="fecha" /></td>
										</tr>
										<tr>
											<td align="right">Total:</td>
											<td align="left"><input id="total" /></td>
										</tr>
										<tr>
											<td><input type="radio" id="atendido" name="modos"
												value="A"> Atendido</td>
											<td><input type="radio" name="modos" id="completado"
												value="C"> Completado</td>
											<td><input type="radio" name="modos" id="pendiente"
												value="P"> Pendiente</td>

										</tr>
										<tr>
											<td align="left"></td>
											<td align="left"><input
												type="button" id="Eliminar" value="Eliminar" /> <input
												type="button" id="Actualizar" value="Actualizar" /></td>
											<td><input id="Cancelar" type="button" value="Cancelar" /></td>
										</tr>

									</table>
								</div>
							</div>

						</td>

					</tr>


					<tr>
						<td>
							<div id='jqxWidget'>
								<div id="jqxgrid"></div>
							</div>

						</td>
						<td></td>
					</tr>

				</table>
			</td>
		</tr>
		<tr>
		</tr>
		<tr class="blk" align="center">
			<td colspan="5">Copyright © tiendaonline.com</td>
		</tr>
	</table>

</body>
</html>