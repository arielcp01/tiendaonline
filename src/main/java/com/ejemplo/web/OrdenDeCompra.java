package com.ejemplo.web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejemplo.model.OrdenCompra;
import com.ejemplo.persistencia.PersistenciaCore;

/**
 * Servlet implementation class OrdenDeCompra
 */

public class OrdenDeCompra extends HttpServlet {
	private static final String LISTA_ORDEN_JSP = "ordenDeCompra.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenDeCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OrdenCompra> listaOrden = cargarOrdenCompra();
		// Agregar la lista cargada como un atributo
		request.setAttribute("lista", listaOrden);
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

	private List<OrdenCompra> cargarOrdenCompra() {
		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		Query query = em.createQuery("FROM " + OrdenCompra.class.getName());
		@SuppressWarnings("unchecked")
		List<OrdenCompra> resultList = query.getResultList();
		return resultList;
	}
}
