package excepciones_I;

import javax.swing.JOptionPane;

public class Varias_Excepciones {

	public static void main(String[] args) {
		try {
			division();
		} catch (ArithmeticException e) {
			System.out.println("Estás dividiendo 0");
		} catch (NumberFormatException e) {
			System.out.println("No has introducido un número entero");
			// Devuelve el valor introducido
			System.out.println(e.getMessage());
			// Devuelve más información del error
			System.out.println("Se ha generado un error de este tipo " + e.getClass().getName());
		}
	}

	static void division() {
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el dividendo"));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce el divisor"));
		System.out.println("El resultado es: " + num1 / num2);
	}
}
