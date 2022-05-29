package graficos;

import javax.swing.*;
import java.awt.*;

public class EscribiendoEnMarco {

	public static void main(String[] args) {
		MarcoConTexto mimarco = new MarcoConTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Lamina extends JPanel {
	public void paintComponent(Graphics g) {
		// Super ejecutará el código heredado antes de sobrescribirlo
		super.paintComponent(g);
		// Pintará en pantalla este texto
		g.drawString("Estamos aprendiendo Swing", 100, 100);
	}
}

class MarcoConTexto extends JFrame {
	public MarcoConTexto() {
		setVisible(true);
		setSize(600, 450);
		setLocation(400, 200);
		setTitle("primer texto");
		Lamina milamina = new Lamina();// Se crea una lamina
		add(milamina);// Se añade la lamina al marco
	}
}
