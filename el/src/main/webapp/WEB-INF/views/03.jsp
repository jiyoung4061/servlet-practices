<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL(forEach tag) Test</h1>
	<!-- list이름의 배열에서 vo라는 이름으로 하나씩 꺼내겠다는 것! -->
	<!-- status : loop의 상태 ex. 몇번 돌았는지, index 등 -->
	<c:set var='countList' value='${fn:length(list) }' />
	<c:forEach items='${list }' var='vo' varStatus='status'> 
		[${3-status.index }] -> [ ${status.index } : ${status.count }] [${vo.no } : ${vo.name }] <br/>		
	</c:forEach>
</body>
</html>