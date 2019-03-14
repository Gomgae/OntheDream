<%@page import="net.board.db.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% BoardVO boardvo=(BoardVO)request.getAttribute("boardvo"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
[자유게시판 글내용]<br><br>
글쓴이:<%=boardvo.getBOARD_NAME() %><br>
제목:<%=boardvo.getBOARD_SUBJECT() %><br>
내용:<%=boardvo.getBOARD_CONTENT() %><br><br>

<a href="BoardReply.bo?num=<%=boardvo.getBOARD_NUM()%>">[답변]</a> 
[수정] 
<a href="BoardDelete.bo?num=<%=boardvo.getBOARD_NUM()%>">[삭제] </a>
<a href="BoardList.bo">[목록]</a>
</body>
</html>