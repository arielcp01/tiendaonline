package com.ejemplo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String productoIdStr = request.getParameter("productoId");
		String cantidad = request.getParameter("Cantidad");
		Integer productoId = Integer.parseInt(productoIdStr);
		int cant = Integer.parseInt(cantidad);
		if (productoIdStr == null) {
			response.sendError(500, "Producto id no seteado");
			return;
		}
		if (cantidad == null) {
			response.sendError(500, "Falta Cantidad de Producto");
			return;
		}
		System.out.println("agregar Carrito Producto " + productoIdStr
				+ "Cantidad " + cantidad);
		HttpSession session = request.getSession();
		System.out.println("session " + session.toString());
		CarritoDeCompra carrito = (CarritoDeCompra) session
				.getAttribute("carrito");
		CarritoDeCompra carro = new CarritoDeCompra();
		if (carrito == null) {
			carrito = new CarritoDeCompra();
			session.setAttribute("carrito", carrito);
		}
		int can = 0;
		List<DetalleCarritoProducto> listaDetallesProductos = new ArrayList<DetalleCarritoProducto>();
		listaDetallesProductos = carrito.getProductos();
		System.out.println(" cantidad de datos "
				+ listaDetallesProductos.size());
		// /se verifica si ya se cargo ese dato
		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		Producto producto = em.find(Producto.class, productoId);
		DetalleCarritoProducto detalle = new DetalleCarritoProducto();
		if (listaDetallesProductos.size() != 0) {
			for (DetalleCarritoProducto listaProductos : listaDetallesProductos) {

				if (productoId != listaProductos.getProducto().getId()) {
					carro.addDetalleProducto(listaProductos);
				}

			}
		}
		detalle.setProducto(producto);
		detalle.setCantidad(cant);
		carro.addDetalleProducto(detalle);
		listaDetallesProductos = carro.getProductos();
		if (listaDetallesProductos.size() != 0) {
			for (DetalleCarritoProducto listaProductos : listaDetallesProductos) {
				can = listaProductos.getCantidad();
				Producto prod = listaProductos.getProducto();
				System.out.println("Producto Cargados " + prod.getDescripcion()
						+ "cantidad " + can);

			}
		}
		session.setAttribute("carrito", carro);
		//RequestDispatcher requestDispatcher = request
		//		.getRequestDispatcher("/listaProductos");
		//requestDispatcher.forward(request, response);
		response.sendRedirect("/my-webapp/listaProductos");
		
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("/listaProductos");
		requestDispatcher.forward(request, response);
	}
}
