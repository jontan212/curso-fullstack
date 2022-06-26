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
 * @author Jonathan
 */
public class ConsultarQuejas extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 proceso
        HttpSession sesion = req.getSession(true);
        String codigoDistrito = (String) sesion.getAttribute("codigo");
        String nombreDistrito = (String) sesion.getAttribute("nombre");
        // 2 salida 
        resp.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML>");
        pw.println("<HEAD>");
        pw.println("<style>body {text-align: center;} a {font-size: 80px; text-decoration: none;} a:hover{background-color: #00E4FF;} </style>");
        pw.println("</HEAD>");
        pw.println("<BODY>");

        pw.println("<h1>Tipo de consulta</h1>");
        pw.println("<a href='/examples/sistemasQuejas/PorMapa'>Por mapa</a><br>");
        pw.println("<a href='/examples/sistemasQuejas/PorSexo'>Por sexo</a>");
        pw.println("<h2 style='position: absolute; top: 0px; right: 0px;'>" + codigoDistrito + " | " + nombreDistrito + "<h2>");

        pw.println("</BODY>");
        pw.println("</HTML>");
    }
}
