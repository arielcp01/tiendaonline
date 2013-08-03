package com.ejemplo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tarjeta database table.
 * 
 */
@Entity
@Table(name = "tarjeta")
@NamedQuery(name = "Tarjeta.findAll", query = "SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "tarjetasequence", sequenceName = "tarjetasequence", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarjetasequence")
	private Long id;

	private String ciudad;

	private Integer digitoverificador;

	private String direccion;

	@Temporal(TemporalType.DATE)
	private Date fechadevencimiento;

	private String marca;

	private String nombre;

	private Long nrotarjeta;

	private String observaciones;

	private String telefono;

	//bi-directional many-to-one association to Ordencompra
	@OneToMany(mappedBy="tarjeta")
	private List<OrdenCompra> ordencompras;

	public Tarjeta() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getDigitoverificador() {
		return this.digitoverificador;
	}

	public void setDigitoverificador(Integer digito) {
		this.digitoverificador = digito;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechadevencimiento() {
		return this.fechadevencimiento;
	}

	public void setFechadevencimiento(Date fechadevencimiento) {
		this.fechadevencimiento = fechadevencimiento;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getNrotarjeta() {
		return this.nrotarjeta;
	}

	public void setNrotarjeta(Long nrotarjeta) {
		this.nrotarjeta = nrotarjeta;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<OrdenCompra> getOrdencompras() {
		return this.ordencompras;
	}

	public void setOrdencompras(List<OrdenCompra> ordencompras) {
		this.ordencompras = ordencompras;
	}

	public OrdenCompra addOrdencompra(OrdenCompra ordencompra) {
		getOrdencompras().add(ordencompra);
		ordencompra.setTarjeta(this);

		return ordencompra;
	}

	public OrdenCompra removeOrdencompra(OrdenCompra ordencompra) {
		getOrdencompras().remove(ordencompra);
		ordencompra.setTarjeta(null);

		return ordencompra;
	}

}