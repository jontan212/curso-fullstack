package metaDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Info_Metadatos {

	public static void main(String[] args) {
		mostrarInfoBBDD();
		mostrarInfoTablas();
	}

	private static void mostrarInfoBBDD() {
		Connection miConexion = null;
		try {
			miConexion = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pruebas?autoReconnect=true&useSSL=false", "root", "");

			// Obtención de metadatos
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			// Mostramos información de la BBDD
			System.out.println("Gestor de BBDD: " + datosBBDD.getDatabaseProductName());
			System.out.println("Versión del Gestor: " + datosBBDD.getDatabaseProductVersion());
			System.out.println("Nombre del Driver: " + datosBBDD.getDriverName());
			System.out.println("Versión del Driver: " + datosBBDD.getDriverVersion() + "\n");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void mostrarInfoTablas() {
		Connection miConexion = null;
		ResultSet miResultSet = null;
		try {
			miConexion = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/pruebas?autoReconnect=true&useSSL=false", "root", "");

			// Obtención de metadatos
			DatabaseMetaData datosBBDD = miConexion.getMetaData();
			// Lista de tablas
			System.out.println("Lista de tablas:");

			miResultSet = datosBBDD.getTables(null, null, null, null);
			// devuelve solo las tablas que empiezan con p
//			miResultSet = datosBBDD.getTables(null, null, "p%", null);
			while (miResultSet.next()) {
				System.out.println(miResultSet.getString("TABLE_NAME"));
			}

			// Lista de columnas de la tabla PRODUCTOS
			System.out.println("");
			System.out.println("Campos de productos:");

			// Si dejo el 3er arg en null, me mostraria el nombre de las columnas de TODAS
			// las tablas
//			miResultSet = datosBBDD.getTables(null, null, null, null);
			// Solo quiero el nombre de las columnas de la tabla PRODUCTOS
			miResultSet = datosBBDD.getColumns(null, null, "productos", null);
			while (miResultSet.next()) {
				System.out.println(miResultSet.getString("COLUMN_NAME"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				miConexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
