package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.BuyItemBeans;

public class BuyItemDAO {
	public void SetBuyItem(BuyItemBeans buyi) {

		// データベースへ接続
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = GetConnection.getConnection()) {
	
				// SELECT文を準備
				// BUYHISTORYTABLEへデータを追加
				String sql = "INSERT INTO BUYITEM (BUYID,ITEMID) VALUES (?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				for (Integer str : buyi.getItemId()) {
					pStmt.setInt(1, buyi.getBuyId());
					pStmt.setInt(2, str);
					
					// SQL文の実行
					pStmt.executeUpdate();
				}
	
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
