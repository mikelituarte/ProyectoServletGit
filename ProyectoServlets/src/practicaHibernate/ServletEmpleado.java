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
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import servicios.Empleados.EmployeesServices;
import tablas_Clases.Employees;

//import Empleados.EmployeesServices;


public class ServletEmpleado extends HttpServlet{
	
	private final Logger log = LogManager.getRootLogger();
	
	private String botonVolver(){
		String res = "";
		res += "<form method=\"get\" action=\"http://localhost:8090/ProyectoServlets/Empleado.html\">"+
					"<button type=\"submit\">"+
						"Volver"+
					"</button>"+
				"</form>";
		return res;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int numeroPeticiones =0;
		ServletContext sc = req.getServletContext();
		numeroPeticiones = (int) sc.getAttribute("numeroPeticiones");
		sc.setAttribute("numeroPeticiones", (numeroPeticiones+1));
		
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
			resp.setContentType("text/html");
			out = resp.getWriter();
			/*out.println("<br>Nombre: "+empleado.getFirstName());
			out.println("<br>Apellido: "+empleado.getLastName());
			out.println("<br>E-mail: "+empleado.getEmail());
			out.println("<br>Salario: "+empleado.getSalary());*/
			out.println(empleado.imprimirEmpleado());
			
			out.println("Numero de Peticiones: " + sc.getAttribute("numeroPeticiones"));
			out.println(botonVolver());
		}
		else{
			resp.setContentType("text/html");
			out = resp.getWriter();
			out.println("El empleado no Existe");
		}
		System.out.println("Ha llamado a doGet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Ha llamado a doPost");
		super.doPost(req, resp);
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
	
}
