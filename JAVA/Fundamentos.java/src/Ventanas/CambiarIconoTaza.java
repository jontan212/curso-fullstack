/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.*;
import java.awt.event.*;

import java.net.*;
import java.awt.image.*;


public class CambiarIconoTaza  extends Frame{
    
    URL url;
    ImageProducer ip;
    Image img;
    
    CambiarIconoTaza()
    {
        
        this.setTitle("Cambiar Icono");
        
        //cambiar icono**********************************************
        try{
            
           url=new URL("file:///c:\\fullstack profe\\java\\bd.png") ;
            
        }catch(MalformedURLException mue){}
        
        try{
        ip=(ImageProducer)url.getContent();
        img=createImage(ip);
        }catch(Exception ex){}
        
        this.setIconImage(img);
        //*******************************************************
        this.setSize(500,500);
        
        
        this.setVisible(true);
        
        
    }
    
    
    public static void main(String[] args) {
        
        new CambiarIconoTaza();
    }
    
}