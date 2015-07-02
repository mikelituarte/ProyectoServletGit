package practicaHibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServeltImitacionPrimerJSP extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = null;
		resp.setContentType("text/html");
		out = resp.getWriter();
				
		out.println("" +
		"<html> "+
			"<head>"+
				"<title>Hola Mundo</title> "+
			"</head> "+
			"<body> "+
				"<p>Hola, esto un servlet que hace lo mismo que el primer JSP</p> "+
				"<p>La hora del servidor es: " + new Date() +"</p> "+
			"</body> "+
		"</html> ");
	}
}
