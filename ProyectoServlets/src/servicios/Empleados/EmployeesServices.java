//package Empleados;
package servicios.Empleados;

import interfaces.interfaceRecuperable.Recuperable;

import java.sql.SQLException;

//import empleadoHibernateDAO.EmpleadoHibernateDAO;
//import interfaceRecuperable.Recuperable;

public class EmployeesServices {

	private Recuperable objetoDao;
	
	public void setRecuperable(Recuperable objetoDao){
		this.objetoDao = objetoDao;
	}
	
	public Object leerEmpleadoServices(int id)throws ClassNotFoundException, SQLException{
		Object empleado = null;
		empleado = this.objetoDao.leerEmpleado(id);//en funcion del tipo, llamara a un metodo o a otro (hibernate, jdb, hibernateJPa)
		return empleado;
	}
}
