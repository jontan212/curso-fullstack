package leyendo_escribiendo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lectura_Escritura {
	public static void main(String[] args) {
		int contador = 0;
		int datosEntrada[] = new int[126646];
		/*Leer byte*/
		try {
			FileInputStream archivoLectura = new FileInputStream("src/imagen.jpg");
			boolean finalArchivo = false;
			while (!finalArchivo) {
				int byteEntrada = archivoLectura.read();
				if (byteEntrada != -1) {
					datosEntrada[contador] = byteEntrada;
					System.out.println(datosEntrada[contador]);
					contador++;
				} else
					finalArchivo = true;
			}
			archivoLectura.close();
		} catch (IOException e) {
			System.out.println("Error al acceder a la imagen.");
			e.printStackTrace();
		}
		System.out.println("Total bytes: " + contador);
		creaFichero(datosEntrada);
	}
	/*Copiar y crear byte*/
	static void creaFichero(int[] datosNuevoFichero) {
		try {
			FileOutputStream ficheroNuevo = new FileOutputStream("src/imagen_copia.jpg");
			for (int i = 0; i < datosNuevoFichero.length; i++)
				ficheroNuevo.write(datosNuevoFichero[i]);
			ficheroNuevo.close();
		} catch (IOException e) {
			System.out.println("Error al crear el archivo.");
			e.printStackTrace();
		}
	}
}
