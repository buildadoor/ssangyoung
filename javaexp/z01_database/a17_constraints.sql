/*
#check
1. 특정한 데이터를 조건이나 범위를 지정해서, 해당 범위에 데이터만 입력되도록 처리한 것을 말한다.
2. 형식
	컬럼명 데이터유형 constraint 제약명 check ( where 조건문 형식 설정)
	ex) check(컬럼명 = '데이터'), check(컬럼명 between 1000 and 2000)
	컬럼명 데이터유형 check (where 조건문 형식 설정) 
*/
DROP TABLE emp04;
CREATE TABLE emp04(
	gender varchar2(1) CONSTRAINT emp04_gender_ck check( gender IN( 'F','M'))
);
INSERT INTO EMP04 VALUES('F');
INSERT INTO EMP04 VALUES('M');
INSERT INTO EMP04 VALUES('K');	--에러발생
SELECT *
FROM sys.ALL_CONSTRAINTS
WHERE TABLE_NAME = 'EMP04';
--ex) student05 테이블 이름, 학년(1~4), 국어(1~100) 제약조건을 설정하여 테이블을
--	생성하고 확인하세요.
CREATE TABLE student05(
	name varchar2(50) CONSTRAINT student05_name_ck check (name IN('이또치')),
	grade number(1) CONSTRAINT student05_grade_ck check ( (grade BETWEEN 1 AND 4)),
	kor number CONSTRAINT student05_kor_ck check ( (kor BETWEEN 1 AND 100))
);
INSERT INTO student05 values('이또치',4,100);
INSERT INTO student05 values('홍길동',5,100);
INSERT INTO student05 values('이또치',1,100);
INSERT INTO student05 values('마이콜',1,101);--에러
SELECT *
FROM sys.ALL_CONSTRAINTS
WHERE TABLE_NAME = 'STUDENT05';
/*
#외래키 설정(foreign key)
1. 연관관계에 있는 두 테이블에 대하여, 한쪽 테이블에 있는 데이터 기준으로 다른쪽 테이블의
	데이터를 입력할 수 있게 하는 것을 말한다.
2. 기본형식
	컬럼명 데이터유형 constraint 테이블명_컬럼명_fk references 테이블명(컬럼명)
 */
-- 교수테이블과 학생테입르의 담당교수지정컬럼 
CREATE TABLE professor01(
	tno NUMBER PRIMARY KEY,
	name varchar2(50)
);
DROP TABLE student06;
CREATE TABLE student06(
	name varchar2(50),
	tno NUMBER CONSTRAINT student06_tno_fk REFERENCES professor01(tno)
);
INSERT INTO professor01 values(1000,'홍길동교수');
INSERT INTO student06 values('김길동학생',1000);
INSERT INTO student06 values('마길동학생',1000);
INSERT INTO student06 values('오길동학생',1001); --참조에러발생
--ex) 물건테이블(물건번호,물건명,가격), 구매테이블(구매번호,구매수량,물건번호-외래키설정)
DROP TABLE product;
CREATE TABLE product(
	pno NUMBER PRIMARY KEY,
	proname varchar2(50),
	price number
);
DROP TABLE buy;
CREATE TABLE buy(
	bno NUMBER,
	bcnt NUMBER,
	pno NUMBER CONSTRAINT buy_pno_fk REFERENCES product(pno)
);
INSERT INTO product values(12415,'사과',1000);
INSERT INTO buy values(001,4,12415);
INSERT INTO buy values(001,4,12411); --에러
SELECT * FROM product;
SELECT * FROM buy;
SELECT price, bcnt
FROM product p, buy b
WHERE p.pno = b.pno;