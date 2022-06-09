package fundamentos.java;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author manana
 */
import java.applet.Applet;
import javax.swing.*;

public class Hola_Alumnos extends JApplet {
	public void init() {
		JLabel rotulo = new JLabel("Hola alumnos");
		add(rotulo); // Agrega el componente anterior al applet
	}
}
