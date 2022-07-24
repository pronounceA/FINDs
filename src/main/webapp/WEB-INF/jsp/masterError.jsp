<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String title = "登録エラーが発生しました"; %>
<% String cssName = ""; %>
<%@ include file="/include/masterHeader.jsp" %>
<!-- <body> -->
<div class="main">
<h2>商品登録できませんでした</h2>
<p>
以下のことを配慮し、再度入力ください。<br>
・「※」付きの項目は入力必須項目となります。<br>
・商品の価格や追加個数は整数値にて入力ください。<br>
（「-1」や「1.1」などといった数値は入力できません）<br>
・画像サイズが3MBを超えています。
</p>
<a href="/FINDs/MasterServlet?action=back"><button>商品登録画面に戻る</button></a>
</div>
<!-- </body> -->
<%@ include file="/include/masterFooter.jsp" %>