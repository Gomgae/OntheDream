<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    Member member = (Member) request.getAttribute("member");
%>
<form action = "memberUpdate.do" method="post">
아이디 : <input type = "text" name = "id"
value="<%=member.getid() %>"><br>

비 번 : <input type = "password" name = "pass"
value="<%=member.getpass() %>"><br>

이 름 : <input type = "text" name = "name"
value="<%=member.getname() %>"><br>

이메일 : <input type = "text" name = "email"
value="<%=member.getemail() %>"><br>

<input type="submit" value="수정하기">
<input type="reset" value="다시쓰기">
<input type="button" onclick="location.href='Boardinfo.jsp'" value="돌아가기">
</form>
</body>
</html>