/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.*;
import java.awt.event.*;

public class Ventana2 extends Frame {
    
    Ventana2()
    {
        this.setTitle("Mi Ventana 2");
        this.setSize(500,500);
        //******************************************
         this.addWindowListener(new WindowAdapter()
         {
                public void windowClosing(WindowEvent e)
                {
                    
                Ventana1.v2=null; 
                dispose();
                }
         }//clase anónima
         );
         //***********************************************************
        this.setVisible(true);//last line
    }
    
    
}
