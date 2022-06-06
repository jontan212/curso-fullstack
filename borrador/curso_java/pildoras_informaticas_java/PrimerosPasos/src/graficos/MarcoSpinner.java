package graficos;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class MarcoSpinner {
	public static void main(String[] args) {
		FrameSpinner mimarco = new FrameSpinner();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class FrameSpinner extends JFrame {
	public FrameSpinner() {
		setBounds(550, 350, 550, 350);
		add(new LaminaSpinner());
		setVisible(true);
	}
}

class LaminaSpinner extends JPanel {
	public LaminaSpinner() {
		/* Clase anónima */
		JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1) {
			/* Oyente botón arriba */
			public Object getNextValue() {
				return super.getPreviousValue();
			}
			/* Oyente botón abajo */
			public Object getPreviousValue() {
				return super.getNextValue();
			}
		});
		Dimension d = new Dimension(200, 20);
		control.setPreferredSize(d);
		add(control);
	}
}
