<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Order</title>
</head>
<body>

	<br>
	<h1>Order</h1>
	<br><br>
	
	<form action="../pizza">
	<input type="hidden" name="command" value="ordersInsert">
  <label for="menu">메뉴를 선택하세요:</label>
  <input list="menuList" name="menu" id="menu" />
  <datalist id="menuList">
    <option value="페퍼로니 피자" ></option>
    <option value="치즈 피자" ></option>
    <option value="야채 피자"></option>
    <option value="베리 피자" ></option>
    <option value="시카고 피자" ></option>
    <option value="토마토 파스타" ></option>
    <option value="콜라"></option>
    <option value="사이다"></option>
    <option value="맥주"></option>
    </datalist>
    <br><br>
  <label for="branch">지점을 선택하세요:</label>
  <input list="branchList" name="branch" id="branch" />
  <datalist id="branchList">
    <option value="남산점" ></option>
    <option value="이태원점"></option>
    <option value="상봉점" ></option>
  </datalist>
  <br><br>
  <input type="submit" value="주문!">
</form>
  
  
	<br>
	<hr>
	<a href="${pageContext.request.contextPath}">메인으로 돌아가기</a>
	<br>

</body>
</html>