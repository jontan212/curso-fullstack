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
		addMouseMotionListener(EventoRaton);
	}
}

class EventosDeRaton implements MouseMotionListener {
	/* Mientras arrastro algo */
	public void mouseDragged(MouseEvent e) {
		System.out.println("Estás arrastrando");
	}

	/* Mientras muevo el ratón */
	public void mouseMoved(MouseEvent e) {
		System.out.println("Estás moviendo");
	}

}
