SELECT * FROM dept100;
UPDATE DEPT100 
	SET deptno = 13, 
		dname = '아이티사업부',
		loc = '제주도'
	WHERE deptno = 11;
/*
//update 
UPDATE DEPT100 
	SET deptno = ?, 
		dname = ?,
		loc = ?
	WHERE deptno = ?
//delete 
DELETE FROM dept100
WHERE deptno =?
*
*
**/
DELETE FROM dept100
WHERE deptno =11;