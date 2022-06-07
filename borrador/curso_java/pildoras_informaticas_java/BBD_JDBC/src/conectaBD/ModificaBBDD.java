package conectaBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ModificaBBDD {
	public static void main(String[] args) {
		try {
			// 1. CREAR CONEXIÓN
			Connection miConexion = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pruebas?autoReconnect=true&useSSL=false", "root", "");

			// 2. CREAR OBJETO STATEMENT
			Statement miStatement = miConexion.createStatement();

			// 3. INSERT
			String instruccionSql = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO) "
					+ "VALUES ('AR77', 'PANTALÓN', 25.35)";
			miStatement.executeUpdate(instruccionSql);
			System.out.println("Datos insertados correctamente.");

			// 4. UPDATE
			instruccionSql = "UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR77'";
			miStatement.executeUpdate(instruccionSql);
			System.out.println("Datos modificados correctamente.");

			// 5. DELETE
			instruccionSql = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR77'";
			miStatement.executeUpdate(instruccionSql);
			System.out.println("Datos eliminados correctamente.");

		} catch (SQLException e) {
			System.out.println("NO CONECTA!!");
			e.printStackTrace();
		}
	}
}
