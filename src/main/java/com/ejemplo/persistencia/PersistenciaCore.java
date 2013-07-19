package com.ejemplo.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase singleton encargada de Configurar el EntityManagerFactory y de crear objetos EntityManager
 */
public class PersistenciaCore {

	private static PersistenciaCore instancia;
	private EntityManagerFactory emf;

	private PersistenciaCore() {
		this.emf = Persistence.createEntityManagerFactory("my-webapp");
	}

	public static PersistenciaCore getInstance() {
		if (instancia == null) {
			instancia = new PersistenciaCore();
		}
		return instancia;
	}

	public EntityManager createEntityManager() {
		return this.emf.createEntityManager();
	}

}