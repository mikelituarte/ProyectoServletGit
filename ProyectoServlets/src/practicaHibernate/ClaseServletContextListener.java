package practicaHibernate;

import hibernateAll.sesion.manager.SesionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;

public class ClaseServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		/*SessionFactory sf = SesionManager.getSesionFactory();
		ServletContext servletContext = null;*/
		System.out.println("Ha pasado por: ClaseServletContextListener, metodo: contextDestroyed");
		/*servletContext = sce.getServletContext();
		servletContext.setAttribute("sf", sf);*/
		ServletContext sc = sce.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		sf.close();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		SessionFactory sf = SesionManager.getSesionFactory();
		ServletContext servletContext = null;
		servletContext = sce.getServletContext();
		servletContext.setAttribute("sf", sf);
		
		System.out.println("Ha pasado por: ClaseServletContextListener, metodo: contextInitialized");
	}

}
