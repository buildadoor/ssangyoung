--ex) dept와 조건을 통해서 부서명 (키워드)와 분기별 조건으로 부서명, 사원명, 입사일, 급여를
--출력하세요. 
--1) sql
SELECT dname, ename, hiredate , sal
FROM emp e, dept d 
WHERE e.deptno = d.deptno
AND dname LIKE '%'||''||'%'
AND to_char(hiredate,'Q') = '2';
--2)vo

/*
private String dname,
private String ename,
private Date hiredate,
private Double sal;
private String div;//분기  
 
*/
--3)기능메서드 
/*
private List<Emp04> getSch03(Emp04 sch){
		List<Emp04> list = new ArrayList<Emp04>();
*/

SELECT deptno, enanem, job, sal
FROM emp 
WHERE detpno = 10;
/*
ResultSet : 조회 결과으 데이터를 가지고 있다.
1. next() : 행단위로 이동
2. get타입("컬럼명"),get타입(1) 1부터 select의 순서대로 
	while(rs.next()){ 데이터가 있을 때까지 이동
		rs.getInt("empno")
		rs.getString("ename")
		rs.getString(3)
		rs.getDouble(4)
	}
3. 위 반복 프로세스에서 리턴으로 선언한 객체에 단위 데이터를 입력(생성자)하고 
	Emp e = new Emp(rs.getInt("empno"),	rs.getString("ename"),
		rs.getString(3), rs.getDouble(4)
4. List<Emp>에 하나씩 반복문을 통해서 담기
	list.add(e);
	create table emp100
		as select * from emp;
		alter table emp100
		modify(
			job varchar2(50),
			ename varchar2(50)
			empno number(1000) primary key
		)
		sequence 만들기 (primary key 설정)
		create sequence emp100_seq
			start with 1000
			minvalue 1000
			maxvalue 9999;
 */
	create table emp100
		as select * from emp;
		alter table emp100
		modify(
			job varchar2(50),
			ename varchar2(50),
			empno number(4) PRIMARY key
		);
	SELECT*FROM emp100;
		create sequence emp100_seq
			start with 1000
			minvalue 1000
			maxvalue 9999;
		
			insert into emp100 values(emp100_seq.nextval,'홍길동','사원',7800,
	 		to_date('2022/01/01','YYYY/MM/DD'), 3500,100,10);
	 		
/*
 * 
 221013과제 
1) 분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력
emp e, salgrade s
WHERE sal BETWEEN losal AND hisal;
*/
SELECT ename, dname, sal, s.grade
FROM emp e, dept d,salgrade s 
WHERE e.deptno = d.deptno
AND salgrade BETWEEN losal AND hisal
AND to_char(hiredate,'Q') = ''
OR dname = '';

SELECT ename,DNAME, sal, grade
FROM emp e, SALGRADE s ,DEPT d 
WHERE  sal BETWEEN losal AND hisal
AND e.DEPTNO  = d.DEPTNO
AND to_char(hiredate,'q') ='1'
OR dname ='';
private String ename;
private String dname;
privae double sal;
private int grade;
	 	/*
2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.
*/
SELECT to_char(hiredate,'YY'), count(empno) max(sal)
FROM emp 
WHERE to_char(hiredate,'YY')= '80';
SELECT * FROM emp;
SELECT  to_char(hiredate,'YY'), count(empno), max(sal)
FROM EMP e 
GROUP BY to_char(hiredate,'YY')
HAVING to_char(hiredate,'YY')='81';

private DATE hiredate;
private double sal;
private int empno;


/*
3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
    조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요
    */
SELECT ename 이름, empno 사번, mod(empno,2) div , sal 급여, sal+(sal*1/2) 총급여
	FROM emp 
	WHERE mod(empno,2) !=0 

SELECT ENAME, EMPNO, mod(empno, 2) 구분, sal, co.comm+sal
FROM emp e,(SELECT  decode (mod(empno, 2),0,sal,sal*0.5) comm   
         FROM EMP
         ) co
WHERE e.comm = co.comm;


	SELECT ename 이름, empno 사번, mod(empno,2) div , sal 급여, sal+(sal*1/2) 총급여
	FROM emp 
	WHERE mod(empno,2) !=0;

SELECT ENAME, EMPNO, mod(empno, 2) 구분, sal, co.comm+sal
FROM emp e,(SELECT  decode (mod(empno, 2),0,sal,sal*0.5) comm   
         FROM EMP
         ) co
WHERE e.comm = co.comm;


private String ename;
private int empno;
private double sal;
    /*
4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요 
*/
SELECT floor(months_between(sysdate, hiredate)/12)||'년' 근무연한,
      mod(floor(MONTHS_BETWEEN(sysdate, hiredate)),12)||'개월' 개월수
FROM emp
WHERE to_char(hiredate,'YYYY/MM/DD') LIKE '%'||'1980/12/17'||'%';
private date hiredate
private date sysdate

/*   
5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
*/
SELECT *
FROM emp 
WHERE to_char(hiredate, 'Q') in (
		SELECT to_char(hiredate, 'Q') 
		FROM emp 
		WHERE ename LIKE '%'||'SMITH'||'%');
	SELECT * FROM emp;
	

SELECT * FROM EMP e WHERE 
to_char(hiredate,'q') in
(
   SELECT to_char(hiredate,'q') FROM emp 
   WHERE ename  = 'ALLEN'
);

--empno ename job mgr hiredate sal comm deptno

private int empno;
private String ename;
private String job; 
private int mgr;
private DATE hiredate;
private double sal;
private double comm;
private int deptno;

/*
6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
*/
SELECT m.ENAME "관리자",e.ENAME "하위직원", e.EMPNO,e.SAL  
FROM EMP e ,emp m
WHERE e.mgr=m.EMPNO
AND m.ENAME = 'JONES';

private String ename;
private int deptno;
private double sal;
/*

7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
     */ 
	 SELECT deptno, ename
      FROM EMP10 e 
      WHERE to_char(hiredate,'MM')= '02'
      AND deptno = 10;
      
     private int deptno;
     private String ename;
     private date hiredate;
      /*
 */
	 	