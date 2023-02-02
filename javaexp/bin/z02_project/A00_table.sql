

SELECT * FROM BOOKS;
SELECT * FROM BOOKUSERS;
SELECT * FROM LIBRARY;
SELECT * FROM RENTAL; 
SELECT * FROM CLASSIFICATION;
SELECT * FROM PROGRAM;
SELECT * FROM CALL;


--DELETE  FROM BOOKUSERS  WHERE USERSNO = 61;
update callbyuser u,callbymanager m
set m.userno = 41
AND m.CALLANSWER ='어서오세요 회원님.';


CREATE TABLE bookusers(
		usersno varchar2(10) PRIMARY key,
		div varchar2(20),
		uname varchar2(20),
		rrn varchar2(14),
		address varchar2(100),
		phone_number varchar2(13),
		id varchar(20),
		password varchar2(20),
		rentalcnt NUMBER
		);
	
INSERT INTO bookusers values(userlist_seq.NEXTval,'회원'
									,'마이콜','880101-1313131',
									'미국 텍사스','010-8811-1331',
									'micole','uas123',3);
SELECT * 
FROM BOOKUSERS
WHERE uname LIKE '%'||'이또치'||'%';
SELECT * 
FROM BOOKUSERS
WHERE uname = '이또치';


SELECT * FROM BOOKUSERS;
UPDATE BOOKUSERS  SET ADDRESS = '아산시 모종동' WHERE uname = '스누피';

SELECT USERSNO  
FROM BOOKUSERS 
WHERE id = 'ddochi' AND PASSWORD = 'abc123';
SELECT * FROM books;
SELECT id, password
		FROM bookusers
		where id LIKE '%'||'ddo'||'%'
		AND password LIKE '%'||'abc'||'%';
	
SELECT * FROM BOOKUSERS b ;
DROP SEQUENCE userlist_seq;
CREATE SEQUENCE userlist_seq
START WITH 1
INCREMENT BY 1
   MINVALUE 1
   MAXVALUE 9999;
											
INSERT INTO bookusers values('Master','','도서관',
							'800808-1188188','천안 시청','010-1321-1321','ddochi','abc123',0);


						--프로그램
CREATE TABLE program(
			pno varchar2(10),
			pname varchar2(100),
			pcontents varchar2(4000),
			ptime date,
			noticedate date,
			usersno varchar2(10) REFERENCES bookusers(usersno) 
);

INSERT INTO program values(program_seq.NEXTval,'도서관에서 할로윈데이를',
'10월31일까지 trick or treat을 도서관 직원에게 외치시면 사탕을 드립니다',
SYSDATE,20221031,'41');


CREATE SEQUENCE program_seq 
START WITH 1
INCREMENT BY 1
   MINVALUE 1
   MAXVALUE 9999;



CREATE TABLE classification(
			classno number(3) PRIMARY key,
			cname varchar2(50)
);
INSERT INTO classification values(100,'철학');
INSERT INTO classification values(200,'종교');
INSERT INTO classification values(300,'사회과학');
INSERT INTO classification values(400,'순수과학');
INSERT INTO classification values(500,'기술과학');
INSERT INTO classification values(600,'예술');
INSERT INTO classification values(700,'언어');
INSERT INTO classification values(800,'문학');
INSERT INTO classification values(900,'역사');
SELECT * FROM classification;
--도서
CREATE TABLE books(
			isbn NUMBER(13) PRIMARY KEY,
			bname varchar2(100),
			publisher varchar2(20),
			writer varchar2(20),
			genre varchar2(20),
			price NUMBER,
			regisdate DATE,
			rentalwhether varchar2(20),
			classno NUMBER(3) REFERENCES classification(classno)
);
INSERT INTO books VALUES(9791165341909,'달러구트 꿈 백화점','팩토리나인','이미예','판타지소설',13800,sysdate,'대여가능',800);
INSERT INTO books VALUES(9791160023459,'주린이가 가장 알고 싶은 최다질문 top 77','메이트북스','염승환','주식투자',18000,sysdate,'대여불가',300);
INSERT INTO books VALUES(9791191056556,'미드나잇 라이브러리','인플루엔셜','매트헤이그','영미소설',15800,sysdate,'대여가능',800);
INSERT INTO books VALUES(9788959897094,'트렌드 코리아 2023','미래의 창','김난도','경제전망',17100,sysdate,'대여불가능',300);
SELECT * FROM books;

SELECT * 
FROM books
WHERE bname LIKE '%'||'?'||'%';


CREATE TABLE library(
			LOCAL varchar2(20),
			libraryname varchar2(50)
);
INSERT INTO library VALUES('인천','계양도서관');
INSERT INTO library VALUES('서울','국립중앙도서관');
INSERT INTO library VALUES('부산','부산시청열린도서관');
INSERT INTO library VALUES('대구','시립수성도서관');
INSERT INTO library VALUES('광주','광주시립중앙도서관');
INSERT INTO library VALUES('대전','대전학생교육문화원');
INSERT INTO library VALUES('울산','울산도서관');
INSERT INTO library VALUES('세종','국립세종도서관');
INSERT INTO library VALUES('경기','경기도서관');
INSERT INTO library VALUES('강원','미래도서관');
INSERT INTO library VALUES('충북','충북중앙도서관');
INSERT INTO library VALUES('충남','충남도서관');
INSERT INTO library VALUES('전북','전북도청도서관');
INSERT INTO library VALUES('전남','전라남도립도서관');
INSERT INTO library VALUES('경북','경북도서관');
INSERT INTO library VALUES('경남','김해도서관');
INSERT INTO library VALUES('제주','제주도서관');


