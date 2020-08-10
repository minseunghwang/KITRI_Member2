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

<h3>메뉴</h3>
	<c:if test="${not empty sessionScope.id }">		<!-- 이거쓸라면 위에 taglib 임포트도 해야되고 WEB_-INF폴더에 뭐 추가도 해야됌 -->
	${sessionScope.id }님 로그인<br>
	<a href="${pageContext.request.contextPath }/member/memberInfo.jsp">정보수정</a><br>
	<a href="${pageContext.request.contextPath }/LogoutController">로그아웃</a><br>
	<a href='${pageContext.request.contextPath }/DelController'>탈퇴</a>
	<br>
	</c:if>
	
	<c:if test="${empty sessionScope.id }">
	<h3>로그인 실패</h3>
	<a href="${pageContext.request.contextPath }/member/loginForm.jsp">로그인 폼</a>
	</c:if>
</body>
</html>