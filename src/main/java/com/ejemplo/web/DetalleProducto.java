package com.ejemplo.web;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejemplo.model.Producto;
import com.ejemplo.persistencia.PersistenciaCore;

/**
 * Servlet implementation class detalleProducto
 */
public class DetalleProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DetalleProducto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// String path = "listaProductos.jsp";
		String path = "detalleProducto.jsp";
		String productoIdStr = request.getParameter("productoId");
		System.out.println(" Producto " + productoIdStr);
		if (productoIdStr == null) {
			response.sendError(500, "Producto id no seteado");
			return;
		}

		Integer productoId = Integer.parseInt(productoIdStr);

		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		Producto producto = em.find(Producto.class, productoId);

		request.setAttribute("producto", producto);

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(path);

		requestDispatcher.forward(request, response);

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
