		select *
		from board
		where 1=1
	SUBJECT 



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