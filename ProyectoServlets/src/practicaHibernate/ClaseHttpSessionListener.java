package practicaHibernate;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClaseHttpSessionListener implements HttpSessionListener {
	private final Logger log = LogManager.getRootLogger();
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Ha pasado por: ClaseHttpSessionListener, metodo: sessionCreated");
		log.trace("La sesion es: " + arg0.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Ha pasado por: ClaseHttpSessionListener, metodo: sessionDestroyed");
	}

}
