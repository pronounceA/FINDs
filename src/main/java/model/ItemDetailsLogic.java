   package model;

import java.util.ArrayList;
import java.util.TreeMap;

public class ItemDetailsLogic {
	//ArrayListのテスト
	public void addItemDetailsList(ItemDetailsBeans beans) {
		ArrayList<ItemDetailsList> itemdetailsList = beans.getItemDetailsList();
		int index=0;
		int flag=0;
		for(ItemDetailsList idetails : itemdetailsList) {
			if(idetails.getItemId()==(beans.getItemId())){
//				index++; //index番号を配列番号にするため足さない
				flag=1;
				break;
			}
			index++;
		}
		if(flag==1) {
			int oldNumber = itemdetailsList.get(index).getItemNumber();
			itemdetailsList.add(new ItemDetailsList(beans.getItemId(), beans.getItemName(), beans.getItemPrice(), beans.getItemStock(), beans.getItemMemo(), beans.getItemImg(), oldNumber + beans.getItemNumber()));
			beans.setItemDetailsList(itemdetailsList);
		}else {
			itemdetailsList.add(new ItemDetailsList(beans.getItemId(), beans.getItemName(), beans.getItemPrice(), beans.getItemStock(), beans.getItemMemo(), beans.getItemImg(), beans.getItemNumber()));
			beans.setItemDetailsList(itemdetailsList);
		}
	}
	
	//カートの追加ボタンを押したときの商品追加または購入数を変更
	public void addItemDetailsMap(ItemDetailsBeans beans) {
		TreeMap<Integer, ItemDetailsMap> itemDetailsMap = beans.getItemDetailsMap();
		if(itemDetailsMap.containsKey(beans.getItemId())) {
			int oldNumber = itemDetailsMap.get(beans.getItemId()).getItemNumber();
			itemDetailsMap.replace(beans.getItemId(), new ItemDetailsMap(beans.getItemName(), beans.getItemPrice(), beans.getItemStock(), beans.getItemMemo(), beans.getItemImg(), oldNumber + beans.getItemNumber()));
			beans.setItemDetailsMap(itemDetailsMap);
		}else {
			itemDetailsMap.put(beans.getItemId(), new ItemDetailsMap(beans.getItemName(), beans.getItemPrice(), beans.getItemStock(), beans.getItemMemo(), beans.getItemImg(), beans.getItemNumber()));
			beans.setItemDetailsMap(itemDetailsMap);
		}

	}
}
