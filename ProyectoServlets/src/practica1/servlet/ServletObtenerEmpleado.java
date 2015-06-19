package practica1.servlet;


import java.sql.Connection;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practica1.hibernate.EmpleadoDao;

import tablas_Clases.Employees;

//import org.apache.tomcat.jni.Pool;


public class ServletObtenerEmpleado extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		Employees empleado = null;
		EmpleadoDao empleadoDao = new EmpleadoDao();
		PrintWriter out = null;
		String id = null;
		id = req.getParameter("id");
		empleado = empleadoDao.obtenerEmpleado(Integer.parseInt(id));
		if(empleado!=null){
			resp.setContentType("text/html");
			out = resp.getWriter();
			out.println("<br>Nombre: "+empleado.getFirstName());
			out.println("<br>Apellido: "+empleado.getLastName());
			out.println("<br>E-mail: "+empleado.getEmail());
			out.println("<br>Salario: "+empleado.getSalary());
		}
		else{
		resp.setContentType("text/html");
		out = resp.getWriter();
		out.println("El empleado no Existe");

		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Ha llamado a doPost() de la clase MiServlet dentro del paquete miservlet");
		super.doPost(req, resp);
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("Ha llamado a service()de la clase MiServlet dentro del paquete miservlet");
		super.service(arg0, arg1);
	}
	
	
}
