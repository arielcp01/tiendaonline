function mostrar() {

div = document.getElementById("popupWindow");

div.style.display="none";

}
function obtenerDatos(rowscount, listas, hasNullValues) {
	// prepare the data
	var data = new Array();
	var lista = listas;
	// var listElements = [];
	rowscount = lista.length;
	if (rowscount == undefined)
		rowscount = 4;
	//console.log('Listas Obtener Datos ' + lista);

	for ( var i = 0; i < rowscount; i++) {
		console.log(lista[i].producto_id);
		console.log(lista[i].nombre);
		var row = {};
	    var precio = parseFloat(lista[i].precio);
		var cantida = parseFloat(lista[i].cantidad);
		var producto = parseFloat(lista[i].producto_id);
		var total = parseFloat(lista[i].total);
		var nombre = lista[i].nombre;
		row["id"] = i;
		row["producto"] = producto;
		row["nombre"] = nombre;
		row["cantidad"] = cantida;
		row["precio"] = precio;
		row["total"] = total;
		data[i] = row;
		
	}

	return data;
}

function tomarDatos(id) {
	//var id = $("#id").val();
	var identifcador = id;
	//console.log("Tomamos el dato" + id);
	$.ajax({
		url : "detalleCompras",
		type : "GET",
		data : {
			id : identifcador //$("#id").val()
		},
		success : function(dato) {
			// var lista = dato;
			cargaGrilla(dato);
		}
	});

}

function eliminaDatos(id) {
	//console.log("Eliminamos el dato");
	var identifcador = id;
	$.ajax({
		url : "eliminarCompra",
		type : "GET",
		data : {
			id : identifcador //$("#id").val()
		},
		success : function(dato) {
		}
	});

}

function actualizarDatos(id,esta) {
	//console.log("Actualizamos el Estado de la compra");
	var identificador = id;
	var estado		 = esta;
	$.ajax({
		url : "actualizarCompra",
		type : "GET",
		data : {
			id : identificador, //$("#id").val()
			estado: estado
		},
		success : function(dato) {
		}
	});

}

function cargaGrilla(lista) {
	//console.log("Entramos a cargar Grilla " + lista);
	var theme = getDemoTheme();
	// my comment
	// prepare the data
	// var data = generatedata(4,lista);
	var data = obtenerDatos(4, lista);
	var source = {
		localdata : data,
		datatype : "array",
		datafields : [ {
			name : 'producto',
			type : 'string'
		}, {
			name : 'nombre',
			type : 'string'
		}, {
			name : 'precio',
			type : 'number'
		}, {
			name : 'cantidad',
			type : 'number'
		}, {
			name : 'total',
			type : 'number'
		},

		],
		updaterow : function(rowid, rowdata) {
			// synchronize with the server - send update command
		}
	};

	var dataAdapter = new $.jqx.dataAdapter(source);

	// initialize jqxGrid
	$("#jqxgrid").jqxGrid({
		width : 650,
		autoheight: true,
		source : dataAdapter,
		theme : theme,
		showstatusbar : true,
		statusbarheight : 50,
		editable : true,
		showaggregates : true,
		selectionmode : 'singlecell',
		columns : [ {
			text : 'Nombre del Producto',
			columntype : 'textbox',
			datafield : 'nombre',
			width : 200
		}, {
			text : 'Precio',
			datafield : 'precio',
			columntype : 'textbox',
			width : 90
		}, {
			text : 'Cantidad',
			datafield : 'cantidad',
			width : 80,
			columntype : 'textbox'
		},  {
			text : 'Total',
			datafield : 'total',
			cellsalign : 'right',
			// cellsformat : 'c2',
			aggregates : [ 'sum' ]
		} ]
	});

}

