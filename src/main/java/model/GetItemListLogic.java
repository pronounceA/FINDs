package model;

import java.util.List;

import dao.ItemListDAO;

public class GetItemListLogic {
	public List<Item> execute() {
		ItemListDAO dao = new ItemListDAO();
		List<Item> itemList = dao.findAll();
		return itemList;
	}
}
