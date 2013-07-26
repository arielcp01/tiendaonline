<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de productos</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
 <script type="text/javascript" src="./js/jquery-1.10.1.js"></script>
	<script>

	$(document).ready(function(){
   		
   		
   		$("#detalle").click(function() {
   			$.ajax( {
       			url: "detalleCompras",
       			type: "GET",
       			data: {id : $("#id").val()} ,
       			success: function(data) {
       			    var lista = data;
					var listElements = [];
					console.log('lista ' + lista.cantidad);
										
					for (var campo in lista) {
						if (lista.hasOwnProperty(campo)) {
							listElements.push("<li>" + " Pelotas "  + lista.producto_id  +  lista.total +  " "  + lista.cantidad +  + "</li>");
							console.log('lista cantidad ' + lista.cantidad);
								
						}
					}
					
	           		var listadetalle = "<ul>" + listElements.join("") + "</ul>";
	            	
	            	$("#listadetalle").html(listadetalle);
	            	return listadetalle;
	        	}
      		} );
      		
      		return false;
   		});
   });

</script>
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
			<td><a href="listaCarrito"><img src="img/carrito.png"></a></td>
			<td><a href="ordenDeCompra"><img
					src="img/ordenes_compra.png"></a></td>
		</tr>

		<tr>
			<td colspan="5" align="center">
				<h2 align="center">ORDENES DE COMPRA</h2>
				<div id='detallecompra'>
					<table id="productos">
						<tr>
							<th align="center">Orden N°</th>
							<th align="center">Usuario</th>
							<th align="center">Fecha</th>
							<th align="center">Total</th>
							<th align="center">Estado</th>
							<th align="center" colspan="2">Opciones</th>
							<th></th>
						</tr>
						<c:forEach items="${lista}" var="item">
							<tr>
								<td><input value="${item.id}" name="id" id="id"> </td>
								<td>${item.usuario.nombre}</td>
								<td>${item.fechaDeCompra}</td>
								<td align="right">${item.total}</td>
								<td></td>
								<td><input type="submit" id="detalle" name="detalle" value="Ver"></td>
								
								<td align="center"><a href="#"><img
										alt="Detalle" src="img/detalle.png" width="15" height="15"></a></td>
								<td align="center"><a href="#"><img alt="Eliminar"
										src="img/eliminar.png" width="15" height="15"></a></td>
							</tr>
						</c:forEach>
						
						<tr>
							<td colspan="5" align="left"><a href="#"><img
									alt="Actualizar" src="img/actualizar.png" width=70 height="80"></a></td>
						</tr>
					</table>
				</div>
				<table id="top" align="center">
					<tr>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Cantidad</th>
						<th>Total</th>
					</tr>
					
					<c:forEach items="${listadetalle}" var="item2">
						<tr>
							<td>Nombre</td>
							<td>Precio</td>
							<td align="right">${item2.cantidad}</td>
							<td align="right">${item2.total}</td>
						</tr>
					</c:forEach>
					<!--  
					
					<tr>
						<td>
						 <div id="listadetalle"></div>
						 </td>
						 </tr>
						 -->
				</table>
			</td>
		</tr>
		<tr class="blk" align="center">
			<td colspan="5">Copyright Â© tiendaonline.com</td>
		</tr>
	</table>

</body>
</html>