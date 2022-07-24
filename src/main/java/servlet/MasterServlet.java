package servlet;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.MasterDAO;
// import
import model.Master;

@WebServlet("/MasterServlet")
@MultipartConfig(
		location="/tmp",
		//ファイルサイズ3MB以下を許容  少し余裕を持たせて3.3MB以下に設定
		maxFileSize=3_300_000,
		maxRequestSize=3_500_000,
		fileSizeThreshold=3_000_000
		)
public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MasterServlet() {
        super();
    }

	/* doGET */
	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) 
	throws ServletException, IOException {
		
		// フォワード先の初期化
		String forwardPath = null;
		
		// サーブレットクラスから動作を決定するaction値の取得
		String action = request.getParameter("action");
		
		// login.jspからフォワード
		if (action == null) {
			forwardPath = "/WEB-INF/jsp/master.jsp";
		}
		
		// masterComfirm.jspで「登録」ボタンが押された時
		else if (action.equals("done")) {
			// セッションスコープに保存されたMaster情報を取得
			HttpSession session = request.getSession();
			Master registerMaster = (Master) session.getAttribute("registerMaster");
			
			// DBに登録
			MasterDAO masterDAO = new MasterDAO();
			boolean checkInsert = masterDAO.insertDB(registerMaster);
			
			// セッションスコープ内データの削除
			session.removeAttribute("registerMaster");
			
			// フォワード先を設定
			// DAOファイル側でエラーが出ていないか確認
			if (checkInsert) {
				forwardPath = "/WEB-INF/jsp/masterDone.jsp";
			} else {
				forwardPath = "/WEB-INF/jsp/masterDbError.jsp";
			}
		
		// masterDone.jspで「商品登録画面に戻る」ボタンが押された時
		} else if (action.equals("back")) {
			// フォワード先を設定
			forwardPath = "/WEB-INF/jsp/master.jsp";
		
		// master.jspで「メインページに移動」ボタンが押された時
		} else if (action.equals("main")) {
			// フォワード先を設定
			forwardPath = "/WEB-INF/jsp/loginOk.jsp";
		}
		
		// 設定したフォワード先にジャンプ
		RequestDispatcher dispatcher =
		request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/* doPost */
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			// リクエストパラメータの取得
			request.setCharacterEncoding("UTF-8");
			String item_Name  = request.getParameter("item_Name");
			int item_Price = 0;
			int item_Stock = 0;
			String item_Memo  = request.getParameter("item_Memo");
			String forwardPath = null;
			String item_Img = null;
			
			//name属性がitem_ImgのファイルをPartオブジェクトとして取得
	
			Part part = request.getPart("item_Img");
	        LocalDateTime t = LocalDateTime.now();
	        String timeNumOnly = Integer.valueOf(t.get(ChronoField.YEAR)).toString() + t.get(ChronoField.MONTH_OF_YEAR) + t.get(ChronoField.DAY_OF_MONTH) + t.get(ChronoField.HOUR_OF_DAY) + t.get(ChronoField.MINUTE_OF_HOUR) + t.get(ChronoField.SECOND_OF_MINUTE);
			item_Img = "img" + timeNumOnly + part.getSubmittedFileName();
			
			//アップロードするディレクトリ
			String path = getServletContext().getRealPath("/photo");
			System.out.println(path + File.separator + item_Img);
			part.write(path + File.separator + item_Img);
			item_Img =  "./photo/" + item_Img;
	
			
			try {
				item_Price = Integer.parseInt(request.getParameter("item_Price"));
				item_Stock = Integer.parseInt(request.getParameter("item_Stock"));
			} catch(NumberFormatException e) {
				forwardPath = "/WEB-INF/jsp/masterError.jsp";
				RequestDispatcher dispatcher =
				request.getRequestDispatcher(forwardPath);
				dispatcher.forward(request, response);
			}
			
			// チェック用変数の宣言
			String check_Price = request.getParameter("item_Price");
			String check_Stock = request.getParameter("item_Stock");
			
			// 入力必須項目のチェック	
			if (item_Name == null || item_Name.length() == 0 || check_Price == null || check_Stock == null) {	
				// NGパターン
				forwardPath = "/WEB-INF/jsp/masterError.jsp";
			} else if (item_Price <= 0 || item_Stock <= 0) {
				forwardPath = "/WEB-INF/jsp/masterError.jsp";
			} else {
				// OKパターン
				// 登録する情報を設定
				Master registerMaster = new Master(item_Name, item_Price, item_Stock, item_Memo, item_Img);
				
				
				// セッションスコープに商品情報を保存
				HttpSession session = request.getSession();
				session.setAttribute("registerMaster", registerMaster);
				
				// フォワード先を設定
				forwardPath = "/WEB-INF/jsp/masterConfirm.jsp";
			}
			
			// 設定したフォワード先にジャンプ
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
			
		} catch (IllegalStateException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/masterError.jsp");
			dispatcher.forward(request, response);
		}
	}
}
