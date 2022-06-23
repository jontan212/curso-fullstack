/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//JNDI
import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;
/**
 *
 * @author manana
 */
public class PoolTest extends HttpServlet {

    public void doGet(HttpServletRequest peticion, HttpServletResponse respuesta) throws ServletException, IOException {
        //1 proceso

        Context initContext;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/academy");
            cn = ds.getConnection();
            System.out.println("Conectados a academia");

        } catch (Exception ex) {
        }

        // 2 salida
        respuesta.setContentType("text/html");
        //creamos el canal de salida
        PrintWriter pw = respuesta.getWriter();
        pw.println("<HTML>");
        pw.println("<BODY>");
        pw.println("<H1>Mi primer Servlet</H1>");
        pw.println("</BODY>");
        pw.println("</HTML>");
    }
}
