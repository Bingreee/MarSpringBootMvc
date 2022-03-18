<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>부서 추가</title>
</head>
<body>
<form method="post">
	부서번호 : <input name="deptno" value="${no}" readonly><br>
	부서명 : <input name="dname"><br>
	근무지 : <input name="loc"> 
	<input type="submit" value="add">
</form>
</body>
</html>