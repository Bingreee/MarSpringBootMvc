<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>사원 검색(이름)</title>
<style>
	#con{ overflow: hidden;}
	#con div{float: left; margin-right: 20px;}
</style>
</head>
<body>
<h3>이름을 입력하시면 해당 사원의 정보를 확인할 수 있습니다.</h3>
<label for="ename"> 이름 : </label><input name="ename" id="ename" type="search" list="empList">
<button type="button" id="btn">검색</button>
<div id="con">
	<div id="names">
		<select>
			<option>사원 선택</option>
		</select>
	</div>
	<div id="emp"></div>
</div>
<datalist id="empList"></datalist>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("#names select").hide();
		$("#emp").hide();
		$("#btn").click(function(){
			let name = $("#ename").val();
			$.ajax({
				url:"/emp/viewEmpsName/"+name,
				dataType:"json"
			}).done(function(data){
				$("#names select").empty();
				$("#names select").append("<option>사원 선택</option>");
				for(index in data){
					$("#names select").append(
							"<option value='"+ data[index]['EMPNO']+"'>"
							  +data[index]['ENAME']+"</option>")
				} 
				$("#names select").show();
				$("#emp").hide();
			})
		});	
		$("#names select").change(function(){
			
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
				
				$("#emp").append(emp).show();
				
			})//ajax 성공
		})//#empno change
		
	})
</script>
</body>
</html>