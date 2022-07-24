package model;

import java.util.ArrayList;

import dao.BuyHistoryDAO;
import dao.BuyItemDAO;

public class BuyLogic{
	
	// 購入できるか判断し、DBへ登録するメソッド
	public boolean execute(int bankAccount,BuyHistoryBeans buyh, BuyItemBeans buyi, int total) {
		boolean judge = false;
		
		
		if(bankAccount >= total) {
			judge = true;
			BuyHistoryDAO dao = new BuyHistoryDAO();
			dao.SetBuyHistory(buyh);		// データベースにINSERT(TABLE BUYHISTORY)
			
			BuyItemDAO daoi = new BuyItemDAO();
			daoi.SetBuyItem(buyi);			// データベースにINSERT(TABLE BUYITEM)
		}
		
		return judge;
	}
	
	// DBから購入履歴を取得するメソッド
	public ArrayList<Object> getHistory(AccountBeans account) {
		ArrayList<Object> buylist = new ArrayList<Object>();
		
		
		BuyHistoryDAO dao = new BuyHistoryDAO();
		buylist = dao.GetBuyHistory(account); 		// データベースから購入履歴を取得(TABLE BUYHISTORY)
		
		return buylist;
	}
	
	// DBから購入IDを取得するメソッド
	public int getBuyId() {
		int buyid = 0;
		
		BuyHistoryDAO dao = new BuyHistoryDAO();
		buyid = dao.getDAOBuyId();
		
		return buyid;
	}
	
	// DBから商品名を取得するメソッド
	public ArrayList<ArrayList<String>> getItemName(AccountBeans account){
		ArrayList<ArrayList<String>> itemnamelist = new ArrayList<ArrayList<String>>();
		
		BuyHistoryDAO dao = new BuyHistoryDAO();
		itemnamelist = dao.getBuytoItem(account);
		
		return itemnamelist;
	}
}