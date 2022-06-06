package graficos;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MarcoMenu {
	public static void main(String[] args) {
		MenuFrame mimarco = new MenuFrame();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MenuFrame extends JFrame {
	public MenuFrame() {
		setBounds(500, 300, 550, 400);
		MenuLamina milamina = new MenuLamina();
		add(milamina);
		setVisible(true);
	}
}

class MenuLamina extends JPanel {
	public MenuLamina() {
		/*--- Crear barra de menú ---*/
		JMenuBar mibarra = new JMenuBar();
		/*--- Opciones de la barra ---*/
		JMenu archivo = new JMenu("Archivo");
		JMenu edicion = new JMenu("Edición");
		JMenu herramientas = new JMenu("Herramientas");
		/* Submenú */
		JMenu opciones = new JMenu("Opciones");
		/*--- Opciones ---*/
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem guardar_como = new JMenuItem("Guardar Como");
		JMenuItem cortar = new JMenuItem("Cortar");
		JMenuItem copiar = new JMenuItem("Copiar");
		JMenuItem pegar = new JMenuItem("Pegar");
		JMenuItem generales = new JMenuItem("Generales");
		/* Opciones del submenú */
		JMenuItem opcion1 = new JMenuItem("Opción 1");
		JMenuItem opcion2 = new JMenuItem("Opción 1");
		/* Opciones submenú */
		opciones.add(opcion1);
		opciones.add(opcion2);
		/*--- Opciones ---*/
		archivo.add(guardar);
		archivo.add(guardar_como);
		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		/* Separador */
		edicion.addSeparator();
		/* Submenú */
		edicion.add(opciones);
		herramientas.add(generales);
		/*--- Opciones de la barra ---*/
		mibarra.add(archivo);
		mibarra.add(edicion);
		mibarra.add(herramientas);
		/*--- Barra ---*/
		add(mibarra);
	}
}
