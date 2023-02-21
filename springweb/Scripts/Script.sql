  create table calendar01(
   		  id number primary key,
		  title varchar2(100),
		  start01 varchar2(50),
		  end01 varchar2(50),
		  writer varchar2(50),
		  content varchar2(500),
		  backgroundColor varchar2(20), 
		  textColor varchar2(20),
		  allDay number(1), 
		  url varchar2(500)
   );
create sequence cal01_seq
start with 1
minvalue 1;
INSERT INTO CALENDAR01 values(cal01_seq.nextval, '첫번째 일정 등록',
'2023-02-16T09:00:00','2023-02-16T23:00:00','이윤아','프로젝트 회의','#8A084B','#F8E0E6',1,'www.naver.com');
SELECT * FROM CALENDAR01;