package graficos;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.*;

public class CambioEstado {

	public static void main(String[] args) {
		MarcoEstado mimarco = new MarcoEstado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoEstado extends JFrame {
	public MarcoEstado() {
		setVisible(true);
		setBounds(300, 300, 500, 350);
		CambiaEstado nuevo_estado = new CambiaEstado();
		addWindowStateListener(nuevo_estado);
	}
}

class CambiaEstado implements WindowStateListener {
	public void windowStateChanged(WindowEvent e) {
		if (e.getNewState() == Frame.MAXIMIZED_BOTH) {
			System.out.println("La ventana está a pantalla completa");
		} else if (e.getNewState() == Frame.NORMAL) {
			System.out.println("La ventana está normal");
		} else if (e.getNewState() == Frame.ICONIFIED) {
			System.out.println("La ventana está minimizada");
		}
	}
}


