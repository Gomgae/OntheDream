<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>회원관리 시스템 회원가입 페이지</title>
<style>
	table{
		margin : auto;
		width : 400px;
		border : 1px solid gray;
		text-align: center;
	}
	.td_title{
		font-weight: bold;
		font-size: x-large;
	}
</style>

</head>
<body>
<form name="joinform" action="joinProcess.jsp" method="post">
<table border=1>

<tr>
	<td colspan="2" class ="td_title">회원 가입 페이지 </td>
</tr>
<tr>
	<td>아이디:</td>
	<td><input type="text" name="id"> </td>
</tr>
<tr>
	<td>비밀번호:</td>
	<td><input type="password" name="pass"></td>
</tr>
<tr> 
<td>이름:</td>
	<td><input type="text" name="name"></td>
</tr>
<tr>
<td>나이:</td>
	<td><input type="text" name="age"></td>
</tr>
<tr>
<td>성별:</td>
	 <td><input type="radio" name="gender1" value="남" checked>남자
	 <input type="radio" name="gender2" value="여">여자</td>
</tr>
<tr>
 <td>이메일 주소:</td>
 	<td><input type="text" name="email">
</tr>
	<tr>
		<td colspan="2">
			<a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
			<a href="javascript:joinform.reset()">다시작성</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>
