package com.ejemplo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ejemplo.model.*;
import com.ejemplo.persistencia.PersistenciaCore;
import net.sf.json.*;

/**
 * Servlet implementation class OrdenDeCompra
 */

@SuppressWarnings("serial")
public class DetalleCompras extends HttpServlet {
	private static final String LISTA_ORDEN_JSP = "ordenDeCompra.jsp";

	// private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetalleCompras() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String idStr = request.getParameter("id");
		// System.out.println("idStr" + idStr);
		if (idStr == null) {
			response.sendError(500, "Detalle id no seteado");
			return;
		}
		Long id = Long.parseLong(idStr);
		// System.out.println("id " + id );
		List<DetalleCompra> listaDetalle = (List<DetalleCompra>) compras(id);
		// DetalleCompra detalle=null;
		// Detallecompra listaDetalle = cargarDetalle(id);

		JSONObject json = null;

		List<JSONObject> jsonCategories = new ArrayList<JSONObject>();

		for (int i = 0; i < listaDetalle.size(); i++) {
			DetalleCompra detalle = listaDetalle.get(i);
			Long productoId = detalle.getProductoId();
			EntityManager em = PersistenciaCore.getInstance()
					.createEntityManager();
			Producto producto = em.find(Producto.class, productoId);
			json = new JSONObject();
			json.put("producto_id", productoId);
			json.put("nombre", producto.getDescripcion());
			json.put("cantidad", detalle.getCantidad());
			json.put("precio", producto.getPrecio());
			json.put("total", detalle.getTotal());
			jsonCategories.add(json);
		
		}

		out.write(jsonCategories.toString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Agregar la lista cargada como un atributo
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(LISTA_ORDEN_JSP);
		requestDispatcher.forward(request, response);
	}

	private List<DetalleCompra> compras(Long id) {
		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		OrdenCompra orden = em.find(OrdenCompra.class, id);
		List<DetalleCompra> detallecompras = orden.getDetallecompras();
		return detallecompras;
	}

}
