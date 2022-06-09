/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.awt.*;
import java.awt.event.*;

/*
public interface MouseListener{

public void mouseClicked(MouseEvent e);
public void mousePressed(MouseEvent e);
public void mouseReleased(MouseEvent e);
public void mouseEntered(MouseEvent e);
public void mouseExited(MouseEvent e);
}


public interface WindowListener{

public void windowClosing(WindowEvent e);
public void windowClosed(WindowEvent e);
public void windowIconified(WindowEvent e);
public void windowDeiconified(WindowEvent e);
public void windowActivated(WindowEvent e);
public void windowDeactivated(WindowEvent e);
public void windowOpened(WindowEvent e);

}

//dispose(); hace que la ventana se cierre

*/
public class Coordenadas extends Frame {
    Label lx,ly;
    TextField tx,ty;
    Panel p;
    Coordenadas()
    {
        this.setTitle("Coordenadas");
        this.setSize(700,600);
        this.setLayout(new BorderLayout());
        //crear los componentes
        lx = new Label("X:");
        ly = new Label("Y:");
        tx = new TextField(10);
        ty = new TextField(10);
        p=new Panel();
        p.setBackground(Color.orange);
        p.add(lx);
        p.add(tx);
        p.add(ly);
        p.add(ty);
        this.add("North",p);
        this.addMouseListener(new Raton());
        this.addWindowListener(new Ventana());
       
        this.setResizable(false);
        this.setVisible(true);
    }
public static void main(String[] args) {
    new Coordenadas(); 
    }
class Raton extends MouseAdapter{
   
   public void mouseClicked(MouseEvent e){    
   tx.setText(""+e.getX());
   ty.setText(String.valueOf(e.getY()));
//convierte de entero a cadena    
    } 
}//clase interna

class Ventana extends WindowAdapter{
   
   public void windowClosing(WindowEvent e){    
        dispose();
   
    } 
}//clase interna 

}//Clase externa
