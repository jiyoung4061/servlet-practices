<%@page import="com.markany.guestbook.dao.GuestBookDao"%>
<%@page import="com.markany.guestbook.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String host = request.getParameter("host");
	String region = request.getParameter("region");
	Long value = Long.valueOf(request.getParameter("value"));
	
	GuestBookVo vo = new GuestBookVo();
	vo.setHost(host);
	vo.setRegion(region);
	vo.setValue(value);
	
	new GuestBookDao().insert(vo);
	response.sendRedirect("/guestbook01/index.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<h1>방명록 등록완료</h1>
</body>
</html>