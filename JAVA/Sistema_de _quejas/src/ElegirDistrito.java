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
public class ElegirDistrito extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1 proceso
        String codigo = req.getParameter("cod");
        String nombre = req.getParameter("nombre");
        HttpSession sesion = req.getSession(true);
        sesion.setAttribute("codigo", codigo);
        sesion.setAttribute("nombre", nombre);

        // 2 salida 
        resp.setContentType("text/html");
        // Creamos el canal de salida
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML>");
        pw.println("<HEAD>");
        pw.println("<style>\n"
                + "        body {\n"
                + "            text-align: center;\n"
                + "        }\n"
                + "        img{\n"
                + "            display: block;\n"
                + "            margin: auto;\n"
                + "        }\n"
                + "    </style>");
        pw.println("</HEAD>");
        pw.println("<BODY>");
        
        pw.println("<h1>Marcar Punto o Consultar<h1>");
        pw.println("<h2 style='position: absolute; top: 0px; right: 0px;'>" + codigo + " | " + nombre + "<h2>");
        pw.println("<img src=\"/quejas/img/consultasymarcar.jpg\" usemap=\"#image-map\">\n"
                + "<map name=\"image-map\">\n"
                + "    <area target=\"\" alt=\"Realizar consulta\" title=\"Realizar consulta\" href=\"/examples/sistemasQuejas/ConsultarQuejas\" coords=\"162,192,193,194,237,194,277,185,319,169,345,147,365,117,360,89,345,62,318,50,301,40,275,32,250,27,229,23,213,21,213,41,213,58,209,70,199,83,178,101,166,121,160,143,159,158,157,177\" shape=\"poly\">\n"
                + "    <area target=\"\" alt=\"Marcar punto\" title=\"Marcar punto\" href=\"/examples/sistemasQuejas/MarcarPunto\" coords=\"14,113,18,89,32,70,48,59,73,45,83,37,99,33,115,30,129,26,139,25,154,21,176,21,188,21,203,22,209,28,211,39,211,46,210,59,204,68,198,78,187,88,176,98,170,113,161,127,160,141,156,147,155,159,155,164,155,174,154,184,157,192,146,192,134,192,119,191,104,186,89,179,73,173,60,164,44,156,28,147,21,130\" shape=\"poly\">\n"
                + "</map>");
        
        pw.println("</BODY>");
        pw.println("</HTML>");
    }
}
