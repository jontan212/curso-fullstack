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
public class FormularioQueja extends HttpServlet {

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
        pw.println("<style>body {text-align: center;} </style>");
        pw.println("</HEAD>");
        pw.println("<BODY>");

        pw.println("<h1>Rellene el formulario</h1>");
        pw.println("<FORM ACTION='/examples/sistemasQuejas/InsertarQueja'>");
        pw.println("Sexo:\n"
                + "      <label\n"
                + "        ><input\n"
                + "          type=\"radio\"\n"
                + "          name=\"sexo\"\n"
                + "          value=\"hombre\"\n"
                + "          id=\"hombre\"\n"
                + "        />Hombre</label\n"
                + "      >\n"
                + "      <label\n"
                + "        ><input type=\"radio\" name=\"sexo\" value=\"mujer\" id=\"mujer\" />Mujer</label\n"
                + "      >\n"
                + "      <br />\n"
                + "      Tipo de queja:\n"
                + "      <select name=\"queja\">\n"
                + "        <option value=\"Ambiental\">Ambiental</option>\n"
                + "        <option value=\"Social\">Social</option>\n"
                + "        <option value=\"Conflictiva\">Conflictiva</option>\n"
                + "      </select>\n"
                + "      <br />\n"
                + "      Descripción:<br /><textarea\n"
                + "        name=\"descripcion\"\n"
                + "        cols=\"90\"\n"
                + "        rows=\"10\"\n"
                + "      ></textarea>\n"
                + "      <br />\n"
                + "      <input type='hidden' name='x' value='" + req.getParameter("mimapa.x") + "'><br>\n"
                + "      <input type='hidden' name='y' value='" + req.getParameter("mimapa.y") + "'><br>\n"
                + "      <input type=\"submit\" value=\"Enviar\" />");
        pw.println("</FORM>");
        pw.println("<h2 style='position: absolute; top: 0px; right: 0px;'>" + codigoDistrito + " | " + nombreDistrito + "<h2>");

        pw.println("</BODY>");
        pw.println("</HTML>");
    }
}
