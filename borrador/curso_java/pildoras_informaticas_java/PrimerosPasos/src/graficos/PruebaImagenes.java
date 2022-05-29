package graficos;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;

public class PruebaImagenes {

	public static void main(String[] args) {
		MarcoImagen mimarco = new MarcoImagen();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoImagen extends JFrame {
	public MarcoImagen() {
		setTitle("Marco Con Imagen");
		setBounds(750, 300, 300, 200);
		LaminaConImagen milamina = new LaminaConImagen();
		add(milamina);
	}
}

class LaminaConImagen extends JPanel {
	private Image imagen;

	public LaminaConImagen() {
		try {
			imagen = ImageIO.read(new File("src/graficos/earth.gif"));
		} catch (IOException e) {
			System.out.println("la imagen no se encuentra");
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// File miimagen = new File("src/graficos/hitler.jpg");

		int anchuralmagen = imagen.getWidth(this);
		int alturalmagen = imagen.getHeight(this);
		g.drawImage(imagen, 0, 0, null);
		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 4; j++) {
				if (i + j > 0) {
					g.copyArea(0, 0, anchuralmagen, alturalmagen, anchuralmagen * i, alturalmagen * j);
				}
			}
		}
	}
}
