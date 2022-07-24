<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String title = "お買い上げありがとうございました"; %>
<% String cssName = "buyOkNg"; %>

<%@ include file="/include/header.jsp" %>
<table>
<tr>
<td><span class="buy_ok">Thank You</span></td>
<tr>
<td style="text-align: center"><span class="buy_ok_text">お買い上げありがとうございました！</span></td>
</tr>
</table>
<p class="button_area">
<a href="/FINDs/ItemListServlet" class="red">お買物を続ける</a>
<a href="/FINDs/IndexServlet" class="blue">トップページへ</a>
<a href="/FINDs/LoginServlet" class="blue">ログアウト</a>
</p>
<%@ include file="/include/footer.jsp"%>