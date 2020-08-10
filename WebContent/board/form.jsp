<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>글작성</h3>
	<form action="${pageContext.request.contextPath }/WriteController" method="post">
	<table>
		<tr>
			<th>작성자</th>
			<td><input type="text" value="${sessionScope.id }" name="writer" size="45" readonly></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><input type="text" name="title" size="45"></td>
		</tr>
		<tr>
			<th>글 내용</th>
			<td><textarea name="content" rows="15" cols="45"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="reset" value="취소">
			<input type="submit" value="작성">
			</td>
		</tr>
	</table>
	</form>

</body>
</html>