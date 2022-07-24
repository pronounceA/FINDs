<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String title = "商品登録完了"; %>
<% String cssName = ""; %>
<%@ include file="/include/masterHeader.jsp" %>
<!-- <body> -->
<div class="main">
<h2>商品登録完了</h2>
<p>
商品の登録が完了しました。<br>
<a href="/FINDs/MasterServlet?action=back"><button>商品登録画面に戻る</button></a>
<a href="/FINDs/LoginServlet"><button>ログイン画面に戻る</button></a>
</p>
</div>
<!-- </body> -->
<%@ include file="/include/masterFooter.jsp" %>