package com.ejemplo.terminal;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.ejemplo.model.OrdenCompra;
import com.ejemplo.model.Usuario;

public class JPARelacionQueryTest {
	public static void main(String[] args) {
		String persistenceUnitName = "my-webapp";
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();

		// EntityTransaction transaction = em.getTransaction();
		// transaction.begin();

		try {

			Usuario usuario = em.find(Usuario.class, 4L);

			List<OrdenCompra> ordenesDeCompras = usuario.getOrdenesDeCompras();
			for (OrdenCompra ordenCompra : ordenesDeCompras) {
				System.out.println("Orden: " + ordenCompra.getId());
			}

			Query query = em
					.createQuery("FROM OrdenCompra oc WHERE oc.usuario.id = :usuarioId");
			query.setParameter("usuarioId", 4L);
			query.setMaxResults(10);
			List<OrdenCompra> resultList = query.getResultList();

			for (OrdenCompra ordenCompra : resultList) {
				System.out.println("Orden: " + ordenCompra.getId());
			}

			// transaction.commit();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}
}
