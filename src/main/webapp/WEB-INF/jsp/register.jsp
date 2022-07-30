<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String title = "アカウント登録";
%>
<%
String cssName = "";
%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/Register.css">
<link rel="stylesheet" href="css/headerFooter.css">
<link rel="stylesheet" href="css/kiyaku.css">
<%@ include file="/include/header.jsp"%>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="jack">
		<div class="acount">
			<h1>新規アカウント登録</h1>

			<form action="./RegisterServlet" method="post">

				<div class="nikk">
					<h3>ニックネーム</h3>
				</div>
				<div class="hako">
					<input type="text" name="name" placeholder="例：FINDs"
						style="width: 300px; height: 40px;" required>
				</div>

				<div class="pass">
					<h3>パスワード※</h3>
					<div class="hako2">
						<input type="password" name="pass" placeholder="例：ABCD　abcd　1234"
							style="width: 300px; height: 40px;" required>
							<div class="pa">
						<h4>（半角4文字以上）</h4>
					</div>
				</div>
				</div>

				<div class="kouza">
					<h3>口座に入金する金額を入力してください※</h3>
					<input type="text" name="bankAccount" placeholder="例：5000"
						style="width: 300px; height: 40px;" required>
					
					
					<div class="btn">
						<input type="submit" name="button" value="登録">
					</div>

				</div>
			</form>

			<c:if test="${not empty errorMsg}">
				<p>${errorMsg}</p>
			</c:if>
			<c:if test="${not empty registerErrorMsg}">
				<p>${registerErrorMsg}</p>
			</c:if>
		</div>
	</div>
	<%@ include file="/include/footer.jsp"%>
</body>
</html>