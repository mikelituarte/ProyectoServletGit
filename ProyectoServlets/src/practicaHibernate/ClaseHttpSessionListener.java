package practicaHibernate;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ClaseHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Ha pasado por: ClaseHttpSessionListener, metodo: sessionCreated");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Ha pasado por: ClaseHttpSessionListener, metodo: sessionDestroyed");
	}

}
