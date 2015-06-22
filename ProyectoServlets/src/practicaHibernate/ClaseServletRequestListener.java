package practicaHibernate;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ClaseServletRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Ha pasado por: ClaseServletRequestListener, metodo: requestDestroyed");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Ha pasado por: ClaseServletRequestListener, metodo: requestInitialized");
	}

}
