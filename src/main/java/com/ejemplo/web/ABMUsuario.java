package com.ejemplo.web;

import java.io.IOException;
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
import com.ejemplo.model.Usuario;
import com.ejemplo.persistencia.*;


/**
 * Servlet implementation class ProductoController
 */
public class ABMUsuario extends HttpServlet {
	private static final String LISTA_PRODUCTOS_JSP = "abmUsuarios.jsp";
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ABMUsuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Obtener la lista de productos
		String modoG = new String(""); 
		modoG = request.getParameter("mode");
		System.out.println("GET modoG: " + modoG);
		if (modoG == null){
			List<Usuario> listaUsuario = cargarUsuarios();
			// Agregar la lista cargada como un atributo
			request.setAttribute("lista", listaUsuario);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher(LISTA_PRODUCTOS_JSP);
			requestDispatcher.forward(request, response);
		} else {
			
			doPost(request, response);
		}
	}

	private List<Usuario> cargarUsuarios() {
		EntityManager em = PersistenciaCore.getInstance().createEntityManager();
		Query query = em.createQuery("FROM " + Usuario.class.getName());
		@SuppressWarnings("unchecked")
		List<Usuario> resultList = query.getResultList();
		return resultList;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String modoP = request.getParameter("mode");
		String nombre = request.getParameter("nombre");
		String estado = request.getParameter("estado");
		String nivel = request.getParameter("nivel");
		if (nivel == null)
			nivel = "0";
		Integer nivelN = Integer.parseInt(nivel);
		String password = request.getParameter("password");
		String id = request.getParameter("usuarioId");
		if (id == null)
			id = "0";
		Long idL = Long.parseLong(id);
		
		/// Empiezo la transaccion
		String persistenceUnitName = "my-webapp";
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(persistenceUnitName);
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();
		
		Usuario usu1 = new Usuario();
		if (!modoP.equals("INS"))
			usu1 = em.find(Usuario.class, idL);
			
		usu1.setEstado(estado);
		usu1.setNivel(nivelN);
		usu1.setNombre(nombre);
		usu1.setPassword(password);
		
		transaction.begin();
		try {
			if (modoP.equals("INS"))
				em.persist(usu1);
			if (modoP.equals("DLT"))
				em.remove(usu1);
			transaction.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("Error al intentar grabar los datos ");
		} finally {
			em.close();
			emf.close();
		}
		
		response.sendRedirect("/my-webapp/abmUsuario");
	}

}
