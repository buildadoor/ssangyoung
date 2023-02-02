
/* 월요일 18시 
 객체 관계 모델링 실습 
# 다음 내용을 모두 포함하는 데이터베이스를 설계하세요.
(설계-erd + 테이블 생성-제약사항포함 + 데이터 입력)
1. 회사는 네 개의 부서를 운영한다. 
	부서는 (부서번호, 부서이름)을 저장한다.
	depart(deptno, dname)
	
2. 부서는 1명 이상의 직원(직원번호, 직원이름, 직책)을 두고 있다. 
	각 직원은 하나의 부서에 소속된다.
	employee(empno, ename, job,deptno) - depno는 foreign key dept(deptno) 비식별자 처리
	
3. 직원은 부양가족(이름,나이)이 있을 수 있다.
	=> 부양가족(부양가족번호, 이름, 나이, 사원번호)
	empfamily(efno, ename, age, empno) -empno는 foreign key employee(empno) 
		비식별자 처리

4. 각 직원은 근무했던 부서에 대한 근무 기록(기간, 직책)이 있다. 
	직책은 사원번호를 통해서 가져올 수 있기 때문에 설정하지 않는다. 기간(startdte, enddte)
	==> 근무기록(근무기록번호, 사원번호, 부서번호, 시작일, 마지막일)
	=> hisemploy(hisno, empno,deptno, startDte, endDte) empno, deptno 비식별자 처리 
	
	ex) 1000(홍길동),10(인사), 2022/01/01, 2022/01/31)
		1000(홍길동),20(총무), 2022/02/01, 2022/02/28)
		1000(홍길동),10(인무), 2022/03/01, 2022/03/31)
*/
DROP TABLE depart;
CREATE TABLE depart(
	deptno number(4) PRIMARY KEY,
	dname varchar2(50)
);
INSERT INTO depart values(1000,'회계');
INSERT INTO depart values(1001,'인사');
INSERT INTO depart values(1002,'재무');
SELECT * FROM depart;

ALTER TABLE employee
ADD ename varchar(50);
CREATE TABLE employee(
	empno number(4) PRIMARY KEY,
	ename varchar(50),
	job varchar2(50)
);
INSERT INTO employee values(7000,'홍길동','대리');
INSERT INTO employee values(7001,'김길동','사리');
INSERT INTO employee values(7002,'신길동','과장');
INSERT INTO employee values(7003,'마혜영','사원');
SELECT * FROM employee;

CREATE TABLE hisemploy(
	hisno NUMBER PRIMARY KEY, 
	startdte DATE,
	enddte DATE,
	deptno number(4) REFERENCES depart(deptno),
	empno number(4) REFERENCES employee(empno)
);
SELECT * FROM hisemploy;
--1 2022/01/01, 2022/01/31, 1001(인사), 1000(홍길동),
--2 2022/02/01, 2022/02/28, 1002(총무), 7000(홍길동),
--3 2022/03/01, 2022/03/31, 1001(인사), 7000(홍길동), 
INSERT INTO hisemploy values(1, to_date('2022/01/01','YYYY/MM/DD'),
			to_date('2022/01/31','YYYY/MM/DD'),1001,7000);
INSERT INTO hisemploy values(2, to_date('2022/02/01','YYYY/MM/DD'),
			to_date('2022/02/28','YYYY/MM/DD'),1002,7000);
INSERT INTO hisemploy values(3, to_date('2022/03/01','YYYY/MM/DD'),
			to_date('2022/03/31','YYYY/MM/DD'),1001,7000);
SELECT * FROM hisemploy;

CREATE TABLE empfamily(
	enfo NUMBER PRIMARY KEY,
	name varchar2(50),
	age NUMBER,
	empno number(4) REFERENCES employee(empno)
);
--1 이연아 28. 7000
--2 홍마리 5, 7000
--3 홍철수 2, 7000
DROP TABLE empfamily;
INSERT INTO empfamily VALUES (1,'이연아',28,7000);
INSERT INTO empfamily VALUES (2,'홍마리',5,7000);
INSERT INTO empfamily VALUES (3,'홍철수',2,7000);
SELECT * FROM employee;
SELECT * FROM depart;
SELECT * FROM hisemploy;
SELECT * FROM empfamily;

SELECT *
FROM employee e, hisemploy h, depart d
WHERE e.empno = h.empno
AND h.deptno = d.deptno;
SELECT *
FROM employee e, empfamily f
WHERE e.empno = f.empno;

/*

DROP TABLE company1010;
CREATE TABLE company1010(
	dname varchar2(20) PRIMARY KEY,
	deptno number(2)
);
INSERT INTO COMPANY1010  values('HumanResource',11);
SELECT * FROM COMPANY1010;

DROP TABLE department;
CREATE TABLE department(
	empno number(4),
	ename varchar(30),
	ejob varchar(20)
);
INSERT INTO DEPARTMENT  values(1111,'김배민','대리');
SELECT * FROM DEPARTMENT;
DROP TABLE employee;
CREATE TABLE employee(
	fname varchar(30) CONSTRAINT employee_fname_nn NOT NULL,
	fage number(2),
	bdname varchar(20),
	bjob varchar(20)
);
INSERT INTO EMPLOYEE values('김요기',16,'ACCOUNTING','사원');
SELECT * FROM employee;
*/