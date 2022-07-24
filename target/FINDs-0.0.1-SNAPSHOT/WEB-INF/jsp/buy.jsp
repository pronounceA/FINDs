<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="model.ItemDetailsBeans, model.ItemDetailsMap,java.util.Map,java.util.TreeMap"%>
<%
	ItemDetailsBeans itemDetailsBeans = (ItemDetailsBeans) session.getAttribute("itemDetailsBeans");
%>
<%
String title = "カート";
%>
<%
String cssName = "buy";
%>
<%@ include file="/include/header.jsp" %>
<div class="cart-title">
	<div class="main-cart">
	</div>
	<div class="main-ctr">
		Cart
	</div>
</div>

<div class="cartlist-container">
		<%
			int mainTmpTotal = 0;
		%>
		<%
			for (ItemDetailsMap valueList : itemDetailsBeans.getItemDetailsMap().values()) {
		%>
			<div class="cart-item">
				<div class="item-upper">
					<div class="main-cart-img">
						<img src="<%= valueList.getItemImg() %>">
					</div>
					<div class="cnpa">
						<div class="cart-name">
							<span><%= valueList.getItemName() %></span>
						</div>
						<p class="small">
							<span>価格 : ￥<%=valueList.getItemPrice()%></span><br>
							<span>数量 : <%=valueList.getItemNumber()%></span>
						</p>
					</div>
				</div>
			</div>
			<%
				mainTmpTotal += valueList.getItemPrice() * valueList.getItemNumber();
			%>
		<%}%>
	</div>
	<div class="total-price"><span class="total">合計：</span><span class="yen">￥</span><span class="value"><%= mainTmpTotal %></span></div>
<form action="./BuyServlet" method="post">
	<input class="buy-button" type="submit" value="購入">
</form>
<form action="./ItemListServlet" method="get">
	<input class="back-button" type="submit" value="買物に戻る">
</form>
<%@ include file="/include/footer.jsp"%>