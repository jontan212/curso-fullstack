/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author manana
 */
public class Cabeceras extends HttpServlet {

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        // 1 proceso
        Enumeration e = peticion.getHeaderNames();
        // los nombres de las cabeceras
        StringBuffer sb = new StringBuffer();
        while (e.hasMoreElements()) {
            String cabecera = (String) e.nextElement();
            sb.append("<b>" + cabecera + "</b>");
            sb.append(peticion.getHeader(cabecera));
            sb.append("<br>");
        }
        // 2 salida 
        respuesta.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = respuesta.getWriter();
        pw.println("<HTML>");
        pw.println("<BODY>");
        pw.println(sb.toString());
        pw.println("</BODY>");
        pw.println("</HTML>");
    }
}
