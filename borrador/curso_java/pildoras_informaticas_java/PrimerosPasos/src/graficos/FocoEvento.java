package graficos;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Iterator;

import javax.swing.*;

public class FocoEvento {

	public static void main(String[] args) {
		MarcoFoco mimarco = new MarcoFoco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoFoco extends JFrame {
	public MarcoFoco() {
		setVisible(true);
		setBounds(300, 300, 600, 450);
		add(new LaminaFoco());
	}
}

class LaminaFoco extends JPanel {
	/* Cuadros de texto */
	JTextField cuadro1;
	JTextField cuadro2;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/* Invalida la colocación por defecto */
		setLayout(null);
		cuadro1 = new JTextField();
		cuadro2 = new JTextField();

		cuadro1.setBounds(120, 10, 150, 20);
		cuadro2.setBounds(120, 50, 150, 20);

		add(cuadro1);
		add(cuadro2);

		LanzaFocos elFoco = new LanzaFocos();
		cuadro1.addFocusListener(elFoco);
	}

	private class LanzaFocos implements FocusListener {
		/* Cuando gana el foco */
		public void focusGained(FocusEvent e) {
		}

		/* Cuando pierde el foco */
		public void focusLost(FocusEvent e) {
			String email = cuadro1.getText();
			boolean comprobacion = false;
			for (int i = 0; i < email.length(); i++) {
				if (email.charAt(i) == '@') {
					comprobacion = true;
				}
			}
			if (comprobacion) {
				System.out.println("Correcto");
			} else {
				System.out.println("Incorrecto");
			}
		}
	}
}
