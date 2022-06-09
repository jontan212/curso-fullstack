/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.awt.*;
import java.awt.event.*;

public class Ventana1 extends Frame implements ActionListener{
     Button b;
     static Ventana2 v2;
    Ventana1()
    {
        this.setTitle("Mi Ventana 1");
        this.setSize(500,500);
        this.setLayout(new FlowLayout());
        
        //crear los componentes
        b=new Button("Abrir Ventana 2");
       
        //añadir
        this.add(b);
    
        //******************************************
         this.addWindowListener(new WindowAdapter()
         {
                public void windowClosing(WindowEvent e)
                {
                 
                dispose();
                System.exit(0);
                }
         }//clase anónima
         );
         //***********************************************************
        //añadir source a listener
        b.addActionListener(this);
        this.setVisible(true);//last line
    }
     public void actionPerformed(ActionEvent e)
    { 
        if(e.getSource()==b)
        {
            if(v2==null)
            {
          v2= new Ventana2();
            }
        }  
    }
    public static void main(String[] args) {
       
        new Ventana1();
        
    } 
}