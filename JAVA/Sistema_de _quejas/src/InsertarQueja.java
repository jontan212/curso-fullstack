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
public class InsertarQueja extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 proceso
        Connection con = null;
        PreparedStatement st = null;
        HttpSession sesion = req.getSession(true);

        int codigoDistrito = Integer.parseInt((String) sesion.getAttribute("codigo"));
        String nombreDistrito = (String) sesion.getAttribute("nombre");
        String sexo = req.getParameter("sexo");
        String queja = req.getParameter("queja");
        String descripcion = req.getParameter("descripcion");
        int x = Integer.parseInt(req.getParameter("x"));
        int y = Integer.parseInt(req.getParameter("y"));

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/sistema_de_quejas", "root", "");
            st = con.prepareStatement("INSERT INTO quejas (sexo, tipo_de_queja, descripcion, x, y, codigo_distrito) VALUES (?, ?, ?, ?, ?, ?)");
            st.setString(1, sexo);
            st.setString(2, queja);
            st.setString(3, descripcion);
            st.setInt(4, x);
            st.setInt(5, y);
            st.setInt(6, codigoDistrito);
            st.executeUpdate();
            st.close();

        } catch (SQLException sqe) {
            System.out.println("No se pudo conectar " + sqe.getMessage());
        }
        // 2 salida 
        resp.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML>");
        pw.println("<HEAD>");
        pw.println("<style>body {text-align: center;} </style>");
        pw.println("</HEAD>");
        pw.println("<BODY>");

        pw.println("<h1>Queja registrada con éxito, espere 3 segundos.</h1>");
        pw.println("<meta http-equiv='refresh' content='3; url=/quejas'>");
        pw.println("<h2 style='position: absolute; top: 0px; right: 0px;'>" + codigoDistrito + " | " + nombreDistrito + "<h2>");

        pw.println("</BODY>");
        pw.println("</HTML>");

        try {
            con.close();
            System.out.println("Desconectados de sistema_de_quejas");
        } catch (SQLException sqe) {
            System.out.println("No se pudo desconectar " + sqe.getMessage());
        }
    }
}
