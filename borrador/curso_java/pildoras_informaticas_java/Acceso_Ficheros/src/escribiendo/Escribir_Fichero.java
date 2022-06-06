package escribiendo;
import java.io.FileWriter;
import java.io.IOException;
public class Escribir_Fichero {
	public static void main(String[] args) {
		Escribiendo accedeEscritura = new Escribiendo();
		accedeEscritura.escribir();
	}
}

class Escribiendo {
	public void escribir() {
		String frase = "Esto es una prueba de escritura.";
		try {
			// Siempre sobreescribe un archivo con ese nombre, si no existe lo crea
			FileWriter escritura = new FileWriter("src/texto_nuevo.txt");
			
			// El 2do arg (true) agrega a continuacion del final
			// FileWriter escritura = new FileWriter("src/texto_nuevo.txt", true);
			
			// Este for no es necesario ya que con solo escritura.write(frase); escribe toda la frase
			for(int i = 0; i < frase.length(); i++)
				escritura.write(frase.charAt(i));			
			escritura.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
