package com.ejemplo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


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
	private Date fechadecompra;

	private BigDecimal total;

	//bi-directional many-to-one association to Detallecompra
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE },mappedBy="ordencompra")
	private List<DetalleCompra> detallecompras;

	//bi-directional many-to-one association to Tarjeta
	@ManyToOne
	private Tarjeta tarjeta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

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

	public Date getFechaDeCompra() {
		return this.fechadecompra;
	}

	public void setFechaDeCompra(Date fechadecompra) {
		this.fechadecompra = fechadecompra;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<DetalleCompra> getDetallecompras() {
		return this.detallecompras;
	}

	public void setDetallecompras(List<DetalleCompra> detallecompras) {
		this.detallecompras = detallecompras;
	}

	public DetalleCompra addDetallecompra(DetalleCompra detallecompra) {
		getDetallecompras().add(detallecompra);
		detallecompra.setOrdencompra(this);

		return detallecompra;
	}

	public DetalleCompra removeDetallecompra(DetalleCompra detallecompra) {
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