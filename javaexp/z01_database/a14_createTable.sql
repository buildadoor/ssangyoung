/*a14_createTable
# 데이터 베이스 테이블 생성과 활용
1. 기본 형식
	create table 테이블명(
		컬럼명 데이터유형 제약조건
	);
	ex) 회원테이블
	create table member(
		id varchar2(20) primary key, --중복 및 null 방지
		pass varchar2(20) not null, --반드시 입력되어야함 
		name varchar2(50) not null,
		point number,
		grade char(1) -- 등급 정보로 고정형 A, B, C
	
	);
	
# 데이터 유형
1. 분류
	1) 고정형 문자열 : char(크기)
		크기가 일정한 문자 데이터 유형
		최대크기 : 2000바이트 
		ex) char(10) : 10byte 저장 
	2) 가변형 문자열 : varchar2(크기)
		크기가 가변적인 문자열 데이터 유형으로 
		최대크기 : 4000바이트 
		ex) varchar2(10) : 10byte ~ 1byte 저장 
	3) 숫자형 : number(p,s)
		정밀도(p)와 스케일(s)로 표현되는 숫자 데이터 타입 
		p:1~38
		s:-84~127
	4) 날짜형 : date
		날짜형식을 저장하기위한 데이터 타입
		
*/	
create table member(
		id varchar2(20) primary key, --중복 및 null 방지
		pass varchar2(20) not null, --반드시 입력되어야함 
		name varchar2(50) not null,
		point number,
		grade char(1) -- 등급 정보로 고정형 A, B, C
	);
--	--primary key, not null 등은 무결성 확보를 위한 제약 조건이다.
SELECT * FROM MEMBER;
INSERT INTO MEMBER values('himan',7777,'홍길동',1000,'A');
INSERT INTO MEMBER values('himan',7777,'홍길동',1000,'A');
--primary key : 제약조건에 의해서 동일한 아이디를 입력하는 순간 에러가 발생.

-- ex) 물건정보테이블을 만들되 물건의 일련번호(8자리고정)을 포함하여
-- 		물건명, 가격, 제품소개를 입력할 수 있는 테이블을 만들고, 위
--		insert구문을 활용하여 데이터 3개를 입력 후 조회하세요.
--		물건의 일련 번호 (cahr(8)), 물건명(varchar2(50)), 
--		가격 (number), 제품소개(varchar2(500)) 
CREATE TABLE product(
		isbn char(8),
		name varchar2(50),
		price NUMBER,
		intro varchar2(500)
		);
SELECT * FROM product; 
INSERT INTO product values('PRD1000','사과',2000,'사과 설명..');
INSERT INTO product values('PRD1001','바나나',4500,'바나나 설명..');
INSERT INTO product values('PRD1002','딸기',12000,'딸기 설명...=.');
SELECT  * FROM MEMBER;
--1:다 관계의 연관관계 테이블 생성 
--특정한 회원이 구매한 물건 : buyproduct
-- 속성 도출 : 구매한 회원 아이디, 구매할 물건 아이디, 구매할 갯수, 구매한 날
/*
# 테이블의 데이터 입력 형식(DML)
1. 기본형식
	1) 전체 데이터 입력 : 생성된 컬럼순위롤 데이터 유형에 맞게 입력
		insert into 테이블명 values(데이터1, 데이터2...)
		ex) 사원테이블 
		insert into emp 
		values (2000, '홍길동', '사원', 7000, sysdate, 3000, 1000, 10);
		컬럼의 고유 순서대로 데이터를 입력 처리한다.
	2) 부분 특정 컬럼 입력 : 특정한 컬럼을 지정하여 입력한다.
		ex) insert into emp(empno, job, deptno) values (1001, '대리', 20);
		emp(입력할 컬럼 순서 지정) values (왼쪽에 선언한 컬럼 순서대로 데이터 입력)
	3) 제약 사항 : 
		primary key  등 무결성 제약사항이 있으면 해당 제약사항에 벗어나지 
		않게 입력하여야 한다
		ex) insert into emp(empno) values(1001);
		이전 데이터가 1001데이터가 있으므로 primary key 제약에 걸려 입력하지 못한다.
		 
*/
-- 연습용 복사테이블에 만들기
/*
1. 복사테이블 만들기
	1) 데이터 + 기본 속성 (컬럼)
		create table 새로운 테이블명
		as select * from 기본 테이블;

		create table emp999
		as select empno no, 
			ename name,
			to_char(hiredate, 'YYYY/MM/DD')hire
			 from emp; 
	:sql명령문에 의해서 컬럼의 속성과 컬럼명이 결정되어 테이블이 만들어진다. 
				
	2) 기본 속성(컬럼)
		create table 새로운 테이블명
		as select * from 기존테이블 where 1=0;
*/
CREATE TABLE emp8888
AS SELECT empno NO, ename name, sal salary
FROM emp;
SELECT * FROM emp8888;
CREATE TABLE emp8889
AS SELECT *
FROM emp 
WHERE 1=0; --WHERE 조건은 1=0으로 FALSE조건으로 처리하면 데이터는 보이지 
-- 않지만 컬럼은 확인할 수 있다. 이렇게 컬럼만 복사할 때 이 구문을 사용한다.
SELECT * FROM emp8889;
/*
# 복사테이블의 한계
1. 무결성 제약을 위한 constraints 복사가 되지 않는다.
==> 무결성 제약조건 복사테이블을 만든 후, 제약조건 설정시 
	alter table 테이블
	add/modify 컬럼 타입 제약조건;
형식으로 설정하여 변경/ 추가한다.
*/



