<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script src="./js/jquery.js"></script>
<script src="./js/jquery.validate.js"></script>
<script src="./js/jquery-1.5.1.js"></script>
<script src="./js/jquery.ui.core.js"></script>
<script src="./js/jquery.ui.widget.js"></script>


<script type="text/javascript" src="./js/compraTarjeta.js">
	
</script>

<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="./js/jquery-ui.css">
<style type="text/css">
body {
	font-size: 60%;
}

label {
	display: inline-block;
	width: 60px;
}

legend {
	padding: 0.5em;
}

fieldset fieldset label {
	display: block;
}

#comprarTarjeta label {
	width: 250px;
}

#comprarTarjeta label.error,#comprarTarjeta button.submit {
	margin-left: 253px;
}

#comprarTarjeta label.error {
	margin-left: 10px;
	width: auto;
	display: inline;
}
</style>
<!--
#comprarTarjeta {
	width: 500px;
}
#comprarTarjeta {
	width: 670px;
}
-->
</head>
<body>

	<form id="comprarTarjeta" name="comprarTarjeta" method="post" action="grabarCarrito" > 
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

				<h2 style="TEXT-DECORATION: underline;">FINALICE SU COMPRA</h2>
				<fieldset class="ui-widget ui-widget-content ui-corner-all">
					<legend class="ui-widget ui-widget-header ui-corner-all">Datos
						de la Tarjeta</legend>
					<table border="0">
						<td>Numero de Tarjeta:</td>
						<td><input id="tarjeta" name="tarjeta" required
							maxlength="16" /></td>

						<td>Total de la Compra</td>
						<td><c:out value="${total}" /></td>
						<tr>
						<tr>
							<td>Marca:</td>
							<td><select name="marca" id="marca" requierd>
									<option>Visa</option>
									<option>Mastercard</option>
									<option>Cabal</option>
									<option>Calve</option>
							</select></td>

						</tr>
						<tr>
							<td>Digito Verificador:</td>
							<td><input id="digito" name="digito" style="width: 36px;"
								required maxlength="4" /></td>
						</tr>
						<tr>
							<td>Nombre del Plastico:</td>
							<td><input id="nombre" name="nombre" style="width: 289px;"
								required maxlength="30" /></td>
						</tr>
						<tr>
							<td>Fecha de Vencimiento:</td>
							<td><input id="fecha" name="fecha"
								onkeyup="mascara(this,'/',true)" required maxlength="10" /></td>
						</tr>
					</table>
				</fieldset>
				<fieldset class="ui-widget ui-widget-content ui-corner-all">
					<legend class="ui-widget ui-widget-header ui-corner-all">Datos
						de la Entrega</legend>
					<table border="0">
						<tr>
							<td>Calle:</td>
							<td><input id="calle" name="calle" required maxlength="50"
								style="width: 387px;" /></td>
						</tr>
						<tr>
							<td>Número de Telefono:</td>
							<td><input id="telefono" name="telefono" required /></td>
						</tr>
						<tr>
							<td>Pais:</td>
							<td><select name="pais" id="pais">
									<option>Paraguay</option>
									<option>Argentina</option>
									<option>Brasil</option>
							</select></td>
						</tr>
						<tr>
							<td>Ciudad:</td>
							<td><input id="ciudad" name="ciudad" required maxlength="50" /></td>
						</tr>
						<tr>
							<td>Observacion:</td>
							<td><textarea class="ui-widget-content" id="observacion"
									name="observacion" style="width: 348px;"> </textarea>
						</tr>

					</table>

				</fieldset> <input type="submit" id="completar" name="completar" value="Completar Compra" /> 
				<td>Result</td><td><input type="text" value="" id="result"/></td>
				<a href="listaProductos">Modificar Carrito</a>
			</td>
			<tr class="blk" align="center">
				<td colspan="4">Copyright © tiendaonline.com</td>
			</tr>

		</table>


	</form>

</body>
</html>