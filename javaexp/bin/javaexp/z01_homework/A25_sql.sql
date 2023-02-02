--2. 연도별 사원의 수와 최대급여 
select to_char(hiredate,'YYYY') year,
		count(*),max(sal)
from emp 
group by to_char(hiredate,'YYYY');

/*
class Exp02{
private String year;
private int cnt;
private double sal;
}
*/
--3qjs
--에러 
SELECT e.*, decode(div,0,'짝','홀') div,
	decode(div,0,'100%','50%') bonus_per, --보너스 표시
	decode(div,0,1,0.5)*sal bonus, --보너스금액
	sal + decode(div,0,1,0.5)*sal totpay --총금액
FROM (
	SELECT empno, MODE(empno,2) div,
		ename, sal
	FROM emp
	) e
WHERE div IN (0,1);
        

SELECT e.*, decode(div,0,'짝','홀') div,
	decode(div,0,'100%','50%') bonus_per, --보너스 표시
	round(decode(div,0,1,0.5)*sal) bonus, --보너스 금액
	sal + round(decode(div,0,1,0.5)*sal) totpay -- 총 금액 
FROM (
	SELECT empno, mod(empno,2) div,
			ename, sal
	FROM emp )e
	WHERE div IN (0,1);
--프로그램 상에 0: 짝, 1 :홀 , 0,1 : 전체 
/*
 VO 조건 (홀/짝/전체) 이름, 사번, 구분,급여,보너스(%),총급여
매개변수 : String div
class Exp03{
	private String ename;
	private int deptno;
	private String div2;
	private double sal;
	private String bonus_per;
	private int bonus;
	private int totpay;
}
public List<Exp03> getExp03List(String div){
	List<Exp03> list = new ArrayList<Exp03>();
	
	return list;
}
*/
--4.사원정보의 특정 근무일 기준(조건)으로 근무연한/개월 수를 표현하세요
SELECT e.*,
	floor(mm/12) YEAR,
	floor(MOD(mm,12)) mon,
	floor(mm/12)||'년'||floor(MOD(mm,12))||'개월' workmonth
FROM (
	SELECT ename,
			MONTHS_BETWEEN(to_date('2001/01/01','YYYY/MM/DD'),hiredate),
			hiredate)mm, 
	FROM emp
)e;
--
SELECT e.*,
	floor(mm/12) YEAR,
	floor(MOD(mm,12)) mon,
	floor(mm/12)||'년'||floor(MOD(mm,12))||'개월' workmonth
FROM (
	SELECT ename, 
		MONTHS_BETWEEN(to_date('2001/01/01','YYYY/MM/DD'),
		hiredate) mm
	FROM emp
	) e;


--vo처리 
SELECT ename, 
	floor(mm/12)||'년'||floor(MOD(mm,12))||'개월' workmonth
FROM (
	SELECT ename, 
		MONTHS_BETWEEN(to_date('2001/01/01','YYYY/MM/DD'),
				hiredate) mm
	FROM emp
	) e;
/*
 class Exp04{
 	private String ename;
 	private String workmonth;
 }
 
 public List<Exp04> getExp04List(String std){}
*/
--
SELECT *
FROM emp 
WHERE to_char(hiredate,'Q')=(
	SELECT to_char(hiredate,'Q')
	FROM emp 
	WHERE ename = 'ALLEN' 
);
--vo
-- public List<Emp> getExp04(String ename){}
SELECT *
FROM emp;
--관리자명 
SELECT *
FROM EMP 
WHERE mgr in(
SELECT EMPNO
FROM EMP 
WHERE ename = 'BLAKE'
);
--EMP ==> 생성자 추가.
--public List<Emp> getExp06
--public List<emp>
--7번 조건(월)에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요

--답

SELECT *
FROM EMP 
WHERE deptno in(
		SELECT DEPTNO
		from EMP
		where to_char(hiredate,'mm')='02');

--vo
--pulic List<Emp>getExp07(String mm){}


	create table emp100
		as select * from emp;
		alter table emp100
		modify(
			job varchar2(50),
			ename varchar2(50)
			empno number(4) primary key
		);

		create sequence emp100_seq
			start with 1000
			minvalue 1000
			maxvalue 9999;
--	2) sql 작성
		
	 	insert into emp100 values(emp100_seq.nextval,'홍길동','사원',7800,
	 		to_date('2022/01/01','YYYY/MM/DD'), 3500,100,10);
	 		
	 	SELECT * FROM emp100;
	 	
CREATE TABLE dept100
 AS SELECT * FROM dept;
 ALTER TABLE dept100
 modify(
 	dname varchar2(50),
 	loc varchar2(50)
 );
insert into dept100 values(11,'인사','서울');
 SELECT * FROM dept100;
--A03_DeptDao.java에 추가 기능 메서드 처리. 
--1.sql : insert into dept10 values(11,'인사','서울')
--2.vo
--3. public void insertDept(Dept ins){}

CREATE TABLE person(
	name varchar(50),
	age NUMBER, 
	loc varchar2(50)
);
INSERT INTO person values('홍길동',25,'서울 신림');
/
 * *
1 . VO
2. 메서드 정의 
3. main()추가 처리
4. DB로 확인 

A04_DaoExp.java

class Person{
	private String name;
	private int age;
	private String loc;
}
public void insertPerson(Person ins){}
 
   
 */

-- public void insertDeptExp(DeptExp ins){}