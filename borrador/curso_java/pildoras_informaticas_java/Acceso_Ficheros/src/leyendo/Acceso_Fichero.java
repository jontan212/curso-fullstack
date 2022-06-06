package leyendo;

import java.io.FileReader;
import java.io.IOException;

public class Acceso_Fichero {
	public static void main(String[] args) {
		LeerFichero accediendo = new LeerFichero();
		accediendo.lee();
	}
}

class LeerFichero {
	public void lee() {
		try {
			FileReader entrada = new FileReader("src/ejemplo.txt");
			// Lee el archivo y cuando llegue al final devolverá -1
			int c = entrada.read();
			while (c != -1) {
				// Se hace la conversión para que sea legible
				char letra = (char) c;
				System.out.print(letra);
				c = entrada.read();
			}
			// Se cierra
			entrada.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo.");
			e.printStackTrace();
		}
	}

}