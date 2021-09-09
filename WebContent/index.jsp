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
<header class="w3-container w3-red w3-center" style="padding:128px 16px">
  <h1 class="w3-margin w3-jumbo">Play Pizza</h1>
  <p class="w3-xlarge">근데 이제 배달은 안되는</p>
  <c:if test="${not empty sessionScope.sId}">
  <img src="images/orderIcon.png" onclick="location.href='orders/order.jsp'" style="cursor: pointer;" width="300" height="300"/>
</c:if>

<c:if test="${ empty sessionScope.sId}">
  <img src="images/orderIcon.png" onclick="location.href='customer/login.jsp'" style="cursor: pointer;" width="300" height="300"/>

</c:if>

</header>

<!-- First Grid -->
<div class="w3-row-padding w3-padding-64 w3-container" style="background-image: url('images/피자이벤트.jpg'); style="background-size">
  <div class="w3-content">
    <div class="w3-twothird">
      <h1>Today's Event</h1>
      <h5 class="w3-padding-32">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</h5>

      <p class="w3-text-grey">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint
        occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
        laboris nisi ut aliquip ex ea commodo consequat.</p>
    </div>

    <div class="w3-third w3-center">
      <i class="fa fa-bullhorn w3-padding-64 w3-text-red"></i>
    </div>
  </div>
</div>

<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>
