-- 메뉴 정보
DROP TABLE menu cascade constraint;

-- 고객 정보
DROP TABLE customers cascade constraint;

-- 지점 정보
DROP TABLE branches cascade constraint;

-- 주문 정보
DROP TABLE orders cascade constraint;

DROP SEQUENCE CUSTOMER_SEQ;
DROP SEQUENCE MENU_SEQ;
DROP SEQUENCE BRANCHES_SEQ;
DROP SEQUENCE ORDERS_SEQ;

CREATE SEQUENCE CUSTOMER_SEQ;
CREATE TABLE customers (
       customer_id          	NUMBER  PRIMARY KEY,
       sid               		VARCHAR2(50) NOT NULL,
       address					VARCHAR2(50) NOT NULL,
       phone                	VARCHAR2(50) NOT NULL
);

CREATE SEQUENCE MENU_SEQ;
CREATE TABLE menu (
       menu_id        			NUMBER PRIMARY KEY,
       name                		VARCHAR2(50) NOT NULL,
       price          			NUMBER NOT NULL
);

CREATE SEQUENCE BRANCHES_SEQ;
CREATE TABLE branches (
       branch_id          		NUMBER PRIMARY KEY,
       name      				VARCHAR2(50) NOT NULL,
       address  				VARCHAR2(50) NOT NULL,
       phone  					VARCHAR2(50) NOT NULL
);

CREATE SEQUENCE ORDERS_SEQ;
CREATE TABLE orders (
	   order_id     			NUMBER PRIMARY KEY,
	   customer_id 				NUMBER NOT NULL,
       menu_id           		NUMBER NOT NULL,       
       branch_id           		NUMBER NOT NULL     
);

ALTER TABLE orders ADD FOREIGN KEY (customer_id) REFERENCES customers (customer_id);
ALTER TABLE orders ADD FOREIGN KEY (menu_id) REFERENCES menu (menu_id);
ALTER TABLE orders ADD FOREIGN KEY (branch_id) REFERENCES branches  (branch_id);
