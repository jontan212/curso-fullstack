package procAlmacenado;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ActualizaProductos {
	public static void main(String[] args) {
		double nPrecio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el nuevo precio"));
		String nArticulo = JOptionPane.showInputDialog("Introduzca el nombre del artículo");
		try {
			Connection miConexion = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pruebas?autoReconnect=true&useSSL=false", "root", "");

			CallableStatement miSentencia = miConexion.prepareCall("{call ACTUALIZA_PROD(?, ?)}");
			miSentencia.setDouble(1, nPrecio);
			miSentencia.setString(2, nArticulo);
			miSentencia.executeQuery();

			System.out.println("Actualización OK");
			miConexion.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
