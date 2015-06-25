package practicaHibernate;

import hibernateAll.empleadoHibernateDAO.EmpleadoHibernateDAO;
import interfaces.interfaceRecuperable.Recuperable;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servicios.Empleados.EmployeesServices;
import servicios.usuario.UsuarioServices;
import tablas_Clases.Usuario;

public class ServletAutentication extends HttpServlet {

	private final Logger log = LogManager.getRootLogger();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSesion = null; 
		Usuario usuario = null;
		//boolean existe = false;
		PrintWriter out = null;
		resp.setContentType("text/html");
		out = resp.getWriter();
		UsuarioServices servicio = new UsuarioServices();
		try {
			usuario = servicio.leerUsuario(req.getParameter("user_name"), req.getParameter("pass"));
		} catch (ClassNotFoundException | SQLException e) {
			log.error("Error al leer usuario en clase ServletAutentitacion metodo doPost");
			e.printStackTrace();
		}
		if(usuario != null){
			out.println("Bienvenido <b>"+ usuario.getNombre()+ "</b>");
			//if (req.getSession(false) == null){
				httpSesion = req.getSession(); 
				httpSesion.setAttribute("user_name", usuario.getNombre());
				log.trace("leemos el atributo \"user_name\" de la sesion: " + req.getSession(false).getAttribute("user_name"));
			//}
			//else
				//log.trace("Ya existia la sesion:");
		}
		else
			out.println("El usuario NO existe!");
		//super.doPost(req, resp);
	}
}
