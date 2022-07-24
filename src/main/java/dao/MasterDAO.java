package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

// import
import model.Master;


public class MasterDAO {
	// データベース接続情報
	public boolean insertDB(Master master) {
	
		// データベースへ接続
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = GetConnection.getConnection()) {
			
				// SQL文
				String sql = "INSERT INTO ITEM_TABLE(ITEM_NAME, ITEM_PRICE, ITEM_STOCK, ITEM_MEMO, ITEM_IMG) VALUES(?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, master.getItem_Name());
				pStmt.setInt(2, master.getItem_Price());
				pStmt.setInt(3, master.getItem_Stock());
				pStmt.setString(4, master.getItem_Memo());
				pStmt.setString(5, master.getItem_Img());
				pStmt.executeUpdate();
				
				return true;
			} catch (URISyntaxException e) {
				e.printStackTrace();
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}
