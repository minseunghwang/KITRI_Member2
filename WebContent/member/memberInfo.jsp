<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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

<h3>��������</h3>
*���̵�� ����Ұ�
<form action="${pageContext.request.contextPath }/EditController" method="post">
	id: <input type="text" name="updid" value=<%=session.getAttribute("id")%> readonly><br />
	pwd: <input type="text" name="updpwd" value=<%=m.getPwd()%>><br />
	name: <input type="text" name="updname" value=<%=m.getName()%>><br />
	email: <input type="text" name="updemail" value=<%=m.getEmail()%>><br />
	<input type="submit" value="��������"><br />
</form>
<a href="${pageContext.request.contextPath }/member/result.jsp">����</a>


</body>
</html>