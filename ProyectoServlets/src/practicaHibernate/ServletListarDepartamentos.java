package practicaHibernate;

import hibernateAll.empleadoHibernateDAO.DepartamentoHibernateDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.departamentos.DepartmentsServices;
import tablas_Clases.Departments;

public class ServletListarDepartamentos extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		PrintWriter out = null;
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		Departments departamento = null;
		DepartmentsServices servicio = new DepartmentsServices();
		List<Departments> lista = servicio.obtenerDepartamentos();
		Iterator<Departments> it = lista.iterator();
		out.println("<select>");
		while(it.hasNext()){
			departamento = it.next();
			out.println("<option value=\""+ departamento.getDepartmentName()+ "\">"+ departamento.getDepartmentName()+ "</option>");
			
		}
		out.println("</select>");
		out.println("<br>");
		out.println("<br>");
		RequestDispatcher disparador = req.getRequestDispatcher("/ServletSesionesActivas");
		disparador.include(req, resp);
		
	}
}
