package com.ejemplo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the tarjeta database table.
 * 
 */
@Entity
@NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "tarjetaSequence", sequenceName = "tarjetaSequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarjetaSequence")
	private Long id;

	private String direccion;

	private String ciudad;

	private BigDecimal digitoVerificador;

	@Temporal(TemporalType.DATE)
	private Date fechaDeVencimiento;

	private String marca;

	private String nombre;

	private String observaciones;

	private String telefono;

//	// bi-directional many-to-one association to Ordencompra
//	@OneToMany(mappedBy = "tarjeta")
//	private List<Ordencompra> ordencompras;

	public Tarjeta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public BigDecimal getDigitoVerificador() {
		return digitoVerificador;
	}

	public void setDigitoVerificador(BigDecimal digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}

	public Date getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(Date fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	// public Ordencompra addOrdencompra(Ordencompra ordencompra) {
	// getOrdencompras().add(ordencompra);
	// ordencompra.setTarjeta(this);
	//
	// return ordencompra;
	// }
	//
	// public Ordencompra removeOrdencompra(Ordencompra ordencompra) {
	// getOrdencompras().remove(ordencompra);
	// ordencompra.setTarjeta(null);
	//
	// return ordencompra;
	// }

}