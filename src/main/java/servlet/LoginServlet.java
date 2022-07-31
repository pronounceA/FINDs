package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.AccountBeans;
import model.LoginBeans;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("getにとんだ");

		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action != null && action.equals("logout")) {
			session.removeAttribute("user");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("postにとんだ");
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if (action == null) {
			// リクエストパラメーターの取得
			request.setCharacterEncoding("UTF-8");
			String Name = request.getParameter("Name");
			String Pass = request.getParameter("Pass");
			// ログインの処理
			LoginBeans login = new LoginBeans(Name, Pass);
			LoginLogic bo = new LoginLogic();
			boolean result = bo.execute(login);

			if (Name.equals("admin") && Pass.equals("admin")) {
				response.sendRedirect("./MasterServlet");

			} else {

				// ログイン処理の分岐
				if (result) {
					// 成功時セッションスコープに保存

					AccountDAO dao = new AccountDAO();
					AccountBeans account = dao.findByLogin(login);

					int IdTmp = account.getId();
					String NameTmp = account.getName();
					String PassTmp = account.getPass();
					int PointsTmp = account.getPoints();
					int bankAccountTmp = account.getBankAccount();
					account = new AccountBeans(IdTmp, NameTmp, PassTmp, PointsTmp, bankAccountTmp);

					// "user"にセットするaccountの内容を確認
					// System.out.println(IdTmp);
					// System.out.println(NameTmp);
					// System.out.println(PassTmp);
					// System.out.println(PointsTmp);
					// System.out.println(bankAccountTmp);

					HttpSession session = request.getSession();
					session.setAttribute("user", account);
					session.setAttribute("userName", Name);
					session.removeAttribute("registerMsg");

					// フォワード
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
			}
		} else if (action.equals("action")) {
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}  
	}
}
