<%@page import="com.markany.guestbook.dao.GuestBookDao"%>
<%@page import="com.markany.guestbook.vo.GuestBookVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<GuestBookVo> list = new GuestBookDao().findAll();
String host = request.getParameter("host");
String region = request.getParameter("region");
System.out.println("host:" + host);
System.out.println("region:" + region);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form method="post" action="delete.jsp">
		<input type='hidden' name="host" value=<%=host%>> 
		<input type='hidden' name="region" value=<%=region%>>
		<div>
			host = <%=host%> / region = <%=region%> 을 삭제하시겠습니까? 
		</div>
		<br/>
		<input type="submit" value="삭제"> 
		<a href="/guestbook01/index.jsp">메인으로 돌아가기</a>
	</form>
</body>
</html>