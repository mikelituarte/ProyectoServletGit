package practicaHibernate;

public class AdivinarNumero {

	private static int numeroAadivinar = -1;
	private static int maximo =100;
	private static int minimo= 1;
	
	
	public AdivinarNumero(){
		
	}
	
	public static int getNumeroAadivinar(){
		return numeroAadivinar;
	}
	public static void setNumeroAadivinar(int numeroAadivinar){
		numeroAadivinar = numeroAadivinar;
	}
	

	public static int getMaximo() {
		return maximo;
	}

	public static void setMaximo(int maximo) {
		AdivinarNumero.maximo = maximo;
	}

	public static int getMinimo() {
		return minimo;
	}

	public static void setMinimo(int minimo) {
		AdivinarNumero.minimo = minimo;
	}
	
	public static int procesarNumero(){
		return (maximo+minimo)/2;
	}
}
