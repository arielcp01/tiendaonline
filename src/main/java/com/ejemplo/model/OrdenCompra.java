package com.ejemplo.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordencompra database table.
 * 
 */
@Entity
@Table(name = "ordencompra")
@NamedQuery(name = "Ordencompra.findAll", query = "SELECT o FROM Ordencompra o")

public class Ordencompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "OrdenDeCompraSequence", sequenceName = "OrdenDeCompraSequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrdenDeCompraSequence")
	private Long id;

	private Integer cantidad;

	private String estado;

	@Temporal(TemporalType.DATE)
	private Date fechadecompra;

	private BigDecimal total;

	//bi-directional many-to-one association to Detallecompra
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE },mappedBy="ordencompra")
	private List<Detallecompra> detallecompras;

	//bi-directional many-to-one association to Tarjeta
	@ManyToOne
	private Tarjeta tarjeta;
	
	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Ordencompra() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechadecompra() {
		return this.fechadecompra;
	}

	public void setFechadecompra(Date fechadecompra) {
		this.fechadecompra = fechadecompra;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<Detallecompra> getDetallecompras() {
		return this.detallecompras;
	}

	public void setDetallecompras(List<Detallecompra> detallecompras) {
		this.detallecompras = detallecompras;
	}

	public Detallecompra addDetallecompra(Detallecompra detallecompra) {
		getDetallecompras().add(detallecompra);
		detallecompra.setOrdencompra(this);

		return detallecompra;
	}

	public Detallecompra removeDetallecompra(Detallecompra detallecompra) {
		getDetallecompras().remove(detallecompra);
		detallecompra.setOrdencompra(null);

		return detallecompra;
	}

	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}