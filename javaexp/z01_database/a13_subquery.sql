/*a13_subquery.sql
#subquery
1. 개요
	하나의 sql 명령문의 결과를 다른 sql 명령문에 전달하기 위해 두 개 이상의
	sql 명령문을 하나의 sql명령문으로 연결하여 처리하는 방법
	1) 메인쿼리
		where 컬럼 연산자 (서브쿼리)
	------------------------------
	2) 인라인뷰 형식
		from (서브쿼리), (서브쿼리)
	3) select (서브쿼리)
		from 테이블 
		
2. 서브쿼리의 필요성
	1) 사원'SMITH'와 동일한 부서번호를 가진 사원의 정보를 검색
		- 사원 테이블에서 'SMITH'라는 사원을 SQL 명령문을 통해 검색 
		- 부서번호 20을 확인하여, 동일한 부서번호를 통해 사원 정보를 검색한다.
		- 위와 같이 2중으로 SQL처리할 내용을 통합하여 하나의 SQL명령문으로 처리한다.
		- 메인 쿼리
			WHERE deptno = (서버쿼리)
3. 실행 순서
	1) main query에 최하단에 있는 부분부터 실행해서 결과를 가지고 상위에 있는 query로 전달한다. 

*/
--SMITH와 동일한 부서의 사원정보를 출력하세요
SELECT *
FROM EMP 
WHERE deptno = (
	SELECT deptno 
	FROM emp 
	WHERE ename = 'SMITH'
);
--ex)WARD와 같은 직책에 있는 사원 정보를 출력
SELECT *
FROM emp 
WHERE job = (
	SELECT JOB
	FROM emp 
	WHERE ename = 'WARD'
);
--해설
SELECT job 
FROM emp 
WHERE ename = 'WARD';

SELECT *
FROM emp 
WHERE job = (
	SELECT job 
	FROM emp 
	WHERE ename = 'WARD'
);


--ex)KING을 관리자로 둔 사원 정보를 출력
SELECT *
FROM emp e, emp m
WHERE m.ename  (
	SELECT m.ename 
	FROM emp e, emp m
	WHERE m.ename= 'KING'
);
--해설
SELECT empno
FROM emp 
WHERE ename = 'KING';

SELECT * 
FROM EMP
WHERE mgr = (
	SELECT empno
	FROM emp 
	WHERE ename= 'KING'
);
/*
#서버쿼리의 종류
1. 단일행 서버 쿼리
	-서버의 쿼리의 결과가 하나의 행인 경우를 말한다.
	-하나의 행을 조건으로 처리하는 비교 연산자(=,>,<,>=,<=,<>,!=)등을 활용할 수 있다.
	ex) select *
	from emp 
	where sal <= (
		select max(sal)
		from emp
		where deptno = 10
	);
	부서번호가 10인 사원의 최대 급여보다 적은 급여를 가진 사원 정보
	-- 그룹함수의 통계의 단일값을 기준으로 하는 경우는 단일행/단일열 서버 쿼리 
	ex) 평균급여보다 많은 사원정보를 출력
	select *
	from emp
	where sal >= (select avg(sal)from emp);

2. 다중행 서버 쿼리 
 - 서버 쿼리의 결과값이 여러 행일때, 활용된다.
 - 다중행 비교연산자 : in, any, some, all, exists 등을 활용할 수 있다.
 ex) select *
 	 from emp
 	 where job in(
 	 	select job
 	 	from emp
 	 	where sal between 1000 and 2000
 	 );
 	 급여가 1000~2000 사이의 사원과 같은 직책인 사원정보
	
	-- 부서별로 최고급여와 동일한 사원을 출력
	select *
	from emp
	where (deptno, sal) in(
		select deptno, max(sal)
		from emp
		group by deptno
	);
	ps) 부서별 최고 급여는 sql을 통해서 기본적으로 부서번호와 최고급여
		정보만 나오지 사원의 기타정보를 도출할 수 없다. 위와 같이 subquery를
		통해 해당 정보의 사원 정보를 도출할 수 있다.
**/
--ex)
select *
from emp 
where sal <= (
	select max(sal)
	from emp
	where deptno = 10
);
select *
from emp 
where sal <= (
	select min(sal)
	from emp
	where deptno = 10
);

