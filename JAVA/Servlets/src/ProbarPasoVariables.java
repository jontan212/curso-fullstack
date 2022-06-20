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
public class ProbarPasoVariables extends HttpServlet {

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        HttpSession sesion = peticion.getSession(true);

        String materia = (String) sesion.getAttribute("Materia");
        String codigo = peticion.getParameter("codigo");
        // 2 salida 
        respuesta.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = respuesta.getWriter();
        pw.println("<HTML>");
        pw.println("<BODY>");
        pw.println("<h2>" + materia + "<h2>");
        pw.println("<h2>" + codigo + "<h2>");
        pw.println("</BODY>");
        pw.println("</HTML>");
    }
}
