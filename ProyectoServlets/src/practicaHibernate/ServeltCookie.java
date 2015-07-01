package practicaHibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServeltCookie extends HttpServlet {

	/**
	 * metodo que apartir de un HttpServletRequest busca una Cookie con el nombre pasado como parametro
	 * @param req Donde buscara la Cookie
	 * @param nombreCookie Es el nombre de la Cookie a buscar
	 * @return Retorna la Cookie que coincide con el nombre pasado y en caso de no encontrarla devuelve null
	 */
	private Cookie encontrarCookie(HttpServletRequest req, String nombreCookie){
		int i =0;
		boolean encontrado = false;
		Cookie miCookie = null;
		
		Cookie[] cookies = req.getCookies(); 
		if(cookies != null){
			while (i<cookies.length && !encontrado){
				if (cookies[i].getName().equals(nombreCookie)){
					miCookie = cookies[i];
					encontrado = true;
				}
				else
					i++;
			}
		}
		return miCookie;

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Date fecha = new Date();
		String contenido = null;
		Character nVeces = null;
		
		PrintWriter out = null;
		resp.setContentType("text/html");
		out = resp.getWriter();
		
		
		Cookie miCookie = encontrarCookie(req, "miCookie");
		if(miCookie !=null){// existe mi cookie....
			contenido = miCookie.getValue();
			int nVecesEntero = Integer.parseInt(contenido);
			if(nVecesEntero < 3){
				out.println("El valor de la Cookie es: "+ nVecesEntero + " y la incremento...");
				nVecesEntero++;
				contenido = contenido.substring(0, contenido.length()-1)+ nVecesEntero;
				miCookie.setValue(contenido);
				resp.addCookie(miCookie);
				
			}
			else{
				out.println("El valor de la Cookie es: "+ nVecesEntero + " y la borro");
				miCookie.setMaxAge(0);
				resp.addCookie(miCookie);
			}
		}
		else{// si no existe mi coockie, la creo...
			miCookie = new Cookie("miCookie", "0");
			miCookie = new Cookie("miCookie", "0");
			miCookie.setMaxAge(60*60);
			resp.addCookie(miCookie); 
			out.println("He creado una nueva Cookie");
		}
		
	}
}
