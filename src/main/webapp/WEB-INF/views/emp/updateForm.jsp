<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>사원 정보 수정</title>
</head>
<body>
<form action="/emp/updateEmp" method="post">
	<input type="hidden" name="_method" value="put">
	empno  : <input name="empno" value="${emp.empno }" readonly><br>
	ename  : <input name="ename" value="${emp.ename }"><br>
	job  : <input name="job" value="${emp.job }"><br>
	mgr  : <input name="mgr" value="${emp.mgr }"><br>
	hiredate  : <input name="hiredate" type="date" value='<fmt:formatDate value="${emp.hiredate }" pattern="yyyy-mm-dd"/>'><br>
	sal  : <input name="sal" value="${emp.sal }"><br>
	comm  : <input name="comm" value="${emp.comm }"><br>
	deptno  : <select name="deptno">
				<c:forEach items="${list}" var="dept">
					<option value="${dept.deptno}">${dept.dname}</option>
				</c:forEach>
			</select><br>
	
	<input type="submit" value="update">

</form>
</body>
</html>