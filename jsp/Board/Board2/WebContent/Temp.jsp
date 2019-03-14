<%@page import="java.util.*"%>
<%@page import="net.board.db.*"%>
<%@page import="test.DBTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% BoardDAO dao= new BoardDAO(); 
  int count =dao.getListCount();
  BoardVO board=dao.getDetail(1);
  ArrayList<BoardVO> list=dao.getBoardList(1, 10);
  
  dao.bodardDelete(15); //글삭제 테스트 코드
  
  //글 수정 테스트 코드 시작
  board.setBOARD_SUBJECT("수정 제목"); //위에서 가져온 1번글의 제목을 수정
  board.setBOARD_CONTENT("수정 내용"); //위에서 가져온 1번글의 내용을 수정
  dao.boardModify(board); //글 수정 실행
  //글 수정 테스트 코드 끝
  
  dao.dbclose();
%>
  전체글개수는 <%=count %>
  <%=board.getBOARD_NAME() %>
  
<%   
  for(int i=0; i<list.size(); i++){
 %>
	  <%=list.get(i).getBOARD_SUBJECT() %><br>
<%
  }
%>
  
  
  
  
  
  
  
  
  
</body>
</html>