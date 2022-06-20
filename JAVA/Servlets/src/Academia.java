/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

/**
 *
 * @author manana
 */
public class Academia extends HttpServlet {

    String drv;
    Connection con;
    Statement st;
    ResultSet rs;
    String salida;

    // Al inicializar el proyecto
    public void init(ServletConfig conf) throws ServletException {
        super.init(conf); // si queremos usar el objeto conf
        // Para leer un parámetro del xml
        drv = conf.getInitParameter("driver");
        // Cargar el driver archivo jar en C:\xampp\tomcat\lib para poder usarlo
        try {
            Class.forName(drv);
            System.out.println("Driver cargado");
            salida = "Driver Cargado";
        } catch (ClassNotFoundException cne) {
            System.out.println("Driver no cargado" + cne.getMessage());
        }
    }

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        // 1 proceso
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/academia", "root", "");
            System.out.println("Conectados a academia");
            salida += "<br>Conectados a Academia";
            st = con.createStatement();
            String sql = "select * from alumnos";
            rs = st.executeQuery(sql);
        } catch (SQLException sqe) {
            System.out.println("No se pudo conectar " + sqe.getMessage());
        }
        // 2 salida 
        respuesta.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = respuesta.getWriter();
        pw.println("<HTML>");
        pw.println("<BODY>");
//        pw.println(salida);
        pw.println("<table border==\"1\">");
        try {
            while (rs.next()) {
                pw.println("<tr>");
                pw.println("<TD bgcolor=\"orange\"><strong>" + rs.getString(1) + "</strong></TD>");
                pw.println("<TD>" + rs.getString(2) + "</TD>");
                pw.println("<TD>" + rs.getString(3) + "</TD>");
                pw.println("<TD>" + rs.getString(4) + "</TD>");
                pw.println("<TD>" + rs.getString(5) + "</TD>");
                pw.println("</tr>");
            }

        } catch (SQLException e) {
        }

        pw.println("</table>");
        pw.println("</BODY>");
        pw.println("</HTML>");
        salida = "";

        try {
            con.close();
            System.out.println("Desconectados de academia");
        } catch (SQLException sqe) {
            System.out.println("No se pudo desconectar " + sqe.getMessage());
        }
    }
}
