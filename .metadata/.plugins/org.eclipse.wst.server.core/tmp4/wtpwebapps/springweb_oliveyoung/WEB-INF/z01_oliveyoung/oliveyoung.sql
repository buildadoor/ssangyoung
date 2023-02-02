SELECT * FROM ovMember;
SELECT * FROM ovCategory;
SELECT * FROM ovProduct;
SELECT * FROM ovQuestion;
SELECT * FROM ovShoppingCart;
select id, pass, auth, nickname,
			address, point
		from ovMember;
--회원
CREATE TABLE ovMember(
   id varchar2(50) PRIMARY KEY,
   pass varchar2(50),
   auth varchar2(20),
   nickname varchar2(50),
   address varchar2(150),
   point NUMBER);
INSERT into OVMEMBER values('ov','1234','관리자','관리자','서울 서교동',9999);
  UPDATE OVMEMBER
   SET auth = '0'
   WHERE id = 'ov';
alter table cjmember rename TO ovMember; --테이블명 변경
--카테고리
CREATE TABLE ovCategory(
ctgNo varchar2(100) PRIMARY KEY ,
ctgName varchar2(300)
);
INSERT into OVCATEGORY values('10','스킨케어');
--상품
CREATE TABLE ovProduct(
   prodNo varchar2(10) PRIMARY KEY,
   ctgNo varchar2(100) CONSTRAINTS ovCategory_ctgNo_fk REFERENCES ovCategory(ctgNo),
   seller varchar2(100),
   id varchar2(50) CONSTRAINTS ovMember_id_fk REFERENCES ovMember(id),
   prdName varchar2(300),
   prdKind varchar2(2000),
   prdPrice number,
   prdImg varchar2(500),
   prdDescript varchar2(4000),
   prdDelivery varchar2(4000),
   point NUMBER);
--문의
CREATE TABLE ovQuestion(
   cstmrId varchar2(50) CONSTRAINTS ovMember_id_fk2 REFERENCES ovMember(id),
   quDate DATE,
   quKind varchar2(200),
   quContent varchar2(2000),
   quImg varchar2(4000),
   adminId varchar2(50) CONSTRAINTS ovMember_id_fk3 REFERENCES ovMember(id),
   anDate DATE,
   anContent varchar2(2000)   
   );
--장바구니
CREATE TABLE ovShoppingCart(
id varchar2(50) CONSTRAINTS ovMember_id_fk4 REFERENCES ovMember(id),
prodNo varchar2(10) CONSTRAINTS ovProduct_prodNo_fk REFERENCES ovProduct(prodNo),
addDate DATE,
addCnt number);