/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 *
 * @author manana
 */
public class Contador extends HttpServlet {

    int cont;

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        // 1 proceso
        cont++;
        // 2 salida 
        respuesta.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = respuesta.getWriter();
        pw.println("<HTML>");
        pw.println("<BODY>");
        pw.println("<h1 style=\"font-size:200px;\">Visita número " + cont + "</h1>");
        pw.println("</BODY>");
        pw.println("</HTML>");
    }
}
