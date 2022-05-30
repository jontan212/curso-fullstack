package graficos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PruebaEventos {

	public static void main(String[] args) {
		MarcoBotones mimarco = new MarcoBotones();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoBotones extends JFrame {
	public MarcoBotones() {
		setTitle("Botones y Eventos");
		setBounds(700, 300, 500, 300);
		LaminaConBotones milamina = new LaminaConBotones();
		add(milamina);
	}
}

class LaminaConBotones extends JPanel {
	// Se crea un botón con su texto
	JButton botonAzul = new JButton("Azul");
	JButton botonAmarillo = new JButton("Amarillo");
	JButton botonRojo = new JButton("Rojo");

	public LaminaConBotones() {
		// Se añade el botón a la lamina
		add(botonAzul);
		add(botonAmarillo);
		add(botonRojo);
		/*
		 * Se indica en el botón que va a desencadenar un evento de tipo click y por
		 * parámetro quien va a recibir el evento, en este caso la proppia lámina
		 */
//		ColorFondo Amarillo = new ColorFondo(Color.yellow);
//		ColorFondo Azul = new ColorFondo(Color.blue);
//		ColorFondo Rojo = new ColorFondo(Color.red);
		botonAzul.addActionListener(new ColorFondo(Color.BLUE));
		botonAmarillo.addActionListener(new ColorFondo(Color.YELLOW));
		botonRojo.addActionListener(new ColorFondo(Color.RED));
	}

	private class ColorFondo implements ActionListener {
		public ColorFondo(Color c) {
			colorDeFondo = c;
		}

		/*
		 * El método que recibe el evento, debe implementar la interfaz ActionListener
		 * el objeto que lo recibe, recibe por parámetro el tipo de evento, en este caso
		 * ActionEvent es del ratón
		 */
		public void actionPerformed(ActionEvent e) {
			/* Con getSource() nos desvuelve quién es el origen de la fuente del evento */
			Object botonPulsado = e.getSource();
			if (botonPulsado == botonAzul) {
				setBackground(Color.BLUE);
			} else if (botonPulsado == botonAmarillo) {
				setBackground(Color.YELLOW);
			} else {
				setBackground(Color.RED);
			}
		}

		private Color colorDeFondo;
	}
}