WHERE local LIKE '%'||'충남'||'%';

CREATE TABLE call(
			callno varchar2(8) PRIMARY key,
			usersno varchar2(10) CONSTRAINT bookusers_userno_fk 
			REFERENCES bookusers(usersno),
			callcontents varchar2(4000),
			managerno varchar2(10),
			callanswer varchar2(4000)
);

SELECT * FROM CALL WHERE usersno = 1;
INSERT INTO call values(callno_seq.NEXTval,42,'',41,'답변입니다');
INSERT INTO call values(callno_seq.NEXTval,61,'도서관 전화번호 알려주세요','','');
SELECT * FROM CALL;

UPDATE CALL SET callanswer = 
'이번 달은 도서관 휴무가 따로 없습니다 언제든 방문해주세요^^'
managerno = '41' WHERE callno = '44';




INSERT INTO call values(callno_seq.NEXTval,42,'질문',41,'답변');
SELECT * FROM CALL;
CREATE SEQUENCE callno_seq 
START WITH 1
INCREMENT BY 1
   MINVALUE 1
   MAXVALUE 9999;

CREATE TABLE rental(
			rentalno varchar(20),
			usersno varchar2(10) CONSTRAINT rental_userno_fk REFERENCES bookusers(usersno),
			isbn NUMBER(13) CONSTRAINT book_isbn_fk REFERENCES books(isbn),
			shipwhether varchar2(20),
			returndate DATE,
			returnwhether varchar2(20) 
);
UPDATE rental
SET RETURNWHETHER = 'O'
WHERE USERSNO = '63'
AND RETURNWHETHER = 'X'
AND rentalno = '20';
SELECT * FROM rental;
SELECT * FROM CALL;


UPDATE CALL SET callanswer = 'ㅍㅇㅌ', managerno = 41 
WHERE callno = 43;



INSERT INTO rental values(rentallist_seq.NEXTval,2,9788959897094,'X',to_char(sysdate+14,'YYMMDD'),'O');
INSERT INTO rental values(rentallist_seq.NEXTval,63,9791165341909,'X',to_char(sysdate+14,'YYMMDD'),'O');
--독서왕
SELECT * FROM rental;

SELECT COUNT(RETURNWHETHER)
FROM RENTAL
WHERE USERSNO = 2 
AND RETURNWHETHER = 'O';
GROUP BY USERSNO
ORDER BY COUNT(USERSNO);
--max 뽑는 방법 
SELECT userno, max(COUNT(RETURNWHETHER))
FROM(SELECT userno, COUNT(RETURNWHETHER)
FROM RENTAL
WHERE RETURNWHETHER = 'O');
SELECT * FROM RENTAL;
--독서왕 top3 
SELECT USERSNO,MM.RWC
FROM(SELECT USERSNO,COUNT(RETURNWHETHER) RWC
FROM RENTAL
WHERE RETURNWHETHER = 'O'
GROUP BY USERSNO
ORDER BY RWC DESC) MM
WHERE rownum<=3;

SELECT USERNO,COUNT(RETURNWHETHER)
FROM RENTAL
GROUP BY USERNO;





SELECT * FROM rental;
DROP SEQUENCE rentallist_seq;
CREATE SEQUENCE rentallist_seq
START WITH 1
INCREMENT BY 1
   MINVALUE 1
   MAXVALUE 9999;

INSERT INTO rental values(rentallist_seq.NEXTval,61,9791191056556,'X',sysdate+14,'X');

SELECT * FROM RETURN;
SELECT * FROM rental;
CREATE TABLE return(
			usersno varchar2(10) CONSTRAINT return_userno_fk REFERENCES bookusers(usersno),
			rentalno varchar(20),
			returnwhether varchar2(20),
			returndate DATE
);
SELECT * FROM RETURN;
INSERT INTO RETURN values(?,?,?,sysdate);
INSERT INTO RETURN values(63,10,'반납',sysdate);

DROP TABLE return;

SELECT USERNO ,USERNAME ,RENTALCNT,RETURNWARNING
FROM (
SELECT USERNO ,USERNAME ,RENTALCNT,RETURNWARNING  FROM BOOKUSER 
WHERE RETURNWARNING < 5
AND div = '회원'
ORDER BY RENTALCNT DESC)
WHERE rownum<=3;


INSERT INTO RETURN values(41,87,'반납');
DROP TABLE RETURN; 
SELECT * FROM RETURN;
SELECT * FROM Rental;

SELECT * FROM PROGRAM WHERE PNAME LIKE '%'||''||'%';
SELECT * FROM program;
SELECT * FROM rental;
SELECT * FROM RETURN;

SELECT * FROM rental;
DROP TABLE rental;
INSERT INTO rental VALUES (rentallist_seq.NEXTval,42,9791191056556,'X',
TO_CHAR(sysdate+14,'YYYYMMDD'),'미반납');

-- INSERT INTO rental VALUES (rentallist_seq.NEXTval,?,?,?,sysdate+7,,);
UPDATE rental SET returndate = TO_CHAR(sysdate+14,'YYYYMMDD') WHERE isbn = 9791191056556;


DROP TABLE RETURN;



DELETE FROM books WHERE bname =?;
CREATE SEQUENCE rentallist_seq
START WITH 1
INCREMENT BY 1
   MINVALUE 1
   MAXVALUE 9999;