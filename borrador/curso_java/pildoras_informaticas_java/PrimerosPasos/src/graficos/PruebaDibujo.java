package graficos;

import java.awt.*;

import javax.swing.*;
import java.awt.geom.*;

public class PruebaDibujo {

	public static void main(String[] args) {
		MarcoConDibujos mimarco = new MarcoConDibujos();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoConDibujos extends JFrame {
	public MarcoConDibujos() {
		setTitle("prueba de Dibujo");
		setSize(400, 400);
		LaminaConFiguras milamina = new LaminaConFiguras();
		add(milamina);
	}
}

class LaminaConFiguras extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Primero se hace una refundición
		Graphics2D g2 = (Graphics2D) g;

		// La clase Rectangle2D es abstracta, así que se instancia su clase interna
		// Double
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		// Método para pintar el elemento
		g2.draw(rectangulo);

		Ellipse2D elipse = new Ellipse2D.Double();
		// Se utiliza la base del rectangulo para crear la elipse
		elipse.setFrame(rectangulo);
		g2.draw(elipse);

		// Línea
		g2.draw(new Line2D.Double(100, 100, 300, 250));

		// Centro del rectángulo
		double CentroenX = rectangulo.getCenterX();
		double CentroenY = rectangulo.getCenterY();
		double radio = 150;
		Ellipse2D circulo = new Ellipse2D.Double();
		// Establece la elipse en función de las coordenadas del punto central y las
		// coordenadas del punto de esquina especificados
		circulo.setFrameFromCenter(CentroenX, CentroenY, CentroenX + radio, CentroenY + radio);
		g2.draw(circulo);
	}
}
