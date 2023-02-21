	select * from member
			where id = 'himan'
			and pass = '7777';
		
merge into boardfile  a
	     using (SELECT '${fname}' fname, ${no} NO, '${etc}' subject  FROM dual) b
	        on (a.no = b.no)
	      when matched then    
		update set fname = b.fname,
				uptdte = sysdate
		  when not matched then
			insert values(b.no, 
					b.fname,b.subject,sysdate,sysdate);		
	/*	
--동적 query와 preparedstatement 처리 mapping데이터
--1. 동적 query
--	sql을 임의로 만들때, 사용한다.
--	mybatis에서는 ${동적데이터}
--  sql"%"+검색데이터+"%" 
		select ename="+alias+"
		where 1=1"
		if(ename!=null)
		sql += "ename='홍길동'"
		
				
				
--2. preparedstatement 처리 mapping데이터
-- 컬럼명을 지정한 입력데이터 일 때, 사용된다.
-- #{매핑할 데이터}
-- sql where ename= ? 		
SELECT '${fname}' fname, ${NO} NO, '${etc}' subject FROM dual	
		*/
		
	SELECT '파일명' fname, ${NO} NO, '25' subject FROM dual;
--dao의 매개변수를 통해 넘겨온 데이터와 boardfile 테이블의 내용을 비교해서
-- 해당 no번호가 있으면 update 처리 없으면 insert처리 


-- rownum : 데이터를 1부터 리스트 처리, 
-- level : 계층형 sql 레벨 처리(답글레벨)
select rownum cnt, LEVEL, b.*
from board b
where 1=1
START WITH refno=0
CONNECT BY PRIOR NO = refno
ORDER siblings BY NO desc;	
DELETE FROM board WHERE NO=9;
SELECT * FROM board;
--최상위 글 desc 포함된 하위글을 바로 나오게 하면서 desc
 SELECT * FROM board;
		select *
		from(
			select rownum cnt, level, b.*
			from board b
			where 1=1
			START WITH refno=0
			CONNECT BY PRIOR NO = refno
			ORDER siblings BY NO desc)
	where cnt between 5 and 19;





SELECT * from board; 
 DELETE  FROM board WHERE no  = 21; --삭제 
  DROP TABLE board;
   create table board(
      no number primary key,
      refno number,
      subject varchar2(200),
      content varchar2(2000),
      writer varchar2(100),
      readcnt number,
      regdte date,
      uptdte date
   );
   DROP sequence board_seq;
   create sequence board_seq
      start with 1
      minvalue 1
      maxvalue 999999
      nocache
      increment by 1;
   --sample 데이터 등록
   insert into board values(
   board_seq.nextval,0,'두번째글','내용','마길동',0, sysdate, sysdate);   
  alter sequence board_seq nocache;
  
    select * 
    from board 
    WHERE 1=1
    AND subject LIKE '%'||''||'%'
    AND writer LIKE '%'||''||'%'
    order by regdte desc;
   
SELECT * FROM board 
WHERE NO =1; 
UPDATE board 
	SET READCNT = readcnt+1
WHERE NO = 1;
/*
SELECT * FROM board 
	WHERE NO = #{no} 
	UPDATE board 
SET READCNT = readcnt+1
	WHERE NO = #{no}
 */

	 create table boardfile(
      	 	no number,
      	 	fname varchar2(500),
      	 	etc varchar2(500),
      	 	regdte date, 
      	 	uptdte date
      	 );
    --  sql 작성
		insert into boardfile values(board_seq.nextval,
		'a01.text','파일등록',sysdate,sysdate);
		insert into boardfile values(1,
		'a02.text','파일등록',sysdate,sysdate);
		select fname
		from boardfile
		where no = 1;

SELECT * FROM emp;
select * from emp
start with mgr = null
connect by prior empno = mgr;


SELECT LEVEL, mgr, e.*
FROM emp e 
START WITH mgr = 7839
CONNECT BY PRIOR empno = mgr;