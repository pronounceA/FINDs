<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String cssName ="itemList"; %>
<% String title = "商品一覧"; %>
<%@ include file="/include/header.jsp" %>
<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');
</style>
		<div class="item-content">
			<c:forEach var="item" items="${ itemList }">
				<div class="item">
					<div class="item-inner">
						<a class="item-link" href="./ItemDetailsServlet?ID=${ item.itemId }">
							<img class="item-img" src="${ item.itemImg }" alt="150">
						</a>
						<div class="item-name">
							<a class="item-link" href="./ItemDetailsServlet?ID=${ item.itemId }">
								<c:choose>
									<c:when test="${ item.itemName.length() < 17 }">
										<c:out value="${ item.itemName }" />
									</c:when>
									<c:otherwise>
										<c:out value="${ item.itemName.substring(0, 17) }…" />
									</c:otherwise>
								</c:choose>
							</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="pagenation">
			<c:if test="${ pageNo != 1 }">
				<span class="left-allow allow">
					<a href="./ItemListServlet?page=${ pageNo - 1 }"><div class="arrow-left icon"></div></a>
				</span>
			</c:if>
				<div class=page-link>
					<c:choose>
						<c:when test="${ maxPage <= 7 }">
							<c:forEach var="i" begin="1" end="${ maxPage }" step="1">
								<c:choose>
									<c:when  test="${ pageNo == i }">
										<span class="page-number page-now"><c:out value="${ i }" /></span>
									</c:when>
									<c:otherwise>
										<a href="./ItemListServlet?page=${ i }">
											<span class="page-number"><c:out value="${ i }" /></span>
										</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
						<c:when test="${ pageNo < 5  }">
							<c:forEach var="i" begin="1" end="6" step="1">
								<c:choose>
									<c:when  test="${ pageNo == i }">
										<span class="page-number page-now"><c:out value="${ i }" /></span>
									</c:when>
									<c:otherwise>
										<a href="./ItemListServlet?page=${ i }">
											<span class="page-number"><c:out value="${ i }" /></span>
										</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<span class="page-number">...</span>
							<a href="./ItemListServlet?page=${ maxPage }"><span class="page-number">${ maxPage }</span></a>
						</c:when>
						<c:when test="${ pageNo + 4 > maxPage }">
							<a href="./ItemListServlet?page=1"><span class="page-number">1</span></a>
							<span class="page-number">...</span>
							<c:forEach var="i" begin="${maxPage - 4 }" end="${ maxPage }" step="1">
								<c:choose>
									<c:when  test="${ pageNo == i }">
										<span class="page-number page-now"><c:out value="${ i }" /></span>
									</c:when>
									<c:otherwise>
										<a href="./ItemListServlet?page=${ i }">
											<span class="page-number"><c:out value="${ i }" /></span>
										</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<a href="./ItemListServlet?page=1"><span class="page-number">1</span></a>
							<span class="page-number">...</span>
							<c:forEach var="i" begin="${ pageNo - 2 }" end="${ pageNo +2 }" step="1">
								<c:choose>
									<c:when  test="${ pageNo == i }">
										<span class="page-number page-now"><c:out value="${ i }" /></span>
									</c:when>
									<c:otherwise>
										<a href="./ItemListServlet?page=${ i }">
											<span class="page-number"><c:out value="${ i }" /></span>
										</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
							<span class="page-number">...</span>
							<a href="./ItemListServlet?page=${ maxPage }"><span class="page-number">${ maxPage }</span></a>
						</c:otherwise>
					</c:choose>
				</div>
			<c:if test="${ pageNo != maxPage }">
				<span class="right-allow allow">
					<a href="./ItemListServlet?page=${ pageNo + 1 }"><div class="arrow-right icon"></div></a>
				</span>
			</c:if>
		</div>
<%@ include file="/include/footer.jsp" %>