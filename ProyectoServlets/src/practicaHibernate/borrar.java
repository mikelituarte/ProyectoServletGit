package practicaHibernate;

public class borrar {

	
	private static boolean isNumeric(String cadena){

		try {

			Integer.parseInt(cadena);

			return true;

		} catch (NumberFormatException nfe){

			return false;

		}

	}


	
	public static void main(String[] args) {
		String numero = "13";
		
		System.out.println(isNumeric(numero));
	}
}
