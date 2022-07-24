package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import model.AccountBeans;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher
				("/WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String name = request.getParameter("name");
		String passTmp = request.getParameter("pass");
		String pass = passTmp;
		int points = 5000;
		String bankAccountTmp = request.getParameter("bankAccount");
		int bankAccount = 0;
		if(!(bankAccountTmp.equals(""))) {
			bankAccount = Integer.parseInt(bankAccountTmp);
		}
		
		
		String errorMsg = "【エラー】";
		
		if(name.equals("")) {
			errorMsg += "<br>ニックネームを入力してください";
		}
		if(pass.equals("")) {
			errorMsg += "<br>パスワードを入力してください";
		}
		if(!(pass.equals("")) && (!(pass.matches("[0-9]*[A-Z]*[a-z]*")) || pass.length() < 4)) {
			errorMsg += "<br>パスワードを正しく入力してください";
		}
		if(bankAccount == 0) {
			errorMsg += "<br>口座入金額を入力してください";
		}
		
		
		int registerJudge = 0;
		
		if(errorMsg != "【エラー】") {
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher
					("/WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);
		} else {
			AccountBeans account = new AccountBeans(name, pass, points, bankAccount);
			RegisterDAO dao = new RegisterDAO();
			registerJudge = dao.create(account);
		}
			if(registerJudge == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("registerMsg", "アカウント登録完了<br>初回登録特典で5,000ポイント付与されました");
				response.sendRedirect("./LoginServlet");
			} else if(registerJudge == 2) {
				request.setAttribute("registerErrorMsg", "【エラー】<br>そのニックネームは使用されています");
				RequestDispatcher dispatcher =
						request.getRequestDispatcher
						("/WEB-INF/jsp/register.jsp");
				dispatcher.forward(request, response);
			} else if(registerJudge == 3) {
				request.setAttribute("registerErrorMsg", "【エラー】<br>データベースエラーです。管理者に問い合わせてください。");
				RequestDispatcher dispatcher =
						request.getRequestDispatcher
						("/WEB-INF/jsp/register.jsp");
				dispatcher.forward(request, response);
			}
		
		
	}

}
