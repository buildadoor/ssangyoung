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
private date hiredate,
private double sal;
private String div;//분기  
 
*/
--3)기능메서드 
/*
private List<Emp04> getSch03(Emp04 sch){
		List<Emp04> list = new ArrayList<Emp04>();
*/