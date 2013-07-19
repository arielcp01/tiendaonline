package com.ejemplo.terminal;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.ejemplo.model.DetalleCompra;
import com.ejemplo.model.OrdenCompra;
import com.ejemplo.model.Producto;
import com.ejemplo.model.Usuario;

public class JPACrearEstructuraBase {
	public static void main(String[] args) {
		String persistenceUnitName = "my-webapp";
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		try {
			Usuario usu1 = new Usuario();
			usu1.setNombre("Marcos");
			usu1.setPassword("12345");
			usu1.setNivel(12);

			em.persist(usu1);
			
			OrdenCompra odc = new OrdenCompra();
			odc.setCantidad(2);
			odc.setFechaDeCompra(new Date());
			odc.setTotal(new BigDecimal(10));
			odc.setUsuario(usu1);

			em.persist(odc);
			
			DetalleCompra detalle = new DetalleCompra();
			detalle.setCantidad(1);
			detalle.setTotal(new BigDecimal(10));
			
			Producto prd = new Producto();
			prd.setCantidad(1);
			prd.setDescripcion("Prueba1");
			prd.setIva(new BigDecimal(1));
			prd.setObservaciones("Observacion1");
			prd.setPrecio(new BigDecimal(10));
			
			em.persist(prd);
			
			detalle.setProducto(prd);
			detalle.setOrdencompra(odc);
			
			em.persist(detalle);

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
