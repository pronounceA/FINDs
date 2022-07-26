<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<% String title = "マイページ"; %>
<% String cssName = "mypage"; %>
<%@ include file="/include/header.jsp" %>

<h2 class="mypage_title">${user.name}さんの会員情報</h2>
<div class="box">
	<div class="personal">
		ユーザーID：${user.id}<br>
		ニックネーム：${user.name}<br>
		所有ポイント：${user.points}P<br>
		口座残高：${user.bankAccount}円<br>
		<!--  <a href="/TeamB/BuyServlet?action=buyhistory">購入履歴</a><br> -->
		<!-- ※アカウントを切り替える場合は<a href="/TeamB/LoginServlet?action=logout">こちら</a> -->
	</div>
</div>

<%@ include file="/include/footer.jsp" %>