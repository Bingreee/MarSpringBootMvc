<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>리포트 제출</title>
</head>
<body>
	<h3>@RequestParam 사용</h3>
	<form action="submitReport1" method="post"
		enctype="multipart/form-data">
		 학번: <input type="text" name="studentNumber" /> <br />
		 리포트파일: <input type="file" name="report" /> 
		<input type="submit" />
	</form>

	<h3>MultipartHttpServletRequest 사용</h3>
	<form action="submitReport2" method="post"
		enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br /> 
		리포트파일: <input type="file" name="report" accept="image/*"/><br /> 
		<input type="submit" />
	</form>

	<h3>커맨드 객체 사용</h3>
	<form action="submitReport3" method="post"
		enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br /> 
		리포트파일: <input type="file" name="report" multiple="multiple"/> <br /> 
		<input type="submit" />
	</form>


</body>
</html>




