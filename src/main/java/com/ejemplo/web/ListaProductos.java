package com.ejemplo.web;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejemplo.model.Producto;
import com.ejemplo.persistencia.*;


/**
 * Servlet implementation class ProductoController
 */
public class ListaProductos extends HttpServlet {
	private static final String LISTA_PRODUCTOS_JSP = "listaProductos.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ListaProductos() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Obtener la lista de productos
		List<Producto> listaProductos = cargarListaProductos();
		// Agregar la lista cargada como un atributo
		request.setAttribute("lista", listaProductos);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(LISTA_PRODUCTOS_JSP);
		requestDispatcher.forward(request, response);

	}
	
	@SuppressWarnings("unchecked")
	private List<Producto> cargarListaProductos() {
		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		List<Producto> resultList = null;
		try{
			Query query = em.createQuery("FROM " + Producto.class.getName());
			resultList = query.getResultList();
		} finally {
			if(em != null){
				em.close();
			}
		}
		return resultList;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
