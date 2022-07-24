package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetItemListLogic;
import model.Item;


@WebServlet("/ItemListServlet")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		Integer pageNo;
		Integer maxPage;
		if (page == null) {
			pageNo = 1;
		} else {
			pageNo = Integer.parseInt(page);
		}
		request.setAttribute("pageNo", pageNo);
		
		GetItemListLogic getItemListLogic = new GetItemListLogic();
		List<Item> itemList = getItemListLogic.execute();
		maxPage = (itemList.size() - 1) / 12 + 1;
		if (pageNo.intValue() * 12 < itemList.size() ) {
			itemList = itemList.subList((pageNo.intValue() - 1 ) * 12, pageNo.intValue() * 12);
		} else {
			itemList = itemList.subList((pageNo.intValue() - 1 ) * 12, itemList.size());
		}
		request.setAttribute("itemList", itemList);
		request.setAttribute("maxPage", maxPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemList.jsp");
		dispatcher.forward(request, response);
	}
}
