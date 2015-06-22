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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import servicios.Empleados.EmployeesServices;
import tablas_Clases.Employees;

//import Empleados.EmployeesServices;

public class ServletEmpleado extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext sc = req.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		Session sesion = sf.openSession();
		sesion.close();
		
		PrintWriter out = null;
		Employees empleado = null;
		EmployeesServices es = new EmployeesServices();
		Recuperable objetoDao = new EmpleadoHibernateDAO();
		es.setRecuperable(objetoDao);
		Integer id = new Integer(req.getParameter("id"));
		try {
			empleado = (Employees)es.leerEmpleadoServices(id);
		} catch (ClassNotFoundException | SQLException e) {
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
