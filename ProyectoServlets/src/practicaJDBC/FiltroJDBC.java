package practicaJDBC;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FiltroJDBC implements Filter{

	private final Logger log = LogManager.getRootLogger();
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest sreq, ServletResponse sresp, FilterChain fc) throws IOException, ServletException {

			//Integer id = new Integer(sreq.getParameter("id"));
			long antes;
			antes = System.currentTimeMillis();
			log.trace("Ha entrado en doFilter de la clase MiFiltro");
			fc.doFilter(sreq, sresp);
			long despues;
			despues = System.currentTimeMillis();
			log.trace("------------");
			log.trace("tiempo con JDBC: "+(despues-antes));
			log.trace("xxxxxxxxxxxx");
			
		
		/*long antes;
		antes = System.currentTimeMillis();
		log.trace("Ha entrado en doFilter de la clase MiFiltro");
		fc.doFilter(sreq, sresp);
		long despues;
		despues = System.currentTimeMillis();
		log.trace("------------");
		log.trace("tiempo con JDBC: "+(despues-antes));
		log.trace("xxxxxxxxxxxx");*/
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

		
	}

}
