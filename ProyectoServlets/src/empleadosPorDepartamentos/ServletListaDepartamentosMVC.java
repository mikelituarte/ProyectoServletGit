package empleadosPorDepartamentos;

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

public class ServletListaDepartamentosMVC extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

		PrintWriter out = null;
		resp.setContentType("text/html");
		out = resp.getWriter();
		String botonObtener = "";
		
		Departments departamento = null;
		DepartmentsServices servicio = new DepartmentsServices();
		List<Departments> lista = servicio.obtenerDepartamentos();
		Iterator<Departments> it = lista.iterator();
		out.println("<form action='ServletListaEmpleadosPorDepartamento' method='get'>");
		out.println("<select name='departamentoID'>");
		while(it.hasNext()){
			departamento = it.next();
			out.println("<option value=\""+ departamento.getDepartmentId()+ "\">"+ departamento.getDepartmentName()+ "</option>");
		}
		out.println("</select>");
		out.println("<br>");
		out.println("<input type='submit' value='Obtener'></>");
		out.println("</form>");
		
	}
	
	
	
}
