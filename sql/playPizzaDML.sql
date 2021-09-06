-- activist insert[재능 기부자 저장]
insert into customers values(CUSTOMER_SEQ.nextval, 'aaa', '남산', '1111');
insert into customers values(CUSTOMER_SEQ.nextval, 'bbb', '이태원', '2222');
insert into customers values(CUSTOMER_SEQ.nextval, 'ccc', '명동', '3333');

-- recipient insert[재능 수혜자 저장]
insert into menu values(MENU_SEQ.nextval, '페퍼로니 피자', 10000);
insert into menu values(MENU_SEQ.nextval, '고구마 피자', 8000);
insert into menu values(MENU_SEQ.nextval, '포테이토 피자', 12000);

-- probono insert[재능기부 정보 저장]
insert into branches values(BRANCHES_SEQ.nextval, '남산점', '남산', '4444');
insert into branches values(BRANCHES_SEQ.nextval, '이태원점', '이태원', '5555');
insert into branches values(BRANCHES_SEQ.nextval, '상봉점', '상봉', '6666');

-- probono_project insert[재능 기부 프로젝트 저장]
insert into orders values(ORDERS_SEQ.nextval, 2, 1, 1);
insert into orders values(ORDERS_SEQ.nextval, 2, 1, 1);
insert into orders values(ORDERS_SEQ.nextval, 1, 3, 2);

commit;