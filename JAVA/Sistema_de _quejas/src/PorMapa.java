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
 * @author Jonathan
 */
public class PorMapa extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 proceso
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        HttpSession sesion = req.getSession(true);
        String mapa = null;

        int codigoDistrito = Integer.parseInt((String) sesion.getAttribute("codigo"));
        String nombreDistrito = (String) sesion.getAttribute("nombre");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/sistema_de_quejas", "root", "");
            String sql = "SELECT mapa FROM distritos WHERE codigo=" + codigoDistrito;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            mapa = rs.getString(1);

        } catch (SQLException sqe) {
            System.out.println("No se pudo conectar " + sqe.getMessage());
        }

        try {
            String sql = "SELECT * FROM quejas WHERE codigo_distrito=" + codigoDistrito;
            rs = st.executeQuery(sql);

        } catch (SQLException sqe) {
            System.out.println("No se pudo conectar " + sqe.getMessage());
        }
        // 2 salida 
        resp.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML>");
        pw.println("<BODY>");

        pw.println("<img style='position: absolute; top: 0px; left: 0px;' src='/quejas/img/" + mapa + "' width='650'>");
        try {
            while (rs.next()) {
                String colorQueja = "";
                if (rs.getString("tipo_de_queja").equals("Ambiental")) {
                    colorQueja = "/quejas/img/verde.png";
                } else if (rs.getString("tipo_de_queja").equals("Social")) {
                    colorQueja = "/quejas/img/azul.png";
                } else {
                    colorQueja = "/quejas/img/rojo.png";
                }
                pw.println("<img width='16' height='32' style='position: absolute; top: " + (rs.getInt("y") - 32) + "px; left: " + (rs.getInt("x") - 8) + "px;' src='" + colorQueja + "' alt='" + rs.getString("descripcion") + "' title='" + rs.getString("descripcion") + "'>");
            }
        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }
        pw.println("<h2 style='position: absolute; top: 0px; right: 0px;'>" + codigoDistrito + " | " + nombreDistrito + "<h2>");
        
        pw.println("</BODY>");
        pw.println("</HTML>");

        try {
            rs.close();
            st.close();
            con.close();
            System.out.println("Desconectados de sistema_de_quejas");
        } catch (SQLException sqe) {
            System.out.println("No se pudo desconectar " + sqe.getMessage());
        }
    }
}
