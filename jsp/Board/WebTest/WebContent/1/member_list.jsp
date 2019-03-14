<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*" %>
	<%@ page import="javax.naming.*" %>
    <% 
	request.setCharacterEncoding("UTF-8");
	String id=(String)session.getAttribute("id");
	if(!(id.equals("admin"))){ // !() 안 id가 admin 아닐때 메인으로 다시 보내주는 역할
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
		pstmt=conn.prepareStatement("select * from Member");
  		rs=pstmt.executeQuery();		
		}catch(Exception e){
  			e.printStackTrace();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% while(rs.next()){
%>
	<a href="member_info.jsp?id=<%=rs.getString("id")%>">
	<%=rs.getString("id")%></a>&nbsp;
	
	<a href="member_delete.jsp?id=<%=rs.getString("id")%>">삭제</a><br>
	
	
<%} %>


</body>
</html>