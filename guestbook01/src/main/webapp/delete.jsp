<%@page import="com.markany.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String host = request.getParameter("host");
	String region = request.getParameter("region");
	
	new GuestBookDao().delete(host, region);
	response.sendRedirect("/guestbook01/index.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<%= host %>
	<%= region %>
</body>
</html>