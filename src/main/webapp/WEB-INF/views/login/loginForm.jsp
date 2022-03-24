<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인 화면</title>
</head>
<body>
<h3>로그인 화면 입니다.</h3>
<form:form action="login" method="get" modelAttribute="loginDto">
	<form:errors element="div"/>
	<label for="id">id : </label><input name="id" id="id"><form:errors path="id" delimiter=" "></form:errors> <br>
	<label for="pw">pw : </label><input name="pw" id="pw" type="password"><form:errors path="pw" delimiter=" "></form:errors><br>
	<input type="submit" value="로그인">
</form:form>
   
</body>
</html>