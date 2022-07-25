package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	public static Connection getConnection() throws URISyntaxException, SQLException {
		URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
		
		return DriverManager.getConnection(dbUrl, username, password);
//		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=JST", "root", "");
	}
}
