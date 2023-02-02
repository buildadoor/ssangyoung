CREATE TABLE EMPDEPT100 
AS SELECT e.*, dname, loc 
FROM emp e, dept d
WHERE e.deptno = d.deptno;
SELECT * FROM EMPDEPT100;
DROP TABLE EMPDEPT100;

ALTER TABLE EMPDEPT100
modify(
	ename varchar2(50),
	job varchar2(50),
	dname varchar2(50),
	loc varchar2(50)
);
ALTER TABLE EMPDEPT100
DROP COLUMN deptno; 

CREATE SEQUENCE EMPDEPT100_seq
	START WITH 1000
	MINVALUE 1000
	MAXVALUE 9999;
SELECT * FROM EMPDEPT100;
INSERT INTO EMPDEPT100 values(EMPDEPT100_seq.nextval,
'홍길동','사원',7566,to_date('20200101','YYYYMMDD'),
3500,100,'인사','서울강남');
/* VO EMPDEPT100
private int empno;
private String ename;
private String job;
private int mgr;
private String hiredateS;
private Date hiredate;
private double sal;
private double comm;
private String dname;
private String loc;

*/
--4번
DROP TABLE MEMBER100; 
CREATE TABLE MEMBER100(
	id varchar2(50) PRIMARY KEY,
	pass varchar2(20),
	name varchar2(50),
	auth varchar2(50),
	point number,
	regdte date
);
DROP TABLE member100;
INSERT INTO member100 values('himan','7777','홍길동','관리자',1000,sysdate);
SELECT * FROM member100;
SELECT * FROM member100 
WHERE id LIKE '%/'||''||'%',
OR name LIKE '%'||''||'%';
private String id;
private String pass;
private String name;
private String auth;
private int point;
privte DATE regdte;
SELECT * FROM emp100;
update emp100
		set ename = '홍길동',
			job = '과장',
			sal = 6000
		where empno = 7369;
	delete emp100
	where empno = 1003;