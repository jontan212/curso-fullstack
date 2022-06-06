package ficheros_directorios;

import java.io.File;

public class Pruebas_rutas {
	public static void main(String[] args) {
		// Al no indicar una ruta como C:/Users/... lo que hace es tomar la carpeta del
		// proyecto como ruta por defecto
		File archivo = new File("ejemplo_archivo");
		/* Devuelve la ruta abosoluta con el parámatero pasado al constructor */
		System.out.println(archivo.getAbsolutePath());
		/* Comprueba si existe */
		System.out.println(archivo.exists());
		File carpeta = new File("bin");
		System.out.println(carpeta.getAbsolutePath());
		System.out.println(carpeta.exists());
	}
}
