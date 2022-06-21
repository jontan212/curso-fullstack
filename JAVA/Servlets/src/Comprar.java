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
public class Comprar extends HttpServlet {

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        // 1 proceso
        // Recogemos las variables que nos llegan por URL (GET)
        String codigo = peticion.getParameter("cod");
        String nombre = peticion.getParameter("nombre");
        HttpSession sesion = peticion.getSession(true);
        sesion.setAttribute("codigo", codigo);
        sesion.setAttribute("nombre", nombre);
        // 2 salida 
        respuesta.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = respuesta.getWriter();
        pw.println("<HTML>");
        pw.println("<HEAD>");
        pw.println("<STYLE>");
        pw.println("A {font-size:25pt; color:navy; text-decoration:none;}");
        pw.println("A:hover {font-size:35pt; color:black; text-decoration:underline;}");
        pw.println("</STYLE>");
        pw.println("</HEAD>");
        pw.println("<BODY>");

        pw.println("<DIV style=\"position:absolute; top:10px; left:1400px;\">");
        pw.println("<H2>" + codigo + " | " + nombre + "<H2>");
        pw.println("</DIV>");
        pw.println("</BR>");
        pw.println("</BR>");
        pw.println("<CENTER>");
        pw.println("<A href=\"http://localhost:8080/examples/servlets/servlet/ReservarEntrada\">Reserva Entradas</A>");
        pw.println("</BR>");
        pw.println("</BR>");
        pw.println("</BR>");
        pw.println("</BR>");
        pw.println("</BR>");
        pw.println("<IMG src=\"/equipos/images/ticket.jpg\" height=\"300\">");
        pw.println("<hr><font color=\"gray\"><small>&copy;Todos los derechos reservados.Megaentradas.com 2022</small></font>");

        pw.println("</BODY>");
        pw.println("</HTML>");
    }
}
