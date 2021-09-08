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
<body>

<jsp:include page="common/navbar.jsp"></jsp:include>

<!-- Header -->
<header class="w3-container w3-red w3-center" style="padding:128px 16px">
  <h1 class="w3-margin w3-jumbo">Play Pizza</h1>
  <p class="w3-xlarge">근데 이제 배달은 안되는</p>
  <button class="w3-button w3-black w3-padding-large w3-large w3-margin-top">주문하기</button>
</header>

<!-- First Grid -->
<div class="w3-row-padding w3-padding-64 w3-container">
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

<!-- 	<form action="pizza?command=customer" method="post">
		고객 ID : <input type="text" name="sId"><input type="submit" value="검색">
	</form>
		
	<form action="pizza?command=branch" method="post" >
		&nbsp;&nbsp;&nbsp;
		2. 지점명 : <input type="text" name="name"><input type="submit" value="검색">
	</form>
	
	<br>
	<form action="pizza?command=menu" method="post" >
		메뉴 이름 : <input type="text" name="name"><input type="submit" value="검색">
	</form>
 -->
	
