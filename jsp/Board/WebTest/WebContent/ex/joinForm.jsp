<!-- ȸ������  ������ -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>ȸ������ �ý��� ȸ������ ������</title>
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
		<td colspan="2" class = "td_title">
			ȸ������ ������
		</td>
	</tr>
	<tr>
		<td><label for = "id">���̵� : </label></td>
		<td><input type="text" name="id" id = "id"/></td>
	</tr>
	<tr>
		<td><label for = "pass">��й�ȣ : </label></td>
		<td><input type="password" name="pass" id = "pass"/></td>
	</tr>
	<tr>
		<td><label for = "name">�̸� : </label></td>
		<td><input type="text" name="name" id = "name"/></td>
	</tr>
	<tr>
		<td><label for = "age">���� : </label></td>
		<td><input type="text" name="age" id = "age"/>
		</td>
	</tr>
	<tr>
		<td><label for = "gender1"></label>���� : </td>
		<td>
			<input type="radio" name="gender" value="��" checked id = "gender1"/>����
			<input type="radio" name="gender" value="��" id = "gender2"/>����
		</td>
	</tr>
	<tr>
		<td><label for = "email">�̸��� �ּ� : </label></td>
		<td><input type="text" name="email" id = "email"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="javascript:joinform.submit()">ȸ������</a>&nbsp;&nbsp;
			<a href="javascript:joinform.reset()">�ٽ��ۼ�</a>
		</td>
	</tr>
</table>
</form>
</body>
</html>