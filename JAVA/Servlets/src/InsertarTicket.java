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
public class InsertarTicket extends HttpServlet {

    String drv;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        drv = config.getInitParameter("driver");
        try {
            Class.forName(drv);
            System.out.println("Driver cargado");
        } catch (ClassNotFoundException cne) {
            System.out.println("Driver no cargado " + cne.getMessage());
        }
    }

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        // 1 proceso
        Connection con = null;
        PreparedStatement st = null;
        HttpSession sesion = peticion.getSession(true);
        int codigo = Integer.parseInt((String) sesion.getAttribute("codigo"));
        String nombre = peticion.getParameter("nombre");
        String email = peticion.getParameter("email");
        int x = Integer.parseInt(peticion.getParameter("x"));
        int y = Integer.parseInt(peticion.getParameter("y"));

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/equipos", "root", "");
            st = con.prepareStatement("INSERT INTO entradas (nombre, email, x, y, codigo) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, nombre);
            st.setString(2, email);
            st.setInt(3, x);
            st.setInt(4, y);
            st.setInt(5, codigo);
            System.out.println(st);
            st.executeUpdate();
            st.close();

        } catch (SQLException sqe) {
            System.out.println("No se pudo conectar " + sqe.getMessage());
        }

        // 2 salida 
        respuesta.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = respuesta.getWriter();
        pw.println("<HTML>");
        pw.println("<BODY>");

        pw.println("<H1>Compra realizada con éxito</H1>");
        pw.println("<meta http-equiv='refresh' content='5; url=/equipos/equipos.html'>");

        pw.println("</BODY>");
        pw.println("</HTML>");

        try {
            con.close();
            System.out.println("Desconectados de equipos");
        } catch (SQLException sqe) {
            System.out.println("No se pudo desconectar " + sqe.getMessage());
        }
    }

}
