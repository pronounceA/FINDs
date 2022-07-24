package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AccountBeans;

public class SetPointDAO {
	public AccountBeans executePoints(int pointGet, AccountBeans accountBeans) {
//		List<AccountBeans> setList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try(Connection conn = GetConnection.getConnection()) {
			  String sql1 = "UPDATE ACCOUNT SET POINTS=? WHERE ID=?";
			  PreparedStatement tStmt = conn.prepareStatement(sql1);
			  tStmt.setInt(1, accountBeans.getPoints()+pointGet);
			  tStmt.setInt(2, accountBeans.getId());
			  tStmt.executeUpdate();
	
			  String sql2 = "SELECT ID, NAME, PASS, POINTS, BANK_ACCOUNT FROM ACCOUNT WHERE ID=?";
			  PreparedStatement pStmt = conn.prepareStatement(sql2);
			  pStmt.setInt(1, accountBeans.getId());
			  //UPDATE文を実行し、結果表を取得
			  ResultSet rs = pStmt.executeQuery();
			  
			  //一致した
			  if(rs.next()) {
				  int userId = Integer.parseInt(rs.getString("ID"));
				  String userName = rs.getString("NAME");
				  String userPass = rs.getString("PASS");
				  int userPoints = Integer.parseInt(rs.getString("POINTS"));
				  int bankAccount = Integer.parseInt(rs.getString("BANK_ACCOUNT"));
				  accountBeans = new AccountBeans(userId, userName, userPass, userPoints, bankAccount);
	//			  setList.add(accountBeans);
			  }
			  return accountBeans;
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
	}
}

