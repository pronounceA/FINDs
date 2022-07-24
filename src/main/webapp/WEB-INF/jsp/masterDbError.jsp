<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String title = "登録エラーが発生しました"; %>
<% String cssName = ""; %>
<%@ include file="/include/masterHeader.jsp" %>
<!-- <body> -->
<div class="main">
<h2>商品登録できませんでした</h2>
<p>
データベース側でエラーが発生しています。<br>
・「H2 Database」を起動の上、再度登録し直してください。<br>
・「H2 Database」側の設定を再度ご確認ください。<br>
・不明な場合は、恐れ入りますが管理者までお問合せ願います。
</p>
<a href="/FINDs/MasterServlet?action=back"><button>商品登録画面に戻る</button></a>
</div>
<!-- </body> -->
<%@ include file="/include/masterFooter.jsp" %>