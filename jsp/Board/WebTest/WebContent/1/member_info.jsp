<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id=request.getParameter("id"); // 주소 에서 불러온 id
	String admin=(String)session.getAttribute("id"); // 세션 id 위의 id랑 전혀 다름
	if(!(admin.equals("admin"))){ // !() 안 id가 admin 아닐때 메인으로 다시 보내주는 역할
		out.println("<script>");
		out.println("location.herf='main.jsp'");
		out.println("</script>");
	}
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
  		Context init = new InitialContext();
  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/aaa");
  		conn = ds.getConnection();
		
  		pstmt=conn.prepareStatement("select * from member where id=?");
		pstmt.setString(1, id); // 1은 위에 where ?의 의미하는것
  		rs=pstmt.executeQuery();		
		}catch(Exception e){
  			e.printStackTrace();
	}

	rs.next();
%>

<%=rs.getString("id")%> <br>
	<%=rs.getString("pass")%> <br>
	<%=rs.getString("name")%> <br>
	<%=rs.getString("age")%> <br>
	<%=rs.getString("gender")%> <br>
	<%=rs.getString("email")%> <br><br>
	
	<a href="member_list.jsp">뒤로가기 
	
</body>
</html>