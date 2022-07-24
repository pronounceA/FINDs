package model;

import java.util.ArrayList;

// 購入履歴テーブルへ送る
public class BuyHistoryBeans{
	private int id;		// ユーザーID（連番で設定）
	private String name;		// ユーザーID（連番で設定）
	private String day;		// 購入した日付
	private int points;	// 増減ポイント
	private int buyId;	// 購入ID
	private ArrayList<Object> buylist = new ArrayList<Object>();
	private ArrayList<ArrayList<String>> buynamelist = new ArrayList<ArrayList<String>>();
	
	// テスト用
//	private int id = 0;
//	private String name = "";		// ユーザーID（連番で設定）
//	private String day = "1";		// 購入した日付
//	private int points = 2;	// 増減ポイント
//	private int buyId = 3;	// 購入ID
//	private ArrayList<Object> buylist = new ArrayList<Object>();
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getDay() {return day;}
	public void setDay(String day) {this.day = day;}
	
	public int getPoints() {return points;}
	public void setPoints(int point) {this.points = point;}
	
	public int getBuyId() {return buyId;}
	public void setBuyId(int buyId) {this.buyId = buyId;}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public ArrayList<Object> getBuylist() {return buylist;}
	public void setBuylist(ArrayList<Object> buylist) {this.buylist = buylist;}
	
	public ArrayList<ArrayList<String>> getBuynamelist() {return buynamelist;}
	public void setBuynamelist(ArrayList<ArrayList<String>> buynamelist2) {this.buynamelist = buynamelist2;}	
}	