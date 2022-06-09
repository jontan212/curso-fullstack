package Ventanas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageProducer;
import java.net.MalformedURLException;
import java.net.URL;

public class MenuBD extends JFrame implements ActionListener{
    URL url;
    ImageProducer ip;
    Image img;
    TextArea ta;
    Label estado;
    MenuBar mbarra;
    Menu m1,m2,m3,m4;
    MenuItem m11,m12,m13,m14,m21,m22,m23,m24,m31,m41,m42;
    
    MenuBD()
    {
        this.setTitle("Base de Datos");
        this.setLayout(new BorderLayout());
          //cambiar icono**********************************************
        try{
            
          url=new URL("file:///c:\\fullstack profe\\java\\database.png") ;
            
        }catch(MalformedURLException mue){
            System.out.println("URL mal formada");
        
        }
        try{
        ip=(ImageProducer)url.getContent();
        img=createImage(ip);
        }catch(Exception ex){}
        this.setIconImage(img);
        //**********************************************************
        //******************************************
         this.addWindowListener(new WindowAdapter()
         {
                public void windowClosing(WindowEvent e)
                {
                 JOptionPane.showMessageDialog(null,"Vas a cerrar la APP");
                 System.exit(0);
               
                }
         }//clase anónima
         );
         estado=new Label("Estado:                               ");
         estado.setBackground(Color.yellow);
         ta=new TextArea();
         mbarra=new MenuBar();
    //M1**************************************************************
         m1 = new Menu("Base de Datos");

        m11 = new MenuItem("Cargar DRV");
        m12 = new MenuItem("Conectar");
        m13 = new MenuItem("Desconectar");
        m14 = new MenuItem("SALIR");

        m1.add(m11);
        m1.add(m12);
        m1.add(m13);
        m1.addSeparator();
        m1.add(m14);

        mbarra.add(m1);
    //Menu m2***************************************************
        m2 = new Menu("CRUD");

        m21 = new MenuItem("Insertar Registro");
        m22 = new MenuItem("Borrar Registro");
        m23 = new MenuItem("Modificar Registro");
        m24 = new MenuItem("Ver Tabla");

        m2.add(m21);
        m2.add(m22);
        m2.add(m23);
        m2.add(m24);
         
        mbarra.add(m2);
        
   //Menu m3***************************************************
        m3=new Menu("Sentencias Precompiladas");
         
        m31=new MenuItem("Buscar Registro");
        m3.add(m31);
        mbarra.add(m3);
         //Menu m4**************************************************
        m4=new Menu("Transacciones"); 
        m41=new MenuItem("Insertar Registro");
        m4.add(m41);
        m42=new MenuItem("COMMIT");
        m4.add(m42);
        mbarra.add(m4);
        
        //********************************************************
        m11.addActionListener(this);
        m12.addActionListener(this);
        m13.addActionListener(this);
        m14.addActionListener(this);
        m21.addActionListener(this);
        m22.addActionListener(this);
        m23.addActionListener(this);
        m24.addActionListener(this);
        m31.addActionListener(this);
        m41.addActionListener(this);
        m42.addActionListener(this);
        //**********************************************************
        this.add("Center",ta);
        this.add("South",estado);
        this.setMenuBar(mbarra);
        this.setSize(800,600);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new MenuBD();
    }
    public void actionPerformed(ActionEvent e)
    {
        
        if (e.getSource()==m11)
        {
            
            
        }
         if (e.getSource()==m12)
        {
            
            
        }
          if (e.getSource()==m13)
        {
            
            
        }
           if (e.getSource()==m14)
        {
            
            
        }
            if (e.getSource()==m21)
        {
            new InsertarAlumno().setVisible(true);
            
        }
             if (e.getSource()==m22)
        {
             new DeleteAlumno().setVisible(true);
            
        }
              if (e.getSource()==m23)
        {
             new ModificarAlumno().setVisible(true);
            
        }
               if (e.getSource()==m24)
        {
            
            
        }
                
        
        
        
    }
    
}