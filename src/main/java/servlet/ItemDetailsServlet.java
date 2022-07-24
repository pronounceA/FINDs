package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetItemDetailsList;
import model.ItemDetails;
import model.ItemDetailsBeans;
import model.ItemDetailsLogic;

/**
 * Servlet implementation class ItemDetailsServlet
 */
@WebServlet("/ItemDetailsServlet")
public class ItemDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//セッションスコープ
		HttpSession session = request.getSession();
		
		//前回のカート内容破棄
		if(session.getAttribute("iD")!=null) {
			session.removeAttribute("iD");
			session.removeAttribute("itemDetailsList");
		}
		
		//商品IDの取得とセッションスコープへの保存
		ItemDetails iD = new ItemDetails(Integer.parseInt(request.getParameter("ID")));
		session.setAttribute("iD", iD);
		
		//データベースの商品データ取得とセッションスコープに保存
		GetItemDetailsList getItemDetailsList = new GetItemDetailsList();
		List<ItemDetails> itemDetailsList = getItemDetailsList.execute();
		session.setAttribute("itemDetailsList", itemDetailsList);
		
		//カートの追加画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ItemDetails.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//セッションスコープ
		HttpSession session = request.getSession();
		ItemDetails iD = (ItemDetails) session.getAttribute("iD");
		List<ItemDetails> itemDetailsList = (List<ItemDetails>) session.getAttribute("itemDetailsList");
		ItemDetailsBeans itemDetailsBeans = (ItemDetailsBeans) session.getAttribute("itemDetailsBeans");

		//初回立ち上げ時、カート内容のセッションスコープ初期化
		if(itemDetailsBeans==null) {
			itemDetailsBeans = new ItemDetailsBeans();
			itemDetailsBeans.setItemId(0);
			itemDetailsBeans.setItemName("");
			itemDetailsBeans.setItemPrice(0);
			itemDetailsBeans.setItemStock(0);
			itemDetailsBeans.setItemMemo("");
			itemDetailsBeans.setItemImg("");
			itemDetailsBeans.setItemNumber(0);
			//セッションスコープに初期化情報追加
			session.setAttribute("itemDetailsBeans", itemDetailsBeans);
		}
		
		/*商品番号の検索*/
		int index=0;
		for(ItemDetails idetails : itemDetailsList) {
			if(idetails.getItemId()==(iD.getID())){
//				index++; //index番号を配列番号にするため足さない
				break;
			}
			index++;
		}
		int itemId = itemDetailsList.get(index).getItemId();
		String itemName = itemDetailsList.get(index).getItemName();
		int itemPrice = itemDetailsList.get(index).getItemPrice();
		int itemStock = itemDetailsList.get(index).getItemStock();
		String itemMemo = itemDetailsList.get(index).getItemMemo();
		String itemImg = itemDetailsList.get(index).getItemImg();
		int itemNumber=0;
		if(request.getParameter("itemNumber")!=null) {
			itemNumber = Integer.parseInt(request.getParameter("itemNumber"));
		}
		/*データの移動確認用*/
//		System.out.println(index);
//		System.out.println(itemId);
//		System.out.println(itemName);
//		System.out.println(itemPrice);
//		System.out.println(itemStock);
//		System.out.println(itemMemo);
//		System.out.println(itemImg);
//		System.out.println(itemNumber);
		
		/*Beansのセッションスコープ保存確認用*/
//		int itemId = 1;
//		String itemName = "name";
//		int itemPrice = 100;
//		int itemStock = 10;
//		String itemMemo = "Memo";
//		String itemImg = "Img";
		
		/*カート情報用セッションスコープに保存*/
		itemDetailsBeans.setItemId(itemId);
		itemDetailsBeans.setItemName(itemName);
		itemDetailsBeans.setItemPrice(itemPrice);
		itemDetailsBeans.setItemStock(itemStock);
		itemDetailsBeans.setItemMemo(itemMemo);
		itemDetailsBeans.setItemImg(itemImg);
		itemDetailsBeans.setItemNumber(itemNumber);
		ItemDetailsLogic itemDetailsLogic = new ItemDetailsLogic();
		itemDetailsLogic.addItemDetailsList(itemDetailsBeans);
		itemDetailsLogic.addItemDetailsMap(itemDetailsBeans);
		
		//セッションスコープにカート情報を追加
		session.setAttribute("itemDetailsBeans", itemDetailsBeans);
		
		/*商品一覧に移動*/
		response.sendRedirect("./BuyServlet?action=test");
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/test/testList.jsp");
//		dispatcher.forward(request, response);
	}
}
