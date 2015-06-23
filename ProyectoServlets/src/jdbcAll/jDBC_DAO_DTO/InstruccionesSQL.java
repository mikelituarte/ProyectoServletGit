package jdbcAll.jDBC_DAO_DTO;

public class InstruccionesSQL {

	////public static String consultarSueldo
	
	public static final String consultaSueldo = " SELECT * " +
            									" FROM employees " +
            									" WHERE salary > 3000 " +
            									" ORDER BY salary DESC ";
	
	public static final String LEER_EMPLEADO = "SELECT * FROM employees WHERE employee_id =?";

}
