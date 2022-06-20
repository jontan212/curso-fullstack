/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author manana
 */
public class Sesiones extends HttpServlet {

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        // 1 proceso
        HttpSession sesion = peticion.getSession(true);
        sesion.setAttribute("Materia", "JAVA");
        // 2 salida 
        respuesta.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = respuesta.getWriter();
        pw.println("<HTML>");
        pw.println("<BODY>");
        if (sesion.isNew()) {
            pw.println("Bienbenido!!!");
        } else {
            pw.println("Ya has estado aquí");
        }
        pw.println(new Date(sesion.getCreationTime()));
        pw.println(new Date(sesion.getLastAccessedTime()));
        pw.println("<a href=\"http://localhost:8080/examples/servlets/servlet/ProbarPasoVariables?codigo=001\">Probar variables</a>");
        pw.println("</BODY>");
        pw.println("</HTML>");
    }
}
