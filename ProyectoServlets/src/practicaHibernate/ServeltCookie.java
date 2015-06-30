package practicaHibernate;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServeltCookie extends HttpServlet {

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
		
		//Cookie cookie = new Cookie(“micokie",“21/12/14 15:35"); 
		//cookie.setMaxAge(60*60); //1 hora
		//response.addCookie(cookie);  //MANDO UNA COOKIE
		Date fecha = new Date();
		
		
		Cookie miCookie = encontrarCookie(req, "miCookie");
		if(miCookie !=null){// existe mi cookie....
			
		}
		else{// si no existe mi coockie, la creo...
			miCookie = new Cookie("miCookie", "21/12/14 15:35");
			miCookie.setMaxAge(60*60);
			miCookie.setValue("nVeces");
			
			resp.addCookie(miCookie); 
		}
		
	}
}
