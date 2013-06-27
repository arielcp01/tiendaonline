package com.ejemplo.web.controller;

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

import com.ejemplo.model.Producto;
import com.ejemplo.persistencia.PersistenciaCore;


@WebServlet("/ProductoController")
public class ProductoController extends HttpServlet {
	private static final String LISTA_PRODUCTOS_JSP = "listaProductos.jsp";
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener la lista de productos
		List<Producto> listaProductos = cargarListaProductos();
		// Agregar la lista cargada como un atributo
		request.setAttribute("lista", listaProductos);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(LISTA_PRODUCTOS_JSP);
		requestDispatcher.forward(request, response);
	}

	private List<Producto> cargarListaProductos() {
		// Actualmente, este metodo obtiene la lista de productos directamente utilizando elk EntityManager.
		// Mas adelante debemos de definir una capa de Serivicios para abstraer el acceso a la logica de negocios
		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		Query query = em.createQuery("FROM " + Producto.class.getName());
		@SuppressWarnings("unchecked")
		List<Producto> resultList = query.getResultList();
		return resultList;
	}

}
