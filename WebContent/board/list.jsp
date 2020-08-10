<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>글 목록</h3>
	<a href="${pageContext.request.contextPath }/board/form.jsp">글작성</a>
	<br>
	<c:if test="${not empty list }">
		<table border="1" cellspacing="0">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
			<c:forEach var="b" items="${list }">
				<tr>
					<td>${b.num }</td>
					<td>
						<a href="${pageContext.request.contextPath }/ReadController?num=${b.num}">${b.title }</a>
					</td>
					<td>${b.writer }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty list }">
		글 없다.
	</c:if>

</body>
</html>