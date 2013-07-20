$(document).ready(function() {
    $('#finalizar').click(function() {
        $.get('finalizarCompra', function(responseText) {
            alert(responseText);
        });
    });
});