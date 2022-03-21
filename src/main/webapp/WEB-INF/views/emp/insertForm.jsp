<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>사원 추가</title>
</head>
<body><!--  empno , list -->
<h3>사원 정보 추가</h3>
<form method="post">
	<fieldset>
		<legend> 사원 정보 입력</legend>
		사원 번호 : <input name="empno" value="${empno}" readonly><br>
		사원 이름 : <input name="ename"><br>
		직급 : <input name="job"><br>
		상사 번호 : <input name="mgr"><br>
		입사일 : <input type="date" name="hiredate"><br>
		급여 : <input name="sal"><br>
		커미션 : <input name="comm"><br>
		부서 : <select name="deptno">
				<c:forEach items="${list}" var="dept">
					<option value="${dept.deptno}">${dept.dname}</option>
				</c:forEach>
			 </select><br>
		<input type="submit" value="입력">	 
	</fieldset>	

</form>
</body>
</html>