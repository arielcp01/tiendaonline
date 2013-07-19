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
 * Servlet implementation class VerProducto
 */
public class VerProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VerProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productoIdStr = request.getParameter("productoId");
		if (productoIdStr == null) {
			response.sendError(500, "Producto id no seteado");
			return;
		}

		Integer productoId = Integer.parseInt(productoIdStr);

		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		Producto producto = em.find(Producto.class, productoId);

		request.setAttribute("producto", producto);

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("verProducto.jsp");
		requestDispatcher.forward(request, response);

	}

}
