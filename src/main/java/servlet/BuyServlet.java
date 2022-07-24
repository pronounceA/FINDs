package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemListManagementDAO;
import dao.SetBankAccountDAO;
import model.AccountBeans;
import model.BuyHistoryBeans;
import model.BuyItemBeans;
import model.BuyLogic;
import model.ItemDetailsBeans;
import model.ItemDetailsMap;

/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ArrayList<String>> buynamelist = new ArrayList<ArrayList<String>>();
		
		// 購入履歴のArraylistの作成
		ArrayList<Object> buylist = new ArrayList<Object>();

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		// セッションスコープを生成
		HttpSession session = request.getSession();
		
		// アカウントページから購入履歴が押される
		if (action.equals("buyhistory")) {
			// ユーザー情報を取得
			AccountBeans account = (AccountBeans) session.getAttribute("user");
			BuyLogic buylogic = new BuyLogic();
			buylist = buylogic.getHistory(account);

//			System.out.println("account:" + account);
			System.out.println(buylist);

			// セッションスコープへ保存
			BuyHistoryBeans buyhistory = new BuyHistoryBeans();
			buyhistory.setBuylist(buylist);
			
			// ログイン中のIDの購入履歴から購入IDを照合し
			// 購入IDを照合した商品IDを取得する
			buynamelist = buylogic.getItemName(account);
			System.out.println("商品名" + buynamelist);
			buyhistory.setBuynamelist(buynamelist);
			
			session.setAttribute("buylist", buyhistory);

			// 購入履歴jspへフォワード
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("WEB-INF/jsp/buyhistory.jsp");
			dispatcher1.forward(request, response);
		} else {
			// カートの中身表示jspへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/buy.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwordPath = ""; // フォワード先格納
		int total = 0; // 買い物の合計金額 カートのセッションスから金額を取得し合計
		int bankAccount; // 口座残高
		int id = 0; // ID
		String name = ""; // ニックネーム
		int points = 0; // ポイント
//		Set<Integer> itemId;		 // 商品ID
		int buyId = 0; // 購入ID


		// セッションスコープを生成
		HttpSession session = request.getSession();

		// カートの合計金額を取得
		ItemDetailsBeans itemdetails = (ItemDetailsBeans) session.getAttribute("itemDetailsBeans"); // 買い物カートのセッションスから情報を取得
		// テスト用
//		itemDetailsBeans = new ItemDetailsBeans();
//		itemDetailsBeans.setItemId(0);
//		itemDetailsBeans.setItemName("");
//		itemDetailsBeans.setItemPrice(0);
//		itemDetailsBeans.setItemStock(0);
//		itemDetailsBeans.setItemMemo("");
//		itemDetailsBeans.setItemImg("");
//		itemDetailsBeans.setItemNumber(0);
//		//セッションスコープに初期化情報追加
//		session.setAttribute("itemDetailsBeans", itemDetailsBeans);
//		System.out.println(itemdetails);

		ItemDetailsBeans itemdetailsbeans = (ItemDetailsBeans) session.getAttribute("itemDetailsBeans");

		for (ItemDetailsMap value : itemdetailsbeans.getItemDetailsMap().values()) { // カートのArrayListから金額を取得し
			total += value.getItemPrice() * value.getItemNumber(); // 合計額を算出
		}
//		System.out.println("あ" + total);

//		// 商品IDを取得
		Set<Integer> itemId = itemdetails.getItemDetailsMap().keySet();

//		System.out.println("商品ID：" + itemId);

//		// 口座残高を個人情報から取得
		AccountBeans account = (AccountBeans) session.getAttribute("user");
		try {
			bankAccount = account.getBankAccount(); // セッションスコープから口座残高値を取得
			name = account.getName(); // セッションスコープから名前を取得
			points = account.getPoints(); // セッションスコープからポイントを取得
			id = account.getId();

//		System.out.println(bankAccount);
//		System.out.println(name);
//		System.out.println(points);

			BuyLogic buylogic = new BuyLogic();

			// BuyHistoryBeansプロパティに保存
			BuyHistoryBeans buyh = new BuyHistoryBeans();
			// 現在日時情報で初期化されたインスタンスの取得
			LocalDateTime nowDateTime = LocalDateTime.now();
			DateTimeFormatter java8Format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			// 日時情報を指定フォーマットの文字列で取得
			String java8Disp = nowDateTime.format(java8Format);
			buyh.setDay(java8Disp); // 日付をプロパティへ保存
			buyh.setId(id); // idをプロパティへ保存
			buyh.setName(name); // 名前をプロパティへ保存
			buyh.setPoints(points); // ポイントをプロパティへ保存

			buyId = buylogic.getBuyId(); // DBから一番最新の購入IDを取得
			buyId++;
			buyh.setBuyId(buyId); // 購入IDをプロパティへ保存
			
			session.setAttribute("buyh", buyh);

			// BuyItemBeansプロパティに保存
			BuyItemBeans buyi = new BuyItemBeans();
			buyi.setItemId(itemId);
			buyi.setBuyId(buyId);
			session.setAttribute("buyi", buyi);

			if (buylogic.execute(bankAccount, buyh, buyi, total)) { // DBへ保存
				forwordPath = "WEB-INF/jsp/buyOk.jsp";
				
				// DB内の口座を減らす
				SetBankAccountDAO setbankaccount = new SetBankAccountDAO();
				setbankaccount.executeBankAccount(-total, account);	 // total=買物値段の合計
				
				// DB内の商品の在庫を減らす
				ItemListManagementDAO itemlistmanagement = new ItemListManagementDAO();
				itemlistmanagement.executeItemlist(itemdetailsbeans, account);
				
				//セッション更新
				account.setBankAccount(bankAccount-total);
				session.setAttribute("user", account);

				// カートの中身を削除
				session.removeAttribute("itemDetailsBeans");

				// カートの購入履歴情報を削除
				session.removeAttribute("buyh");
			} else {
				forwordPath = "WEB-INF/jsp/buyNg.jsp";
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher(forwordPath);
			dispatcher.forward(request, response);
		} catch (NullPointerException e) {
			response.sendRedirect("/FINDs/LoginServlet");
		}
	}

}
