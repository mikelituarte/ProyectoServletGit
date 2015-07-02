package practicaHibernate;

import java.util.HashMap;
import java.util.Map;

import hibernateAll.sesion.manager.SesionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

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
		int numeroPeticiones =0;
		HashMap<String,  HttpSession> sesionesActivas = new HashMap<String,  HttpSession>();
		SessionFactory sf = SesionManager.getSesionFactory();
		ServletContext servletContext = null;
		servletContext = sce.getServletContext();
		servletContext.setAttribute("sf", sf);
		servletContext.setAttribute("numeroPeticiones", numeroPeticiones);
		servletContext.setAttribute("sesionesActivas", sesionesActivas);
		
		servletContext.setAttribute("maximo", 100);
		servletContext.setAttribute("minimo", 1);
		servletContext.setAttribute("numero", -1);
		
		System.out.println("Ha pasado por: ClaseServletContextListener, metodo: contextInitialized");
	}

}
