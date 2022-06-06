package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class UsoEmpleado {
	public static void main(String[] args) {
		// Los arraylist reservan un espacio inicial en memoria para 10 elementos
		// Cuando se excede, se crea otra copia con un elemento mas, se muda y borra el
		// anterior
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		// Le indico inicialmente la capacidad, si la supero no pasa nada
		listaEmpleados.ensureCapacity(11);
		listaEmpleados.add(new Empleado("Ana", 45, 2500));
		listaEmpleados.add(new Empleado("Antonio", 55, 2600));
		listaEmpleados.add(new Empleado("Maria", 25, 2000));
		listaEmpleados.add(new Empleado("Jose", 22, 2000));
		listaEmpleados.trimToSize(); // Hago que el garbage collector recorte del array el espacio que no utilice
		// Aun después de este metodo puedo seguir agregando pero consumire más recursos

		System.out.println("Cantidad de empleados: " + listaEmpleados.size());
		// Introduce un elemento en la posición elegida
		listaEmpleados.set(1, new Empleado("Olga", 22, 2000));
		// Devuelve el elemento según el par
		System.out.println("El 3er empleado es: " + listaEmpleados.get(2).dameDatos());
		
		System.out.println("La lista de todos los empleados es:");
		for (Empleado e : listaEmpleados)
			System.out.println(e.dameDatos());
		
		// Lo que ocurre en iterador repercute en el arraylist, supongamos un remove()
		System.out.println("La lista de todos los empleados usando un iterador:");
		Iterator<Empleado> miIterador = listaEmpleados.iterator();
		while (miIterador.hasNext()) {
			Empleado miEmpleado = miIterador.next();
			System.out.println(miEmpleado.dameDatos());
			if (miEmpleado.getNombre().equals("Jose"))
				miIterador.remove();
		}
		
		System.out.println("Paso a los empleados a un array:");
		Empleado[] arrayEmpleados = new Empleado[listaEmpleados.size()];
		listaEmpleados.toArray(arrayEmpleados); // Lo convierte a array
		for (int i = 0; i < arrayEmpleados.length; i++) {
			System.out.println(arrayEmpleados[i].dameDatos());
		}
	}

}

class Empleado {
	public Empleado(String nombre, int edad, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String dameDatos() {
		return "El empleado se llama " + nombre + ". Tiene " + edad + " años y un salario de " + salario;
	}

	private String nombre;
	private int edad;
	private double salario;
}
