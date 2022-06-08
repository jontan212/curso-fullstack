package transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserta_Clientes_Pedidos {
	public static void main(String[] args) {
		Connection miConexion = null;
		try {
			miConexion = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pruebas?autoReconnect=true&useSSL=false", "root", "");
			Statement miStatement = miConexion.createStatement();

			miConexion.setAutoCommit(false);

			String instruccionSql_1 = "INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) "
					+ "VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";
			miStatement.executeUpdate(instruccionSql_1);
			String instruccionSql_2 = "INSERT INTO PEDIDOS (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) "
					+ "VALUES ('82', 'CT84', '11/03/2000')";
			miStatement.executeUpdate(instruccionSql_2);

			miConexion.commit();

			System.out.println("Datos INSERTADOS correctamente.");
			miConexion.close();

		} catch (Exception e) {
			try {
				miConexion.rollback();
				miConexion.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
			e.printStackTrace();
		}
	}
}
