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
public class RecogeDatos extends HttpServlet {

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        // 1 proceso
        String nombre = peticion.getParameter("nombre");
        String ciudad = peticion.getParameter("ciudad");
        String email = peticion.getParameter("email");
        // 2 salida 
        respuesta.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = respuesta.getWriter();
        pw.println("<HTML>");
        pw.println("<BODY>");
        pw.println("<h2>Nombre= " + nombre + "</h2>");
        pw.println("<h2>Ciudad= " + ciudad + "</h2>");
        pw.println("<h2>Email= <font color=\"red\">" + email + "</font></h2>");
        pw.println("</BODY>");
        pw.println("</HTML>");
    }
    
    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        doGet(peticion, respuesta);
    }
    

}
