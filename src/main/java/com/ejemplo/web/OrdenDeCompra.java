package com.ejemplo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.ejemplo.model.Detallecompra;
import com.ejemplo.model.Ordencompra;
import com.ejemplo.persistencia.PersistenciaCore;

/**
 * Servlet implementation class OrdenDeCompra
 */

public class OrdenDeCompra extends HttpServlet {
	private static final String LISTA_ORDEN_JSP = "ordenDeCompra.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenDeCompra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		List<Ordencompra> listaOrden = cargarOrdenCompra();
		request.setAttribute("lista", listaOrden);
		List<Detallecompra> listaDetalle = cargarDetalle();
		request.setAttribute("listadetalle", listaDetalle);
		//PrintWriter out = response.getWriter();
		JSONObject json = null;
		List<JSONObject> jsonCategories = new ArrayList<JSONObject>();
		for (int i = 0; i < listaOrden.size(); i++) {
			Ordencompra orden = listaOrden.get(i);
			json = new JSONObject();
		    json.put("id",orden.getId());
			//json.put("fecha",orden.getFechadecompra());
			json.put("cantidad", orden.getCantidad());
			json.put("estado", orden.getEstado() );
			json.put("total", orden.getTotal());
			jsonCategories.add(json);
			
		  
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonCategories.toString());
		// Agregar la lista cargada como un atributo
		RequestDispatcher requestDispatcher = request
			.getRequestDispatcher(LISTA_ORDEN_JSP);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		List<Ordencompra> listaOrden = cargarOrdenCompra();
		PrintWriter out = response.getWriter();
		JSONObject json = null;
		List<JSONObject> jsonCategories = new ArrayList<JSONObject>();
		for (int i = 0; i < listaOrden.size(); i++) {
			
			Ordencompra orden = listaOrden.get(i);
			String atendido = "P" ;
			String completado = "P";
			if(orden.getEstado().contentEquals("A") ){
				atendido = "A";
			}
			if(orden.getEstado().contentEquals("C")){
				completado = "C";
			}
			
			json = new JSONObject();
		    json.put("id",orden.getId());
			json.put("fecha", orden.getFechadecompra().toString());
			json.put("cantidad", orden.getCantidad());
			json.put("estado", orden.getEstado() );
			json.put("atendido", atendido );
			json.put("completado", completado );
			json.put("total", orden.getTotal());
			json.put("nombre",orden.getUsuario().getNombre());
			jsonCategories.add(json);
			
		  
		}
		out.write(jsonCategories.toString());
		out.flush();
		out.close();
		
	}

	private List<Ordencompra> cargarOrdenCompra() {
		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		Query query = em.createQuery("FROM " + Ordencompra.class.getName());
		@SuppressWarnings("unchecked")
		List<Ordencompra> resultList = query.getResultList();
		em.close();
		return resultList;
	}

	private List<Detallecompra> cargarDetalle() {
		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		Query query = em.createQuery("FROM " + Detallecompra.class.getName());
		@SuppressWarnings("unchecked")
		List<Detallecompra> resultList = query.getResultList();
		em.close();
		return resultList;
	}
	
}
