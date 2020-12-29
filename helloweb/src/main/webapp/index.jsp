<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String no = request.getParameter("no");
int number = (no != null && no.matches("\\d*")) ? Integer.parseInt(no) : -1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Hello Web - <%=number %></h1>
</body>
</html>