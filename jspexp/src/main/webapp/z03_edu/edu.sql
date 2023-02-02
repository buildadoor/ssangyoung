select distinct m.empno, m.ename
from emp100 m , emp e
where e.mgr = m.empno;
/*
 <select name="mgr">
 	<option value="7566">JONES</option>
 	<option value="7582">CLARK</option>
 	<option value="7839">KING</option>
 	<option value="7698">BLAKE</option>
 	<option value="7902">FORD</option>
 </select>
 <select name="deptno">
 	<option value="10">ACCOUNTING</option>	
 	<option value="20">RESERACH</option>	
 	<option value="30">SALES</option>	
 	<option value="40">OPERATIONS</option>	
 	<option value="50">회계</option>	
 	<option value="51">인사</option>	
 	 </select>
 */
SELECT * FROM admin;
SELECT * FROM major;
SELECT * FROM member_s;
SELECT * FROM student;
SELECT * FROM schRecord;
SELECT * FROM notice;
SELECT * FROM lecture;
SELECT * FROM scholarahip;
SELECT * FROM stdLecture;
SELECT * FROM tuition;
SELECT * FROM professor_s;
CREATE TABLE admin(
   adminId varchar2(20) PRIMARY KEY,
   adminPw varchar2(20)
);

UPDATE LECTURE SET lecPlan ='2022_1_lecplan.jpg' WHERE lecNum = '1';
INSERT INTO admin VALUES ('admin1004','manager1004');

CREATE TABLE major(
   majorNo NUMBER PRIMARY KEY,
   majorName varchar2(30)
);=-
SELECT * FROM MAJOR;
--농업생명과학대학
INSERT INTO major VALUES(10,'농산학과');
INSERT INTO major VALUES(11,'바이오섬유소재학과');
INSERT INTO major VALUES(12,'식품자원경제학과');
--사회과학
INSERT INTO major VALUES(20,'문헌정보학과');
INSERT INTO major VALUES(21,'사회학과');
INSERT INTO major VALUES(22,'심리학과');
--사범대
INSERT INTO major VALUES(30,'가정교육과');
INSERT INTO major VALUES(31,'교육학과');
INSERT INTO major VALUES(32,'국어교육과');
--예술대
INSERT INTO major VALUES(40,'국악학과');
INSERT INTO major VALUES(41,'디자인학과');

--공과대
INSERT INTO major VALUES(50,'전자공학과');
INSERT INTO major VALUES(51,'화학공학과');
INSERT INTO major VALUES(52,'컴퓨터공학과');
--인문대
INSERT INTO major VALUES(60,'고고인류학과');
INSERT INTO major VALUES(61,'국어국문학과');
INSERT INTO major VALUES(62,'노어노문학과');
--자연과학
INSERT INTO major VALUES(70,'물리학과');
INSERT INTO major VALUES(71,'수학과');
INSERT INTO major VALUES(72,'통계학과');
--간호대
INSERT INTO major VALUES(80,'간호학과');
--의과대학교 
INSERT INTO major VALUES(90,'의예과');
INSERT INTO major VALUES(91,'의학과');


CREATE TABLE member_s(
   id varchar2(20) PRIMARY KEY,
   password varchar(20),
   code number
);
INSERT INTO MEMBER_S values(20000101,'abc123',2);
--코드 학생1 교수2
ALTER TABLE MEMBER_S MODIFY code NUMBER;
SELECT * FROM MEMBER_S;
INSERT INTO member_s values('20000001','0260',2);
DELETE FROM MEMBER_S;

