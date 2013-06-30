package com.ejemplo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ejemplo.modelo.Productos;

/**
 * Servlet implementation class ProductoController
 */
public class listaProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public listaProductos() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = "listaProductos.jsp";

		List<Productos> listaProductos = cargarListaProductos();

		request.setAttribute("lista", listaProductos);
		
		
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}

	private List<Productos> cargarListaProductos() {
		ArrayList<Productos> lista = new ArrayList<Productos>();
		Productos p1 = new Productos();
		p1.getProducto();
		lista.add(p1);
		
		return lista;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
