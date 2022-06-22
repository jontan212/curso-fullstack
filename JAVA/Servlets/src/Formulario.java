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
public class Formulario extends HttpServlet {

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        // 1 proceso

        // 2 salida 
        respuesta.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = respuesta.getWriter();
        pw.println("<HTML>");
        pw.println("<BODY>");

        pw.println("<H1>Tus datos:</H1>");
        pw.println("<FORM ACTION='http://localhost:8080/examples/servlets/servlet/InsertarTicket'>");
        pw.println("Nombre: <input type='text' name='nombre' size='20'><br>");
        pw.println("Email: <input type='email' name='email' size='20'>");
        pw.println("<input type='hidden' name='x' value='" + peticion.getParameter("mimapa.x") + "'><br>");
        pw.println("<input type='hidden' name='y' value='" + peticion.getParameter("mimapa.y") + "'><br>");
        pw.println("<input type='submit' value='Comprar tu entrada'>");
        pw.println("</FORM>");

        pw.println("</BODY>");
        pw.println("</HTML>");
    }
}
