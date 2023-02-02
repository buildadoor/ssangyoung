

SELECT * FROM MEMBER200;
CREATE TABLE member200(
   id varchar2(100) PRIMARY KEY,
   pass varchar2(100),
   name varchar2(100),
   auth varchar2(100),
   point NUMBER
);

insert into member200 values('byeGirl','8888','오영삼','quest',3000);

INSERT INTO member200 values('himan','7777','홍길동','admin',1000);
INSERT INTO member200 values('higirl','8888','홍현아','admin',2000);
INSERT INTO member200 values('goodMan','5555','오길동','normal',1000);
INSERT INTO member200 values('badGirl','3333','신영희','quest',100);

select * from member200
   where id like '%'||''||'%'
   and name like '%'||''||'%'
   AND auth = 'admin';
   --<if test="auth!=''">
   --and auth = #{auth}
   --</if>
   select * from member200;
   where id = 'himan';
   update member200
      set name='himan',
         pass='9999',
         point='3000',
         auth='admin'
      where id = 'himan';
   delete member200
   where id = #{id};

SELECT DISTINCT auth
FROM member200;



DROP TABLE member200;
select * from member200
	where id like '%'||''||'%'
	and name like '%'||''||'%'
	AND auth = 'admin';

select * from member200
	where id = 'himan'
	update member 200
		set name='himan',
			pass='9999',
			point=9999,
			auth='admin'
		where id = 'himan';

	SELECT DISTINCT auth
	FROM member200;
CREATE TABLE member200(
	id varchar2(100) PRIMARY KEY,
	pass varchar2(100),
	name varchar2(100),
	auth varchar2(100),
	point NUMBER
);
INSERT INTO member200 values('himan','7777','홍길동','admin',1000);
INSERT INTO member200 values('higirl','8888','홍현아','admin',2000);
INSERT INTO member200 values('goodman','5555','박길동','normal',1000);
INSERT INTO member200 values('badgirl','4444','박현아','quest',2000);
SELECT * FROM member200;

SELECT * FROM product111;
SELECT * FROM member111;
SELECT * FROM buyinfo111;

CREATE TABLE PRODUCT111(
	pid varchar2(100) PRIMARY key, 
	name varchar2(100),
	price NUMBER,
	rcnt number
);
CREATE TABLE member111(
	mid varchar2(100) PRIMARY KEY,
	pass varchar2(100),
	name varchar2(100),
	auth varchar2(100)
);
CREATE TABLE buyinfo111(
	pid varchar2(100),
	mid varchar2(100),
	bcnt NUMBER,
	buydate date
);
INSERT INTO product111 values(1000,'사과',2000,100);
INSERT INTO product111 values('1001','바나나',4000,200);
INSERT INTO member111 values('himan','7777','홍길동','관리자');
INSERT INTO member111 values('higirl','8888','홍현아','관리자');
INSERT INTO buyinfo111 values('1000','himan',5,sysdate);

SELECT p.name pname, price, m.mid, m.name, pass, auth, b.bcnt
FROM product111 p, member111 m, buyinfo111 b
WHERE p.pid = b.pid and m.mid = b.mid;

SELECT p.name pname, price, m.name, auth, b.bcnt
FROM product111 p, member111 m, buyinfo111 b
WHERE p.pid = b.pid and m.mid = b.mid;



select id user99, pass password99, auth authority  from MEMBER;
SELECT * FROM dept100;
  select e.*, grade, hisal, losal
      from emp e, salgrade s
      where sal between losal and hisal;
INSERT INTO dept100 VALUES(10,'회계','한국');

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