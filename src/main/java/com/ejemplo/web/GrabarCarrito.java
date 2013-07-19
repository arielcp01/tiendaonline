package com.ejemplo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import com.ejemplo.model.DetalleCompra;
import com.ejemplo.model.OrdenCompra;
import com.ejemplo.model.Producto;
import com.ejemplo.model.Tarjeta;
import com.ejemplo.persistencia.*;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * Servlet implementation class ProductoController
 */
@SuppressWarnings({ "unused", "restriction" })
public class GrabarCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public GrabarCarrito() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Obtener la lista de productos
		//response.setContentType("application/json");
		//PrintWriter out = response.getWriter();
		// System.out.println("entramos en grabar carrito " );
		Tarjeta tarjeta = new Tarjeta();
		String tarjetas = request.getParameter("tarjeta");
		String digito = request.getParameter("digito");
		String fecha = request.getParameter("fecha");
		String calle = request.getParameter("calle");
		String marca = request.getParameter("marca");
		String telefono = request.getParameter("telefono");
		String pais = request.getParameter("pais");
		String ciudad = request.getParameter("ciudad");
		String observacion = request.getParameter("observacion");
		String nombre = request.getParameter("nombre");
		Long nroTrajeta = Long.parseLong(tarjetas);
		tarjeta.setNrotarjeta(nroTrajeta);
		tarjeta.setDigitoVerificador(Integer.parseInt(digito));
		tarjeta.setDireccion(calle);
		tarjeta.setMarca(marca);
		tarjeta.setTelefono(telefono);
		tarjeta.setCiudad(ciudad);
		tarjeta.setNombre(nombre);
		tarjeta.setObservaciones(observacion);
		// obtener y transformar la fecha de string a date
		SimpleDateFormat formfecha = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formfecha.parse(fecha);
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tarjeta.setFechaDeVencimiento(date);
		 System.out.println("tarjeta " + tarjetas + " digito " + digito +
		" pais " + pais + " Fecha " + date.toString());
		cargarTarjeta(tarjeta);
		//ObjectMapper mapper = new ObjectMapper();
		//String json = "true";//mapper.writeValueAsString(tarjeta);
		//System.out.println("json" + json);
		//out.println(json);
		//out.flush();
		//out.close();
		response.sendRedirect("/my-webapp/listaProductos");

	}

	private void cargarTarjeta(Tarjeta tarjeta) {
		String persistenceUnitName = "my-webapp";
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			String id = Long.toString(tarjeta.getNrotarjeta());
			System.out.println("Id de Tarjeta " + id);
			em.persist(tarjeta);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error al intentar grabar los datos ");
		} finally {
			em.close();
			emf.close();
		}

	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("application/json");
		//PrintWriter out = response.getWriter();
		
		Tarjeta tarjeta = new Tarjeta();
		String tarjetas = request.getParameter("tarjeta");
		String digito = request.getParameter("digito");
		String fecha = request.getParameter("fecha");
		String calle = request.getParameter("calle");
		String marca = request.getParameter("marca");
		String telefono = request.getParameter("telefono");
		String pais = request.getParameter("pais");
		String ciudad = request.getParameter("ciudad");
		String observacion = request.getParameter("observacion");
		String nombre = request.getParameter("nombre");
		Long nroTrajeta = Long.parseLong(tarjetas);
		tarjeta.setNrotarjeta(nroTrajeta);
		tarjeta.setDigitoVerificador(Integer.parseInt(digito));
		tarjeta.setDireccion(calle);
		tarjeta.setMarca(marca);
		tarjeta.setTelefono(telefono);
		tarjeta.setCiudad(ciudad);
		tarjeta.setNombre(nombre);
		tarjeta.setObservaciones(observacion);
		// obtener y transformar la fecha de string a date
		SimpleDateFormat formfecha = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = formfecha.parse(fecha);
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tarjeta.setFechaDeVencimiento(date);
		 System.out.println("tarjeta " + tarjetas + " digito " + digito +
		" pais " + pais + " Fecha " + date.toString());
		cargarTarjeta(tarjeta);
		//ObjectMapper mapper = new ObjectMapper();
		//String json = "true";//mapper.writeValueAsString(tarjeta);
		//System.out.println("json" + json);
		//out.println(json);
		//out.flush();
		//out.close();
		response.sendRedirect("/my-webapp/listaProductos");
	}

}
