<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<% String title = "マイページ"; %>
<% String cssName = ""; %>
<%@ include file="/include/header.jsp" %>

<h2>ログインしてください</h2>
<p>
ログインしてください<br>
<a href="/TeamB/LoginServlet"><button>ログイン画面へ</button></a><br>

</p>

<%@ include file="/include/footer.jsp" %>