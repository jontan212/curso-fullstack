package beans;

import java.awt.Dimension;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class VisorDeImagenesBean extends JLabel {
	public VisorDeImagenesBean() {
		setBorder(BorderFactory.createEtchedBorder());
	}

	public void setEscogeImagen(String elegirImagen) {
		try {
			archivo = new File(elegirImagen);
			setIcon(new ImageIcon(ImageIO.read(archivo)));
		} catch (IOException e) {
			archivo = null;
			setIcon(null);
		}
	}

	public String getEscogeImagen() {
		if (archivo == null)
			return null;
		else
			return archivo.getPath();
	}

	public Dimension getPreferredSize() {
		return new Dimension(600, 400);
	}

	private File archivo = null;
}
