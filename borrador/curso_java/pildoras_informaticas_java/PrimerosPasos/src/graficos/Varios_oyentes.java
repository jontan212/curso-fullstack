package graficos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Varios_oyentes {

	public static void main(String[] args) {
		Marco_Principal marco = new Marco_Principal();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}

}

class Marco_Principal extends JFrame {
	public Marco_Principal() {
		setTitle("Prueba varios");
		setBounds(1300, 100, 300, 200);
		Lamina_Principal lamina = new Lamina_Principal();
		add(lamina);
	}
}

class Lamina_Principal extends JPanel {
	JButton boton_cerrar;

	public Lamina_Principal() {
		JButton boton_nuevo = new JButton("Nuevo");
		add(boton_nuevo);
		boton_cerrar = new JButton("Cerrar todo");
		add(boton_cerrar);
		OyenteNuevo miOyente = new OyenteNuevo();
		boton_nuevo.addActionListener(miOyente);
	}

	private class OyenteNuevo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/* Se le pasa el boton fuente */
			Marco_Emergente marco = new Marco_Emergente(boton_cerrar);
			marco.setVisible(true);
		}
	}
}

class Marco_Emergente extends JFrame {
	private static int contador = 0;

	public Marco_Emergente(JButton boton_de_principal) {
		contador++;
		setTitle("Ventana " + contador);
		setBounds(40 * contador, 40 * contador, 300, 150);
		/* El boton se le asigana el addActionListener */
		boton_de_principal.addActionListener(new CierraTodos());
	}

	private class CierraTodos implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/* Cierra la ventana */
			dispose();
		}
	}
}
