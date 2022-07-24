package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map.Entry;

import model.AccountBeans;
import model.ItemDetailsBeans;
import model.ItemDetailsMap;

public class ItemListManagementDAO {
	public AccountBeans executeItemlist(ItemDetailsBeans itemdetailsbeans, AccountBeans accountBeans) {
//		List<AccountBeans> setList = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = GetConnection.getConnection()) {
				for (Entry<Integer, ItemDetailsMap> entry : itemdetailsbeans.getItemDetailsMap().entrySet()) { // カートのArrayListから金額を取得し
					// ITEM_TABLEから在庫の個数を取得
					int itemstock = 0;
					String sql0 = "SELECT * FROM ITEM_TABLE WHERE ITEM_ID=?";
					PreparedStatement pStmt0 = conn.prepareStatement(sql0);
					pStmt0.setInt(1, entry.getKey());
					ResultSet rs0 = pStmt0.executeQuery();
					
					if(rs0.next()) {
						itemstock = rs0.getInt("ITEM_STOCK");
					}
					
					String sql1 = "UPDATE ITEM_TABLE SET ITEM_STOCK=? WHERE ITEM_ID=?";
					PreparedStatement tStmt = conn.prepareStatement(sql1);
					tStmt.setInt(1, itemstock - entry.getValue().getItemNumber());
					tStmt.setInt(2, entry.getKey()); // 在庫からカートの個数を引く
					tStmt.executeUpdate();
					
					if (itemstock - entry.getValue().getItemNumber() == 0) {
						String sql2 = "DELETE FROM ITEM_TABLE WHERE ITEM_ID=?";
						PreparedStatement tStmt2 = conn.prepareStatement(sql2);
						tStmt2.setInt(1, entry.getKey());
						tStmt2.executeUpdate();
					}
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
