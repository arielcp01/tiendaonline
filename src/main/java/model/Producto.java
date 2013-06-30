package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer prdid;

	private BigDecimal prdcant;

	private String prddsc;

	private byte[] prdimg;

	private BigDecimal prdiva;

	private String prdobs;

	private BigDecimal prdprice;

	//bi-directional many-to-one association to Detallecompra
	@OneToMany(mappedBy="producto")
	private List<Detallecompra> detallecompras;

	public Producto() {
	}

	public Integer getPrdid() {
		return this.prdid;
	}

	public void setPrdid(Integer prdid) {
		this.prdid = prdid;
	}

	public BigDecimal getPrdcant() {
		return this.prdcant;
	}

	public void setPrdcant(BigDecimal prdcant) {
		this.prdcant = prdcant;
	}

	public String getPrddsc() {
		return this.prddsc;
	}

	public void setPrddsc(String prddsc) {
		this.prddsc = prddsc;
	}

	public byte[] getPrdimg() {
		return this.prdimg;
	}

	public void setPrdimg(byte[] prdimg) {
		this.prdimg = prdimg;
	}

	public BigDecimal getPrdiva() {
		return this.prdiva;
	}

	public void setPrdiva(BigDecimal prdiva) {
		this.prdiva = prdiva;
	}

	public String getPrdobs() {
		return this.prdobs;
	}

	public void setPrdobs(String prdobs) {
		this.prdobs = prdobs;
	}

	public BigDecimal getPrdprice() {
		return this.prdprice;
	}

	public void setPrdprice(BigDecimal prdprice) {
		this.prdprice = prdprice;
	}

	public List<Detallecompra> getDetallecompras() {
		return this.detallecompras;
	}

	public void setDetallecompras(List<Detallecompra> detallecompras) {
		this.detallecompras = detallecompras;
	}

	public Detallecompra addDetallecompra(Detallecompra detallecompra) {
		getDetallecompras().add(detallecompra);
		detallecompra.setProducto(this);

		return detallecompra;
	}

	public Detallecompra removeDetallecompra(Detallecompra detallecompra) {
		getDetallecompras().remove(detallecompra);
		detallecompra.setProducto(null);

		return detallecompra;
	}

}