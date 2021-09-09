<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
<h1>지점</h1>

<hr><p> 
 
<table border="1">
	<tr>
		<th>지점 id</th><th>지점명</th><th>주소</th><th>전화번호</th>
	</tr>
 	<tr>
 		<td>${requestScope.branch.branchId}</td>
 		<td>${requestScope.branch.name}</td>
 		<td>${requestScope.branch.address}</td>
 		<td>${requestScope.branch.phone}</td>
 	</tr>
</table>

<!-- * 카카오맵 - 지도퍼가기 -->
<!-- 1. 지도 노드 -->
<div id="daumRoughmapContainer1631104355532" class="root_daum_roughmap root_daum_roughmap_landing"></div>

<!--
	2. 설치 스크립트
	* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
-->
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


</center>
</body>
</html>







