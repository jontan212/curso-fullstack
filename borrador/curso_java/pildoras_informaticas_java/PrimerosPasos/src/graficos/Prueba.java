package graficos;

import java.time.temporal.JulianFields;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class Prueba {
	public static void main(String[] args) {
		MarcoPrueba mimarco = new MarcoPrueba();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoPrueba extends JFrame {
	public MarcoPrueba() {
		setBounds(500, 300, 500, 350);
		LaminaPrueba milamina = new LaminaPrueba();
		add(milamina);
		setVisible(true);
	}
}

class LaminaPrueba extends JPanel {
	public LaminaPrueba() {
		JTextField micampo = new JTextField(20);
		EscuchaTexto el_evento = new EscuchaTexto();
		/* Se obtiene el document de JTextField */
		Document midoc = micampo.getDocument();
		/* Se pone el documento a la escucha */
		midoc.addDocumentListener(el_evento);
		add(micampo);
	}

	private class EscuchaTexto implements DocumentListener {
		/* Cuando se inserta texto */
		public void insertUpdate(DocumentEvent e) {
			System.out.println("Has insertado texto");
		}

		/* Cuando elimina texto */
		public void removeUpdate(DocumentEvent e) {
			System.out.println("Has borrado texto");
		}

		public void changedUpdate(DocumentEvent e) {
		}
	}
}
