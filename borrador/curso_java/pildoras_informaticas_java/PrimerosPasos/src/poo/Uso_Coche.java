package poo;

public class Uso_Coche {

	public static void main(String[] args) {
		// Instanciar una clase
		Coche renault = new Coche(4, 100, 20, 1, 700);
		// Se usa el método get para obtener el número de ruedas
		System.out.println(renault.getRuedas());
		// Se usa el método set para modificar el número de ruedas
		renault.setRuedas(6);
		// Devuelve 6 ruedas
		System.out.println(renault.getRuedas());

		System.out.println(renault.toString());
	}

}
