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
<% String check=(String)request.getAttribute("check");
	if(check.equals("ok")){
%>
님이 로그인 하셨습니다.
<%}
else{%>
님 패스워드가 틀렸습니다
<%} %>
<% 
int i;
	for(i=1; i<=10; ++i){
%>
	<%= i %><br>

<%} %>


</body>
</html>
