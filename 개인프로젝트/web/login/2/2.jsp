<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("id") %>
<%
	String pw = request.getParameter("pw");
	if(pw.equals("1234"))%>
님 로그인 되었습니다.
<%else
	님 패스워드가 틀렸습니다
%>

</body>
</html>
