package mis_applets;

import java.applet.Applet;
import javax.swing.*;

public class Hola_Alumnos extends Applet {
	public void init() {
		JLabel rotulo = new JLabel("Hola alumnos");
		add(rotulo); // Agrega el componente anterior al applet
	}
}
