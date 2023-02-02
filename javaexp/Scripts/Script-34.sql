SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp01
where ename LIKE '%'||''||'%'
AND job LIKE '%'||''||'%'
AND sal BETWEEN 1000 AND 2000
;

--매개변수에 의해 검색의 조건을 처리하는 기능메서드 만들기

SELECT *
FROM dept 
WHERE dname LIKE '%'||'O'||'%'
AND loc LIKE '%'||''||'%';

--부서별 최고 급여자
SELECT deptno, ename, sal  
FROM emp10
WHERE (deptno, sal) IN (
	SELECT deptno, max(sal)
	FROM emp01 
	GROUP BY deptno
);

