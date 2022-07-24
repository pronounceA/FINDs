<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ItemDetailsBeans, model.ItemDetails, java.util.List"  %>
<%
ItemDetailsBeans beans = (ItemDetailsBeans) session.getAttribute("itemDetailsBeans");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>商品一覧</h1>
<%= beans.getItemDetailsMap() %><br>
<%= beans.getItemDetailsList() %><br>
<a href="./ItemListServlet"><button>戻る</button></a>
</body>
</html>