package com.ejemplo.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ejemplo.model.DetalleCompra;
import com.ejemplo.model.OrdenCompra;
import com.ejemplo.model.Usuario;
import com.ejemplo.utils.CarritoDeCompra;
import com.ejemplo.utils.DetalleCarritoProducto;

/**
 * Servlet implementation class FinalizarCompra
 */

public class FinalizarCompra extends HttpServlet {
	private static final String LISTA_ORDEN_JSP = "compraTarjeta";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizarCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String persistenceUnitName = "my-webapp";
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		CarritoDeCompra carrito = new CarritoDeCompra();
		try {
			carrito = (CarritoDeCompra) request.getSession().getAttribute("carrito");
			if (carrito == null){
				response.sendRedirect("/my-webapp/listaProductos");
			} else {			
				List<DetalleCarritoProducto> listaCarrito = carrito.getProductos();
				
				Usuario usu1 = new Usuario();
				usu1.setId(0L);
				
				OrdenCompra odc = new OrdenCompra();
				odc.setCantidad(carrito.getCantProducto());
				odc.setEstado(new String("P"));
				odc.setFechaDeCompra(new Date());
				odc.setTotal(carrito.getTotal());
				odc.setUsuario(usu1);
	
				em.persist(odc);
				
				for (DetalleCarritoProducto detalleCarritoProducto : listaCarrito) {
					DetalleCompra detalle = new DetalleCompra();
					detalle.setCantidad(detalleCarritoProducto.getCantidad());
					detalle.setOrdencompra(odc);
					detalle.setProducto(detalleCarritoProducto.getProducto());
					detalle.setTotal(detalleCarritoProducto.getTotal());
					em.persist(detalle);
				}
				transaction.commit();
				
				HttpSession session = request.getSession();
				session.setAttribute("carrito", null);
			}

		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

		if (!(carrito==null)){
			// Agregar la lista cargada como un atributo
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher(LISTA_ORDEN_JSP);
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
