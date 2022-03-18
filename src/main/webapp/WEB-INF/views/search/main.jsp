<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>검색 메인</title>
</head>
<body>
	인기 키워드:
	<c:forEach var="popularQuery" items="${popularQueryList}">
					${popularQuery} 
				</c:forEach>
	<form action="game">
		<select name="type">
			<c:forEach var="searchType" items="${searchTypeList}">
				<option value="${searchType.code}">${searchType.text}</option>
			</c:forEach>
		</select>
		 <input type="text" name="query" value="" />
		 <input type="submit" value="검색" />
	</form>
</body>
</html>