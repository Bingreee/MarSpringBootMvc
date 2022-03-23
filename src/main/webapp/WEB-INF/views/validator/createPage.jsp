<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>CreatePage</title>
</head>
<body>
	createPage.jsp	<br />
	<form:form action="create" modelAttribute="dto" method="get">
		작성자 : <input type="text" name="writer" value="${dto.writer}">
		<form:errors path="writer" delimiter="/"/>
		<br /> 
		내용 : <input type="text" name="content" value="${dto.content}">
		<form:errors path="content"/>
		<br /> <input type="submit" value="전송"> <br />
	</form:form>

</body>
</html>