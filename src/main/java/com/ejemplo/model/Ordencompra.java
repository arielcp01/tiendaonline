package com.ejemplo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordencompra database table.
 * 
 */
@Entity
@NamedQuery(name="Ordencompra.findAll", query="SELECT o FROM Ordencompra o")
public class Ordencompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer comid;

	private BigDecimal comcant;

	private String comest;

	@Temporal(TemporalType.DATE)
	private Date comfch;

	private String comip;

	private String comses;

	private BigDecimal comtot;

	private BigDecimal comtotiva;

	private Time hora;

	//bi-directional many-to-one association to Detallecompra
	@OneToMany(mappedBy="ordencompra")
	private List<Detallecompra> detallecompras;

	//bi-directional many-to-one association to Tarjeta
	@ManyToOne
	@JoinColumn(name="tarnro")
	private Tarjeta tarjeta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usrid")
	private Usuario usuario;

	public Ordencompra() {
	}

	public Integer getComid() {
		return this.comid;
	}

	public void setComid(Integer comid) {
		this.comid = comid;
	}

	public BigDecimal getComcant() {
		return this.comcant;
	}

	public void setComcant(BigDecimal comcant) {
		this.comcant = comcant;
	}

	public String getComest() {
		return this.comest;
	}

	public void setComest(String comest) {
		this.comest = comest;
	}

	public Date getComfch() {
		return this.comfch;
	}

	public void setComfch(Date comfch) {
		this.comfch = comfch;
	}

	public String getComip() {
		return this.comip;
	}

	public void setComip(String comip) {
		this.comip = comip;
	}

	public String getComses() {
		return this.comses;
	}

	public void setComses(String comses) {
		this.comses = comses;
	}

	public BigDecimal getComtot() {
		return this.comtot;
	}

	public void setComtot(BigDecimal comtot) {
		this.comtot = comtot;
	}

	public BigDecimal getComtotiva() {
		return this.comtotiva;
	}

	public void setComtotiva(BigDecimal comtotiva) {
		this.comtotiva = comtotiva;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
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