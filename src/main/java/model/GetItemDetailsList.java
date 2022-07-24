package model;

import java.util.List;

import dao.ItemCheckDAO;

public class GetItemDetailsList {
	public List<ItemDetails> execute(){
		ItemCheckDAO dao = new ItemCheckDAO();
		List<ItemDetails> itemDetailsList = dao.findAll();
		return itemDetailsList;
	}
}
