--a20_dml.sql
/*
#데이터 수정
1. update 명령문은 테이블에 저장된 데이터 수정을 위한 조작어이다.
2. 기본 형식
	update 테이블명
	set 컬럼1 = 변경할 데이터,
		컬럼2 = 변경할 데이터 
		..
	where 조건문
3. 주의사항
	1) where 절을 생략하면 테이블의 모든 행이 수정된다.
	2) 조건문과 변경할 데이터 부분을 subquery를 이용하여 처리할 수 있다.
*/

UPDATE EMP10 
	SET empno =1000,
		job = '사원'
	WHERE empno = 7369;
	
--ex) emp10 보너스가 null인 데이터를 모두 1000으로 수정처리하세요 
UPDATE emp10 
	SET comm = 1000
	WHERE comm IS null;
SELECT * FROM emp10;
--ex) emp10 1/4분기에 입사한 사원 정보를 현재날짜로 수정처리하세요
UPDATE EMP10
	SET hiredate = SYSDATE 
	WHERE to_char(hiredate,'Q') ='1';
SELECT * FROM emp10;
/*
#subquery를 통한 수정처리
1. update명령문에 set부분이나 where 조건절에 subquery를 이용하여 수정 처리하는 
것을 말한다. 
2. 다른 테이블이나 현재 테이블에 정보를 변경할 때, 일단 query를 수행한 결과로 
해당 데이터를 수정 처리하는 것을 말한다.
3. 변경할 컬럼의 타입과 갯수는 반드시 일치하여야한다.
4. 유형 
	1) set부분 subquery 활용
		-한개의 컬럼 set컬럼명 = (결과가 1개인 컬럼 query)
		-두개이상의 컬럼 set (컬럼명..) = (결과가 2개 이상 컬럼 query)

# 단일행 수정 subquery
update 테이블명
	set 컬럼명 = (select 컬럼 from 테이블명 )
 where 조건 
ex) subquery를 통해 얻어진 데이터를 해당 컬럼의 값을 변경 
*/
-- ex) 최대 급여를 사원번호 @@@에게 할당 처리 
--1) 최대 급여 
SELECT max(sal)
FROM emp10;
--2) 사원번호@@@의 급여의 변경 
SELECT *
FROM emp10; 
UPDATE emp10
	SET sal = (
		SELECT max(sal)
		FROM emp10
	)
WHERE empno = 7369;
SELECT * FROM emp10;

-- 해당 데이터는 항상 입력/수정/삭제에 의해 바뀌고 있는 상황에서 통계치를 처리하려면
-- subquery가 필요로 하다. 

/*
# 다중열 수정 sunquery
update 테이블명
	set (컬럼1, 컬럼2) = ( select 컬럼1, 컬럼2 from 테이블명)
where 조건 
ex) sunquery의 두개 이상 컬럼의 내용을 기준으로 검색된 내용ㅇ로 변경 처리 
*/
-- ex) 특정 부서의 평균 급여를 해당 부서와 급여로 변경처리 
--	  직책이 SALESMAN의 부서와 급여를 10부서의 평균급여로 변경  
-- 1) subquery 10부서의 평균 급여
SELECT deptno, round(avg(sal))
FROM emp10
WHERE deptno = 10
GROUP BY deptno;
-- 2) update 구문의 query를 작성
SELECT *
FROM emp10
where job = 'SALESMAN';
UPDATE EMP10	
	set(deptno,sal) = (
		SELECT deptno, round(avg(sal))
		FROM emp10
		WHERE deptno = 10
		GROUP BY deptno
	)
WHERE job = 'SALESMAN';
SELECT * FROM emp10;


/*
--부서번호가 10인 사원정보의 급여를 부서정보 20인 사원의 최고 급여로 변경처리
SELECT ename, sal
FROM emp 
WHERE deptno = 10;

SELECT max(sal)
FROM emp10 
WHERE deptno = 20;

UPDATE emp10 
	SET sal = (
		SELECT max(sal)
		FROM emp10 
		WHERE deptno = 20
	)
WHERE deptno = 10;
--ex) 직책이 SALESMAN인 사람의 평균 급여를 사원번호 7499에 급여로 수정처리하세요
SELECT avg(sal)
FROM emp10 
WHERE job = 'SALESMAN';
SELECT * FROM emp 10 WHERE empno = 7499;


UPDATE EMP10	
	SET sal = (
		SELECT avg(sal)
		FROM EMP10
		WHERE job = 'SALESMAN'
		)
		WHERE empno = 7499;
--ex)2사분기 최고 급여를 사원명 ALLEN의 급여로 변경처리 하세요 
SELECT max(sal)
FROM emp 
WHERE to_char(hiredate,'Q')='1';
SELECT * FROM emp10;
SELECT *
FROM emp10 
SELECT * FROM emp10 WHERE to_char(hiredate,'Q') = '2';

UPDATE emp10
	SET sal = (
		SELECT max(sal)
		FROM emp10
		WHERE to_char (hiredate,'Q')='2'
	)
		WHERE ename = 'ALLEN';
	
SELECT * FROM emp10;
WHERE ename = 'ALLEN';
--ex) 직책이 MANAGER인 사원의 최저 급여를
-- SMITH의 급여로 수정하세요 . 
SELECT min(sal)
FROM emp 10
WHERE job = 'MANAGER';

UPDATE emp10 
	SET sal = (
		SELECT min(sal)
		FROM emp10
		WHERE job = 'MANAGER'
	)
	WHERE ename = 'SMITH';
SELECT * FROM emp10;

/*
# 데이터 삭제 처리 
1. 조회조건 where을 통해 특정한 데이터를 row단위로 삭제처리한다.
2. ROW 단위이기에 삭제구문을 선택하는 컬럼이 없다.
	delete
	from 테이블
	where 조건
3. 조건은 기존에 데이터와 같이 subquery를 이용해서 조건을 활용 가능 하다.
*/
DELETE 
FROM emp10 
WHERE empno = 7369;
SELECT * FROM emp10;
--ex)급여중에 가장 낮은 데이터를 삭제처리하세요
DELETE 
FROM EMP10  
WHERE sal = (
	SELECT min(sal) FROM emp10
)
--ex)부서별로 최근에 입사한 사원을 삭제처리하세요
SELECT deptno, max(hiredate)
FROM EMP10 
GROUP BY deptno;

DELETE 
FROM emp10 
WHERE (deptno, hiredate) IN (
	SELECT deptno, max(hiredate)
	FROM EMP10 
	GROUP BY deptno)
	
SELECT * FROM emp10;