package practicaHibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servicios.Empleados.EmployeesServices;
import tablas_Clases.Employees;

public class ServletIncrementarSalario extends HttpServlet{
	
	private final Logger log = LogManager.getRootLogger();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Employees> le = null;
		ServletConfig sc = getServletConfig();
		String i = sc.getInitParameter("incremento");
		BigDecimal incremento = new BigDecimal(i);
		
		EmployeesServices es = new EmployeesServices();
		le = es.incrementarSalario(incremento);
		PrintWriter out = null;
		resp.setContentType("text/html");
		out = resp.getWriter();
		if (le != null) {

			Iterator<Employees> it = le.iterator();
			/*
			 * while(it.hasNext()){ System.out.println(it.next());
			 * out.println("Salario incrementado corectamente"); }
			 */
			for (Employees e : le) {
				 out.println(e.imprimirEmpleado());
				 out.println("<br>");
				//log.trace("Ha entrado en el for each");
				//System.out.println(e.imprimirEmpleado());
			}
		}
		else
			out.println("IncrementoSalario");
	}
}
