<%@page import="java.util.List"%>
<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member List Page</title>
</head>
<center>
<body>
<h1>Member List Page</h1>
<% List<Member> memberList = (List<Member>) request.getAttribute("memberList"); %>
<table>
   <tr>
   <th>아이디</th>
   <th>이름</th>
   <th>이메일</th>
   </tr>
   <%for(Member m : memberList){
      
   %>
   <tr>
   <td><%=m.getid() %></td>
   <td><%=m.getname() %></td>
   <td><%=m.getemail() %></td>
   </tr>
 <%
 
   }
  %>
</table>
</body>
</center>
</html>
