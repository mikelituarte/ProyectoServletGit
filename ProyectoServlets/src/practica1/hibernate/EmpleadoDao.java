package practica1.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import tablas_Clases.Employees;

public class EmpleadoDao {

	private  Session sesion;
	private static Configuration configuration;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	
	
	public EmpleadoDao(){
    	configuration = new Configuration().configure();
    	builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    	factory = configuration.buildSessionFactory(builder.build());//Solo se hace una vez en cada programa
	}
	
	
	public Employees obtenerEmpleado(Object id){
		
		Session sesion = null;;
		Transaction transaccion = null;
		Employees empleado = null;
		try{
			sesion = factory.openSession();
			transaccion = sesion.beginTransaction();
			empleado = (Employees)sesion.get(Employees.class, (Serializable) id);
		}
		catch(Exception e){
			e.printStackTrace();
			transaccion.rollback();
		}
		finally{
			sesion.disconnect();
			sesion.close();
			factory.close();
		}
		return empleado;
	}
}
