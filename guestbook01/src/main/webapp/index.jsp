<%@page import="com.markany.guestbook.dao.GuestBookDao"%>
<%@page import="com.markany.guestbook.vo.GuestBookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<GuestBookVo> list = new GuestBookDao().findAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="add.jsp" method="post">
	<table border=1 width=500>
		<tr>
			<td>host</td><td><input type="text" name="host"></td>
			<td>region</td><td><input type="text" name="region"></td>
			<td>value</td><td><input type="text" name="value"></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE="등록"></td>
		</tr>
	</table>
	</form>
	<br>
	<table width=510 border=1>
		<% 
		int index = 0;
		for(GuestBookVo vo : list) {
		%>
		<tr>
			<td><%= index++ %></td>
			<td><%= vo.getHost() %></td>
			<td><%= vo.getRegion() %></td>
			<td><%= vo.getValue() %></td>
			<td><a href="/guestbook01/deleteform.jsp?host=<%= vo.getHost()%>&&region=<%= vo.getRegion()%>">삭제</a></td>
			<td><a href="/guestbook01?a=updateform&no=">수정</a></td>
		</tr>
		<%} %>
	</table>
</body>
</html>