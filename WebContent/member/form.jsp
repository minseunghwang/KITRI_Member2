<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h3>ȸ������</h3>
<form action="${pageContext.request.contextPath }/JoinController" method="post">
	id: <input type="text" name="id"><br />
	pwd: <input type="text" name="pwd"><br />
	name: <input type="text" name="name"><br />
	email: <input type="text" name="email"><br />
	<input type="reset" value="���">
	<input type="submit" value="����"><br />
</form>

</body>
</html>