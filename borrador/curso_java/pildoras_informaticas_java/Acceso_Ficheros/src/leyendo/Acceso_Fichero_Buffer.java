package leyendo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Acceso_Fichero_Buffer {
	public static void main(String[] args) {
		LeerFicheroBuffer accediendo = new LeerFicheroBuffer();
		accediendo.lee();
	}

}

class LeerFicheroBuffer {

	public void lee() {
		try {
			FileReader entrada = new FileReader("src/ejemplo.txt");
			BufferedReader miBuffer = new BufferedReader(entrada);
			String linea = miBuffer.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = miBuffer.readLine();
			}
			miBuffer.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo.");
			e.printStackTrace();
		}
	}
}
