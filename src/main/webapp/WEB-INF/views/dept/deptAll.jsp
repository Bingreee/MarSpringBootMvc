<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>부서 정보</title>
</head>
<body>
<h3>모든 부서의 정보를 출력합니다.</h3>
<!-- deptAll : List<Dept> -->
<c:forEach items="${deptAll}" var="dept">
	${ dept.deptno} / ${dept.dname } / ${dept.loc }<br>
</c:forEach>


</body>
</html>