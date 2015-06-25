package practicaHibernate;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClaseHttpSessionListener implements HttpSessionListener {
	private final Logger log = LogManager.getRootLogger();
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HashMap<String,  HttpSession> sesionesActivas  = null;
		String nombreSesion = null;
		HttpSession httpSesion = null; 
		System.out.println("Ha pasado por: ClaseHttpSessionListener, metodo: sessionCreated");
		log.trace("La sesion es: " + arg0.getSession().getId() + " en sesionCreated");
		ServletContext sc = arg0.getSession().getServletContext();
		sesionesActivas = (HashMap<String, HttpSession>) sc.getAttribute("sesionesActivas");
		sesionesActivas.put(arg0.getSession().getId(), arg0.getSession());
		arg0.getSession().getServletContext().setAttribute("sesionesActivas", sesionesActivas);
		log.trace("AAAAA--Created--AAAA");
		log.trace(sesionesActivas.toString());
		Iterator it = sesionesActivas.values().iterator();
		while(it.hasNext()){
			httpSesion = (HttpSession) it.next();
			nombreSesion = (String) httpSesion.getAttribute("user_name");
			log.trace("Sesion Activa " + nombreSesion);
		}
		log.trace("BBBBB--Created--BBBB");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Ha pasado por: ClaseHttpSessionListener, metodo: sessionDestroyed");
		log.trace("Se ha llamado al metodo sessionDestroyer dela clase SesionListener");
		HashMap<String,  HttpSession> sesionesActivas  = null;
		ServletContext sc = arg0.getSession().getServletContext();
		sesionesActivas = (HashMap<String, HttpSession>) sc.getAttribute("sesionesActivas");
		sesionesActivas.remove(arg0.getSession().getId(), arg0.getSession());
		arg0.getSession().getServletContext().setAttribute("sesionesActivas", sesionesActivas);
		log.trace("AAAAA--Destroyed--AAAA");
		log.trace(sesionesActivas.toString());
		log.trace("BBBBB--destroyed--BBBB");
	}

}
