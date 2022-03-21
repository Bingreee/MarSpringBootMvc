<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>부서 정보</title>
</head>
<body>
<h3>모든 부서 정보</h3>
<!-- deptAll : List<Dept> -->
<c:forEach items="${deptAll }" var="dept">
	${dept.deptno } / ${dept.dname } / ${dept.loc }
	<input type="button" value="삭제" onclick="deleteDept(${dept.deptno })">
	<input type="button" value="수정" onclick="updateDept(${dept.deptno })"><br>
</c:forEach>
<script>
	function deleteDept(no) {
		location.href="/delete/"+no;
	}
	
	function updateDept(no) {
		location.href="/update/"+no;
	}
</script>
</body>
</html>