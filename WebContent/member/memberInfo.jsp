<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="member.dao.JoinDaoImpl"%>
<%@ page import="model.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	JoinDaoImpl service = new JoinDaoImpl();
	Member m = service.select((String)session.getAttribute("id"));
%>

<h3>정보수정</h3>
*아이디는 변경불가
<form action="${pageContext.request.contextPath }/EditController" method="post">
	id: <input type="text" name="updid" value="${m.id }" readonly><br />
	pwd: <input type="text" name="updpwd" value="${m.pwd }"><br />
	name: <input type="text" name="updname" value="${m.name }"><br />
	email: <input type="text" name="updemail" value="${m.email }"><br />
	<input type="submit" value="정보수정"><br />
</form>
<a href="${pageContext.request.contextPath }/member/result.jsp">메인</a>


</body>
</html>