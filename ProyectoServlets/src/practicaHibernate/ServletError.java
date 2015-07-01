package practicaHibernate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletError extends HttpServlet {

	private final Logger log = LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		log.trace("En el ServletError: " + req.getAttribute("javax.servlet.error.exception"));
		
		resp.sendRedirect("http://172.16.1.19:8090/ProyectoServlets/Error.html");
	}
}
