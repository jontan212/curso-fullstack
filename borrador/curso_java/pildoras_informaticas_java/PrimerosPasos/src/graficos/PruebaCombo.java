package graficos;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.MidiEvent;
import javax.swing.*;

public class PruebaCombo {

	public static void main(String[] args) {
		MarcoCombo mimarco = new MarcoCombo();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoCombo extends JFrame {
	public MarcoCombo() {
		setBounds(50, 300, 550, 400);
		LaminaCombo milamina = new LaminaCombo();
		add(milamina);
		setVisible(true);
	}
}

class LaminaCombo extends JPanel {
	private JLabel texto;
	private JComboBox micombo;

	public LaminaCombo() {
		setLayout(new BorderLayout());
		texto = new JLabel("En un lugar de la Mancha de cuyo nombre...");
		texto.setFont(new Font("Serif", Font.PLAIN, 18));
		add(texto, BorderLayout.CENTER);
		JPanel lamina_norte = new JPanel();
		/* Crea selector */
		micombo = new JComboBox();
		/* Permite editar las opciones */
		micombo.setEditable(true);
		/* Crea sus opciones */
		micombo.addItem("Serif");
		micombo.addItem("SansSerif");
		micombo.addItem("Dialog");
		Evento_combo mievento = new Evento_combo();
		micombo.addActionListener(mievento);
		lamina_norte.add(micombo);
		add(lamina_norte, BorderLayout.NORTH);
	}

	private class Evento_combo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * El método get devuelve la opción elegida de tipo objeto y se convierte a
			 * String
			 */
			texto.setFont(new Font((String) micombo.getSelectedItem(), Font.PLAIN, 18));
		}
	}
}
