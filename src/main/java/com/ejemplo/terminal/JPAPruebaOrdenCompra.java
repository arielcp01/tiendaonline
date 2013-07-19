package com.ejemplo.terminal;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ejemplo.model.OrdenCompra;
import com.ejemplo.model.Producto;
import com.ejemplo.model.Usuario;

public class JPAPruebaOrdenCompra {
	public static void main(String[] args) {
		String persistenceUnitName = "my-webapp";
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		try {
			for (int i = 0; i < 20; i++) {
				Producto prod1 = new Producto();
				prod1.setDescripcion("prueba" + i * 10);
				em.persist(prod1);
			}

			Usuario usu1 = new Usuario();
			usu1.setNombre("Marcos");
			usu1.setPassword("12345");

			em.persist(usu1);

			usu1.setNivel(12);
			
			
			OrdenCompra odc = new OrdenCompra();
			odc.setCantidad(2);
			odc.setFechaDeCompra(new Date());
			odc.setTotal(new BigDecimal(10));

			em.persist(odc);

			List<OrdenCompra> ordenesDeCompras = usu1.getOrdenesDeCompras();
			ordenesDeCompras.add(odc);
			odc.setUsuario(usu1);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}
}
