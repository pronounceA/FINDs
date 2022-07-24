package model;

public class Item {
	private int itemId;
	private String itemName;
	private int itemPrice;
	private int itemStock;
	private String itemMemo;
	private String itemImg;
	
	public Item(int itemId, String itemName, int itemPrice, int itemStock, String itemMemo, String itemImg) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemStock = itemStock;
		this.itemMemo = itemMemo;
		this.itemImg = itemImg;
	}
	
	public int getItemId() { return itemId; }
	public String getItemName() { return itemName; }
	public int getItemPrice() { return itemPrice; }
	public int getItemStock() { return itemStock; }
	public String getItemMemo() { return itemMemo; }
	public String getItemImg() { return itemImg; }
}
