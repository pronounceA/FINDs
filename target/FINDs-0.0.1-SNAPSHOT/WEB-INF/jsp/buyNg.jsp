<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String title = "残高不足により購入できませんでした"; %>
<% String cssName = "buyOkNg"; %>

<%@ include file="/include/header.jsp" %>
<table>
<tr>
<td><span class="buy_ng">残高不足により購入できませんでした</span></td>
<tr>
<td style="text-align: center">
<span class="buy_ng_text">
弊社社長も悲しんでおられます...<br>
なんとかして買ってあげてください。
</span>
</td>
</tr>
</table>
<p>
<img src="./photo/buy_ng.gif" width="800" height="450" class="banner_img">
</p>
<p class="button_area">
<a href="./ItemListServlet" class="red">お買物を続ける</a>
<a href="./IndexServlet" class="blue">トップページへ</a>
<a href="./LoginServlet" class="blue">ログアウト</a>
</p>
<%@ include file="/include/footer.jsp" %>