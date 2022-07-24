package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();
    }

	/* doGET */
	protected void doGet(HttpServletRequest request,
	HttpServletResponse response) 
	throws ServletException, IOException {
		
		// フォワード先の初期化
		String forwardPath = null;
		
		// サーブレットクラスから動作を決定するaction値の取得
//		String action = request.getParameter("action");
		
		// login.jspからフォワード
//		if (action == null) {
			forwardPath = "/index.jsp";
//		} else if (action.equals("back")) {
//			forwardPath = "/WEB-INF/jsp/minigame.jsp";
//		}
		
		// 設定したフォワード先に飛ぶ（共通）
		RequestDispatcher dispatcher =
		request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/* doPost */
	protected void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException { }
}