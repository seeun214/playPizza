<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String url = application.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Branch Detail</title>
<jsp:include page="../common/styleLink.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../common/navbar.jsp"></jsp:include>
	<header class="w3-container" style="padding:128px 16px; margin: 0 20%">
	<h1>${requestScope.branch.name}</h1>

	<p class="type" id="detail_on_sale"
		style="text-align: center; position: relative; display: inline-block; width: 70px; height: 70px; font-size: 12px; color: #fff; background-color: #ff143c; line-height: 16px; border-radius: 50%">
		<span
			style="width: 100%; left: 0; position: absolute; top: 50%; transform: translateY(-50%);">온라인<br>방문포장<br>30%
		</span>
	</p>
	<p class="type2" id="detail_off_sale"
		style="text-align: center; position: relative; display: inline-block; width: 70px; height: 70px; font-size: 12px; color: #fff; background-color: #043088; line-height: 16px; border-radius: 50%;">

		<span
			style="width: 100%; left: 0; position: absolute; top: 50%; transform: translateY(-50%);">오프라인<br>방문포장<br>30%
		</span>

	</p>

	<hr>
	<h5>전화번호 : ${requestScope.branch.phone}</h5>
	<h5>주소 : ${requestScope.branch.address}</h5>
	<h5>영업시간 : 11:00 ~ 21:00</h5>
	<h5>주차정보 : 매장주차불가</h5>

	<c:if test="${requestScope.branch.name eq'남산점'}">
		<div id="daumRoughmapContainer1631104355532" class="root_daum_roughmap root_daum_roughmap_landing"></div>
		<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

		<!-- 3. 실행 스크립트 -->
		<script charset="UTF-8">
			new daum.roughmap.Lander({
				"timestamp" : "1631104355532",
				"key" : "27ave",
				"mapWidth" : "640",
				"mapHeight" : "360"
			}).render();
		</script>
	</c:if> 
	
	<c:if test="${requestScope.branch.name eq'이태원점'}">
		<div id="daumRoughmapContainer1631165619228" class="root_daum_roughmap root_daum_roughmap_landing"></div>
		<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
		
		<script charset="UTF-8">
			new daum.roughmap.Lander({
				"timestamp" : "1631165619228",
				"key" : "27b6f",
				"mapWidth" : "640",
				"mapHeight" : "360"
			}).render();
		</script>
	</c:if> 
	
	<c:if test="${requestScope.branch.name eq'상봉점'}">
		<div id="daumRoughmapContainer1631165697232" class="root_daum_roughmap root_daum_roughmap_landing"></div>
		<script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
		
		<!-- 3. 실행 스크립트 -->
		<script charset="UTF-8">
			new daum.roughmap.Lander({
				"timestamp" : "1631165697232",
				"key" : "27b6h",
				"mapWidth" : "640",
				"mapHeight" : "360"
			}).render();
		</script>
	</c:if>
	</header>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>