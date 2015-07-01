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
		String contenido = "21/12/14 15:35 0";
		System.out.println(contenido.charAt(contenido.length()-1));
		
		//System.out.println(isNumeric(numero));
	}
}
