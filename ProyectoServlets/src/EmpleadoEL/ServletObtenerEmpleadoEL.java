package EmpleadoEL;

import hibernateAll.empleadoHibernateDAO.EmpleadoHibernateDAO;
import interfaces.interfaceRecuperable.Recuperable;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import servicios.Empleados.EmployeesServices;
import tablas_Clases.Employees;

public class ServletObtenerEmpleadoEL extends HttpServlet {

	private final Logger log = LogManager.getRootLogger();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = null;
		Employees empleado = null;
		EmployeesServices es = new EmployeesServices();
		Recuperable objetoDao = new EmpleadoHibernateDAO();
		es.setRecuperable(objetoDao);
		Integer id = new Integer(req.getParameter("id"));
		try {
			empleado = (Employees)es.leerEmpleadoServices(id);
		} catch (ClassNotFoundException | SQLException e) {
			log.error("Se ha producido un error al leer Empleado por ID en ServletEmpleadoJSP metodo doGet");
			e.printStackTrace();
		}
		if(empleado!=null){
			req.setAttribute("empleadoBean", empleado);
			req.getRequestDispatcher("/mostrarEmpleadoEL.jsp").forward(req, resp);
		}
		else{
			resp.setContentType("text/html");
			out = resp.getWriter();
			out.println("El empleado no Existe");
		}
	}
}
