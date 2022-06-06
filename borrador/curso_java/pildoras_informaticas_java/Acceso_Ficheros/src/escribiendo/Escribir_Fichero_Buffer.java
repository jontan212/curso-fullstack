package escribiendo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escribir_Fichero_Buffer {
	public static void main(String[] args) {
		EscribiendoBuffer accedeEscritura = new EscribiendoBuffer();
		accedeEscritura.escribir();
	}
}

class EscribiendoBuffer {
	public void escribir() {
		String frase = "Esto es una prueba de escritura.";
		try {
			FileWriter escritura = new FileWriter("src/texto_nuevo.txt");
			BufferedWriter miBuffer = new BufferedWriter(escritura);
			miBuffer.write(frase);
			// Si no se cierra el Buffer el archivo estara en blanco
			miBuffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
