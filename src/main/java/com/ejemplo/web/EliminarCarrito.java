package com.ejemplo.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ejemplo.utils.CarritoDeCompra;
import com.ejemplo.utils.DetalleCarritoProducto;

/**
 * Servlet implementation class ProductoController
 */
public class EliminarCarrito extends HttpServlet {
	private static final String LISTA_PRODUCTOS_JSP = "carritoCompras.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EliminarCarrito() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CarritoDeCompra carrito = new CarritoDeCompra();
		carrito = (CarritoDeCompra) request.getSession().getAttribute("carrito");
		List<DetalleCarritoProducto> listaCarrito = carrito.getProductos();
		String idString = request.getParameter("productoId");
		int id = Integer.parseInt(idString);
		
		DetalleCarritoProducto detEliminar = new DetalleCarritoProducto();
		for (DetalleCarritoProducto detalleCarritoProducto : listaCarrito) {
			if (detalleCarritoProducto.getProducto().getId() == id) {
				detEliminar = detalleCarritoProducto;
				break;
			}
		}
		if (detEliminar != null)
			listaCarrito.remove(detEliminar);
		
		carrito.setListaDetallesProductos(listaCarrito);
		request.getSession().setAttribute("carrito", carrito);
		// Agregar la lista cargada como un atributo
		request.setAttribute("listaCarrito", listaCarrito);
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(LISTA_PRODUCTOS_JSP);
		requestDispatcher.forward(request, response);
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
