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
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name = "productos")
@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "productoSequence", sequenceName = "productoSequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productoSequence")
	private Integer id;

	private Integer cantidad;

	private String descripcion;

	// private byte[] prdimg;

	private BigDecimal iva;

	private String observaciones;

	private BigDecimal precio;

	// //bi-directional many-to-one association to Detallecompra
	// @OneToMany(mappedBy="producto")
	// private List<Detallecompra> detallecompras;

	public Producto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	// public Detallecompra addDetallecompra(Detallecompra detallecompra) {
	// getDetallecompras().add(detallecompra);
	// detallecompra.setProducto(this);
	//
	// return detallecompra;
	// }
	//
	// public Detallecompra removeDetallecompra(Detallecompra detallecompra) {
	// getDetallecompras().remove(detallecompra);
	// detallecompra.setProducto(null);
	//
	// return detallecompra;
	// }

}