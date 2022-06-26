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
public class MarcarPunto extends HttpServlet {

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

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 proceso
        HttpSession sesion = req.getSession(true);
        String codigo = (String) sesion.getAttribute("codigo");
        String nombre = (String) sesion.getAttribute("nombre");

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/sistema_de_quejas", "root", "");
            String sql = "SELECT mapa FROM distritos WHERE codigo=" + codigo;
            st = con.createStatement();
            rs = st.executeQuery(sql);

        } catch (SQLException sqe) {
            System.out.println("No se pudo conectar " + sqe.getMessage());
        }
        // 2 salida 
        resp.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML>");
        pw.println("<HEAD>");
        pw.println("</HEAD>");
        pw.println("<BODY>");

        pw.println("<h2 style='position: absolute; top: 0px; right: 0px;'>" + codigo + " | " + nombre + "<h2>");
        try {
            if (rs.next()) {
                pw.println("<FORM ACTION='/examples/sistemasQuejas/FormularioQueja'>");
                pw.println("<INPUT style='position: absolute; top: 0px; left: 0px;' type='image' name='mimapa' src=\"/quejas/img/" + rs.getString(1) + "\" width=\"650\">");
                pw.println("</FORM>");
            }

        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }

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
