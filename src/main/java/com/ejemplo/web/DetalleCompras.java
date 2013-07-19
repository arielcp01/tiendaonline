package com.ejemplo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.ejemplo.model.DetalleCompra;
import com.ejemplo.persistencia.PersistenciaCore;

/**
 * Servlet implementation class OrdenDeCompra
 */

public class DetalleCompras extends HttpServlet {
	private static final String LISTA_ORDEN_JSP = "ordenDeCompra.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleCompras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String idStr = request.getParameter("id");
		System.out.println("idStr" + idStr);
		if (idStr == null) {
			response.sendError(500, "Detalle id no seteado");
			return;
		}
		Long id = (long) Integer.parseInt(idStr);
		DetalleCompra listaDetalle = cargarDetalle(id);
		//request.setAttribute("listadetalle", listaDetalle);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(listaDetalle);
		System.out.println("json" + json);
		out.println(json);
		out.flush();
		out.close();
		/*
		// Agregar la lista cargada como un atributo
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher(LISTA_ORDEN_JSP);
		requestDispatcher.forward(request, response);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Agregar la lista cargada como un atributo
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher(LISTA_ORDEN_JSP);
				requestDispatcher.forward(request, response);
	}


	private DetalleCompra cargarDetalle(Long id) {
		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		DetalleCompra detallecompra = em.find(DetalleCompra.class,id);
		return detallecompra;
	}
	
}
