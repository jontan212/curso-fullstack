package graficos;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Sintaxis_radio {
	public static void main(String[] args) {
		Marco_radio_sintaxis mimarco = new Marco_radio_sintaxis();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Marco_radio_sintaxis extends JFrame {
	public Marco_radio_sintaxis() {
		setBounds(550, 300, 500, 300);
		Lamina_radio_sintaxis milamina = new Lamina_radio_sintaxis();
		add(milamina);
		setVisible(true);
	}
}

class Lamina_radio_sintaxis extends JPanel {
	public Lamina_radio_sintaxis() {
		/* Se crea un grupo */
		ButtonGroup migrupo1 = new ButtonGroup();
		/* Se creo los botones de radio */
		JRadioButton boton1 = new JRadioButton("Azul", false);
		JRadioButton boton2 = new JRadioButton("Rojo", true);
		JRadioButton boton3 = new JRadioButton("Verde", false);
		/* Se asigna los botones al grupo */
		migrupo1.add(boton1);
		migrupo1.add(boton2);
		migrupo1.add(boton3);
		/* Se añaden los botones a la lámina */
		add(boton1);
		add(boton2);
		add(boton3);
	}
}
