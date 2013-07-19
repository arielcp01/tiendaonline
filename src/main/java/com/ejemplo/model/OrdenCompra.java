package com.ejemplo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ordencompra database table.
 * 
 */
@Entity
@Table(name = "ordencompra")
@NamedQuery(name = "Ordencompra.findAll", query = "SELECT o FROM OrdenCompra o")
public class OrdenCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "OrdenDeCompraSequence", sequenceName = "OrdenDeCompraSequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrdenDeCompraSequence")
	private Long id;

	private Integer cantidad;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechaDeCompra;

	private BigDecimal total;

	// bi-directional many-to-one association to Detallecompra
	
	// bi-directional many-to-one association to Tarjeta
	@ManyToOne
	private Tarjeta tarjeta;
	
	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public OrdenCompra() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaDeCompra() {
		return fechaDeCompra;
	}

	public void setFechaDeCompra(Date fechaDeCompra) {
		this.fechaDeCompra = fechaDeCompra;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	//
	// public Detallecompra addDetallecompra(Detallecompra detallecompra) {
	// getDetallecompras().add(detallecompra);
	// detallecompra.setOrdencompra(this);
	//
	// return detallecompra;
	// }
	//
	// public Detallecompra removeDetallecompra(Detallecompra detallecompra) {
	// getDetallecompras().remove(detallecompra);
	// detallecompra.setOrdencompra(null);
	//
	// return detallecompra;
	// }

}