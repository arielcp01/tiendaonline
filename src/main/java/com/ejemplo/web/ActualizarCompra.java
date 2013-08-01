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
import com.ejemplo.model.Detallecompra;
import com.ejemplo.model.Ordencompra;
import com.ejemplo.persistencia.PersistenciaCore;

/**
 * Servlet implementation class FinalizarCompra
 */

public class ActualizarCompra extends HttpServlet {
	private static final String LISTA_ORDEN_JSP = "ordenDeCompra.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarCompra() {
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
		String estado = request.getParameter("estado");
		//System.out.println("idStr" + idStr + " estado " + estado);
		if (idStr == null) {
			response.sendError(500, "Detalle id no seteado");
			return;
		}
		if (estado == null) {
			response.sendError(500, "Estado no seteado");
			return;
		}
		Long id = Long.parseLong(idStr);
		//System.out.println("id " + id + " estado " + estado);
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			Ordencompra orden = em.find(Ordencompra.class,id);
			orden.setEstado(estado);
			em.merge(orden);
			em.getTransaction().commit();
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
	
}
