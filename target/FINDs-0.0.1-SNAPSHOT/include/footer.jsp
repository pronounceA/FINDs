<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page
	import="model.ItemDetailsBeans, model.ItemDetailsMap,java.util.Map,java.util.TreeMap"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
ItemDetailsBeans itemListBeans = (ItemDetailsBeans) session.getAttribute("itemDetailsBeans");
%>
<style>
@import url('https://fonts.googleapis.com/css2?family=Raleway:wght@600;800&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@400&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@600;800&display=swap');
</style>
					</div>
					<div class="side-container">
						<% if(itemListBeans==null){ %>
							<a href=#><img src="photo/22402573.jpg" alt="banner1"></a>
							<a href=#><img src="photo/22447020.jpg" alt="banner2"></a>
						<% } else { %>
						<%
						int tmpTotal = 0;
						%>
							<div class="cart-title">
								<div class="cart">
								</div>
								<div class="ctr">
									Cart
								</div>
							</div>
							<div class="cartlist-container">
									<%
									for (ItemDetailsMap valueList : itemListBeans.getItemDetailsMap().values()) {
									%>
										<div class="cart-item">
											<div class="item-upper">
												<div class="cart-img">
													<img src="<%= valueList.getItemImg() %>">
												</div>
												<div class="cnpa">
													<div class="cart-name">
														<% if (valueList.getItemName().length() < 8) {%>
															<span><%= valueList.getItemName() %></span>
														<% } else { %>
															<span><%= valueList.getItemName().substring(0, 8) %>...</span>
														<% } %>
													</div>
													<p class="small">
														<span>価格 : ￥<%=valueList.getItemPrice()%></span><br>
														<span>数量 : <%=valueList.getItemNumber()%></span>
													</p>
												</div>
											</div>
											
											
											
										</div>
										<%
											tmpTotal += valueList.getItemPrice() * valueList.getItemNumber();
										%>
									<%}%>
								</div>
								<div class="total-price"><span class="total">合計：</span><span class="yen">￥</span><span class="value"><%= tmpTotal %></span></div>
								<a class="goto-cart" href="./BuyServlet?action=test">購入画面</a>
							<% } %>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="spacer"></div>
		<footer class="footer">
			<div class="wrapper ">
				<div class="fh">
					<a href="./IndexServlet">
						<img src="./photo/white.png" alt="logo">
					</a>
					<ul class="footer-menu">
						<li><a href=#>会社概要</a></li>
						<li><a href=#>個人情報保護方針</a></li>
						<li><a href=#>採用情報</a></li>
					</ul>
				</div>
				<div class="copyright">
					<span>Copyright 2022 ©Finds All Rights Reserved.</span>
				</div>
			</div>
		</footer>
	</body>
</html>