<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String id=request.getParameter("id");
String admin=(String)session.getAttribute("id");
if(!(admin.equals("admin"))){
	out.println("<script>");
	out.println("location.href='main.jsp'");
	out.println("</script>");
}
Connection conn = null;
PreparedStatement pstmt=null;
try{
	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/aaa");
	conn = ds.getConnection();
	pstmt=conn.prepareStatement("delete from member where id=?");
	pstmt.setString(1, id);
	int num=pstmt.executeUpdate();
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		conn.close();
		pstmt.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}	
}
%>
</body>
</html>