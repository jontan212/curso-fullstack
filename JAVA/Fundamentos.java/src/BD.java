
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
public class BD {

    public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Cargado");
        } catch (ClassNotFoundException cne) {
            System.out.println("Driver no cargado"
                    + cne.getMessage());
        }

        // 2 Establecer conexión 
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/academia", "root", "");
            System.out.println("Conectados a Academia");
        } catch (SQLException sqe) {
            System.out.println("No se pudo conectar " + sqe.getMessage());
        }
        // 3. Desconectar 
        try {
            con.close();
            System.out.println("Desconectados de Academia");
        } catch (SQLException sqe) {
            System.out.println(
                    "No se pudo desconectar " + sqe.getMessage());

        }
    }
}
