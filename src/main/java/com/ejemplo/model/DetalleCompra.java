package com.ejemplo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the detallecompra database table.
 * 
 */
@Entity
@Table(name = "detallecompra")
@NamedQuery(name = "DetalleCompra.findAll", query = "SELECT d FROM DetalleCompra d")
public class DetalleCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DetalleCompraSequence", sequenceName = "DetalleCompraSequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DetalleCompraSequence")
	private Long id;
	private int cantidad;
	private BigDecimal total;
	
	@ManyToOne
	private Producto producto;
	
	@ManyToOne
	private OrdenCompra ordencompra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public OrdenCompra getOrdencompra() {
		return ordencompra;
	}

	public void setOrdencompra(OrdenCompra ordencompra) {
		this.ordencompra = ordencompra;
	}
	
	public Integer getProductoId() {
		return this.productoId;
	}

	public void setProductoId(Integer productoId) {
		this.productoId = productoId;
	}
}