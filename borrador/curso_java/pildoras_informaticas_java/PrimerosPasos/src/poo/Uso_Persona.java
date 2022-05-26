package poo;

public class Uso_Persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

abstract class Persona {
	public Persona(String nom) {
		nombre = nom;
	}

	public String dameNombre() {
		return nombre;
	}

	public abstract String dameDescripcion();

	private String nombre;
}

// Clase que hereda de la clase asbtracta Persona
//class Empleado2 extends Persona {
//	public String dameDescripcion() {
//		return "Este empleado tiene un Id= " + Id + " con un sueldo=" + sueldo;
//	}
//
//	private double sueldo;
//	private int Id;
//}

// Clase que hereda de la clase asbtracta Persona
class Alumno extends Persona {
	public Alumno(String nom, String car) {
		super(nom);
		carrera = car;
	}
	// Método que es obligado a sobrescribir 
	public String dameDescripcion() {
		return "Este alumno esta estudiando la carrera de" + carrera;
	}

	private String carrera;
}

