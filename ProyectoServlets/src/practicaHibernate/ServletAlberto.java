package practicaHibernate;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAlberto extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		resp.sendRedirect("http://172.16.1.57:8090/ProyectoServlets/Login.html");
	}
}