--농업생명과학대학
INSERT INTO member_s values('20191000','8574',1);
INSERT INTO member_s values('20191001','9657',1);
INSERT INTO member_s values('20191002','0015',1);
INSERT INTO member_s values('20201003','4465',1);
INSERT INTO member_s values('20201004','3652',1);
INSERT INTO member_s values('20201005','9587',1);
INSERT INTO member_s values('20211006','3365',1);
INSERT INTO member_s values('20211007','4452',1);
INSERT INTO member_s values('20211008','9986',1);
INSERT INTO member_s values('20211009','7845',1);
--사회과학
INSERT INTO member_s values('20192000','9512',1);
INSERT INTO member_s values('20192001','7946',1);
INSERT INTO member_s values('20192002','7625',1);
INSERT INTO member_s values('20202003','9635',1);
INSERT INTO member_s values('20202004','7985',1);
INSERT INTO member_s values('20202005','0202',1);
INSERT INTO member_s values('20212006','7451',1);
INSERT INTO member_s values('20212007','9632',1);
INSERT INTO member_s values('20212008','8452',1);
INSERT INTO member_s values('20212009','0301',1);
--사범대학
INSERT INTO member_s VALUES ('20193000','6588',1);
INSERT INTO member_s VALUES ('20193001','3235',1);
INSERT INTO member_s VALUES ('20193002','6698',1);
INSERT INTO member_s VALUES ('20203003','1415',1);
INSERT INTO member_s VALUES ('20203004','8684',1);
INSERT INTO member_s VALUES ('20203005','3516',1);
INSERT INTO member_s VALUES ('20213006','6548',1);
INSERT INTO member_s VALUES ('20213007','3215',1);
INSERT INTO member_s VALUES ('20213008','6944',1);
INSERT INTO member_s VALUES ('20213009','2315',1);
--예술대학
INSERT INTO member_s VALUES ('20194000','6439',1);
INSERT INTO member_s VALUES ('20194001','1513',1);
INSERT INTO member_s VALUES ('20194002','8522',1);
INSERT INTO member_s VALUES ('20204003','4132',1);
INSERT INTO member_s VALUES ('20204004','3262',1);
INSERT INTO member_s VALUES ('20204005','8342',1);
INSERT INTO member_s VALUES ('20214006','0926',1);
INSERT INTO member_s VALUES ('20214007','5723',1);
INSERT INTO member_s VALUES ('20214008','0970',1);
INSERT INTO member_s VALUES ('20214009','0230',1);
--공과대
INSERT INTO member_s VALUES ('20195000','7549',1);
INSERT INTO member_s VALUES ('20195001','8854',1);
INSERT INTO member_s VALUES ('20195002','6947',1);
INSERT INTO member_s VALUES ('20205003','1652',1);
INSERT INTO member_s VALUES ('20205004','3254',1);
INSERT INTO member_s VALUES ('20205005','9984',1);
INSERT INTO member_s VALUES ('20215006','6224',1);
INSERT INTO member_s VALUES ('20215007','3021',1);
INSERT INTO member_s VALUES ('20215008','1214',1);
INSERT INTO member_s VALUES ('20215009','7361',1);
--인문대학
INSERT INTO member_s values('20196000','4545',1);
INSERT INTO member_s values('20196001','7894',1);
INSERT INTO member_s values('20196002','2012',1);
INSERT INTO member_s values('20206003','6595',1);
INSERT INTO member_s values('20206004','1114',1);
INSERT INTO member_s values('20206005','6587',1);
INSERT INTO member_s values('20216006','7895',1);
INSERT INTO member_s values('20216007','3202',1);
INSERT INTO member_s values('20216008','9200',1);
INSERT INTO member_s values('20216009','7846',1);
--자연과학대학
INSERT INTO member_s VALUES ('20197000','1547',1);
INSERT INTO member_s VALUES ('20197001','6685',1);
INSERT INTO member_s VALUES ('20197002','2561',1);
INSERT INTO member_s VALUES ('20207003','9546',1);
INSERT INTO member_s VALUES ('20207004','3215',1);
INSERT INTO member_s VALUES ('20207005','6632',1);
INSERT INTO member_s VALUES ('20217006','9748',1);
INSERT INTO member_s VALUES ('20217007','1238',1);
INSERT INTO member_s VALUES ('20217008','9844',1);
INSERT INTO member_s VALUES ('20217009','6535',1);
--간호대
INSERT INTO member_s VALUES ('20198000','1392',1);
INSERT INTO member_s VALUES ('20198001','3312',1);
INSERT INTO member_s VALUES ('20198002','2417',1);
INSERT INTO member_s VALUES ('20208003','5453',1);
INSERT INTO member_s VALUES ('20208004','2054',1);
INSERT INTO member_s VALUES ('20208005','1301',1);
INSERT INTO member_s VALUES ('20218006','9849',1);
INSERT INTO member_s VALUES ('20218007','3573',1);
INSERT INTO member_s VALUES ('20218008','5326',1);
INSERT INTO member_s VALUES ('20218009','9927',1);
--의과대학
INSERT INTO member_s VALUES ('20199000','8578',1);
INSERT INTO member_s VALUES ('20199001','1302',1);
INSERT INTO member_s VALUES ('20199002','9855',1);
INSERT INTO member_s VALUES ('20209003','7848',1);
INSERT INTO member_s VALUES ('20209004','9595',1);
INSERT INTO member_s VALUES ('20209005','6541',1);
INSERT INTO member_s VALUES ('20219006','7856',1);
INSERT INTO member_s VALUES ('20219007','2587',1);
INSERT INTO member_s VALUES ('20219008','9632',1);
INSERT INTO member_s VALUES ('20219009','0254',1);

