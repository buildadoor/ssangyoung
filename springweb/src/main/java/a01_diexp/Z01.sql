select e.empno, e.ename, d.dname, m.ename, e.job
	from emp100 e, emp100 m, dept d
	where e.mgr = m.empno
	and e.deptno = d.deptno;




SELECT deptno, dname
FROM dept100;
SELECT DISTINCT e.mgr, m.ename 
FROM emp100 e, emp100 m
WHERE e.mgr = m.empno;
SELECT DISTINCT job 
FROM emp100;



		select *
		from dept100
		where dname like '%'||''||'%'
		and loc like '%'||''||'%';

SELECT * FROM emp100;
SELECT * FROM emp WHERE empno = 7499;
CREATE TABLE product101(
name varchar2(100),
price NUMBER,
cnt number
);
      select e.*, grade, hisal, losal
      from emp e, salgrade s
      where sal between losal and hisal;
     
    SELECT m.*, name, price
    FROM MEMBER m, PRODUCT101 p;
INSERT INTO product101 VALUES ('사과',2000,3);
select e.*, dname, loc
		from emp e, dept d
		where e.deptno = d.deptno;
	  select e.*, grade, hisal, losal
      from emp e, salgrade s
      where sal between losal and hisal;
-- dept와 salgrade를 조인 
SELECT d.*, grade
FROM dept d, salgrade s
WHERE d.dept = d.salgrade;
SELECT * FROM SALGRADE s ;

     SELECT e.*, grade, hisal, losal
	 FROM emp e, salgrade s
	 where sal BETWEEN losal and hisal;

	SELECT e.*, s.grade
FROM emp e, salgrade s;

[출처] 10월 11일 수업중 과제(DB) (oracle one) | 작성자 oa0613
--[1단계:확인] 4. 단일 리턴값 처리 연습(아래와 같은 sql을 처리하는 dao와 mapper.xml을 구현하고  main()에서 호출하세요.
    --      1) 최고 관리자 번호
SELECT max(mgr) FROM emp100;
--      2) 40번 부서의 최근 입사자의 입사일
 select to_char(max(HIREDATE), 'YYYY-MM-DD') from emp100 where deptno=40;
--      3) 직책이 SALESMAN의 최저 급여
SELECT min(sal) FROM emp100 WHERE job = 'SALESMAN';
--      4) 연봉이 2000~4000 구간의 사원의 수
SELECT COUNT(*) FROM EMP100 WHERE sal BETWEEN 2000 AND 4000;
--      5) 1/4분기에 입사한 사원의 수
SELECT count(*) FROM emp100 WHERE to_char(hiredate,'Q')='4';
      
      
--1단계:확인] 4. 단일 객체 처리 연습(아래와 같은 sql을 처리하는 dao와 mapper.xml을 구현하고  main()에서 호출하세요.
--      1) 직책이 MANAGER인 사원의 최고 급여자
SELECT max(sal) FROM emp100 WHERE job = 'MANAGER';
--      2) 부서번호가 10인 부서정보 (Dept alias 등록 필요 - dept - 공통 mybatis에)
  select * from dept where deptno=10;
 -- public Dept getDeptByDeptno();
 -- Mapper.xml
 -- <select id = "getDeptByDeptno" resultType="dept"?
 --</select>
--      3) 사원명이 TURNER인 사원의 정보
SELECT * FROM emp100 WHERE ename = 'TURNER';
--      4) 최초 입사자의 사원 정보 
select * from emp100 where hiredate=(select min(hiredate) from emp100);
--      5) 2/4분기 최고 급여자의 정보
SELECT * FROM EMP100 WHERE SAL=(SELECT MAX(SAL) FROM EMP100 WHERE to_char(HIREDATE, 'q')=2);

select e.*, dname, loc
FROM emp e, dept d
WHERE e.deptno = d.deptno;

SELECT e.*, grade
FROM EMP e,SALGRADE s
WHERE sal BETWEEN losal AND hisal
AND sal BETWEEN 1000 AND 3000;

SELECT empno NO, ename name, sal+nvl(comm,0) tot
FROM emp100;
-- no, name, tot : column
-- empno, ename, sal : Emp 안에 property 할당
-- 1. result mapper에서 선언 id값을 가져오기.
select ename name, mgr manager, sal salaray from emp;
select deptno no, dname departname, loc location from dept;
select * from salgrade;
