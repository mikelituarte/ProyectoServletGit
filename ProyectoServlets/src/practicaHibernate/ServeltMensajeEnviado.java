package practicaHibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServeltMensajeEnviado extends HttpServlet {
	
	
	private String botonVolver(){
		String res = "<br>";
		res += "<form method=\"get\" action=\"http://172.16.1.19:8090/ProyectoServlets/email.html\">"+
					"<button type=\"submit\">"+
						"Volver"+
					"</button>"+
				"</form>";
		return res;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

		PrintWriter out = null;
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		out.println("<b>Mensaje enviado!</b>");
		out.println(" En breve tu mensaje sera atendido<br>");
		out.println(botonVolver());
		//resp.sendRedirect("http://172.16.1.19:8090/ProyectoServlets/email.html");
	}

}
