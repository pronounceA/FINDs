package model;

/*TreeMapでデータを扱いたい*/
public class ItemDetailsMap {
	int itemId;
	String itemName;
	int itemPrice;
	int itemStock;
	String itemMemo;
	String itemImg;
	int itemNumber;
	
	ItemDetailsMap(String itemName, int itemPrice, int itemStock, String itemMemo, String itemImg, int itemNumber){
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
