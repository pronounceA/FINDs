<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ItemDetailsBeans, model.ItemDetails, java.util.List"  %>
<%
ItemDetails iD = (ItemDetails) session.getAttribute("iD");
List<ItemDetails> itemDetailsList = (List<ItemDetails>) session.getAttribute("itemDetailsList");

int index=0;
for(ItemDetails idetails : itemDetailsList) {
	if(idetails.getItemId()==(iD.getID())){
//		index++; //index番号を配列番号にするため足さない
		break;
	}
	index++;
}

int hand=0;
ItemDetailsBeans beans = (ItemDetailsBeans) session.getAttribute("itemDetailsBeans");
if(beans!=null){
	if(beans.getItemDetailsMap().containsKey(iD.getID())){
		hand=beans.getItemDetailsMap().get(iD.getID()).getItemNumber();
	}
}
%>
<% String title = "商品の詳細"; %>
<% String cssName = "itemDetails"; %>
<style>
@import url('https://fonts.googleapis.com/css2?family=Kosugi+Maru&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato:wght@700&family=Montserrat&display=swap');
</style>
<%@ include file="/include/header.jsp" %>

<form action="./ItemDetailsServlet" method="post">
	<div class="column">
		<div class="left-column">
			<img class="item-img" src="<%= itemDetailsList.get(index).getItemImg()%>" alt="150">
		</div>
		<div class="right-column">
			<div class="item-name">
				<h2><%= itemDetailsList.get(index).getItemName() %></h2>
			</div>
			<div class="under-item-name">
				<div class="item-price-box">
					<div class="item-price-tag">
						価格 :
					</div>
					<div class="item-price">
						￥
						<span class="price-content">
							<%= itemDetailsList.get(index).getItemPrice() %>
						</span>
					</div>
				</div> 
	
				<div class="cart-option">
					<!-- <p class="item-stock">残り点</p> -->
					<select name = "itemNumber">
						<% for(int i=1; i<itemDetailsList.get(index).getItemStock()+1-hand; i++){%>
							<option value="<%= i%>"><%= i%></option>
						<%} %>
					</select>
					/ <%= itemDetailsList.get(index).getItemStock()-hand %>個
					<div class="submit-button">
						<input type = "submit" value="カートへ追加" class="into-cart-button">
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
<div class="item-description">
	<div class="description-title"><span>商品説明</span></div>
	<div class="description-content"><span class="add-border"> <%= itemDetailsList.get(index).getItemMemo() %></span></div>
</div>
<div class="return">
	<a class="return-a" href="./ItemListServlet">戻る</a>
</div>
<%@ include file="/include/footer.jsp" %>