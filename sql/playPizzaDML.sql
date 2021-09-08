-- customers insert[고객 정보 저장]
insert into customers values(CUSTOMER_SEQ.nextval, 'aaa', 'aaa', '남산', '1111');
insert into customers values(CUSTOMER_SEQ.nextval, 'bbb', 'bbb', '이태원', '2222');
insert into customers values(CUSTOMER_SEQ.nextval, 'ccc', 'ccc', '명동', '3333');

-- menu insert[메뉴 정보 저장]
insert into menu values(MENU_SEQ.nextval, '페퍼로니 피자', 20000,'pepperoni.jpg');
insert into menu values(MENU_SEQ.nextval, '치즈 피자', 18000, 'cheese.jpg');
insert into menu values(MENU_SEQ.nextval, '야채 피자', 20000, 'vege.jpg');
insert into menu values(MENU_SEQ.nextval, '베리 피자', 20000, 'berry.jpg');
insert into menu values(MENU_SEQ.nextval, '시카고 피자', 20000, 'chicago.jpg');
insert into menu values(MENU_SEQ.nextval, '토마토 파스타', 6000, 'pasta.jpg');
insert into menu values(MENU_SEQ.nextval, '콜라', 3000, 'cola.jpg');
insert into menu values(MENU_SEQ.nextval, '사이다', 3000, 'cider.jpg');
insert into menu values(MENU_SEQ.nextval, '맥주', 5000, 'beer.jpg');

-- branches insert[지점 정보 저장]
insert into branches values(BRANCHES_SEQ.nextval, '남산점', '남산', '4444');
insert into branches values(BRANCHES_SEQ.nextval, '이태원점', '이태원', '5555');
insert into branches values(BRANCHES_SEQ.nextval, '상봉점', '상봉', '6666');

-- orders insert[주문 정본 저장]
insert into orders values(ORDERS_SEQ.nextval, 2, 1, 1);
insert into orders values(ORDERS_SEQ.nextval, 2, 1, 1);
insert into orders values(ORDERS_SEQ.nextval, 1, 3, 2);

commit;