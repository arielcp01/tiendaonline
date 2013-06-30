package com.ejemplo.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class Productos {
	EntityManagerFactory emf;
	EntityManager em;
	
	public Productos(){
		emf = Persistence.createEntityManagerFactory("my-webapp");
		em = emf.createEntityManager();
		
	}
	
	public void getProducto(){
		Producto p1 = new Producto();
		p1.getPrddsc();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.flush();
	}
	/*
	private String nombre;

	public Producto(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	*/
}
