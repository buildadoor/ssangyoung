SELECT * FROM ovMember;
delete FROM ovmember where id = 'ddochi';
INSERT into OVMEMBER values('ddochi','dd','1','이또치','대전 대흥동',5000);
INSERT into OVMEMBER values('builadoor','lee','1','이윤아','천안 불당동',15000);
INSERT into OVMEMBER values('jane','eee','1','이제인','아산 모종동',2000);
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
  
 SELECT * FROM ovProduct; 
INSERT INTO OVPRODUCT VALUES('A001','1','리얼베리어 로션','기초',29000,'product1.jpg','피부에 촉촉히 스며드는 고보습 로션');
INSERT INTO OVPRODUCT VALUES('A002','2','맥 소바','색조',25000,'product2.jpg','자연스러운 아이섀도우 발색은 맥 소바');
INSERT INTO OVMEMBER VALUES('dooli','hi','1','강둘리','대전 대흥동',3333);
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