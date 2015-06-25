package practicaHibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletSesionesActivas extends HttpServlet{
	private final Logger log = LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HashMap<String,  HttpSession> sesionesActivas  = null;
		sesionesActivas = (HashMap<String, HttpSession>) req.getServletContext().getAttribute("sesionesActivas");
		HttpSession httpSesion = null;
		String nombreSesion = null;
		PrintWriter out = null;
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		out.println("<b>Sesiones Activas</b><br>");
		Iterator it = sesionesActivas.values().iterator();
		while(it.hasNext()){
			httpSesion = (HttpSession) it.next();
			nombreSesion = (String) httpSesion.getAttribute("user_name");
			log.trace("Sesion Activa en ServletSesionesActivas: " + nombreSesion);
			out.println(" " + nombreSesion + "<br>");
		}
	}
}