SELECT * FROM student WHERE majorNo=52;
CREATE TABLE student(
   id varchar2(20) PRIMARY KEY CONSTRAINT member_s_id_fk4 REFERENCES member_s(id),
   stdName varchar2(30),
   stdYear NUMBER,
   enterYear NUMBER,
   address varchar2(100),
   birthday DATE,
   stdEmail varchar2(100),
   stdPhone varchar2(30),
   status varchar2(20),
   majorNo NUMBER CONSTRAINT major_majorNo_fk REFERENCES major(majorNo)
);
INSERT INTO student VALUES ('20195000','이동동',3,2019,'서울 서교동',sysdate,'pucoca@naver.com','010-1234-1234','재학중',52);
UPDATE student
   SET stdEmail = 'two__yoon@naver.com'WHERE stdName = '이동동';
CREATE TABLE schRecord(
   id  varchar2(20) CONSTRAINT student_id_fk3 REFERENCES student(id),
   rYear NUMBER,
   semester NUMBER,
   grade number
);

CREATE TABLE notice(
   noticeNo NUMBER PRIMARY KEY,
   title varchar2(100),
   contents varchar2(500),
   noticeDate DATE,
   views NUMBER,
   adminId varchar2(20) CONSTRAINTS admin_adminId_fk REFERENCES admin(adminId)
);
INSERT INTO notice values(1,'안녕하세요','안녕여러분환영합니다쌍용대학교입니다',sysdate,3,'admin1004');

CREATE TABLE lecture(
   lecNum NUMBER PRIMARY KEY,
   lecName varchar2(30),
   lecLoc varchar2(30),
   lecPlan varchar2(500),
   lecYear varchar2(30),
   semester varchar2(30),
   grade NUMBER,
   majorNo NUMBER CONSTRAINT major_majorNo_fk3 REFERENCES major(majorNo),
   times varchar2(20),
   sort varchar2(20),
   id varchar(20) CONSTRAINTS member_s_id_fk3 REFERENCES member_s(id),
   class_I NUMBER
);
SELECT fileName FROM tuition WHERE id='20195000';
INSERT INTO tuition(id,FILENAME) values('20195000','tui_20201003.png');
SELECT * FROM stdLECTURE;
UPDATE stdLecture SET attendance = ?, midtest = ?,endtest = ?, total = ? WHERE id = ?
DROP TABLE stdLecture;
DROP TABLE LECTURE;
SELECT * FROM LECTURE;
DELETE  FROM lecture WHERE LECNUM  = 222; --삭제 
INSERT INTO lecture values(12,'실크로드의 이해','국제관203호',null,2022,2,3,20,'월1,2,3','전공선택','20000001');
INSERT INTO lecture values(222,'인사관리론','국제관305호',null,2022,2,3,52,'금123','전공필수','20000001',3);
INSERT INTO lecture values(1321,'인사','국제관305호',null,'2022','2',3,20,'금1,2,3','전공필수','20000001',2);
DELETE FROM lecture WHERE lecNum = 123124 AND lecName ='실크로드의 이해';
UPDATE lecture
   SET LECNAME = ?,
       LECLOC = ?,
       LECYEAR = ?,
       SEMESTER = ?,
       GRADE = ?,
       MAJOR = ?,
       TIMES = ?,
       SORT = ?
   WHERE LECNUM = ?;
  UPDATE lecture
   SET LECNAME = '동북아의 이해',
       LECLOC = '국제관 301호',
       LECYEAR = 2022,
       SEMESTER = 1,
       GRADE = 2,
       MAJOR = '경영학과',
       TIMES = '월1,2',
       SORT = '전공선택'
   WHERE LECNUM = 123123;
 ALTER TABLE LECTURE MODIFY lecYear varchar2(30);
