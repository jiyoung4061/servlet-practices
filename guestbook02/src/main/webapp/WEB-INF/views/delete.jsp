<%@page import="com.markany.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
	String password = request.getParameter("password");
	
	new GuestBookDao().delete(no, password);
	response.sendRedirect("/gb");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<%= no %>
	<%= password %>
</body>
</html>