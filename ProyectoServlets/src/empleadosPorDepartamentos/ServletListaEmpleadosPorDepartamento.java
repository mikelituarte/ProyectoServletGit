package empleadosPorDepartamentos;

import hibernateAll.empleadoHibernateDAO.EmpleadoHibernateDAO;
import interfaces.interfaceRecuperable.Recuperable;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.Empleados.EmployeesServices;
import tablas_Clases.Employees;

public class ServletListaEmpleadosPorDepartamento extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Employees> lista = null;
		PrintWriter out = null;
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		String departametoIDString = (String)req.getParameter("departamentoID");
		Short departamentoID =  new Short(departametoIDString);
		EmployeesServices es = new EmployeesServices();
		Recuperable objetoDao = new EmpleadoHibernateDAO();
		es.setRecuperable(objetoDao);
		lista = es.obtenerEmpleadosPorDepartamento(departamentoID);
		out.println(lista);
		req.setAttribute("listaEmpleados", lista);
		req.getRequestDispatcher("/mostrarEmpleadosPorDepartamento.jsp").forward(req, resp);
	}
}
