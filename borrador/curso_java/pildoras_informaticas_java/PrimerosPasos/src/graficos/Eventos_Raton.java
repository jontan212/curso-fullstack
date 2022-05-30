package graficos;

import java.awt.event.*;

import javax.swing.*;

public class Eventos_Raton {

	public static void main(String[] args) {
		MarcoRaton mimarco = new MarcoRaton();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoRaton extends JFrame {
	public MarcoRaton() {
		setVisible(true);
		setBounds(700, 300, 600, 450);
		EventosDeRaton EventoRaton = new EventosDeRaton();
		addMouseListener(EventoRaton);
	}
}
class EventosDeRaton implements MouseListener {
	/* Si al pulsar se mueve en el proceso, no funciona */
	public void mouseClicked(MouseEvent e) {
		System.out.println("has hecho click");
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("Acabas de presionar");
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("Acabas de levantar");
	}

	public void mouseEntered(MouseEvent e) {
		System.out.println("Acabas de entrar");
	}

	public void mouseExited(MouseEvent e) {
		System.out.println("Acabas de salir");
	}
}



