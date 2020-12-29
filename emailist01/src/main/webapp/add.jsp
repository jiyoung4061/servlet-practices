<%@page import="com.markany.emaillist.dao.EmaillistDao"%>
<%@page import="com.markany.emaillist.vo.EmaillistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String email = request.getParameter("email");
	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(email);
	
	new EmaillistDao().insert(vo);
	response.sendRedirect("/emaillist01/index.jsp"); // 여기서 페이지를 나가기 때문에 다음 html문서는 읽히지 않음
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이메일 등록하기</h1>
	<%= firstName %>
	<%= lastName %>
	<%= email %>
</body>
</html>