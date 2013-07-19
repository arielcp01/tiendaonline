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
			granTotal = granTotal.add(total);
		}
		return granTotal;
	}
	
	public BigDecimal getTotalIva() {
		BigDecimal granTotal = new BigDecimal(0);
		for (DetalleCarritoProducto detalleProducto : listaDetallesProductos) {
			BigDecimal total = detalleProducto.getTotalImpuesto();
			granTotal = granTotal.add(total);
		}
		return granTotal;
	}

	public void addDetalleProducto(DetalleCarritoProducto detalle) {
		listaDetallesProductos.add(detalle);
	}
	
	public void setListaDetallesProductos(List<DetalleCarritoProducto> lista) {
		listaDetallesProductos = lista;
	}
	
	public void updDetalleProducto(DetalleCarritoProducto detalle) {
		for (DetalleCarritoProducto listaProductos : listaDetallesProductos) {
			if( detalle.getProducto().getId()==listaProductos.getProducto().getId()){
				listaDetallesProductos.remove(detalle);
			}
		}
	}
	
	public List<DetalleCarritoProducto> getProductos() {
		return listaDetallesProductos;
	}

	public int getCantProducto() {
		int cant = 0;
		int total = 0;
		for (DetalleCarritoProducto listaProductos : listaDetallesProductos) {
			cant = listaProductos.getCantidad();
			total = total + cant;
		}
		return total;

	}
	public void removeProducto(List<DetalleCarritoProducto> listaDetallesProductos ){
		   listaDetallesProductos.removeAll(listaDetallesProductos);
	}

	public int getCantTotal() {
		BigDecimal cant = null;
		int total = 0;
		for (DetalleCarritoProducto listaProductos : listaDetallesProductos) {
			cant = listaProductos.getTotal();
			total = total + cant.intValue();
		}
		return total;
	}
}
