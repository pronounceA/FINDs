package model;

import java.util.Set;

// 購入商品テーブル
public class BuyItemBeans{
	private int buyId;	// 購入ID
	private Set<Integer> itemId;	// 商品ID
	
	// テスト用
//	private Set<Integer> buyId;	// 購入ID
//	private int itemId = 1;	// 商品ID
	
	public int getBuyId() {return buyId;}
	public void setBuyId(int buyId) {this.buyId = buyId;}
	
	public Set<Integer> getItemId() {return itemId;}
	public void setItemId(Set<Integer> itemId) {this.itemId = itemId;}
}