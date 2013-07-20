package com.ejemplo.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ejemplo.utils.CarritoDeCompra;

/**
 * Servlet implementation class AgregarCarrito
 */
public class CompraTarjeta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompraTarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int cant = 0;
		int total = 0;
		HttpSession session = request.getSession();

		CarritoDeCompra carrito = (CarritoDeCompra) session
				.getAttribute("carrito");

		if (carrito == null) {
			// System.out.println("Error no tiene cargado nada A�n ");
			// response.sendError(500, "Falta Cantidad de Producto");
			response.sendRedirect("/my-webapp/listaProductos");
		} else {

			total = carrito.getCantTotal();
			System.out.println("Seession " + carrito.toString());
			cant = carrito.getCantProducto();
			request.setAttribute("cantidad", cant);
			request.setAttribute("total", total);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("comprarTarjeta.jsp");
			requestDispatcher.forward(request, response);
		}

	}

}
