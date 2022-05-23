
public class manipula_cadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre = "Juan";
		System.out.println("Mi nombre es " + nombre);
		System.out.println("Mi nombre es " + nombre.length() + " letras.");
		System.out.println("La primera letra de mi nombre es " + nombre + " es la " + nombre.charAt(0));
		System.out
				.println("La última letra de mi nombre es " + nombre + " es la " + nombre.charAt(nombre.length() - 1));
		String alumno1, alumno2;
		alumno1 = "David";
		alumno2 = "david";
		System.out.println(alumno1.equals(alumno2));
	}

}
