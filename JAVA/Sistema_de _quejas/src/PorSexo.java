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
public class PorSexo extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 proceso
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        HttpSession sesion = req.getSession(true);
        int codigoDistrito = Integer.parseInt((String) sesion.getAttribute("codigo"));
        String nombreDistrito = (String) sesion.getAttribute("nombre");
        int mujeres = 0;
        int hombres = 0;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/sistema_de_quejas", "root", "");
            String sql = "SELECT COUNT(sexo) FROM quejas WHERE sexo=\"mujer\" AND codigo_distrito=" + codigoDistrito + " UNION ALL SELECT COUNT(sexo) FROM quejas WHERE sexo=\"hombre\" AND codigo_distrito=" + codigoDistrito;
            st = con.createStatement();
            rs = st.executeQuery(sql);
            try {
                rs.next();
                mujeres = rs.getInt(1);
                rs.next();
                hombres = rs.getInt(1);
            } catch (SQLException e) {
                System.out.println("Puede que solo haya 1 registro " + e.getMessage());
            }

        } catch (SQLException sqe) {
            System.out.println("No se pudo conectar " + sqe.getMessage());
        }
        int total = mujeres + hombres;
        float mujeresPorciento = 0;
        float hombresPorciento = 0;
        if (total != 0) {
            mujeresPorciento = (100 * mujeres) / total;
            hombresPorciento = 100 - mujeresPorciento;
        }
        // 2 salida 
        resp.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML>");
        pw.println("<HEAD>");
        pw.println("<style>body {text-align: center;} td { width: 30px; vertical-align: bottom; } </style>");
        pw.println("</HEAD>");
        pw.println("<BODY>");

        pw.println("<h2 style='position: absolute; top: 0px; right: 0px;'>" + codigoDistrito + " | " + nombreDistrito + "<h2>");
        pw.println("<h1>Mujeres total: " + mujeres + " <br>Hombres total: " + hombres + "</h1>");
        pw.println("<table style='margin: auto;'>"
                + "  <tr>"
                + "    <td><div style=\"height: " + mujeresPorciento + "px; background-color: violet\"></div></td>"
                + "    <td><div style=\"height: " + hombresPorciento + "px; background-color: blue\"></div></td>"
                + "  </tr>"
                + "  <tr>"
                + "    <th>Mujeres " + String.format("%.2f", mujeresPorciento) + "%</th>"
                + "    <th>Hombres " + String.format("%.2f", hombresPorciento) + "%</th>"
                + "  </tr>"
                + "</table>");

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
