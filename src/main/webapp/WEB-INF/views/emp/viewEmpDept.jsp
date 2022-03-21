<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>사원 검색(부서)</title>
</head>
<body>
<h3>부서를 선택하면 사원의 정보를 확인할 수 있습니다.</h3>
<div id="contianer">
<select id="depts">
<option>부서 선택</option>
<c:forEach items="${list}" var="dept">
	<option value="${dept.deptno}">${dept.dname}</option>
</c:forEach>
</select>
<div id="names">
	<select id="empno">
		<option>사원 선택</option>
	</select>
</div>
<div id="emp"></div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("#names").hide();
		
		$("#depts").change(function(){
			let deptno = $(this).val();
			$.ajax({
				url: "/emp/viewEmpsDept/"+deptno,
				dataType:"json"
			}).done(function(data){
				$("#names select").empty();
				for(index in data){
					$("#names select").append("<option value='"+ data[index]['EMPNO']+"'>"+data[index]['ENAME']+"</option>")
				}
				$("#names").show();
			})//ajax 성공
		})//select change
		$("#empno").change(function(){
			let empno = $(this).val();
			$.ajax({
				url: "/emp/viewEmp/"+empno,
				dataType:"json"
			}).done(function(data){
				$("#emp").empty();
				let emp ="";
				for(let key in data){
					emp += key +" : "+data[key]+"<br>";
				}
				$("#emp").append(emp);
			})//ajax 성공
		})//#empno change
	})//ready
</script>
</body>
</html>