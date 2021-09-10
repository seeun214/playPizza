# Order your Pizza! 🍕🍺
# 플레이 피자

# 📜 개요

온라인으로 피자를 주문하기 위한 회원가입, 주문 관리, 지점 정보 조회 시스템

---

# 기여자

## 👩‍🚒[박세은](https://github.com/seeun214)  👩‍🚒[신지혜](https://github.com/jhshin29)  👩‍🚒[서주연](https://github.com/do-oni)

---

# ⏳ 프로젝트 기간

[주제 선정](https://www.notion.so/69f85542ed854d1591d5fb989a7b1216)

[DB모델링 & 화면 구성 목업](https://www.notion.so/DB-5adc8a8abfb440dbae886e5f5089e80e)

[MVC 패턴 설계 및 코딩](https://www.notion.so/MVC-800a669bd52e45f8b764c27f34e50522)

[웹 페이지 구현](https://www.notion.so/6b60201e13af44db9d19dcbc20799aa4)

# 💡깃허브 프로젝트 기능 이용

![깃 프로젝트.PNG](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e5f19183-f89d-4c18-a0c9-21d6e0e975a0/깃_프로젝트.png)

# 💻 개발 환경

`Eclipse` `JAVA` `Apache Tomcat 9.0` `Oracle 11g` `JSP`  `HTML`

---

# 🥘 설계

## 1️⃣ 데이터베이스 설계

![playPizza.png](https://www.notion.so/do-oni/Order-your-Pizza-7b5b049854c04659b242c130f0bfdf2d#5b210f4b7e16448297a056ceb0f6cb93)

## 2️⃣ 오븐 이용하여 목업

[https://ovenapp.io/view/mvkaQnJ3wjLp9XJWjQX2VVBwcdOiRSkt/](https://ovenapp.io/view/mvkaQnJ3wjLp9XJWjQX2VVBwcdOiRSkt/)

---

# ✨ 구현 기능

---

## 📝주문

1. 회원 아이디로 주문 정보 조회
2. 새로운 주문 추가
3. 주문 취소

## 🙋‍♀️고객

1. 회원가입
2. 로그인(로그인 후에 상단 로그인 버튼이 마이페이지로 변경)
3. 고객 정보 조회(마이페이지)
4. 회원탈퇴

## 🏢지점

1.  지점 정보 조회
2. 모든 지점 정보 조회

## 🧾메뉴

1. 메뉴 정보 조회
2. 모든 지점 정보 조회

# 🧨 트러블 슈팅

### 💥 **문제 상황 - 런타임 에러 NumberFormatException 발생**

> 웹상의 데이터를 `request.getParameter("orderId")` 메소드로 받아서 컨트롤러에서 서비스의 `getOneOrder(orderId)` 메소드에 int형 값으로 넘기려고 했을 때 발생

Integer.parseInt() 메소드를 사용하여`service.getOneOrder(Integer.parseInt(request.getParameter("orderId")` 로 형변환을 해주면 된다.

### **💥 문제상황**

> **주문 취소는 주문 후에 바로 실행가능한데, 주문 시 시퀀스 값인 orderId는 입력받지 않기때문에 request에 orderId가 반환되지 않음. 따라서 orderId 값을 받아 삭제되는 주문취소 메소드에서 에러발생**

가장 최근에 주문한 주문은 시퀀스 값이 가장 크기 때문에 `MAX` 함수와 `createNativeQuery`를 사용하여 가장 최근 주문을 검색하였고 order 객체에 저장하여 반환해주어 해결하였다.

---

# 🤔 개선할 점

🔉 **테이블 초기 설정의 아쉬움**
-  주문테이블과 메뉴테이블을 일대다 관계로 설정하여 주문 시 한개의 메뉴만 주문가능
-  각 메뉴마다 이미지를 불러오기 위해 테이블 컬럼을 추가하여 수정함

**🔉메뉴 검색시 메뉴의 일부분만 입력했을 경우 그 단어가 포함된 메뉴들이 전부 출력되는 기능 추가예정**
