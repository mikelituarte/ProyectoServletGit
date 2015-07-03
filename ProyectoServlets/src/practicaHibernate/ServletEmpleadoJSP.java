package practicaHibernate;

import hibernateAll.empleadoHibernateDAO.EmpleadoHibernateDAO;
import interfaces.interfaceRecuperable.Recuperable;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servicios.Empleados.EmployeesServices;
import tablas_Clases.Employees;

public class ServletEmpleadoJSP extends HttpServlet {

	private final Logger log = LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numeroPeticiones =0;
		/*ServletContext sc = req.getServletContext();
		numeroPeticiones = (int) sc.getAttribute("numeroPeticiones");
		sc.setAttribute("numeroPeticiones", (numeroPeticiones+1));*/
		
		PrintWriter out = null;
		Employees empleado = null;
		EmployeesServices es = new EmployeesServices();
		Recuperable objetoDao = new EmpleadoHibernateDAO();
		es.setRecuperable(objetoDao);
		Integer id = new Integer(req.getParameter("id"));
		try {
			empleado = (Employees)es.leerEmpleadoServices(id);
		} catch (ClassNotFoundException | SQLException e) {
			log.error("Se ha producido un error al leer Empleado por ID en ServletEmpleado metodo doGet");
			e.printStackTrace();
		}
		if(empleado!=null){
			req.setAttribute("empleadoBean", empleado);
			req.getRequestDispatcher("/MostarEmpleado.jsp").forward(req, resp);
			
		}
		else{
			resp.setContentType("text/html");
			out = resp.getWriter();
			out.println("El empleado no Existe");
		}
	}
}
