package com.ejemplo.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompra {
	private List<DetalleCarritoProducto> listaDetallesProductos = new ArrayList<DetalleCarritoProducto>();

	public BigDecimal getTotal() {
		BigDecimal granTotal = new BigDecimal(0);
		for (DetalleCarritoProducto detalleProducto : listaDetallesProductos) {
			BigDecimal total = detalleProducto.getTotal();
			granTotal.add(total);
		}
		return granTotal;
	}

	public void addDetalleProducto(DetalleCarritoProducto detalle) {
		listaDetallesProductos.add(detalle);
	}

	public int getCantidadProductos() {
		return listaDetallesProductos.size();
	}

	public BigDecimal getIVA() {
		BigDecimal total = getTotal();
		BigDecimal result = total.divide(new BigDecimal(11));
		return result;
	}

}
