package com.ejemplo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejemplo.modelo.Producto;

/**
 * Servlet implementation class ProductoController
 */
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ProductoController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = "listaProductos.jsp";

		List<Producto> listaProductos = cargarListaProductos();

		request.setAttribute("lista", listaProductos);
		
		
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}

	private List<Producto> cargarListaProductos() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Producto p1 = new Producto("Adidas");
		Producto p2 = new Producto("Nike");
		Producto p3 = new Producto("Lacoste");
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
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
