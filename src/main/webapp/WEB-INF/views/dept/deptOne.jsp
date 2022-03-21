<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>부서 정보 확인</title>
</head>
<body><!-- deptAll -->
<h3>원하는 부서를 선택하세요</h3>
<select>
	<c:forEach items="${deptAll}" var="dept">
		<option value="${dept.deptno}">${dept.dname}</option>
	</c:forEach>
</select>   
<div></div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("select").click(function(){
				let no = $(this).val();
				$.ajax({
					url:"dept/"+no,	
					type:"get",
					dataType:"json"
				}).done(function(data){
				$("div").empty();
				$("div").append("부서번호 : "+ data.deptno+"<br>")
					.append("부서명 : "+ data.dname+"<br>")
					.append("근무지 : "+ data.loc);
				})
		});
	});
</script>
</body>
</html>