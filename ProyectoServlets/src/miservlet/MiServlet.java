package miservlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MiServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String nombre = "";
		String respuesta = null;
		nombre = req.getParameter("nombre");
		respuesta = "El numero de letras que tiene el nombre \""+nombre+"\" es: "+ nombre.length();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print(respuesta);
		//super.doGet(req, resp);
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
