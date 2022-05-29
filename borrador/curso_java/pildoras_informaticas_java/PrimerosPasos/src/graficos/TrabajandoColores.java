package graficos;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class TrabajandoColores {

	public static void main(String[] args) {
		MarcoConColor mimarco = new MarcoConColor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mimarco.setVisible(true);
	}

}

class MarcoConColor extends JFrame {
	public MarcoConColor() {
		setTitle("prueba de Colores");
		setSize(400, 400);
		LaminaConColor milamina = new LaminaConColor();
		add(milamina);
		// Cambia el color de fondo de la lamina, el parámetro es el color de sistema de ventanas
		milamina.setBackground(SystemColor.window);
		// Se usa para cambiar el color de letra
		milamina.setForeground(Color.PINK);
	}
}

class LaminaConColor extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		// Se establece el color que va usar
		g2.setPaint(Color.blue);
		// Se pinta el contorno
		g2.draw(rectangulo);
		// Se vuelve a esteblecer un color
		g2.setPaint(Color.RED);
		// Se pinta el rectangulo con su relleno
		g2.fill(rectangulo);

		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		// Se instancia un color mediante sistema RGB
		Color micolor = new Color(125, 189, 200);
		//Se vuelve establecer el último color elegido
		g2.setPaint(micolor);
		// Se pinta su relleno
		g2.fill(elipse);
	}
}


