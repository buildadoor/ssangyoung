/*
2022-10-04
[1단계:개념] 1. EQUI join과 NON EQUI join의 차이점을 기술하세요
EQUI join은 가장 많이 사용하는 조인 방법으로서 조인 대상이 되는 두 테이블에서 공통적으로 존재하는 칼럼의 값이 일치되는 행을 연결하여 결과를 생성하는 조인 방법.
Non-Equi Join은 조인 조건에 특정 범위 내에 있는지를 조사하기 위해 WHERE 절의 조인 조건으로 = 연산자 이외의 비교 연산자를 사용한다.

[1단계:코드] 2. 직책이 SALESMAN의 급여와 등급을 출력하요
*/
SELECT job, sal, s.grade, d.deptno
FROM emp e, salgrade s, dept d
WHERE sal BETWEEN losal AND hisal
AND job = 'SALESMAN';
/*
[2단계:코드] 3. 1사분기에 입사한 사원중, 부서명이 ACCOUNTING인 사원의 이름, 급여와 급여등급 출력하세요.
*/
SELECT ename, sal, s.grade, dname, to_char(hiredate,'Q')
FROM emp e, salgrade s, dept d
WHERE (hiredate, dname) IN (
	SELECT hiredate, dname 
	FROM emp 
	WHERE dname = 'ACCOUNTING'
	AND to_char(hiredate,'Q')= '1'
);
--해설
--1) 1사분기에 입사한 사원
--2) 조건1 부서명이 ACCOUNTING : 부서 테이블 조인
--3) 급여와 급여등급 : salgrade테이블 조인
--4) 조인 : 사원, 부서, 등급, 조건 : 1사분기에 입사, 부서명이 ACCOUNTING
--출력내용 (select) : ename, sal, grade
SELECT * FROM salgrade;

SELECT ename ,sal, grade, to_char(hiredate,'Q')분기, dname
FROM emp e, dept d, salgrade s 
WHERE e.deptno = d.deptno 
AND sal BETWEEN losal AND hisal
AND to_char(hiredate,'Q')= '1'
AND dname = 'ACCOUNTING';



/*
[1단계:개념] 4. outer join의 기본 형식과 equi join과의 차이점을 기술하세요.
기본 형식
Outer join
기본 형식 : 
(+) 기호를 사용하여 해당 테이블에 정보가 없을지라도 표시할 컬럼을 지정하여 처리한다.
	select 테이블1.컬럼1, 테이블1.공통컬럼, 테이블2.공동컬럼, 테이블2.컬럼1
	from 테이블1, 테이블2
	where 테이블.공통컬럼(+) = 테이블2.공통컬럼
- 조인 조건에 일치하지 않는 행도 포함하여 가져옴

equi join과의 차이점은 조인 조건에 일치하지 않는 행도 포함하여 가져온다는 것이다.

	
	
[2단계:코드] 5. 부서별 최고급여액을 출력하되 사원정보가 없는 부서는 0으로 표현하여 출력하세요.
*/
SELECT deptno 부서, nvl(ename,'없음') 사원명, sal 최고급여 
FROM emp
WHERE (deptno, sal) IN (
	SELECT deptno, max(sal)
	FROM emp 
	GROUP BY deptno
);

/*
[1단계:코드] 6. 관리자하위에 포함된 사원을 기준으로 관리자의 하위 직원의 수를 관리자명, 사원수로 출력하세요.
?????????????*/
SELECT m.ename, count(e.ename)
FROM emp e, emp m
WHERE e.mgr(+) = m.empno ;
--해설
--1) 관리자 하위에 포함된 사원을 기준 (mgr, empno의 self join 테이블처리)
--2) 관리자 정보 m, 기본사원 정보를 e로 처리 
--3) 관리자명(관리자 정보의 사원명), 사원수(기본 사원정보의 count수)
SELECT e.*, m.*
FROM emp e, emp m 
WHERE e.mgr = m.empno;

SELECT m.ename, count(e.empno) 사원수
FROM emp e, emp m 
WHERE e.mgr = m.empno
GROUP BY m.ename;
SELECT * FROM emp;

