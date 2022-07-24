package model;

import java.util.ArrayList;
import java.util.TreeMap;

public class ItemDetailsBeans {
	private int itemId;
	private String itemName;
	private int itemPrice;
	private int itemStock;
	private String itemMemo;
	private String itemImg;
	private int itemNumber;
	private ArrayList<ItemDetailsList> itemDetailsList = new ArrayList<>();
	private TreeMap<Integer, ItemDetailsMap> itemDetailsMap = new TreeMap<Integer, ItemDetailsMap>();	

	public ItemDetailsBeans(){}
	public ItemDetailsBeans(int itemId, String itemName, int itemPrice, int itemStock, String itemMemo, String itemImg, int itemNumber){
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemStock = itemStock;
		this.itemMemo = itemMemo;
		this.itemImg = itemImg;
		this.itemNumber = itemNumber;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public String getItemMemo() {
		return itemMemo;
	}
	public void setItemMemo(String itemMemo) {
		this.itemMemo = itemMemo;
	}
	public String getItemImg() {
		return itemImg;
	}
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public ArrayList<ItemDetailsList> getItemDetailsList() {
		return itemDetailsList;
	}
	public void setItemDetailsList(ArrayList<ItemDetailsList> itemDetailsList) {
		this.itemDetailsList = itemDetailsList;
	}
	public TreeMap<Integer, ItemDetailsMap> getItemDetailsMap() {
		return itemDetailsMap;
	}
	public void setItemDetailsMap(TreeMap<Integer, ItemDetailsMap> itemDetailsMap) {
		this.itemDetailsMap = itemDetailsMap;
	}
}

/*ArrayListでデータを扱いたい*/
class ItemDetailsList {
	int itemId;
	String itemName;
	int itemPrice;
	int itemStock;
	String itemMemo;
	String itemImg;
	int itemNumber;
	
	ItemDetailsList(int itemId, String itemName, int itemPrice, int itemStock, String itemMemo, String itemImg, int itemNumber){
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemStock = itemStock;
		this.itemMemo = itemMemo;
		this.itemImg = itemImg;
		this.itemNumber = itemNumber;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public String getItemMemo() {
		return itemMemo;
	}
	public void setItemMemo(String itemMemo) {
		this.itemMemo = itemMemo;
	}
	public String getItemImg() {
		return itemImg;
	}
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	@Override
    public String toString(){
        return itemId + "," + itemName + "," + itemPrice + "," + itemStock + "," + itemMemo + "," + itemImg + "," + itemNumber;
    }
}

/*TreeMapでデータを扱いたい(パッケージ外で使用しないならここでOK)*/
//class ItemDetailsMap {
//	int itemId;
//	String itemName;
//	int itemPrice;
//	int itemStock;
//	String itemMemo;
//	String itemImg;
//	int itemNumber;
//	
//	ItemDetailsMap(String itemName, int itemPrice, int itemStock, String itemMemo, String itemImg, int itemNumber){
//		this.itemName = itemName;
//		this.itemPrice = itemPrice;
//		this.itemStock = itemStock;
//		this.itemMemo = itemMemo;
//		this.itemImg = itemImg;
//		this.itemNumber = itemNumber;
//	}
//
//	public int getItemId() {
//		return itemId;
//	}
//	public void setItemId(int itemId) {
//		this.itemId = itemId;
//	}
//	public String getItemName() {
//		return itemName;
//	}
//	public void setItemName(String itemName) {
//		this.itemName = itemName;
//	}
//	public int getItemPrice() {
//		return itemPrice;
//	}
//	public void setItemPrice(int itemPrice) {
//		this.itemPrice = itemPrice;
//	}
//	public int getItemStock() {
//		return itemStock;
//	}
//	public void setItemStock(int itemStock) {
//		this.itemStock = itemStock;
//	}
//	public String getItemMemo() {
//		return itemMemo;
//	}
//	public void setItemMemo(String itemMemo) {
//		this.itemMemo = itemMemo;
//	}
//	public String getItemImg() {
//		return itemImg;
//	}
//	public void setItemImg(String itemImg) {
//		this.itemImg = itemImg;
//	}
//	public int getItemNumber() {
//		return itemNumber;
//	}
//	public void setItemNumber(int itemNumber) {
//		this.itemNumber = itemNumber;
//	}
//
//	@Override
//    public String toString(){
//        return itemId + "," + itemName + "," + itemPrice + "," + itemStock + "," + itemMemo + "," + itemImg + "," + itemNumber;
//    }
//}