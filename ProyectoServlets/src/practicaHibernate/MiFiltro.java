package practicaHibernate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
		long antes;
		antes = System.currentTimeMillis();
		log.trace("Ha entrado en doFilter de la clase MiFiltro");
		fc.doFilter(sreq, sresp);
		long despues;
		despues = System.currentTimeMillis();
		log.trace("------------");
		log.trace("tiempo con Hibernate"+(despues-antes));
		log.trace("xxxxxxxxxxxx");
		
	}



}
