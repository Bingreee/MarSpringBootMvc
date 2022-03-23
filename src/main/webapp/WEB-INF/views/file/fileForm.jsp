<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>파일 업로드</title>
</head>
<body>
<h3>파일을 선택하세요</h3>
<form method="post" enctype="multipart/form-data">
	파일 : <input type="file" name="file"><br>
	설명 : <input type="text" name="description">
	<input type="submit" value="upload">
</form>
</body>
</html>