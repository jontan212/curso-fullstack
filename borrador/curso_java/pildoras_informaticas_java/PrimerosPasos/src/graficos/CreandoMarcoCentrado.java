package graficos;

import java.awt.*;

import javax.swing.JFrame;

public class CreandoMarcoCentrado {

	public static void main(String[] args) {
		MarcoCentrado mimarco = new MarcoCentrado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

class MarcoCentrado extends JFrame {
	public MarcoCentrado() {
		// Devuelve nuestro sistema nativo de ventanas
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		// Devuelve las dimensiones de la pantalla
		Dimension tamanoPantalla = mipantalla.getScreenSize();
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		setSize(anchoPantalla / 2, alturaPantalla / 2);
		setLocation(anchoPantalla / 4, alturaPantalla / 4);
		setTitle("marcoCentrado");
		// Imagen que se pasará al icono de la ventana
		Image miIcono = mipantalla.getImage("src/graficos/icono.jpg");
		setIconImage(miIcono);
	}
}

