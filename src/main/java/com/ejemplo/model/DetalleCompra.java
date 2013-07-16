package com.ejemplo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Integer getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Integer producto_id) {
		this.producto_id = producto_id;
	}

	public Long getOrdencompra_id() {
		return ordencompra_id;
	}

	public void setOrdencompra_id(Long ordencompra_id) {
		this.ordencompra_id = ordencompra_id;
	}

	private Long cantidad;

	private BigDecimal total;
	private Integer producto_id;
	private Long ordencompra_id;

	//
	// // bi-directional many-to-one association to Ordencompra
	
}