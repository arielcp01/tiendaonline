package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detallecompra database table.
 * 
 */
@Entity
@NamedQuery(name="Detallecompra.findAll", query="SELECT d FROM Detallecompra d")
public class Detallecompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallecompraPK id;

	private BigDecimal detcant;

	private BigDecimal detimp;

	private BigDecimal detiva;

	private BigDecimal dettot;

	//bi-directional many-to-one association to Ordencompra
	@ManyToOne
	@JoinColumn(name="comid")
	private Ordencompra ordencompra;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="prdid")
	private Producto producto;

	public Detallecompra() {
	}

	public DetallecompraPK getId() {
		return this.id;
	}

	public void setId(DetallecompraPK id) {
		this.id = id;
	}

	public BigDecimal getDetcant() {
		return this.detcant;
	}

	public void setDetcant(BigDecimal detcant) {
		this.detcant = detcant;
	}

	public BigDecimal getDetimp() {
		return this.detimp;
	}

	public void setDetimp(BigDecimal detimp) {
		this.detimp = detimp;
	}

	public BigDecimal getDetiva() {
		return this.detiva;
	}

	public void setDetiva(BigDecimal detiva) {
		this.detiva = detiva;
	}

	public BigDecimal getDettot() {
		return this.dettot;
	}

	public void setDettot(BigDecimal dettot) {
		this.dettot = dettot;
	}

	public Ordencompra getOrdencompra() {
		return this.ordencompra;
	}

	public void setOrdencompra(Ordencompra ordencompra) {
		this.ordencompra = ordencompra;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}