ALTER TABLE LECTURE MODIFY semester varchar2(30);
  
  
CREATE TABLE scholarahip(
   id varchar2(20) CONSTRAINT student_id_fk2 REFERENCES student(id),
   sort varchar2(30),
   schYear NUMBER,
   semester NUMBER,
   amount number
);


CREATE TABLE stdLecture(
   lecNum NUMBER CONSTRAINTS lecture_lecNum_fk REFERENCES lecture(lecNum),
   id varchar2(20) CONSTRAINT student_id_fk REFERENCES student(id),
   attendance NUMBER,
   midtest varchar2(20),
   endtest varchar2(20),
   total NUMBER,
   lecEval varchar2(100)
);
INSERT INTO STDLECTURE values(2023,'20195000',111,'A','A',4,null);
SELECT * FROM STDLECTURE s;
INSERT INTO STDLECTURE values(2023,'20195000',120,'A','A+',4.3,'완벽한 수업');
UPDATE STDLECTURE SET ATTENDANCE = 350 WHERE id = '20195000' AND lecnum = 2023; 
CREATE TABLE tuition(
   id varchar2(20) CONSTRAINT member_s_id_fk REFERENCES member_s(id),
   fileName varchar2(50),
   filePath varchar2(100)
);

CREATE TABLE professor_s(
   id varchar2(20) CONSTRAINTS member_s_id_fk2 REFERENCES member_s(id),
   majorNo NUMBER CONSTRAINT major_majorNo_fk2 REFERENCES major(majorNo),
   proName varchar2(30),
   proEmail varchar2(100),
   proPhone varchar2(30)
);
INSERT INTO PROFESSOR_S VALUES(20000101,20,'이또치','ddochi@ssangyong.com','010-1321-1321');

--삭제순서
DROP TABLE professor_s;
DROP TABLE tuition;
DROP TABLE stdLecture;
DROP TABLE scholarahip;
DROP TABLE lecture;
DROP TABLE notice;
DROP TABLE schRecord;
DROP TABLE student;
DROP TABLE member_s;
DROP TABLE major;
DROP TABLE admin;

ALTER TABLE admin DROP COLUMN adminDept;--컬럼삭제
ALTER TABLE notice MODIFY contents varchar2(2000);
INSERT INTO notice values(8,'2023년-1학기 재입학 신청안내','2023-1학기 재입학에 관한 사항을 붙임과 같이 안내하오니 많은 관심 부탁드립니다.            

1. 신청기간 : (1차) 12.12. (월) ~ 12.23. (금)               (2차) 23.01.16. (월) ~ 01.20. (금)      
2. 신청방법 : 대학 종합정보시스템 로그인 ► 학부학사행정  ► 학적 ►재입학 신청            
3. 재입학 대상 : 제적(자퇴)된 자 (학사징계제적자 제외)          
4. 재입학자 모집 부분 : 최초 입학 당시 입학유형(정원내/외)별로 신청 가능여부가 결정됨 (세부사항은 붙임 참조)        
5. 모집인원 : 총 95명
- 일반계열 정원내 : 84명, 정원외 : 10명
- 의학계열 정원내 : 1명(1학년)    
※ 재입학 미선발 학과 : 사범계열(유아, 특수), 보건계열(임상, 작업), 의학계열(의예,  간호) *모집가능여석 없음    
6. 재입학생 장학금 혜택 : WELCOME BACK 장학금 지원 100만원_생활비성 장학금)
7. 합격자 발표일 : (1차) 23.01.13.(금)              (2차) 23.02.03.(금)    *학과로 문의바랍니다.','2022-12-07',12,'admin1004');