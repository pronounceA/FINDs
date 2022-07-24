<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/loginscreen.css">
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

	<form action="/FINDs/LoginServlet" method="post">


		<div class="rogo"></div>

		<div class="jack">
			<div class="content">
				<h2>ログイン</h2>

				<div class="row">
					ユーザーID: <input type="text" name="Name"required>
				</div>

				<div class="row">
					パスワード: <input type="password" name="Pass"required>
				</div>


				<div class="row2">
					<input type="submit" value="ログイン">
				</div>
			</div>
		</div>

		<div class="text">―――――初めてFINDsショップをご利用ですか?―――――</div>

		<div class="touroku">
			<a class="button" href="/FINDs/RegisterServlet">FINDsアカウントを作成する</a>
		</div>


		<c:if test="${not empty registerMsg }">
			<div class="registerMsg">
				<p>${registerMsg}</p>
			</div>
		</c:if>



	</form>

		<div class="spacer"></div>
		<footer class="footer">
			<div class="wrapper ">
				<div class="fh">
					<a href="/FINDs/IndexServlet">
						<img src="./photo/white.png" alt="logo">
					</a>
					<ul class="footer-menu">
						<li><a href="/FINDs/html/corpotate.html">会社概要</a></li>
						<li><a href="/FINDs/html/privacy.html">個人情報保護方針</a></li>
						<li><a href="/FINDs/html/member.html">採用情報</a></li>
					</ul>
				</div>
				<div class="copyright">
					<span>Copyright 2022 ©小林経済圏 All Rights Reserved.</span>
				</div>
			</div>
		</footer>
</body>
</html>