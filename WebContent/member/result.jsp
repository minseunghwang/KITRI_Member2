<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>�޴�</h3>
	<%
		boolean flag = false;
		flag = (boolean)session.getAttribute("flag");
		if (flag){
	%>
	${sessionScope.id }�� �α���<br>
	<a href="${pageContext.request.contextPath }/LogoutController">�α׾ƿ�</a><br>
	<a href="${pageContext.request.contextPath }/member/memberInfo.jsp">��������</a>
	<br>
	<%
		} else {
	%>
	<h3>�α��� ����</h3>
	<a href="${pageContext.request.contextPath }/member/loginForm.jsp">�α��� ��</a>
	<%
		}
	%>
</body>
</html>