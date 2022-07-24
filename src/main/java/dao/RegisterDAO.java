package dao;


import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBeans;

public class RegisterDAO {
	public int create(AccountBeans account) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try(Connection conn = GetConnection.getConnection()){
				
				String sql1 = "SELECT NAME FROM ACCOUNT WHERE NAME = ?";
				PreparedStatement pStmt1 = conn.prepareStatement(sql1);
				pStmt1.setString(1, account.getName());
				
				ResultSet rs = pStmt1.executeQuery();
				
				String existingName = "";
				if(rs.next()) {
					existingName = rs.getString("NAME");
				}
				
				int result = 0;
				
				if (existingName.equals("")) {
					String sql2 = "INSERT INTO ACCOUNT(NAME, PASS, POINTS, BANK_ACCOUNT) VALUES(?,?,?,?)";
					PreparedStatement pStmt2 = conn.prepareStatement(sql2);
					pStmt2.setString(1, account.getName());
					pStmt2.setString(2, account.getPass());
					pStmt2.setInt(3, account.getPoints());
					pStmt2.setInt(4, account.getBankAccount());
					result = pStmt2.executeUpdate();
				}
				
				if (result != 1) {
					return 2;
				}
				return 1;
			} catch (URISyntaxException e) {
				e.printStackTrace();
				return 3;
			} catch (SQLException e) {
				e.printStackTrace();
				return 3;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return 3;
		}
	}
}
