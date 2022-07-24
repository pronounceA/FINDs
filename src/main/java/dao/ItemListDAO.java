package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;

public class ItemListDAO {
	public List<Item> findAll() {
		List<Item> itemList = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = GetConnection.getConnection()) {
				String sql = "SELECT * FROM ITEM_TABLE ORDER BY ITEM_ID ASC";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				ResultSet rs = pStmt.executeQuery();
				
				while (rs.next()) {
					int itemId = rs.getInt("ITEM_ID");
					String itemName = rs.getString("ITEM_NAME");
					int itemPrice = rs.getInt("ITEM_PRICE");
					int itemStock = rs.getInt("ITEM_STOCK");
					String itemMemo = rs.getString("ITEM_MEMO");
					String itemImg = rs.getString("ITEM_IMG");
					Item item = new Item(itemId, itemName, itemPrice, itemStock, itemMemo, itemImg);
					itemList.add(item);
				}
				return itemList;
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
