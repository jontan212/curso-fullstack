/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.applet.Applet;

/**
 *
 * @author manana
 */
public class Distribuciones extends JApplet {

    JButton jb1;
    JButton jb2;
    Label l;
    JPanel jp;

    public void init() {
        //this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setLayout(new BorderLayout());
        ImageIcon img1 = new ImageIcon("C:\\Users\\manana\\Downloads\\camara.png");
        ImageIcon img2 = new ImageIcon("C:\\Users\\manana\\Downloads\\camara.png");
        jb1 = new JButton("Viajes", img1);
        jb2 = new JButton("Fotos", img2);
        l = new Label("Estado:                ");
        l.setBackground(Color.green);
        jp = new JPanel();
        jp.add(jb1);
        jp.add(jb2);

        this.add("North", jp);
        this.add("South", l);

        //this.setLayout(lm);
    }
}
