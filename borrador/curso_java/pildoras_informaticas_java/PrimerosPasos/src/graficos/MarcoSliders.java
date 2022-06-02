package graficos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class MarcoSliders {

	public static void main(String[] args) {
		Frame_Sliders mimarco = new Frame_Sliders();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Frame_Sliders extends JFrame {
	public Frame_Sliders() {
		setBounds(550, 400, 550, 350);
		Lamina_Sliders milamina = new Lamina_Sliders();
		add(milamina);
		setVisible(true);
	}
}

class Lamina_Sliders extends JPanel {
	public Lamina_Sliders() {
		/* Crear JSlider */
		JSlider control = new JSlider(0, 108, 50);
		/* Lineas mayores */
		control.setMajorTickSpacing(25);
		/* Lineas menores */
		control.setMinorTickSpacing(5);
		/* Pinta las lineas */
		control.setPaintTicks(true);
		/* Pintar números */
		control.setPaintLabels(true);
		add(control);
	}
}
