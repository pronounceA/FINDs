<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Master, javax.servlet.http.Part" %>
<%
Master registerMaster = (Master)session.getAttribute("registerMaster");
String path =(String)session.getAttribute("path");
%>
<% String title = "登録情報の確認"; %>
<% String cssName = ""; %>
<%@ include file="/include/masterHeader.jsp" %>
<!-- <body> -->
<div class="main">
<h2>
登録情報の確認
</h2>
<p>
以下の内容で登録してもよろしいですか。
</p>
<table>
	<tr>
		<td>商品名：</td>
		<td><%= registerMaster.getItem_Name() %><td>
	</tr>
	<tr>
		<td>価格：</td>
		<td><%= registerMaster.getItem_Price() %>円<td>
	</tr>
	<tr>
		<td>追加個数：</td>
		<td><%= registerMaster.getItem_Stock() %>個<td>
	</tr>
	<tr>
		<td>商品詳細</td>
		<td><%= registerMaster.getItem_Memo() %><td>
	</tr>
	<tr>
		<td>商品画像：</td>
		<td><img class="upload-img" src="<%= registerMaster.getItem_Img() %>"><td>
	</tr>
</table>
<p>
<a href="./MasterServlet"><button>商品登録画面に戻る</button></a>
<a href="./MasterServlet?action=done"><button>登録</button></a>
</p>
</div>
<!-- </body> -->
<%@ include file="/include/masterFooter.jsp" %>