<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="javax.sql.*" %>
<%
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	String name=request.getParameter("name");
	int age=Integer.parseInt(request.getParameter("age"));
	String gender=request.getParameter("gender");
	String email=request.getParameter("email");
	
	
	
Connection conn = null;
PreparedStatement pstmt=null;
try{
	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/root");
	conn = ds.getConnection();
	pstmt=conn.prepareStatement("INSERT INTO member VALUES(?,?,?,?,?,?)");
	pstmt.setString(1,id);
	pstmt.setString(2,pass);
	pstmt.setString(3,name);
	pstmt.setInt(4,age);	
	pstmt.setString(5,gender);
	pstmt.setString(6,email);
	int result=pstmt.executeUpdate();
	
	if(result!=0){
		System.out.println("가입 성공");
	}else{
		System.out.println("가입 실패");
	}
	
	System.out.println("DB 연결성공");
}catch(Exception e){
	e.printStackTrace();
	System.out.println("DB 연결 실패~");
}finally{
	try{
		pstmt.close();
		conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}

%>
