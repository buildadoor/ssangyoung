SELECT * FROM kurlyuser;
DELETE  FROM kurlyuser  WHERE USERNO = 41;
SELECT * FROM buylist;
SELECT * FROM buy;
SELECT * FROM product;
SELECT * FROM qna;
SELECT * FROM notice;
DROP TABLE notice;
DROP TABLE qna;
DROP TABLE product;
DROP TABLE buy;
DROP TABLE buylist;
DROP TABLE kurlyuser;
SELECT PASSWORD FROM kurlyuser WHERE USERNAME = '이또치' AND id = 'ddochi';
CREATE TABLE kurlyuser(
		userno varchar2(20) PRIMARY KEY,
		div varchar2(20),
		username varchar2(20),
		rrn varchar2(14),
		address varchar2(100),
		phonenumber varchar2(13),
		id varchar(20),
		password varchar2(20),
		point NUMBER
		);

--userno, div, username, rrn, address, phonenumber, id, password, point
--scanuserno, scandiv, scanusername, scanrrn, scanaddress, 
--scanphonenumber, scanid, scanpassword, scanpoint
CREATE SEQUENCE kurlyuser_seq 
START WITH 1
INCREMENT BY 1
   MINVALUE 1
   MAXVALUE 9999;
 SELECT * FROM kurlyuser;
Drop TABLE KURLYUSER;
DROP SEQUENCE kurlyuser_seq;
INSERT INTO kurlyuser values(0,'관리자',
'이또치','880808-1818188','천안시 서북구 불당24로','010-1234-1234','ddochi','ddochi123',999999);	
INSERT INTO kurlyuser values(kurlyuser_seq.NEXTval,'회원',
'이둘리','770707-1717177','대전광역시 중구 충무로','010-1321-1321','doolli','doolli123',3000);	
UPDATE "USER" SET rrn = 991122-2222222
WHERE USERNAME = '이윤아'; --수정
DELETE  FROM kurlyuser  WHERE USERNO = 0; --탈퇴
SELECT div FROM kurlyuser WHERE id='doolli';
UPDATE kurlyuser SET div = '관리자'
WHERE USERNAME = '이둘리'; --수정

CREATE TABLE product(
		isbn varchar2(20) PRIMARY KEY,
		fication varchar2(20),
		productname varchar2(100),
		price NUMBER,
		information varchar2(2000),
		pompany varchar2(20),
		registerdate DATE,
		discount float
		);
	--isbn fication productname price information pompany registerdate discount
DROP TABLE product;
--제품번호 분류 제품이름 가격 설명 제조사 등록일자 
INSERT INTO product values(product_seq.NEXTval,'정육계란',
'[미트클레버]소갈비찜',35000,'식탁을 빛내줄 메인요리로 미트클레버의 소갈비찜을 제안할게요.','미트클레버',to_date(20221101,'YYYYMMDD'),0.1);	
INSERT INTO product values(product_seq.NEXTval,'채소',
'땅콩호박',5990,'땅콩을 쏙 빼다 닮은 호박','컬리',to_date(20221116,'YYYYMMDD'),0);	
INSERT INTO product values(product_seq.NEXTval,'정육계란',
'[양양]양갈비밀키트',29000,'양꼬치엔 칭따오','양양',to_date(20221123,'YYYYMMDD'),10);	
INSERT INTO product values(product_seq.NEXTval,'채소',
'[야채소년]샐러드키트',3300,'건강한 아침의 시작','야채소년',to_date(20221124,'YYYYMMDD'),6);	
INSERT INTO product values(product_seq.NEXTval,'과일',
'[단과일]샤인머스켓',18800,'올해 마지막 기회 샤인머스켓','단과일',to_date(20221119,'YYYYMMDD'),1);	
INSERT INTO product values(product_seq.NEXTval,'과일',
'아이스홍시',19900,'시원하게 먹는 홍시 드셔보실래요?','컬리',to_date(20221120,'YYYYMMDD'),9);	
SELECT * FROM PRODUCT ;
UPDATE product SET INFORMATION = '매장을 방문한 듯한 맛을 느낄 수 있을 거예요.'
WHERE isbn = 22; --수정
UPDATE product SET discount = 0
WHERE isbn = 21; --수정
SELECT * FROM product WHERE discount >0 ORDER BY discount desc; --알뜰기획 정렬 
SELECT * FROM product ORDER BY REGISTERDATE desc; --신상품 정렬 
SELECT * FROM product WHERE sysdate-7<registerdate ORDER BY REGISTERDATE desc; --
SELECT * FROM product WHERE sysdate-8<registerdate ORDER BY REGISTERDATE desc; --

DELETE  FROM product  WHERE isbn = 7; --삭제 

UPDATE product SET sale= 0
WHERE isbn = 1; --수정

CREATE SEQUENCE product_seq 
START WITH 1
INCREMENT BY 1
   MINVALUE 1
   MAXVALUE 9999;
   
CREATE TABLE qna(
		callno varchar2(20) PRIMARY KEY,
		userno varchar2(20)  REFERENCES kurlyuser(userno),
		question varchar2(2000),
		answer varchar2(2000)
		);	
CREATE SEQUENCE qna_seq 
START WITH 1
INCREMENT BY 1
   MINVALUE 1
   MAXVALUE 9999;
INSERT INTO qna values(qna_seq.NEXTval,'41',
'오늘 주문하면 언제오나요?',',');
UPDATE qna SET ANSWER = '내일 새벽에 도착합니다 고객님~^^'
WHERE callno = 1;
SELECT * FROM qna;
CREATE TABLE noticekurly(
		userno varchar2(20)  REFERENCES kurlyuser(userno),
		noticename varchar2(100),
		contents varchar2(2000),
		regisdate date,
		enddate date
		);
INSERT INTO notice values('0','이또치','블랙프라이데이를 맞이하여 전제품10% 할인을 합니다!','20221124','20221125');	
SELECT * FROM notice;