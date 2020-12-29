<%@page import="com.markany.guestbook.dao.GuestBookDao"%>
<%@page import="com.markany.guestbook.vo.GuestBookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
	// List<GuestBookVo> list = new GuestBookDao().findAll();
	String no = request.getParameter("no");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/gb?a=delete">
	<input type='hidden' name="no" value=<%=no%>>
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="삭제"></td>
			<td><a href="/guestbook02/gb">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>