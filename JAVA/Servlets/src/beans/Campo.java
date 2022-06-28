package beans;

import java.io.Serializable;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author manana
 */
public class Campo implements Serializable {

    private String codigo;
    private String campoURL;
    private Connection con;

    public String getCampoURL() {
        cargarDriver();
        buscarURLCampo();
        return campoURL;
    }

    public void setCampoURL(String campoURL) {
        this.campoURL = campoURL;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void cargarDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver cargado");
        } catch (ClassNotFoundException cne) {
            System.out.println("Driver no cargado " + cne.getMessage());
        }
    }

    public void buscarURLCampo() {
        ResultSet rs;
        // Cargar conexion
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/equipos", "root", "");
            System.out.println("Conexion correcto");
        } catch (SQLException sqe) {
            System.out.println("Error al conectar: " + sqe.getMessage());
        }
        // Buscar URL del campo
        try {
            Statement st = con.createStatement();
            String sql = "SELECT campo FROM equipos WHERE codigo=" + getCodigo();
            rs = st.executeQuery(sql);
            rs.next();
            
            setCampoURL(rs.getString(1));
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar campo: " + e.getMessage());
        }
        // Cerrar conexión 
        try {
            con.close();
        } catch (SQLException sqe) {
            System.out.println("Error al desconectar: " + sqe.getMessage());
        }

    }

    public Campo() {
    }
}
