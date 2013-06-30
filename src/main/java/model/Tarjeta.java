package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tarjeta database table.
 * 
 */
@Entity
@NamedQuery(name="Tarjeta.findAll", query="SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long tarnro;

	private BigDecimal paisid;

	private String tarcalle;

	private String tarciu;

	private BigDecimal tardig;

	@Temporal(TemporalType.DATE)
	private Date tarfchven;

	private String tarmar;

	private String tarnom;

	private String tarobs;

	private String tartel;

	//bi-directional many-to-one association to Ordencompra
	@OneToMany(mappedBy="tarjeta")
	private List<Ordencompra> ordencompras;

	public Tarjeta() {
	}

	public long getTarnro() {
		return this.tarnro;
	}

	public void setTarnro(long tarnro) {
		this.tarnro = tarnro;
	}

	public BigDecimal getPaisid() {
		return this.paisid;
	}

	public void setPaisid(BigDecimal paisid) {
		this.paisid = paisid;
	}

	public String getTarcalle() {
		return this.tarcalle;
	}

	public void setTarcalle(String tarcalle) {
		this.tarcalle = tarcalle;
	}

	public String getTarciu() {
		return this.tarciu;
	}

	public void setTarciu(String tarciu) {
		this.tarciu = tarciu;
	}

	public BigDecimal getTardig() {
		return this.tardig;
	}

	public void setTardig(BigDecimal tardig) {
		this.tardig = tardig;
	}

	public Date getTarfchven() {
		return this.tarfchven;
	}

	public void setTarfchven(Date tarfchven) {
		this.tarfchven = tarfchven;
	}

	public String getTarmar() {
		return this.tarmar;
	}

	public void setTarmar(String tarmar) {
		this.tarmar = tarmar;
	}

	public String getTarnom() {
		return this.tarnom;
	}

	public void setTarnom(String tarnom) {
		this.tarnom = tarnom;
	}

	public String getTarobs() {
		return this.tarobs;
	}

	public void setTarobs(String tarobs) {
		this.tarobs = tarobs;
	}

	public String getTartel() {
		return this.tartel;
	}

	public void setTartel(String tartel) {
		this.tartel = tartel;
	}

	public List<Ordencompra> getOrdencompras() {
		return this.ordencompras;
	}

	public void setOrdencompras(List<Ordencompra> ordencompras) {
		this.ordencompras = ordencompras;
	}

	public Ordencompra addOrdencompra(Ordencompra ordencompra) {
		getOrdencompras().add(ordencompra);
		ordencompra.setTarjeta(this);

		return ordencompra;
	}

	public Ordencompra removeOrdencompra(Ordencompra ordencompra) {
		getOrdencompras().remove(ordencompra);
		ordencompra.setTarjeta(null);

		return ordencompra;
	}

}