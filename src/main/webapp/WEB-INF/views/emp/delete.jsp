<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>사원 정보 삭제</title>
</head>
<body>
<h3>${ empno }사원 정보를 삭제하시겠습니까?</h3>
<form method="post">
	<input type="hidden" name="_method" value="delete">
	<input type="button" value="이전" onclick="history.go(-1)">
	<input type="submit" value="삭제">
</form>
</body>
</html>