function Datos(lista) {
	var data = new Array();
	var rowscount = lista.length;
	// var rowscount = 10;
	//console.log('Cantidad ' + rowscount);
	for ( var i = 0; i < rowscount; i++) {
		//console.log("ID " + lista[i].id);
		var row = {};
		var id = parseFloat(lista[i].id);
		var usuario = lista[i].nombre;
		var fecha = lista[i].fecha;
		var total = parseFloat(lista[i].total);
		var estado = lista[i].estado;
		var atendido = lista[i].atendido;
		var completado  = lista[i].completado;
		
		//console.log("ID identifcado  " + id + " fecha " + fecha + " estado "
		//		+ estado);
		//console.log("atendido  " + atendido + " completado " + completado );
		row["id"] = i;
		row["orden"] = id;
		row["usuario"] = usuario;
		row["fecha"] = fecha;
		row["total"] = total;
		//row["estado"] = estado;
		if (atendido  === "A" ) {
	           row["atendido"] = true;
			}else{
				 row["atendido"] = false;
	        }
		
		if (completado  === "C" ) {
           row["completado"] = true;
		}else{
			 row["completado"] = false;
        }
		data[i] = row;		
	}

	return data;
}

function cargagrillas(lista) {
	
	// var data = generatedata(4,lista);
	var theme = getDemoTheme();
	var data = Datos(lista);  //obtenerDatos(4, lista);
	//console.log("Datos Cargados " + data);
	var source = {
		localdata : data,
		datatype : "array",
		datafields : [ {
			name : 'orden',
			type : 'number'
		}, {
			name : 'usuario',
			type : 'string'
		}, {
			name : 'fecha',
			type : 'string'
		}, 
//		{
//			name : 'estado',
//			type : 'string'
//		},
		{
			name : 'atendido',
			type : 'bool'
		},{
			name : 'completado',
			type : 'bool'
		},
		{
			name : 'total',
			type : 'number'
		},
		
		],
		 updaterow: function (rowid, rowdata, commit) {
             // synchronize with the server - send update command
             // call commit with parameter true if the synchronization with the server is successful 
             // and with parameter false if the synchronization failder.
             commit(true);
         },
		 deleterow: function (rowid,commit) {
             // synchronize with the server - send delete command
             // call commit with parameter true if the synchronization with the server is successful 
             //and with parameter false if the synchronization failed.
             commit(true);
         },
		
	};
	 // initialize the input fields.
    $("#orden").jqxInput({ theme: theme });
    $("#usuario").jqxInput({ theme: theme });
    $("#fecha").jqxInput({ theme: theme });
    //$("#estado").jqxInput({ theme: theme });
    $("#total").jqxInput({ theme: theme });
    
    $("#orden").width(80);
    $("#orden").height(20);
    $("#usuario").width(100);
    $("#usuario").height(20);
    $("#fecha").width(100);
    $("#fecha").height(20);
//    $("#estado").width(40);
//    $("#estado").height(20);
    $("#total").width(100);
    $("#total").height(20);
   
   	var dataAdapter = new $.jqx.dataAdapter(source);
	var editrow = -1;
	// initialize jqxGrid
	$("#grid").jqxGrid({
		width : 800,
		autoheight: true,
		source : dataAdapter,
		theme : theme,
		showstatusbar : true,
		statusbarheight : 50,
		editable : true,
		showaggregates : false,
		selectionmode : 'singlecell',
		columns : [ {
			text : 'Orden N°',
			columntype : 'textbox',
			datafield : 'orden',
			width : 200
		}, {
			text : 'Usuario',
			datafield : 'usuario',
			columntype : 'textbox',
			width : 90
		}, {
			text : 'Fecha',
			datafield : 'fecha',
			width : 80,
			columntype : 'textbox'
		}, {
			text : 'Total',
			datafield : 'total',
			
		} , 
//		{
//			text : 'Estado',
//			datafield : 'estado',
//			
//		} ,
		{
			text : 'Atendido',
			datafield : 'atendido',
			columntype : 'checkbox',
			width : 80,

		},
		{
			text : 'Completado',
			datafield : 'completado',
			columntype : 'checkbox',
			width : 80,

		},
		{ text: 'Mantenimiento', datafield: 'mantenimiento', columntype: 'button', cellsrenderer: function () {
            return "Mantenimiento";
        },
       
        buttonclick: function (row) {
           // open the popup window when the user clicks a button.
           editrow = row;
           var offset = $("#grid").offset();
           $("#popupWindow").jqxWindow({ position: { x: parseInt(offset.left) + 60, y: parseInt(offset.top) + 20 } });

           // get the clicked row's data and initialize the input fields.
           var dataRecord = $("#grid").jqxGrid('getrowdata', editrow);
           $("#orden").val(dataRecord.orden);
           $("#usuario").val(dataRecord.usuario);
           $("#fecha").val(dataRecord.fecha);
          // $("#estado").val(dataRecord.estado);
           $("#total").val(dataRecord.total);
           $("#atendido").val(dataRecord.atendido);
           $("#completado").val(dataRecord.completado);
          // $("#total").jqxNumberInput({ decimal: dataRecord.total});
           // show the popup window.
           $("#popupWindow").jqxWindow('open');
       }
       },

       ]
	});
 
	// display selected row index.
	$("#grid").on(
			'cellselect',
			function(event) {
				var columnheader = $("#grid").jqxGrid('getcolumn',
						event.args.datafield).text;
				var fila = event.args.rowindex;
				var id = jQuery('#grid').jqxGrid('getRowData', fila);   
				// console.log("seleccionado " + fila + " id " + id.orden );
				tomarDatos(id.orden);
				$("#selectedcell").text(
						"Row: " + event.args.rowindex + ", Column: "
								+ columnheader);
			});
	
	 // select a cell in the second row in the 'Last Name' column.
   // $("#grid").jqxGrid('selectcell', 1, "orden");
    
    
    // initialize the popup window and buttons.
    $("#popupWindow").jqxWindow({
        width: 350, resizable: false, theme: theme, isModal: true, autoOpen: false, cancelButton: $("#Cancelar"), modalOpacity: 0.01           
    });

    $("#popupWindow").on('open', function () {
        $("#orden").jqxInput('selectAll');
    });
    $("#Cancelar").jqxButton({ theme: theme });
    $("#Eliminar").jqxButton({ theme: theme });
    $("#Actualizar").jqxButton({ theme: theme });
    // update the edited row when the user clicks the 'Eliminar' button.
    $("#Eliminar").click(function () {
        if (editrow >= 0) {
            var row = { orden: $("#orden").val(), usuario: $("#usuario").val(), 
                fecha: $("#fecha").val(), total: $("#total").val()  };
            var rowID = $('#grid').jqxGrid('getrowid', editrow);
           // console.log("Id seleccionado " + row.orden);
            eliminaDatos(row.orden);	
            $("#grid").jqxGrid('deleterow', rowID);
            $("#popupWindow").jqxWindow('hide');
        }
    });
    $("#Actualizar").click(function () {
        if (editrow >= 0) {
        	var estado = $("#pendiente").val();
        	var complet = document.getElementById("completado");
        	if (complet.checked==true) {
        	//if($("#completado").val()=== "C"){
        		estado = "C";
        		
        	} 
        	var atendi = document.getElementById("atendido");
        	if (atendi.checked == true) {
        	   estado = "A";
        		
        	} 
        	// console.log("estado " + estado);
            var row = { orden: $("#orden").val(), usuario: $("#usuario").val(), 
                fecha: $("#fecha").val(), total: $("#total").val()
                ,atendido: $("#atendido").val(),completado: $("#completado").val(),pendiente: $("#pendiente").val() };
            var rowID = $('#grid').jqxGrid('getrowid', editrow);
            var commit=true;
           // console.log("Id seleccionado " + row.orden);
            actualizarDatos(row.orden,estado);
            cargarDatos();
            $("#grid").jqxGrid('updaterow', rowID,row, commit);
            $("#popupWindow").jqxWindow('hide');
          
        }
    });
}



function cargarDatos() {
	//console.log("Entramos a cargar Grilla " + lista);
	//mostrar();
	// prepare the data
	$.ajax({
		url : "ordenDeCompra",
		type : "POST",
		success : function(dato) {
			cargagrillas(dato);
		}

	});
//	div = document.getElementById("popupWindow");
//
//	div.style.display="";
	
};
