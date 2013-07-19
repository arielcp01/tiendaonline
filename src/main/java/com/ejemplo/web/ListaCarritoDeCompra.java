package com.ejemplo.web;

import java.io.IOException;
import java.math.BigDecimal;
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
public class ListaCarritoDeCompra extends HttpServlet {
	private static final String LISTA_PRODUCTOS_JSP = "carritoCompras.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ListaCarritoDeCompra() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Obtener la lista de productos
		CarritoDeCompra carrito = new CarritoDeCompra();
		carrito = (CarritoDeCompra) request.getSession().getAttribute("carrito");
		List<DetalleCarritoProducto> listaCarrito = carrito.getProductos();
		BigDecimal total = carrito.getTotal();
		BigDecimal totalIva = carrito.getTotalIva();
		BigDecimal granTotal = total.add(totalIva);
		
		System.out.println("total: " + total);
		System.out.println("totalIva: " + totalIva);
		System.out.println("granTotal: " + granTotal);
		
		// Agregar la lista cargada como un atributo
		request.setAttribute("listaCarrito", listaCarrito);
		request.setAttribute("total", total);
		request.setAttribute("totalIva", totalIva);
		request.setAttribute("granTotal", granTotal);
		
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
