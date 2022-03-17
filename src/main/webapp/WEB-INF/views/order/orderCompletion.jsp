<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	주문 완료<br>
	주문 아이템
	<ul>
		<c:forEach var="item" items="${order.orderItems}">
			<li>${item.itemId} / ${item.number} / ${item.remark}</li>
		</c:forEach>
	</ul>
	배송지 : ${order.address}
</body>
</html>