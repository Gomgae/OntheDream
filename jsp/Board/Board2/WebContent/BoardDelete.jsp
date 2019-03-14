<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

삭제할 게시글의 비밀번호를 입력해 주세요. <br>
<form action = "BoardDeleteAction.bo" method = "post" > 

	<input type="password" name="pass">
	<input type="submit" value="확인">
	<input type="hidden" name="num" value=<%=request.getParameter("num") %>>
	

</form>



</body>
</html>