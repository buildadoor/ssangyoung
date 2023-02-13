SELECT * FROM ovMember;
SELECT * FROM ovCategory;
SELECT * FROM ovProduct;
SELECT * FROM ovQuestion;
SELECT * FROM ovShoppingCart;
--회원
CREATE TABLE ovMember(
   id varchar2(50) PRIMARY KEY,
   pass varchar2(50),
   auth varchar2(20),
   nickname varchar2(50),
   address varchar2(150),
   point NUMBER);
 -- #{id},#{pass},1,#{nickname},#{address},3000 
 --회원검색
		select *
		from ovMember
		where id like '%'||'ov'||'%'
		and nickname like '%'||'관리자'||'%'; 
	
INSERT into OVMEMBER values('ov','1234','관리자','관리자','서울 서교동',9999);
INSERT into OVMEMBER values('ov2','1234','0','관리자2','서울 서교동',9999);
INSERT into OVMEMBER values('ddochi','ddochi','1','이또치','천안 불당동',1000);
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
DROP TABLE OVPRODUCT;
--상품
 CREATE TABLE ovProduct(
   prodNo varchar2(10) PRIMARY KEY,
   ctgNo varchar2(100),
   prdName varchar2(300),
   prdKind varchar2(2000),
   prdPrice number,
   prdImg varchar2(1000),
   prdDescript varchar2(4000)
  ); 
 INSERT INTO ovProduct values('A003',2,'웨이크메이크 워터 블러링 픽싱 틴트','색조',15000,'웨이크메이크 워터 블러링 픽싱 틴트.jpg','웨이크 메이크의 히든템 보송하지만 진한 발색');

  
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
  
  DROP TABLE ovShoppingCart;
--장바구니
CREATE TABLE ovShoppingCart(
id varchar2(50) CONSTRAINTS ovMember_id_fk4 REFERENCES ovMember(id),
prodNo varchar2(10) CONSTRAINTS ovProduct_prodNo_fk REFERENCES ovProduct(prodNo),
addDate DATE,
addCnt number);