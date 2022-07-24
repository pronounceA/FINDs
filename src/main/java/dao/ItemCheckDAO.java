package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ItemDetails;

public class ItemCheckDAO {
	//data baseの情報
	public List<ItemDetails> findAll(){
		List<ItemDetails> detailsList = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try(Connection conn = GetConnection.getConnection()){
				//SELECT文を準備
				String sql = "SELECT ITEM_ID, ITEM_NAME, ITEM_PRICE, ITEM_STOCK, ITEM_MEMO, ITEM_IMG FROM ITEM_TABLE";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				//SELECTを実行し、結果表を取得
				ResultSet rs = pStmt.executeQuery();
				
				/*結果表に格納されたレコードの内容を
				 * ItemDetailsBeansインスタンスに設定し、ArrayListインスタンスに追加*/
				while(rs.next()) {
					int itemId = rs.getInt("ITEM_ID");
					String itemName = rs.getString("ITEM_NAME");
					int itemPrice = rs.getInt("ITEM_PRICE");
					int itemStock = rs.getInt("ITEM_STOCK");
					String itemMemo = rs.getString("ITEM_MEMO");
					String itemImg = rs.getString("ITEM_IMG");
					ItemDetails itemDetails = new ItemDetails(itemId, itemName, itemPrice, itemStock, itemMemo, itemImg);
					detailsList.add(itemDetails);
				}
				return detailsList;
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
