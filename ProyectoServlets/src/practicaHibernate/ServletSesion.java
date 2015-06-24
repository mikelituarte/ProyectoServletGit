package practicaHibernate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletSesion extends HttpServlet{

	private final Logger log = LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		HttpSession httpSesion = null; 
	
		if (req.getSession(false) == null){
			httpSesion = req.getSession(); 
			log.trace("No habia sesion, he generado una");
		}
		else
			log.trace("Ya existia la sesion:");
		
	}
}