CREATE TABLE emp10 
AS SELECT *  FROM emp;
SELECT * FROM emp10; --ctrl+테이블 클릭

-- 전체 데이터 입력 
INSERT INTO emp10 values(8000,'홍길동','사원',7902,sysdate,3500,100,10);
--ex)사원 정보를 emp10에 임의로 입력해보세요 사원번호는 8001
INSERT INTO emp10 values(8001,'마길동','사원',7782,to_date('2022-01-10','YYYY-MM-DD'),4000,200,20)
-- 부분 컬럼 입력 
INSERT INTO emp10(empno, ename, deptno) values(8002,'오길동',20);
--삭제 명령
DELETE FROM emp10 WHERE empno = 8000;
SELECT * FROM emp10;
--ex) 사원 번호, 직책 , 입사일 2000-12-31
INSERT INTO emp10(empno, job, hiredate) values(8003,'과장',to_date('2000-12-31','YYYY-MM-DD'));
/*
# 테이블 설계 및 구현
1. 요구사항 정의서 확인 및 entity 확인 및 속성 도출
2. entity타입결정 
3. erd 모델링
	1) 개별 entity type 생성
	2) 연관 관계 설정
		- 식별관계 : 연관 관계 테이블의 key 사용할 때
				ex) 회원과 구매테이블에서 회원의 아이디는 구매테이블의 키의 일부로
					사용된다. 일때 두 테이블과의 관계를 식별관계라고 한다. 
					(일직선으로 표시된다)
		- 비식별관계 : 연관 관계 테이블에 key로 사용하지 않을 때
				ex) 사원테이블과 부서테이블에서 부서테이블의 key인 부서번호가
					사원테이블의 키로 사용되지 않고 하위의 컬럼으로 연관관계를
					가진다. 이 때, 이 부서번호를 기준으로 사원테이블과 부서테이블은
					비식별관계로 설정한다. (점선으로 표시된다) 
			==> 추후 확장성 유무에 따라 식별관계/비식별 관계로 설정하는 기준으로 
				처리하면 된다.
	3) 논리설계/물리설계
		논리설계 : 일단적으로 엔티티와 속성을 나타내는데 한글로 풀어서 명확한 의미를
			적어 놓는다. 
		물리설계 : 실제 테이블을 만들때, 테이블명과 컬럼명을 지정하여 선언해놓는다.
	-------------------
4. 테이블 생성
5. 데이터 입력 및 확인
	1) join관계로 여러가지 sql 처리
 */
SELECT * FROM MEMBER; 
-- 테이블 삭제 명령어 drop table 테이블명;
DROP TABLE MEMBER;
CREATE TABLE member(
	id varchar2(30),
	pass varchar2(20),
	name varchar2(50),
	auth varchar2(20),
	point NUMBER,
	address varchar2(200)
);
CREATE TABLE product(
	isbn char(8);
	name varchar2(50),
	price NUMBER,
	intro varchar2(500)
);
CREATE TABLE buyproduct(
	id varchar2(30),
	isbn char(8),
	cnt NUMBER, 
	buydate date
);
SELECT * FROM MEMBER;
SELECT * FROM product;
SELECT * FROM buyproduct;
INSERT INTO MEMBER values('himan','7777','홍길동','슈퍼고객',10000,'서울');
INSERT INTO MEMBER values('higirl','8888','홍리나','일반고객',5000,'부산');
INSERT INTO MEMBER values('goodman','5555','이철희','방문고객',1000,'대전');
--PRD10000 사과
--PRD10001 바나나
--PRD10002 딸기
INSERT INTO buyproduct values('himan','PRD10000',5,sysdate);
INSERT INTO buyproduct values('himan','PRD10001',3,sysdate);
INSERT INTO buyproduct values('himan','PRD10002',3,sysdate);
INSERT INTO buyproduct values('higirl','PRD10002',2,sysdate);
INSERT INTO buyproduct values('goodman','PRD10002',1,sysdate);
SELECT * FROM buyproduct;
SELECT * FROM MEMBER;
SELECT * FROM product;
--ex)  join 관계에 의해 himan이 구매한 구매자아이디, 물건명, 가격, 갯수를 출력하세요.
SELECT m.id, m.name "구매자명", p.name, price, cnt, price*cnt "총계"
		--총계는 유도 속성에 의해 만들어진다. 
