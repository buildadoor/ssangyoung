SELECT *
FROM emp;
--ex1) 부서를 조건으로 부서번호, 사원명, 직책명, 급여를 출력하세요
-- 	sql ==> vo ==> 기능메서드 선언(A04_DaoExp.java)
select deptno, ename, job, sal
from emp
WHERE deptno =10;
-- select : List<VO>, where : 매개변수
-- type과 이름 
/*
private int deptno;
private String name;
private String job;
private double sal;

ex)기능 메서드 선언 : 리턴값, 매개변수 기본 객체 생성
리턴값은 select ==> VO ==> List<VO>
매개변수는 where ==> Vo/int 
public List<Emp01> getSch01(Emp01 sch){

}
또는 
public List<Emp01> getSch01(int deptno){
	List<Emp01> list = new ArrayList<Emp01>();
	return list;
}
*/
-- 사원명(키워드검색), 급여(시작~끝)으로 조건으로
-- 사원번호, 사원명, 급여를 출력하세요. 
SELECT empno, ename, sal
FROM emp
WHERE ename LIKE '%'||'A'||'%'
AND sal BETWEEN 1000 AND 2000; 
/*--select, where 
private int empno;
private String ename;
private double sal;필드생성먼저 
private int frSal;
private int toSal; ename 이랑 같이 또 필드생성 조회

기능메서드
1. 리턴유형
2. 매개변수
private List<Emp02> getSch02(Emp02 sch){
	List<Emp02> list = new ArrayList<Emp02>();
	
	return list;
}
 * */
--ex) 직책(키워드검색) 또는 부서번호를 조건으로 사원번호, 사원명, 직책명, 부서번호를 검색하세요.
SELECT empno, ename, job, deptno
FROM emp 
WHERE job LIKE '%'||''||'%'
OR deptno = 10;


/*
private int empno;
private String ename;
private String job;
private int deptno;

private List<Emp03> getSch03(Emp03 sch){
		List<Emp03> list = new ArrayList<Emp03>();
*/