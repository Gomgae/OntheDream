<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
	게시판 글쓰기
	<form action ="BoardAddAction.bo" method ="post">
		글쓴이 <input type="text" name ="BOARD_NAME" ><br>
		제목 <input type="text" name ="BOARD_SUBJECT" ><br>
		내용 <textarea name ="BOARD_CONTENT" cols="40" rows="8" ></textarea><br><br>
		비밀번호 <input type="Password" name ="BOARD_PASS"><br><br>
		<input type="submit">
	</form>
	<a href ="" >[등록:Y]</a> <a href ="">[취소:N]</a>
</body>
</html>