FROM MEMBER m, buyproduct b, product p
WHERE m.id = b.id
AND b.isbn = p.isbn;
SELECT * FROM buyproduct;
--ex) 고객/구매/책
--ex1) erd생성 : 손 
--ex2) 테이블 생성
--ex3) 데이터 입력 후, join 관계 출력 
CREATE TABLE customer(
	id varchar2(50),
	name varchar2(50), 
	point number
);
CREATE TABLE buy(
	buydate DATE,
	pay varchar2(50)
);
CREATE TABLE book(
	isbn varchar2(50),
	title varchar2(50),
	author varchar2(50),
	price number
);
INSERT INTO customer values('hellogirl','이또치',20000);
INSERT INTO customer values('helloboy','마이콜',10000);
INSERT INTO customer values('baby','이희동',5000);
SELECT * FROM customer;
INSERT INTO buy values(sysdate,'현금결제');
INSERT INTO buy values(sysdate,'카드결제');
SELECT * FROM buy;
INSERT INTO book values('1522015A','하얼빈','김훈',16000);
INSERT INTO book values('1522016B','아버지의 해방일지','정지아',13500);
SELECT * FROM book;


SELECT id, name "구매자명", title, price
FROM MEMBER c, buy b, book k
WHERE c.id = k.isbn;
DROP TABLE customer;
CREATE TABLE customer(
	id varchar2(30),
	name varchar2(50),
	fund number
);
INSERT INTO customer values('himan','홍길동',100000);
INSERT INTO customer values('higirl','김혜선',200000);
INSERT INTO customer values('goodman','신길동',300000);
INSERT INTO customer values('badgirl','오영숙',130000);
INSERT INTO customer values('wolfman','마길동',500000);
SELECT * FROM customer;

CREATE TABLE book(
	isbn char(10),
	title varchar2(50),
	writer varchar2(30),
	price NUMBER
);
INSERT INTO book values('IBW1000000','자바기초','자바맨',32000);
INSERT INTO book values('IBW1000001','오라클중급','DBGod',42000);
INSERT INTO book values('IBW1000002','파이썬과함께웹','귀도',42000);
INSERT INTO book values('IBW1000003','스프링고급','백맨',35000);
INSERT INTO book values('IBW1000004','빅데이터분석','데이터맨',32000);
SELECT * FROM book;
CREATE TABLE buybook(
	id varchar2(30),
	isbn char(10),
	buydate DATE,
	paycheck varchar2(20)
);
--badGirl wolfman
INSERT INTO buybook values('himan','IBW1000000',sysdate,'신용카드');
INSERT INTO buybook values('himan','IBW1000001',sysdate,'신용카드');
INSERT INTO buybook values('himan','IBW1000002',sysdate,'현금');
INSERT INTO buybook values('himan','IBW1000003',sysdate,'신용카드');
INSERT INTO buybook values('badgirl','IBW1000000',sysdate,'신용카드');
INSERT INTO buybook values('wolfman','IBW1000001',sysdate,'신용카드');
INSERT INTO buybook values('higirl','IBW1000002',sysdate,'현금');
INSERT INTO buybook values('goodman','IBW1000003',sysdate,'신용카드');
SELECT *
FROM customer c, buybook bb, book b
WHERE c.id = bb.id 
AND bb.isbn = b.isbn
ORDER BY c.id;
-- customer은 고객 정보를 저장 
-- book는 판매하는 물품정보를 저장
-- buybook은 고객이 구매한 물품 정보를 양쪽 테이블의 key와 추가 속성인
-- 	날짜, 구매방법등을 기준으로 생성하였다.