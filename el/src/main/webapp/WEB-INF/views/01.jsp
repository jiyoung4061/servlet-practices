<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% pageContext.setAttribute("newLine", "\n"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${iVal}<br/>
	${lVal}<br/>
	${fVal}<br/>
	${bVal}<br/>
	${fn:replace(sVal, newLine, "<br>") }<br/>
	--${obj0}-- => 모르는 값은 안찍힘!<br/>
	-${obj}- => 널값도 안찍힘!<br/>
	${vo.no} => 필드로 검색하지만 getter가 없으면 안됨!<br/>
	${vo.getNo()}<br/>
	${vo.name}<br/>
	
	<h3>산술연산</h3>
	${3*10+5 }<br/>
	${iVal+5 }<br/>
	
	<h3>관계연산</h3>
	${iVal==10 }<br/>
	${iVal < 5 }<br/>
	${obj == null } ==> null은 자바 키워드이기때문에 쓰면 안됨!<br/>
	${empty obj } ==> 위에보단 empty를 사용하기!<br/>
	
	<h3>논리연산</h3>
	${iVal==10 && lVal < 1000}<br/>
	${iVal < 5 && lVal - 10 == 0}<br/>
	
	<h3>요청 파라미터 값</h3>
	--${param.a }--<br/>
	--${param.email }--<br/>
	
	<h3>Map으로 값 받아보기</h3>
	${map.iVal}<br/>
	${map.lVal}<br/>
	${map.fVal}<br/>
	${map.bVal}<br/>
</body>
</html>