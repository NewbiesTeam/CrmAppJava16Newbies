package newbies.java16.crmapp.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	private static Connection connection = null;
	private final static String URL = "jdbc:mysql://localhost:3306/crm";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "tram";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				return connection;
			}
		} catch (ClassNotFoundException | SQLException e) {
		System.out.println("Couldn't find driver to connect");
		}
		System.out.println("Database connection couldn't be established");
		return null;
	}
}
