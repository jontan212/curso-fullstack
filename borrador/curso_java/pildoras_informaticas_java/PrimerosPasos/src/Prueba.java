import java.awt.GraphicsEnvironment;

import javax.swing.*;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.printf("%1.2f", 10.32869);
		String[] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String nombredelafuente : nombresDeFuentes) {

			System.out.println(nombredelafuente);
		}
	}

}
