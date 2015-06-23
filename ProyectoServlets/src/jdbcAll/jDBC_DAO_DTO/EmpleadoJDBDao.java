package jdbcAll.jDBC_DAO_DTO;



import interfaces.interfaceRecuperable.Recuperable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoJDBDao implements Recuperable {

	public EmpleadoDTO componerEmpleado(ResultSet rset) throws SQLException{
		 String employee_id;
		 String first_name;
		 String last_name;
		 String email;
		 String phone_number;
		 String hire_date;
		 String job_id;
		 int salary;
		 int commission_pct;
		 String manager_id;
		 String departament_id;
		 EmpleadoDTO e= null;
		while(rset.next()){
			  employee_id = rset.getString(1);
			  first_name = rset.getString(2);
			  last_name = rset.getString(3);
			  email = rset.getString(4);
			  phone_number = rset.getString(5);
			  hire_date = rset.getString(6);
			  job_id = rset.getString(7);
			  salary = rset.getInt(8);
			  commission_pct = rset.getInt(9);
			  manager_id = rset.getString(10);
			  departament_id = rset.getString(11);
			  e = new EmpleadoDTO(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, departament_id);
		}
		return e;
	}


	@Override
	public Object leerEmpleado(int id) throws ClassNotFoundException, SQLException{
		
		EmpleadoDTO empleadoDTO = null;
		ResultSet rset = null;
		
		
		//Connection nuevaConexion = Conexion.obtenerConexion();
		Connection nuevaConexion = Pool.getConnection();
		PreparedStatement pstm = nuevaConexion.prepareStatement(InstruccionesSQL.LEER_EMPLEADO);
		pstm.setInt(1, id);
		rset = pstm.executeQuery();
		empleadoDTO = componerEmpleado(rset);
		//Conexion.liberarRecursos(nuevaConexion, pstm, rset);
		Pool.liberarRecursos(nuevaConexion, pstm, rset);
		return empleadoDTO;
	}
}
