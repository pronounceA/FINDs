package model;
import java.io.Serializable;

public class Master implements Serializable {
	// private int item_Id;  ※DB側でシーケンス番号を付与
	private String item_Name;
	private int item_Price;
	private int item_Stock;
	private String item_Memo;
	private String item_Img;  // 仮に画像ファイルのパスを入力することに
	
	public Master() {};
	public Master
	(String item_Name, int item_Price, int item_Stock, String item_Memo, String item_Img) {
		this.item_Name = item_Name;
		this.item_Price = item_Price;
		this.item_Stock = item_Stock;
		this.item_Memo = item_Memo;
		this.item_Img = item_Img;
	}
	
	// プロパティ
	public String getItem_Name() { return item_Name;}
	public void setItem_Name(String item_Name) { this.item_Name = item_Name; }
	public int getItem_Price() { return item_Price;}
	public void setItem_Price(int item_Price) { this.item_Price = item_Price; }
	public int getItem_Stock() { return item_Stock;}
	public void setItem_Stock(int item_Stock) { this.item_Stock = item_Stock; }
	public String getItem_Memo() { return item_Memo;}
	public void setItem_Memo(String item_Memo) { this.item_Memo = item_Memo; }
	public String getItem_Img() { return item_Img;}
	public void setItem_Img(String item_Img) { this.item_Img = item_Img; }
}
