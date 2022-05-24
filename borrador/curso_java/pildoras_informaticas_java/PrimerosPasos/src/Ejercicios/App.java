package Ejercicios;

import java.util.Vector;

public class App {

	public static void imprimirOpciones() {
		System.out.println("********************* \n" + "| 1. Crear coche.   | \n" + "| 2. Listar coches. | \n"
				+ "| 3. Salir.         | \n" + "********************* \n");
	}

	public static void main(String[] args) {
		Vector<Coche> arrCoches = new Vector<Coche>();
		boolean salir = false;
		while (salir == false) {
			imprimirOpciones();
			String consola = Leer.porTeclado();
			switch (consola) {
			case "1":
				Coche c = new Coche();
				System.out.println("Creando coche. \n" + "Introduce la marca:");
				c.setMarca(Leer.porTeclado());
				System.out.println("Introduce el modelo:");
				c.setModelo(Leer.porTeclado());
				System.out.println("Introduce el número de caballos:");
				c.setMotor(Integer.parseInt(Leer.porTeclado()));
				arrCoches.add(c);
				System.out.println("Su coche ya ha sido creado. \n");
				break;
			case "2":
				System.out.println("Lista de coches: \n");
				arrCoches.forEach((coche) -> System.out.println("********* \n" + coche + "\n"));
				break;
			case "3":
				salir = true;
				break;
			default:
				System.out.println("Opción incorrecta, eliga una de las 3 opciones.");
				break;
			}
		}
		System.out.println("Ha salido del programa.");
	}

}
