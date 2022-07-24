<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.BuyHistoryBeans"%>
<%
BuyHistoryBeans buyhistory = (BuyHistoryBeans) session.getAttribute("buylist");
String[] str = new String[] { "ユーザーID", "商品名", "日付", "ポイント" };
%>
<%
String title = "カート";
%>
<%
String cssName = "";
%>
<%@ include file="/include/header.jsp"%>
<h1>購入履歴</h1>
<table border=1>
	<%
	for (int i = 0; i < buyhistory.getBuylist().size(); i++) {
	%>
	<tr>
		<td><%=str[i % 4]%></td>
		<%if(i % 4 != 1){ %>
		<td><%=buyhistory.getBuylist().get(i)%></td>
		<%}else{ %>
		<td>
		<%=buyhistory.getBuynamelist().get(i / 4) %>
		<%
			}
		%>
		</td>
	</tr>
	<%if(i % 4 == 3){ %>
	<tr>
	<th></th>
	</tr>
	<%
	}
	}
	%>
</table>

<%@ include file="/include/footer.jsp"%>