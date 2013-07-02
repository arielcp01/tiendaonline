package com.ejemplo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String usrid;

	private String usrest;

	private BigDecimal usrnivel;

	private String usrnom;

	private String usrpass;

	//bi-directional many-to-one association to Ordencompra
	@OneToMany(mappedBy="usuario")
	private List<Ordencompra> ordencompras;

	public Usuario() {
	}

	public String getUsrid() {
		return this.usrid;
	}

	public void setUsrid(String usrid) {
		this.usrid = usrid;
	}

	public String getUsrest() {
		return this.usrest;
	}

	public void setUsrest(String usrest) {
		this.usrest = usrest;
	}

	public BigDecimal getUsrnivel() {
		return this.usrnivel;
	}

	public void setUsrnivel(BigDecimal usrnivel) {
		this.usrnivel = usrnivel;
	}

	public String getUsrnom() {
		return this.usrnom;
	}

	public void setUsrnom(String usrnom) {
		this.usrnom = usrnom;
	}

	public String getUsrpass() {
		return this.usrpass;
	}

	public void setUsrpass(String usrpass) {
		this.usrpass = usrpass;
	}

	public List<Ordencompra> getOrdencompras() {
		return this.ordencompras;
	}

	public void setOrdencompras(List<Ordencompra> ordencompras) {
		this.ordencompras = ordencompras;
	}

	public Ordencompra addOrdencompra(Ordencompra ordencompra) {
		getOrdencompras().add(ordencompra);
		ordencompra.setUsuario(this);

		return ordencompra;
	}

	public Ordencompra removeOrdencompra(Ordencompra ordencompra) {
		getOrdencompras().remove(ordencompra);
		ordencompra.setUsuario(null);

		return ordencompra;
	}

}