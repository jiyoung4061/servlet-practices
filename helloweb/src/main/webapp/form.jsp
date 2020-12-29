<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action='/helloweb/join' method="post">
		이메일: <input type='text' name='email' value=''/>
		<br/><br/>
		
		비밀번호: <input type='password' name='password' value=''/>
		<br/><br/>
		
		생년:
		<select name='birthYear'>
			<option value='1994'>1994년</option>
			<option value='1995'>1995년</option>
			<option value='1996'>1996년</option>
			<option value='1997'>1997년</option>
		</select>
		<br/><br/>

		성별:
		여<input type='radio' name='gender' value='female'/>
		남<input type='radio' name='gender' value='male' checked='checked'/>
		<br/><br/>

		취미:
		코딩 <input type='checkbox' name='hobby' value='coding' />
		수영 <input type='checkbox' name='hobby' value='swimming' />
		낚시 <input type='checkbox' name='hobby' value='fishing' />
		요리 <input type='checkbox' name='hobby' value='cooking' />
		<br/><br/>
		
		내소개
		<!-- textarea 사이에 문자가 들어가면 그 문자가 쓰인 그대로 출력되서 보임!(개행 문자도 포함됨!!) -->
		<textarea name='desc'></textarea>
		<br/><br/>
		
		<input type='submit' value='가입'/>
	</form>
</body>
</html>