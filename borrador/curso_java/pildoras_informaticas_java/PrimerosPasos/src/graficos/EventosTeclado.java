package graficos;

import java.awt.event.*;
import java.awt.Font;

import javax.swing.*;

public class EventosTeclado {

	public static void main(String[] args) {
		MarcoConTeclas mimarco = new MarcoConTeclas();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoConTeclas extends JFrame {
	public MarcoConTeclas() {
		setVisible(true);
		setBounds(700, 300, 600, 450);
		EventoDeTeclado tecla = new EventoDeTeclado();
		addKeyListener(tecla);
	}
}

class EventoDeTeclado implements KeyListener {

	public void keyPressed(KeyEvent e) {
		// Devuelve el código
		int codigo = e.getKeyCode();
		System.out.println(codigo);
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
		// Devuelve la letra
		char letra = e.getKeyChar();
		System.out.println(letra);

	}
}
