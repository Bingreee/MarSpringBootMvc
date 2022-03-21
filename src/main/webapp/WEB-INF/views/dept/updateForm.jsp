<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>부서 수정</title>
</head>
<body>]
<h3> 부서의 정보를 수정합니다.</h3>
	<form method="post" action="/update">
		부서번호 : <input name="deptno" value="${dept.deptno}" readonly><br>
		부서명 : <input name="dname" value="${dept.dname}"><br>
		근무지 : <input name="loc" value="${dept.loc}"> 
	<input type="submit" value="update">
	</form>
</body>
</html>