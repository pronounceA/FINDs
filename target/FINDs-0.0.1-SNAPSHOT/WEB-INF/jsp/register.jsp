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


				<div class="birthday">
					<h3>生年月日※</h3>
					<div class="hako2">
						<input type="text" name="birthday" placeholder="例：YYYY/MM/DD"
							style="width: 300px; height: 40px;" required>
						</div>
							<div class="by">
							年月日(YYYY/MM/DD)の順で入力してください。
							生年月日は一度登録すると変更することはできません。
					</div>
				</div>



				<div class="kouza">
					<h3>口座に入金する金額を入力してください※</h3>
					<input type="text" name="bankAccount" placeholder="例：5000"
						style="width: 300px; height: 40px;" required>

					<div class="noting">
						<h4>※アルファベットと数字のみ使用可能です（大文字と小文字は区別されます）</h4>
					</div>

					<div class="seibetu">
						<h3>性別</h3>
		
						<div > <label> <input type="radio"name="example" value="選択肢1" required>男性 </label> </div> 
						<div > <label> <input type="radio" name="example" value="選択肢2">女性 </label> </div> 
						<div > <label> <input type="radio" name="example" value="選択肢3">その他 </label> </div> 
					</div>
					
						<div class="mail">
						<h3>メールマガジン登録</h3>
						<div > <label> <input type="checkbox"name="mail" value="選択肢1" required>FINDsメールマガジンを登録する </label> </div> 
					</div>
					<div class="by">
						メールマガジンの配信設定は会員情報ページから変更することができます。
					</div>
					<p>――――――――――――――――――――――――――――――</p>

					<div class="mail">
						<h3>利用規約</h3>
						<div > <label> <input type="checkbox"name="mail" value="選択肢1" required>利用規約にご同意の上、確認画面へお進みください。 </label> </div> 
					</div>
					<div class="by">
						利用規約とプライバシーポリシーにご同意の上、確認画面へお進みください。
					</div>
					<div class="rogogo">
					</div>
					<div class="wac">
					<a href="./KiakuSrevlet">利用規約</a>
					</div>
					
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