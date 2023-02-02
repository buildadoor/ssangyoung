CREATE TABLE dept100
AS SELECT * FROM dept;
ALTER TABLE dept100
MODIFY (dname varchar2(50), loc varchar(50));
SELECT *
FROM dept100 
WHERE dname LIKE '%'||'O'||'%'
AND loc LIKE '%'||'N'||'%';
SELECT * FROM dept100;
/*
SELECT *
FROM dept100 
WHERE dname LIKE '%'||'?'||'%'
AND loc LIKE '%'||'?'||'%'

INSERT INTO dept100 values(?,?,?)
*/
INSERT INTO dept100 values(11,'회계','서울');