
function listo()
{
console.log("Inicializar app...");
}

function mascara(d, sep, nums) {
	var pat = new Array(2, 2, 4);
	var pat2 = new Array(1, 3, 3, 3, 3);
	var s = 0;
	var r = 0;
	var q = 0;
	if (d.valant != d.value) {
		val = d.value;
		largo = val.length;
		val = val.split(sep);
		val2 = '';
		for (r = 0; r < val.length; r++) {
			val2 += val[r];
		}
		if (nums) {
			for (z = 0; z < val2.length; z++) {
				if (isNaN(val2.charAt(z))) {
					letra = new RegExp(val2.charAt(z), "g");
					val2 = val2.replace(letra, "");
				}
			}
		}
		val = '';
		val3 = new Array();
		for (s = 0; s < pat.length; s++) {
			val3[s] = val2.substring(0, pat[s]);
			val2 = val2.substr(pat[s]);
		}
		for (q = 0; q < val3.length; q++) {
			if (q == 0) {
				val = val3[q];
			} else {
				if (val3[q] != "") {
					val += sep + val3[q];
				}
			}
		}
		d.value = val;
		d.valant = val;
	}
}


$(document).ready(function() {
 
	//$("#telefono").mask("(999) 999-999");	
	// validate signup form on keyup and submit
	$("#comprarTarjeta").validate({
		rules: {
			tarjeta: "required",
			marca: "required",
			nombre: "required",
			ciudad:"required",
			telefono:"required",
			fecha:"requiered" ,
			digito: {
				required: true,
				minlength: 1, 
				maxlength:4
			},
			
		},
		messages: {
			tarjeta: "Ingrese Tarjeta",
			marca: "Ingrese Marca",
			calle: "Ingrese su Direcion",
			ciudad: "Ingrese la Ciudad",
			fecha:"Ingrese Fecha",
			digito: {
				required: "Por favor ingrese el digito verificador",
				minlength: "Debe 4 contener digitos",
				maxlength: "Debe al menos un digitos"	
			},
			
		}
	});
	
	
	
		
});

var form = $('#comprarTarjeta');
form.submit(function () {
 
$.ajax({
type: form.attr('method'),
url: form.attr('action'),
data: form.serialize(),
success: function (data) {
var result=data;
$('#result').attr("value",result);
 
}
});

});
/*
$("#completar").click(function() {

	 var datos ={tarjeta : $("#tarjeta").val(),fecha : $("#fecha").val(),
				marca : $("#marca").val(),digito : $("#digito").val(),nombre : $("#nombre").val(),
				calle : $("#calle").val(),pais : $("#pais").val(),ciudad : $("#ciudad").val(),
				observacion : $("#observacion").val(),telefono : $("#telefono").val()	};
	$.ajax( {
	   
		url: "grabarCarrito?",
		type: "POST",
		 datatype: "text",
		contentType: "application/json; charset=utf-8",
		data: datos ,
		success: function(data) {
		    var lista = data;
		console.log('lista ' + lista);
							
		 if (data.success == true){
			         $('#mensaje').html(data);
			      }
			     else{
			         $('#mensaje').html(data);
			 }
			 		
	}
	} );
	
	return false;
});

*/