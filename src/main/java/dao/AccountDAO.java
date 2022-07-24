package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBeans;
import model.LoginBeans;

public class AccountDAO  {
	//データベースに接続
//	private final String JDBC_URL = 
//			"jdbc:h2:tcp://localhost/~/FINDs";
//	private final String DB_USER = "sa";
//	private final String DB_PASS = "";
	
	public AccountBeans findByLogin(LoginBeans login) {
		AccountBeans account = null;
		
		try {
			Class.forName(("com.mysql.cj.jdbc.Driver"));
			
			try (Connection conn = GetConnection.getConnection()){
				//SERECT文
				String sql = "SELECT ID, NAME, PASS, POINTS, BANK_ACCOUNT FROM ACCOUNT WHERE NAME = ? AND PASS = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, login.getName());
				pStmt.setString(2, login.getPass());
				
				ResultSet rs = pStmt.executeQuery();
				
				if(rs.next()) {
					int Id = rs.getInt("ID");
					String Name = rs.getString("NAME");
					String Pass = rs.getString("PASS");
					int Points = rs.getInt("POINTS");
					int BANK_Account = rs.getInt("BANK_ACCOUNT");
					account = new AccountBeans(Id, Name, Pass, Points, BANK_Account);
				}
			} catch (URISyntaxException e) {
				e.printStackTrace();
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}
}