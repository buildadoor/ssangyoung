/*
 2022-09-30
[1단계:개념] 1. 그룹함수의 기본형식을 예제를 통해 설명하세요 
 	테이블의 전체 행을 하나 이상의 컬럼을 기준으로 그룹화하여 그룹별로
 	결과를 출력하는 함수 , 그룹함수는 통계적인 결과를 출력하는데 많이 사용된다.
 	select 기준컬럼, 그룹함수(컬럼)
 	from 테이블명
 	[where]
 	group by 그룹컬럼
 	having 그룹함수를 적용한 결과를 조건 처리
 */
SELECT job,  min(sal) 월급
FROM emp 
GROUP BY job 
HAVING min(sal) >= 2000;
/*
[1단계:개념] 2. 그룹함수의 종류를 기술하세요.
 	1) count()	  : null을 제외한 데이터의 건수, 행의 갯수
 	2) max() 	  : null을 제외한 모든 행의 최대값
 	3) min()	  : null을 제외한 모든 행의 최솟값
 	4) sum()   	  : null을 제외한 모든 행의 합
 	5) avg() 	  : null을 제외한 모든 행의 평균값 
 	6) stddev()   : null을 제외한 모든 행의 표준편차 
 	7) variance() : null을 제외한 모든 행의 분산 값
 	
[1단계:코드] 3. 직책별 가장에 최근에 입사한 사원의 입사일을 출력하세요.
*/
SELECT job, max(hiredate) "최근에 입사한 사원"
FROM emp
GROUP BY job
ORDER BY job;
/*
[1단계:코드] 4. 직책별 평균급여가 2000이상인 경우를 출력하세요.
*/
SELECT job, round(avg(sal)) "2000이상 평균 급여"
FROM emp
GROUP BY job
Having avg(sal) >=2000;
/*
[1단계:코드] 5. 월별로 가장 급여가 낮은 급여를 출력하세요.
*/
SELECT to_char(hiredate,'MM')월, min(sal)"가장 낮은 급여"
FROM emp 
GROUP BY to_char(hiredate,'MM')
ORDER BY 월;
/*

[1단계:코드] 6. 사원번호가 짝수/홀수를 청/홍팀으로 나누고 청/홍팀 평균급여와 사원수를 출력하세요.
Decode부분 전체를 그룹바이 코드 옆에 붙이고 실행해보세요!!^^~
*/
--SELECT ename, decode(mod(empno,2),0,'홍팀', '청팀')팀, avg(sal)
--FROM emp
--decode(mod(empno,2),0,'홍팀', '청팀')GROUP BY;

/*
[1단계:코드] 7. 분기별, 입사 사원수의 수가 2명이상인 분기기준으로 분기 별의 최고 급여를 출력하세요.
*/
SELECT to_char(hiredate,'Q')분기,  max(sal) 최고급여
FROM emp 
GROUP BY to_char(hiredate,'Q')
HAVING  count(to_char(hiredate,'Q'))>=2;
/*

[1단계:개념] 8. 테이블의 조인의 기본 형식을 기술하세요.
 	select 테이블1. 컬럼명, 테이블2.컬럼명,...
 	from 테이블1, 테이블2
 	where 테이블1.공통컬럼 = 테이블2. 공통컬럼
 	
 	1) from : 조인 대상 테이블을 기술한다. 테이블은 콤마(,)로 구분한다.
 	2) where : 조인 애트리뷰트와 '='연산자를 활용하여 조인 조건을 기술
 	-기타 조건에 대한 설정을 and 조건으로 연결하여 처리한다.
*/
/*

[1단계:코드] 9. 입사일이 2~5월 사이인 사원의 부서명, 사원명, 입사일을 출력하세요
*/
SELECT  dname, ename, hiredate
FROM emp e, dept d
WHERE e.deptno = d.deptno 
AND to_char(hiredate,'MM')=2 OR
	to_char(hiredate,'MM')=3 OR 
	to_char(hiredate,'MM')=4 OR 
	to_char(hiredate,'MM')=5 --이렇게 나열해서 쓰는게 맞는지 여부 
ORDER BY hiredate;
/*

[1단계:코드] 10. 1/4분기에 입사하고, 연봉이 1000이상인 사원의 사원명, 
      입사일, 입사분기, 부서명, 부서위치를 출력하세요
*/
SELECT ename 사원명, hiredate 입사일, dname 부서명, loc 부서위치
FROM emp e, dept d
WHERE e.deptno = d.deptno 
AND to_char(hiredate,'Q')=1 AND  
	sal>=1000;
/*
[1단계:코드] 11. 부서위치(LOC)별, 최고 급여가 2000이상인 경우를 출력하세요.
*/
SELECT loc, max(sal) "최고 급여 2000이상"
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND sal>=2000
GROUP BY loc;
/*
== 평가대비(데이터베이스) 객관식 문제 ==
1. 어떤 데이터 모델로 데이터를 저장하는지를 나타내는 NoSQL의 종류가 아닌 것은?
1) 키-값(key-value) 데이터베이스
2) 문서 기반(document-based) 데이터베이스
3) 인덱스 기반(index-based) 데이터베이스
4) 컬럼 기반(column-based) 데이터베이스
정답==>3
NoSQL 어떤 데이터 모델로 데이터를 저장하는지에 따라 나누는 4가지는 
- 키-값 데이터베이스
- 문서기반 데이터베이스
- 컬럼기반 데이터베이스
- 그래프기반 데이터베이스

2. NoSQL 데이터의 특징이 아닌 것은?
1) ACID(원자성, 일관성, 격리성, 지속성)를 위한 트랜잭션 기능을 제공
2) 빠른 속도로 생성되는 대량의 비정형 데이터를 저장하고 처리 
3) 저렴한 비용으로 여러 대의 컴퓨터에 데이터를 분산∙저장∙처리 
4) 대부분 오픈 소스로 제공
정답==>1
빠른 속도로 생성되는 대량의 비정형 데이터를 저장하고 처리하기위해
ACID 트랜잭션 기능을 제공하지 않는 대신 저렴한 비용으로 여러 대의 컴퓨터에 데이터를
분산,저장,처리하는 것이 가능하다 

3. 해당하는 분석기술이 맞게 매칭된 것은 무엇인가?
1) 텍스트 마이닝(text mining) - SNS, 블로그, 게시판 등에 기록된 사용자들의 의견을 수집
2) 오피니언 마이닝(opinion mining) - 제품이나 서비스에 대한 긍정, 부정, 중립 등의 선호도를 추출
3) 소셜 네트워크 분석(social network analysis) - 반정형 또는 비정형 텍스트에서 자연어 처리 기술
4) 군집 분석(cluster analysis) - 네트워크에 나타난 영향력, 관심사, 성향, 행동 패턴 등을 추출
정답==>2
1) 오피니언 마이닝 3)텍스트 마이닝 4)소셜 네트워크 분석 

4. 빅데이터의 기본 특징가 3V이 아닌 것은?
1) Volume
2) Velocity
3) Veracity
4) Veriety
정답==>3
3) Veracity은 빅데이터의 확장된 특징이다.

정답:3,1,2,3
 */