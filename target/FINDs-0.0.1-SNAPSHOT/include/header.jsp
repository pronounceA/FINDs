<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="model.AccountBeans" %>
<%
AccountBeans account = (AccountBeans)session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><%= title %></title>
 		<link rel="stylesheet" href="./css/<%= cssName %>.css">
		<link rel="stylesheet" href="./css/headerFooter.css">
	</head>
	<body>
		<header>
			<div class="header">
				<div class="wrapper">
					<a href="./IndexServlet">
						<img class="logo" src="./photo/778141.png" alt="logo">
					</a>
					<div class="right">
						<p>
							<% if (account != null) { %>
								ようこそ、<%= account.getName() %> さん（<a href="./MyPageServlet">マイページ</a>）<br>
								現在のポイント：<%= account.getPoints() %>P<br>
								現在の口座残高：<%= account.getBankAccount() %>円　
								<a href="./LoginServlet?action=logout"><button>ログアウト</button></a>
							<% } else { %>
								ようこそ、ゲストさん <a href="./LoginServlet"><button>ログイン</button></a>
							<% } %>
						</p>
					</div>
				</div>
				<ul class="menu-list">
					<li><a href="/IndexServlet">ＴＯＰ</a></li>		
					<li><a href="/ItemListServlet">FINDsShop</a></li>
				</ul>
			</div>
		</header>
		<div class="under-header">
			<div class="spacer">
			</div>
			<div class="wrapper main-side">
				<div class="main-container">