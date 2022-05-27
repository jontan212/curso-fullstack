import java.util.*;

public class Uso_Tallas {
	enum Talla {
		MINI("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");
		// Constructor
		private Talla(String abreviatura) {
			this.abreviatura = abreviatura;
		}
		// Método get
		public String dameAbreviatura() {
			return abreviatura;
		}
		// Variable que almacena la opción elegida
		private String abreviatura;
	}

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String entrada_datos = entrada.next().toUpperCase();
		/* Devuelve la constante enum del tipo enum especificado
		en el primer parámetro y con el nombre que busca en el segundo parámetro */
		Talla la_talla = Enum.valueOf(Talla.class, entrada_datos);
		System.out.println("Talla=" + la_talla);
		System.out.println("Abreviatura=" + la_talla.dameAbreviatura());
	}

}

//public class Uso_Tallas {
//	enum Talla {
//		MINI, MEDIANO, GRANDE, MUY_GRANDE
//	}
//
//	public static void main(String[] args) {
//		Talla s = Talla.MINI;
//		Talla m = Talla.MEDIANO;
//		Talla l = Talla.GRANDE;
//		Talla xl = Talla.MUY_GRANDE;
//		System.out.println(xl);
//	}
//
//}