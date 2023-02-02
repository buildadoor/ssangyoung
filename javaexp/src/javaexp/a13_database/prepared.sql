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
-- 분기 정보와 급여의 범위를 받아서 해당 분기의 최고 급여자를 리스트 처리 
-- 분기 정보가 없으면 전체 분기별 사원정보  
-- 급여의 범위가 없으면 전체 급여 .
-- pstmt + 동적 query
SELECT empno, ename, qm.qu||'/4' qu, sal --사원번호, 사원명 ,분기, 급여
FROM emp e, (
	SELECT to_char(hiredate, 'Q') qu, max(sal) msal
	FROM emp 
	GROUP BY to_char(hiredate,'Q')
)qm
WHERE to_char(e.hiredate,'Q') = qu
AND sal = msal
AND qu ='4'
AND sal BETWEEN 1000 AND 5000;

/*
SELECT empno, ename, qm.qu||'/4' qu, sal --사원번호, 사원명 ,분기, 급여
FROM emp e, (
	SELECT to_char(hiredate, 'Q') qu, max(sal) msal
	FROM emp 
	GROUP BY to_char(hiredate,'Q')
)qm
WHERE to_char(e.hiredate,'Q') = qu
AND sal = msal
AND qu =?
AND sal BETWEEN ? AND ?

VO 
class EmpQua{
	private int empno;
	private String ename;
	private String qu;
	private double sal;
	private double frSal;
	private double toSal;
}
// 생성자1 : default
// 생성자2 : qu, frSal, toSal
// 생성자3 : empno, ename, qu,sal 
}

기능메서드 
public List<EmpQua> getList(EmpQua sch){}
**/

