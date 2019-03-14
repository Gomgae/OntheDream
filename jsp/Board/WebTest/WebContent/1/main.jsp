<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String id =(String)session.getAttribute("id");
%>
<%=id %>님 로그인 하셨습니다. <br> <br>

<% if(id.equals("admin")){
%>
관리자님 로그인 하신것을 환영합니다 <br><br>
<a href="member_list.jsp">회원 목록 보기</a><br>
<%}%>
</body>
</html>