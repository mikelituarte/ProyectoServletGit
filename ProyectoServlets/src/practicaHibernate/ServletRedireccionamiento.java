package practicaHibernate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServletRedireccionamiento extends HttpServlet{

	private final Logger log = LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

		log.trace("Ha entrado en el doGet de ServletRedireccionamiento, y procedemos a redireccionasrlo a ServletEmpleado");
		resp.sendRedirect("http://172.16.1.19:8090/ProyectoServlets/Empleado.html");
		
	}
}
