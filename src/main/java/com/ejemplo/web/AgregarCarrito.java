package com.ejemplo.web;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ejemplo.model.Producto;
import com.ejemplo.persistencia.PersistenciaCore;
import com.ejemplo.utils.CarritoDeCompra;
import com.ejemplo.utils.DetalleCarritoProducto;

/**
 * Servlet implementation class AgregarCarrito
 */
public class AgregarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarCarrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productoIdStr = request.getParameter("productoId");
		if (productoIdStr == null) {
			response.sendError(500, "Producto id no seteado");
			return;
		}

		HttpSession session = request.getSession();
		CarritoDeCompra carrito = (CarritoDeCompra) session
				.getAttribute("carrito");
		if (carrito == null) {
			carrito = new CarritoDeCompra();
			session.setAttribute("carrito", carrito);
		}

		Integer productoId = Integer.parseInt(productoIdStr);
		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		Producto producto = em.find(Producto.class, productoId);

		DetalleCarritoProducto detalle = new DetalleCarritoProducto();
		detalle.setProducto(producto);
		detalle.setCantidad(1);

		carrito.addDetalleProducto(detalle);

		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("listaProductos.jsp");
		requestDispatcher.forward(request, response);
	}

}
