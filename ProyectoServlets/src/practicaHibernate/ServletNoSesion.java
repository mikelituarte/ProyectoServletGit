package practicaHibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletNoSesion extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

		PrintWriter out = null;
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		out.println("Logueate coño!!!");
		//req.getRequestDispatcher("/ServletAutentication").include(req, resp);
	}
}