/*
[1단계:개념] 7. subquery란 무엇인가? 여러가지 유형과 함께 기술하세요. 
하나의 sql 명령문의 결과를 다른 sql 명령문에 전달하기 위해 두 개 이상의
sql 명령문을 하나의 sql명령문으로 연결하여 처리하는 방법으로 main query에 최하단에 있는 부분부터 실행해서 결과를 가지고 상위에 있는 query로 전달한다. 

1) 단일행 서버 쿼리
-서버의 쿼리의 결과가 하나의 행인 경우를 말한다.
-하나의 행을 조건으로 처리하는 비교 연산자(=,>,<,>=,<=,<>,!=)등을 활용할 수 있다.
		ex) select *
		from emp 
		where sal <= (
			select max(sal)
			from emp
			where deptno = 30
		);
		부서번호가 30인 사원의 최대 급여보다 적은 급여를 가진 사원 정보
2) 다중행 서버 쿼리 
- 서버 쿼리의 결과값이 여러 행일때, 활용된다.
- 다중행 비교연산자 : in, any, some, all, exists 등을 활용할 수 있다.
	ex) select *
		 from emp
	 	 where job in(
	 	 	select job
	 	 	from emp
	 	 	where sal between 2000 and 3000
	 	 );
	 	 급여가 2000~3000 사이의 사원과 같은 직책인 사원정보

[1단계:코드] 8. JAMES와 같은 입사일의 분기를 가진 사원을 출력하세요.
*/
SELECT *
FROM EMP 
WHERE to_char(hiredate,'Q') = (
	SELECT to_char(hiredate,'Q')
	FROM emp 
	WHERE ename = 'JAMES'
);
-- 해설
-- 1) JAMES와 같은 입사일의 분기 ==> JAMES의 입사 분기 (subquery) 
-- 2) 위 분기와 동일한 사원 where to_char(hiredate,'Q')=( 서브쿼리);
SELECT to_char(hiredate,'Q')
FROM emp 
WHERE ename = 'JAMES';

SELECT to_char(hiredate,'Q') 분기, e.*
FROM emp e
WHERE to_char(hiredate,'Q') = (
	SELECT to_char(hiredate,'Q')
	FROM emp 
	WHERE ename = 'JAMES'
);
/*
[1단계:코드] 9. ALLEN과 같은 관리자를 둔 사원을 출력하세요.
*/
SELECT *
FROM emp
WHERE (mgr, ename) in(
	SELECT mgr, ename
	FROM emp	
	WHERE ename = 'ALLEN'
);

/*
[1단계:코드] 10. 보너스가 가장 많은 사원정보(사원명, 부서명, 보너스)를 출력하세요.
*/
SELECT deptno, ename, comm
FROM emp
WHERE (deptno, comm) IN (
	SELECT deptno, max(comm)
	FROM emp 
	GROUP BY deptno);

--해설
--1) 보너스가 가장 많은 사원 : 최고 보너스(subquery) ==> main query
--2) 사원명, 부서명, 보너스 : 부서정보와 조인  
--최고 보너스
SELECT max(comm)
FROM emp;
--최고 보너스를 가진 사원
SELECT *
FROM emp 
WHERE comm = (
	SELECT max(comm)
	FROM emp
);
--부서명을 위한 부서테이블과 조인 및 출력할 컬럼 지정. 
SELECT ename, dname, comm
FROM emp e, dept d
WHERE e.deptno = d.deptno 
AND comm = (
	SELECT max(comm)
	FROM emp
);
/*
[1단계:코드] 11. 12월에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
*/
SELECT *
FROM emp 
WHERE deptno in (
		SELECT deptno
		FROM emp 
		WHERE to_char(hiredate, 'MM') = 12
);
/*


[1단계:개념] 12. 다중행/다중열의 SUBQUERY의 종류와 차이점을 예제를 통해 기술하세요. 
다중행 
- 하나 이상의 행을 반환하는 Subquery
- 단일 행 연산자를 사용하지 못하며, 
다중 행 연산자(IN, NOT IN, ANY, ALL, EXISTS)만 사용이 가능하다.
SELECT [DISTINCT] 컬럼, 컬럼 …
FROM 테이블
WHERE 컬럼 <다중 행 연산자> (SELECT 컬럼
FROM 테이블);

다중열 
- 결과 값이 두개 이상의 컬럼을 반환하는 Subquery 
SELECT [DISTINCT] 컬럼, 컬럼 …
FROM 테이블​
WHERE (컬럼1, 컬럼2, …) IN (SELECT 컬럼1, 컬럼2, …
FROM 테이블);

	
== 평가대비(오라클) 객관식 문제 ==
1. 다중행 서버쿼리로 사용되는 구문이 아닌 것은 ?
1) in 2) any 3) some 4) between
정답:4 ==>  다중행 비교연산자에는 in, any, some, all, exists 등이 있다.

2. 사람의 머리로 이해할 수 있는 현실 세계를 모델링은 하는 것은 어느 분류에 해당하는가?
1) 단계적 - 개념적 모델링
2) 단계적 - 논리적 모델링
3) 도구적 - 개념적 모델링  
4) 도구적 - 논리적 모델링
정답:3 ==> 	도구적 입장에서 데이터 모델링 - 개념적 데이터 모델
		- 사람의 머리로 이해할 수 있는 현실 세계를 개념적 모델링하여 데이터베이스의 개념적 구조로 표현하는 도구
		
3. 개념적 데이터 모델의 도형으로 틀린 것은?
1) 엔티티 - 원
2) 관계 - 마름모
3) 속성 - 타원
4) 개체 - 사각형
정답:1 ==>	객체 - 사각형
			관계 - 마름모
			속성 - 타원
			로 1번은 관계가 없다.

4. subquery로 사용하는 비교연산자가 아닌 것은?
1) both
2) any
3) some
4) exists
정답:1 ==> 1번 문제와 같이 서버쿼리는 in, any, some, all, exists등이 있다.  
*/
