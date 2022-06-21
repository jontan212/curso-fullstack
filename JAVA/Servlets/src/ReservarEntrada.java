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
public class ReservarEntrada extends HttpServlet {

    String drv;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        drv = config.getInitParameter("driver");
        try {
            Class.forName(drv);
            System.out.println("Driver cargado");
        } catch (ClassNotFoundException cne) {
            System.out.println("Driver no cargado" + cne.getMessage());
        }
    }

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        // 1 proceso
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        HttpSession sesion = peticion.getSession(true);
        String codigo = (String) sesion.getAttribute("codigo");
        String nombre = (String) sesion.getAttribute("nombre");

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/equipos", "root", "");
            String sql = "SELECT campo FROM equipos WHERE codigo=" + codigo;
            st = con.createStatement();
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

        pw.println("<DIV style=\"position:absolute; top:10px; left:1400px;\">");
        pw.println("<H2>" + codigo + " | " + nombre + "<H2>");
        pw.println("</DIV>");
        pw.println("</BR>");
        pw.println("</BR>");
        pw.println("<CENTER>");

        try {
            if (rs.next()) {
                pw.println("<FORM ACTION='http://localhost:8080/examples/servlets/servlet/Formulario'>");
                pw.println("<INPUT type='image' name='mimapa' src=\"/equipos/images/" + rs.getString(1) + "\" width=\"900\" height=\"900\">");
                pw.println("</FORM>");
            }

        } catch (SQLException sqe) {
            System.out.println(sqe.getMessage());
        }

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
