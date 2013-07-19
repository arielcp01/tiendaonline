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
public class ObtenerCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ObtenerCarrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// String productoIdStr = request.getParameter("productoId");
		// String cantidad = request.getParameter("Cantidad");
		int cant = 0;
		int total = 0;
		/*
		 * if (productoIdStr == null) { response.sendError(500,
		 * "Producto id no seteado"); return; } if (cantidad == null) {
		 * response.sendError(500, "Falta Cantidad de Producto"); return; }
		 */
		HttpSession session = request.getSession();
		CarritoDeCompra carrito = (CarritoDeCompra) session
				.getAttribute("carrito");
		// DetalleCarritoProducto detalle = new DetalleCarritoProducto();
		// detalle = (DetalleCarritoProducto) session.getAttribute("carrito");
		cant = carrito.getCantProducto();
		total = carrito.getCantTotal();
		// System.out.println("Cantidad de cosas " + cant + " Total "
		// + total.toString());
		System.out.println("Seession " + carrito.toString());
		// String productoIdStr = null;
		// Integer productoId = Integer.parseInt(productoIdStr);
		// EntityManager em =
		// PersistenciaCore.getInstance().createEntityManager();
		// Producto producto = em.find(Producto.class, productoId);
		request.setAttribute("cantidad", cant);
		request.setAttribute("total", total);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("comprarTarjeta.jsp");

		requestDispatcher.forward(request, response);

	}

}