select *
from emp
where job in(
 	 select job
 	 from emp
 	 where sal between 1000 and 2000
);
--ex) 부서번호가 20인 사원정보의 평균 급여보다 높은 사원을 출력하세요
SELECT *
from emp
WHERE sal >= (
	SELECT avg(sal)
	FROM emp 
	WHERE deptno = 20
);
--해설
SELECT avg(sal)
FROM emp 
WHERE deptno = 20;
SELECT *
FROM emp 
WHERE sal > (
	SELECT avg(sal)
	FROM emp 
	WHERE deptno = 20;
);

--ex) 2사 분기에 입사한 사원의 직책과 동일한 사원 정보를 출력
SELECT *
FROM emp 
WHERE job in(
	SELECT job
	FROM emp
	WHERE to_char(hiredate,'Q') = 2
);
--해설
SELECT job 
FROM emp 
WHERE to_char(hiredate,'Q') =2

SELECT *
FROM emp 
WHERE job in(
	SELECT job 
	FROM emp 
	WHERE to_char(hiredate,'Q') =2
);
--ex)5월에 입사한 사원의 부서와 같은 사원의 정보를 출력하세요
SELECT *
FROM emp
WHERE deptno IN(
	SELECT deptno 
	FROM emp 
	WHERE to_char(hiredate,'MM')=5
);
-- 해설 
SELECT 
FROM emp 
WHERE to_char(hiredate, 'MM') = '05';

SELECT *
FROM emp 
WHERE deptno in (
		SELECT deptno
		FROM emp 
		WHERE to_char(hiredate, 'MM') = '05');
/*
#다중열이 있는 서브쿼리 
1. 단일행
2. 다중행
	select 
	from 
	where (조건1컬럼, 조건2컬럼) in (다중열/다중행 sub query)
**/
--부서별 최고 급여자 사원 정보 (다중행/다중열로 검색처리)
SELECT deptno, max(sal)
FROM emp 
GROUP BY deptno;

SELECT deptno, ename, sal 
FROM emp
WHERE (deptno, sal) IN (
	SELECT deptno, max(sal)
	FROM emp 
	GROUP BY deptno
);
--SALESMAN 중에서 가장 급여가 낮은 사람의 사원 정보를 처리
SELECT *
FROM EMP 
WHERE (job, sal) = ( 	--job, sal이 AND 조건으로 연결되어 있는 경우를 말한다. 
	SELECT job, min(sal)
	FROM emp
	WHERE job = 'SALESMAN'
	GROUP BY job 
);
--ex) 1사분기 입사한 사람 중에 급여가 가장 높은 사원의 정보를 출력 (단일행)
SELECT *
FROM emp 
where(to_char(hiredate,'Q'), sal) = (
	SELECT to_char(hiredate,'Q'), max(sal)
	FROM emp 
	WHERE to_char(hiredate,'Q') ='1'
	GROUP BY to_char(hiredate,'Q')
);

--ex) 급여가 2000~3000 사이의 관리자정보와 부서정보와 일치하는 사원을 출력(다중행)
SELECT *
FROM emp 
WHERE (mgr, deptno) IN (
	SELECT mgr, deptno 
	FROM emp 
	WHERE sal BETWEEN 2000 AND 3000
);
-- inline view : query를 통해서 하나의 가상의 테이블을 만들고,
-- 	그 데이터를 통해서 조인하는 것을 말한다.
--	부서별 사원의 급여가 가장 높은 사원의 정보
SELECT e.deptno, empno, ename, me.msal
FROM emp e, (SELECT deptno, max(sal) msal
			FROM emp 
			GROUP BY deptno) me 
WHERE e.deptno = me.deptno
AND e.sal = me.msal;

--ex)분기별 최고 급자의 사원번호, 사원명, 분기, 급여를 출력하세요. (inline view)
--1) 분기별 최고 급여자 정보 만들기
--2) 기본 테이블과 조인하기 (분기, 급여)
--3) 리스트할 정보 select 하기 
SELECT to_char(hiredate, 'Q') qu, max(sal) msal
FROM emp 
GROUP BY to_char(hiredate,'Q');

SELECT empno, ename, qm.qu, sal
FROM emp e, (
	SELECT to_char(hiredate, 'Q') qu, max(sal) msal
	FROM emp 
	GROUP BY to_char(hiredate,'Q')
)qm
WHERE to_char(e.hiredate,'Q') = qu
AND sal = msal;
--참고하기 
SELECT (SELECT max(sal) 
		 FROM emp
		 WHERE deptno=e.deptno) "소속부서 최고급여", e.*
FROM emp e;