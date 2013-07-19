package com.ejemplo.web;
public class ProductoControl {
	private String nombre;
	private Integer precio;
	private Integer cantidad;
	private String observacion;
	private Integer codigo;
	
	public ProductoControl(String nombre) {
		this.nombre = nombre;
	}

	public ProductoControl(Integer codigo,String nombre,Integer precio, Integer cantidad, String observacion) {
		this.codigo			= codigo;
		this.nombre 		= nombre;
		this.precio 		= precio;
		this.cantidad 		= cantidad;
		this.observacion 	= observacion;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre,Integer precio, Integer cantidad, String observacion ) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.observacion = observacion;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the precio
	 */
	public Integer getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
