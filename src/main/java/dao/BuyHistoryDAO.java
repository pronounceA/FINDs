package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AccountBeans;
import model.BuyHistoryBeans;

public class BuyHistoryDAO {
	public void SetBuyHistory(BuyHistoryBeans buyh) {
		// データベースへ接続
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = GetConnection.getConnection()) {
	
				// SELECT文を準備
				// BUYHISTORYTABLEへデータを追加
				String sql = "INSERT INTO BUYHISTORY (ID,BUYID,DAYINFO,POINT) VALUES (?,?,?,?);";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, buyh.getId());
				pStmt.setInt(2, buyh.getBuyId());
				pStmt.setString(3, buyh.getDay());
				pStmt.setInt(4, buyh.getPoints());
	
				// SQL文を実行
				pStmt.executeUpdate();
	
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Object> GetBuyHistory(AccountBeans account) {
		// データベースへ接続
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = GetConnection.getConnection()) {
	
				ArrayList<Object> buylist = new ArrayList<Object>();
				int id = 0;
				int buyid = 0;
				String dayinfo = "";
				int point = 0;
	
				// SELECT文を準備
				// BUYHISTORYTABLEからデータを取得
				String sql = "SELECT * FROM BUYHISTORY WHERE ID = ?;";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, account.getId());
	
				// SQL文を実行
				ResultSet rs = pStmt.executeQuery();
	
				// 購入履歴表に格納されたレコードの内容を表示
				while (rs.next()) {
					id = rs.getInt("ID");
					buyid = rs.getInt("BUYID");
					dayinfo = rs.getString("DAYINFO");
					point = rs.getInt("POINT");
	
					buylist.add(id);
					buylist.add(buyid);
					buylist.add(dayinfo);
					buylist.add(point);
				}
				return buylist;
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

	// 購入IDを照合し、商品IDを取り出す
	public ArrayList<ArrayList<String>> getBuytoItem(AccountBeans account) {
		ArrayList<ArrayList<String>> buynamelist = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<Integer>> buylistlist = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> buyid = new ArrayList<Integer>();

		int id = 0;
		int itemid = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = GetConnection.getConnection()) {
				// SELECT文を準備
				// BUYHISTORYTABLEからデータを取得
				String sql = "SELECT * FROM BUYHISTORY WHERE ID = ?;";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setInt(1, account.getId());
	
				// SQL文を実行
				ResultSet rs = pStmt.executeQuery();
	
				// 現在ログイン中のIDから購入IDを取得
				// 購入履歴表に格納されたレコードの内容を表示
				while (rs.next()) {
					id = rs.getInt("BUYID");
					buyid.add(id);
				}
	
				for (int id2 : buyid) {
					ArrayList<Integer> buylist = new ArrayList<Integer>();
					// SELECT文を準備
					// BUYHISTORYTABLEからデータを取得
					String sql2 = "SELECT * FROM BUYITEM WHERE BUYID = ?;";
					PreparedStatement pStmt2 = conn.prepareStatement(sql2);
					pStmt2.setInt(1, id2);
	
					// SQL文を実行
					ResultSet rs2 = pStmt2.executeQuery();
	
					// 購入履歴表に格納されたレコードの内容を表示
					while (rs2.next()) {
						itemid = rs2.getInt("ITEMID");
						buylist.add(itemid);
					}
					buylistlist.add(buylist);
				}
				System.out.println("確かめ1" + buylistlist);
	
				for (ArrayList<Integer> bulist : buylistlist) {
					ArrayList<String> itemname = new ArrayList<String>();
					for (int id3 : bulist) {
						// SELECT文を準備
						// 取り出したITEMIDと照合した商品名を取得
						String sql3 = "SELECT * FROM ITEM_TABLE WHERE ITEM_ID = ?;";
						PreparedStatement pStmt3 = conn.prepareStatement(sql3);
						pStmt3.setInt(1, id3);
	
						// SQL文を実行
						ResultSet rs3 = pStmt3.executeQuery();
	
						while (rs3.next()) {
							itemname.add(rs3.getString("ITEM_NAME"));
						}
					}
					buynamelist.add(itemname);
				}
				return buynamelist;
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

	// 購入ID取得メソッド
	public int getDAOBuyId() {
		int buyid = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Connection conn = GetConnection.getConnection()) {
	
				// SELECT文を準備
				// BUYHISTORYTABLEからデータを取得
				String sql = "SELECT * FROM BUYHISTORY WHERE DAYINFO = (SELECT MAX(DAYINFO) FROM BUYHISTORY);";
				PreparedStatement pStmt = conn.prepareStatement(sql);
	
				// SQL文を実行
				ResultSet rs = pStmt.executeQuery();
	
				while (rs.next()) {
					buyid = rs.getInt("BUYID");
				}
				return buyid;
			}catch (URISyntaxException e) {
				e.printStackTrace();
				return 0;
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		}
	}
}