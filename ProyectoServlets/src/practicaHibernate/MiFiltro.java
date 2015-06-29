package practicaHibernate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MiFiltro implements Filter{

	private final Logger log = LogManager.getRootLogger();
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		log.trace("Ha entrado en init de la clase MiFiltro");
		
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.trace("Ha entrado en destroy de la clase MiFiltro");
		
	}

	@Override
	public void doFilter(ServletRequest sreq, ServletResponse sresp, FilterChain fc) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		/*long antes;
		antes = System.currentTimeMillis();
		log.trace("Ha entrado en doFilter de la clase MiFiltro");
		fc.doFilter(sreq, sresp);
		long despues;
		despues = System.currentTimeMillis();
		log.trace("------------");
		log.trace("tiempo con Hibernate: "+(despues-antes));
		log.trace("xxxxxxxxxxxx");*/
		String destino1 = "/ProyectoServlets/login.html";
		String destino2 = "http://172.16.1.19:8090/ProyectoServlets/login.html";
		String destino3 = "/ProyectoServlets/ServletAutentication";
		String destino4 = "/ProyectoServlets/email.html";
		HttpServletResponse resp = (HttpServletResponse)sresp;
		HttpServletRequest req = (HttpServletRequest)sreq;//hacemos un casting de ServletRequest a HttpServletRequest
		String destino = req.getRequestURI();//nos da la ruta a la que quiere ir
		if(req.getSession(false) == null){// Si no tiene sesion...
			if(destino.equals(destino2) || destino.equals(destino1) || destino.equals(destino3)  || destino.equals(destino4) ){// Si va a la pagina de login...
				//req.getRequestDispatcher("/ServletNoSesion").include(req, resp);
				fc.doFilter(sreq, sresp);
			}
			else{ //si no va a loguearse, le redirigo a Login
				//req.getRequestDispatcher("/ServletNoSesion").include(req, resp);
				log.trace("La URI es: "+ destino);
				resp.sendRedirect("http://172.16.1.19:8090/ProyectoServlets/login.html");

			}
		}
		else{// si tiene sesion...
			log.trace("La URI al final es: "+ destino);
			fc.doFilter(sreq, sresp);
		}
		
	}



}
