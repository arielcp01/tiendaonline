package com.ejemplo.utils;

import java.math.BigDecimal;

import com.ejemplo.model.Producto;

public class DetalleCarritoProducto {
	private Producto producto;
	private int cantidad;

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getTotal() {
		BigDecimal precio = producto.getPrecio();
		BigDecimal total = precio.multiply(new BigDecimal(cantidad));
		return total;
	}
	
	public BigDecimal getTotalImpuesto() {
		BigDecimal iva = producto.getIva();
		BigDecimal total = iva.multiply(new BigDecimal(cantidad));
		return total;
	}

}
