<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome playPizza</title>
<jsp:include page="common/styleLink.jsp"></jsp:include>
</head>
<style>
img{
	image-size: 200px;
}
</style>
<body>

<jsp:include page="common/navbar.jsp"></jsp:include>

<!-- Header -->
<header class="w3-container w3-red w3-center" style="padding:30px 16px">
  <h1 class="w3-margin w3-jumbo">Play Pizza</h1>
  <p class="w3-xlarge">근데 이제 배달은 안되는</p>

  <c:if test="${not empty sessionScope.id}">
  <img src="images/orderIcon.png" onclick="location.href='orders/order.jsp'" style="cursor: pointer;" width="300" height="300"/>
</c:if>

<c:if test="${empty sessionScope.id}">
  <img src="images/orderIcon.png" onclick="location.href='customer/login.jsp'" style="cursor: pointer;" width="300" height="300"/>
</c:if>

</header>

	<img src="images/playpizza.jpg" class="w3-round" alt="Pizza" style="width: 100%;">
	<img src="images/pizzasale.jpg" class="w3-round" alt="Pizza" style="width: 100%;">

<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
