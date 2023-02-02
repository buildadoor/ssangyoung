/*
 #instr(지정한문자열데이터|컬럼,'검색문자')
 1. 특정한 문자열을 검색해서, 해당 문자열의 위치를 index로 반환처리 하는 함수
 	ex) 주로 대용량의 문자열 데이터를 검색해서 해당 문자열의 첫번째
 		위치를 index로 표현해준다.
 2. 추가옵션
 	instr(데이터/컬럼, '검색문자', 시작위치, 검색된 횟수)
*/
SELECT instr('sql*plus','*') sch1,
	   instr('s*ql*plu*s','*',3,1) sch2,
	   instr('s*ql*plu*s','*',3,2) sch3,
	   instr('s*ql*plu*s','#',3,2) sch4
FROM dual;
SELECT * FROM emp;
-- ex)직책을 검색하되 MAN이 있는 것을 검색하고 해당 위치를 이름, 직책,검색위치
--		로 출력하세요.
SELECT ename, job, instr(job,'MAN') 
FROM emp
WHERE instr (job,'MAN')>0;
/*
#lpad(left padding), rpad(right padding)
1. 전체 문자의 크기를 지정하고, 그 크기보다 못할 때, 
	왼쪽/오른쪽에 특정한 문자를 추가하게 처리하는 기능을 말한다.
2. 형식
	lpad(데이터, 크기, 덧붙일문자열) 
	rpad(데이터, 크기, 덧붙일문자열)
ps) 특정한 컬럼을 동일한 자리수를 만들거나 가변형데이터를 고정형데이터로 변경할 때,
	주로 사용된다.
	varchar2(10) ==> char(10) 
	최대크기 			 모든크기 
	himan==>5b		 himan     ==>10b
 */
SELECT lpad('sql',5,'*')show1, rpad('sql',5,'#') show2
FROM dual;
--사원명을 최대크기를 확인한 후, 고정형으로 변환해서 나머지는 *로 추가해서 등록
SELECT max(length(ename)) FROM emp;--최대 크기 6
SELECT ename, rpad(ename,6,'*') "사원명"
FROM emp;
--ex) 사원명은 8자리, 직책명은 최대크기 확인 후 해당 크기로 설정하여
--	사원명을 왼쪽 #기호로, 직책명으로 오른쪽 @기호를 덧붙여 처리하여 출력하세요.
SELECT max(LENGTH(job)) FROM emp;
SELECT   lpad(ename,8,'#') 사원명,rpad(job,9,'@') 직책명
FROM emp;
-- 중첩 함수에 대한 연습
-- 1. 기본 함수 기능 충분히 연습
-- 2. 이전에 했던 함수를 통해 처리할 수 있는 데이터를 상기 및 의문
-- 3. 다양한 문제를 통해서 필요로 하는 중첩함수 처리 ..
/*
 #ltrim/rtrim
 1. trim은 절삭이라는 말로, 오른쪽 또는 왼쪽에 있는 특정한 문자열을 삭제 처리할 때
 	사용된다.
 	1) ltrim(데이터,'제거할문자') : 왼쪽에 제거할 문자를 없애주는데 반복적으로 처리된다.
 	2) rtrim(데이터, '제거할문자') : 오른쪽에 제거할 문자를 없애주는데 반복적으로 처리된다.
 	3) trim('양쪽에삭제할문자' from데이터) :
 		오른쪽/ 왼쪽 끝에 제거할 문자가 있을 때 한번에 제거 처리 한다.
 cf) char 고정형 데이터를 ==> varchar2 가변형 데이터로 변환하여 사용할 때,
 	 주로 사용된다. 
 ex) 웹에서 등록하거나 조회할 때, 자기도 모르게 space를 입력해서 공백이 들어간 경우, 
 	이를 통해 입력된 데이터를 같은 문자가 있더라도 검색이 안되는 경우가 많다.
 	이 때, 프로그램이 sql 처리시 trim()을 해서 등록 또는 검색하면 이러한 데이터가 
 	정상적으로 처리된다.
 	id : [himan]
 	pass : [ ****] 띄어쓰기 
 	
 */
SELECT ltrim('*****sql*****','*') str1,
	   rtrim('*****sql*****','*') str2,
		trim('*' FROM '*****sql*****')str3
FROM dual;
SELECT job, ltrim(job,'S') job1
FROM emp;
--ex) 직책을 기준으로 왼쪽에 S, 오른쪽에 N을 삭제하고 출력하세요.
SELECT job, ltrim(job,'S') job2, rtrim(job,'N') job3,
			rtrim(ltrim(job,'S'),'N') job4			
FROM emp;