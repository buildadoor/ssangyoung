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