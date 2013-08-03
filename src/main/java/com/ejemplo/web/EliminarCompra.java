package com.ejemplo.web;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ejemplo.model.DetalleCompra;
import com.ejemplo.model.OrdenCompra;
import com.ejemplo.persistencia.PersistenciaCore;

/**
 * Servlet implementation class FinalizarCompra
 */

public class EliminarCompra extends HttpServlet {
	private static final String LISTA_ORDEN_JSP = "ordenDeCompra.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String persistenceUnitName = "web-app";
		// EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(persistenceUnitName);
		String idStr = request.getParameter("id");
		System.out.println("idStr" + idStr);
		if (idStr == null) {
			response.sendError(500, "Detalle id no seteado");
			return;
		}
		Long id = Long.parseLong(idStr);
			
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		OrdenCompra orden = em.find(OrdenCompra.class,id);
		List<DetalleCompra> listaDetalle = (List<DetalleCompra>) compras(id);
		//ListDetallecompra detallecompras =  orden.getDetallecompras();

		transaction.begin();

		try {
			for (int i = 0; i < listaDetalle.size(); i++) {
			     DetalleCompra detalle = listaDetalle.get(i);
			     orden.removeDetallecompra(detalle);
			   	}
			em.remove(orden);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
    	RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(LISTA_ORDEN_JSP);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	private List<DetalleCompra> compras (Long id) {
		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		OrdenCompra orden = em.find(OrdenCompra.class,id);
		 List<DetalleCompra> detallecompras =  orden.getDetallecompras();
		return detallecompras;
	}
}
