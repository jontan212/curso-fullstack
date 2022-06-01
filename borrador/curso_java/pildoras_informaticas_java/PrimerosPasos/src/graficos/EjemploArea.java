package graficos;

import java.awt.event.*;

import javax.swing.*;

public class EjemploArea {

	public static void main(String[] args) {
		MarcoArea mimarco = new MarcoArea();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoArea extends JFrame {
	public MarcoArea() {
		setBounds(500, 300, 500, 350);
		LaminaArea milamina = new LaminaArea();
		add(milamina);
		setVisible(true);
	}
}

class LaminaArea extends JPanel {
	private JTextArea miarea;

	public LaminaArea() {
		/* Área de texto */
		miarea = new JTextArea(8, 20);
		/* Lamina con barras */
		JScrollPane laminaBarras = new JScrollPane(miarea);
		/* Determina si se podrá alargar horizontalmente */
		// miarea.setLineWrap(true);
		add(laminaBarras);
		JButton miboton = new JButton("Dale");
		miboton.addActionListener(new GestionaArea());
		add(miboton);
	}

	private class GestionaArea implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println(miarea.getText());
		}
	}
}

