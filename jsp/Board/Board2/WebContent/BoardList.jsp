<%@page import="net.board.db.BoardVO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	ArrayList<BoardVO> list=(ArrayList<BoardVO>)request.getAttribute("list");
	int startpage = ((Integer)(request.getAttribute("startpage"))).intValue();
	int endpage = ((Integer)(request.getAttribute("endpage"))).intValue();
	int pagenum =((Integer)(request.getAttribute("page"))).intValue();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC 게시판</title>
</head>
<body>
글 개수:<%=request.getAttribute("count") %>	
<table border="1">
<tr>
	<td>번호</td><td>제목</td><td>작성자</td><td>날짜</td><td>조회수</td>
</tr>

게시판 목록을 보여줍니다.


<%
for(int i=0; i<list.size(); i++){
	BoardVO boardVO=list.get(i);
%>
	<tr>
		<td><%=boardVO.getBOARD_NUM() %></td>
		<td><%for(int lev=0; lev<boardVO.getBOARD_RE_LEV(); lev++){ %>
				&nbsp;&nbsp;
			<%} 
			  if(boardVO.getBOARD_RE_LEV()!=0 ){
			%>
				>Re:
			<%} %>
		  <a href="BoardDetailAction.bo?num=<%=boardVO.getBOARD_NUM()%>"><%=boardVO.getBOARD_SUBJECT() %></a>
		</td>
		<td><%=boardVO.getBOARD_NAME() %></td>
		<td><%=boardVO.getBOARD_DATE() %></td>
		<td><%=boardVO.getBOARD_READCOUNT() %></td>
	</tr>
<% 	
}
%>

</table>


<%
for(int i=startpage; i<=endpage; i++) {
	if(i==pagenum){
%>
	<b>
<%
	} 
%>
	<a href="BoardList.bo?page=<%=i%>">[<%=i %>]</a> &nbsp;&nbsp; 
	<%if(i==pagenum){ %>
	</b>

<%
	}
}
%>

<br>

검색이 가능합니다.<br>
<form action="BoardListSearch.bo" method="get">
<table>
	<tr>
		<td>
			<select name="selectitem">
				<option value="BOARD_SUBJECT">제목</option>
				<option value="BOARD_CONTENT">내용</option>
				<option value="BOARD_NAME">작성자</option>
			</select>
		</td>
		<td>
			<input type="text" name="searchWord" >
		</td>
	</tr>
	
</table>
<input type="submit" value="검색">
</form>




</body>
</html>