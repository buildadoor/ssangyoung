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
SELECT * FROM emp01;

CREATE TABLE admin(
   adminId varchar2(20) PRIMARY KEY,
   adminPw varchar2(20)
);

INSERT INTO admin values('admin1004','manager1004');

CREATE TABLE major(
   majorNo NUMBER PRIMARY KEY,
   majorName varchar2(30)
);
SELECT * FROM major;
--농업생명과학대학 학과
INSERT INTO major VALUES(10,'농산학과');
INSERT INTO major VALUES(11,'바이오섬유소재학과');
INSERT INTO major VALUES(12,'식품자원경제학과');
--사회과학대학 학과
INSERT INTO major VALUES(20,'문헌정보학과');
INSERT INTO major VALUES(21,'사회학과');
INSERT INTO major VALUES(22,'심리학과');
--사범대학 학과
INSERT INTO major VALUES(30,'가정교육과');
INSERT INTO major VALUES(31,'교육학과');
INSERT INTO major VALUES(32,'국어교육과');
--예술대학 학과
INSERT INTO major VALUES(40,'국악학과');
INSERT INTO major VALUES(41,'디자인학과');
INSERT INTO major VALUES(42,'미술학과');
--공과대학 학과
INSERT INTO major values(50,'전자공학과');
INSERT INTO major values(51,'화학공학과');
INSERT INTO major values(52,'컴퓨터공학과');
--인문대학 학과
INSERT INTO major values(60,'고교인류학과');
INSERT INTO major values(61,'국어국문학과');
INSERT INTO major values(62,'노어노문학과');

--자연과학대학 학과
INSERT INTO major values(70,'물리학과');
INSERT INTO major values(71,'수학과');
INSERT INTO major values(72,'통계학과');

--간호대학 학과
INSERT INTO major values(80,'간호학과');

--의과대학 학과
INSERT INTO major values(90,'의예과');
INSERT INTO major values(91,'의학과');


CREATE TABLE member_s(
   id varchar2(20) PRIMARY KEY,
   password varchar(20),
   code number
);
SELECT * FROM MEMBER_S;
DELETE FROM member_s;
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

--사회과학대학
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
INSERT INTO member_s VALUES ('20223010','7815',1);

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
--공과대학
INSERT INTO member_s values('20195000','7549',1);
INSERT INTO member_s values('20195001','8854',1);
INSERT INTO member_s values('20195002','6947',1);
INSERT INTO member_s values('20205003','1652',1);
INSERT INTO member_s values('20205004','3254',1);
INSERT INTO member_s values('20205005','9984',1);
INSERT INTO member_s values('20215006','6224',1);
INSERT INTO member_s values('20215007','3021',1);
INSERT INTO member_s values('20215008','1214',1);
INSERT INTO member_s values('20215009','7361',1);
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

--간호대학
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
INSERT INTO student values('20223010','박민정',2,2022,'서울 금천구','2003-01-24',
	'abc123@ssangyong.com','010-8547-7815','재학',30); -- 사범대학/가정교육학과
	INSERT INTO student values('20201003','김민수',4,2020,'서울 홍대','2001-05-26',
	'kkj898@ssangyong.com','010-8579-4465','재학',10); -- 농산학과
SELECT * FROM STUDENT s;
DELETE FROM STUDENT s;

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
ALTER TABLE notice MODIFY contents varchar2(2000);
ALTER TABLE notice MODIFY noticeDate varchar2(30);
DELETE from notice WHERE NOTICENO =2;
INSERT INTO notice values(1,'2023년-1학기 재입학 신청안내','2023-1학기 재입학에 관한 사항을 붙임과 같이 안내하오니 많은 관심 부탁드립니다.            

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
INSERT INTO notice values(2,'2023년 2월 학사학위취득유예(졸업유예)신청안내','2023년 2월 졸업예정자 중 학사학위취득유예(졸업유예)을 희망하는 학생은 다음과 같이 기간 내 신청하여 주시기 바랍니다.        

                                                      - 다           음 -        
▣ 학사학위취득유예 제도란?        
- 졸업요건을 모두 총족하여 해당학기에 졸업이 가능하나, 학생 본의의 의사로 졸업을 연기하는 제도        
- 교과과정(주전공, 복수전공)를 이수하지 못해 학업 연장을 하는 ‘졸업연장’과는 다른 제도임        
- 수료자는 학사학위취득유예를 신청할 수 없음        
1. 신청자격 : 졸업학점 이수 및 졸업평가(종합시험/논문/작품등), 다면적졸업인증에 합격한 자        
2. 신청 및 취소기간 : 23. 1. 9.(월) ~ 1. 13.(금)        
3. 신청방법 : 온라인 신청        
                (학교홈페이지-포털사이트 -학사인트라넷-학부학사행정-학사학위취득유예(졸업유예)신청)        
5. 취소방법 : 취소신청서를 작성하여 이메일 제출        
            (E-mail : gyomu@sch.ac.kr)        
6. 기타사항          
1) 학사학위취득유예 "승인" 후 취소는 불가함(취소 신청기간에만 가능)      
2) 교직이수자는 학사학위취득유예 신청이 불가하나, 교직 포기 후 졸업요건 충족시에는 신청가능        
3) 졸업종합시험 및 다면적졸업인증 미통과자는 학사학위취득유예 신청이 불가함        
4) 학사학위취득유예 기간은 1개 학기 단위로 2회(1년)까지 가능        
5) 학사학위취득 유예학기 수강신청이 불가함        
6) 학사학위취득유예자는 수료증명서 및 졸업예정증명서를 발급받을 수 있음        
   단, 졸업예정증명서는 학위수여식 이후 발급가능        
7) 이외 사항은 학사팀(041-530-1531/1532)으로 문의하기 바랍니다.','2022-12-15',20,'admin1004');
SELECT noticeNo,title,NOTICEDATE,VIEWS FROM notice WHERE title LIKE '%'||'재'||'%';
SELECT noticeNo,title,NOTICEDATE,VIEWS FROM notice WHERE contents LIKE '%'||'재입학'||'%';
CREATE TABLE lecture(
   lecNum NUMBER PRIMARY KEY,
   lecName varchar2(30),
   lecLoc varchar2(30),
   lecPlan varchar2(500),
   lecYear NUMBER,
   semester NUMBER,
   grade NUMBER,
   times varchar2(20),
   sort varchar2(20),
   id varchar(20) CONSTRAINTS member_s_id_fk3 REFERENCES member_s(id), --교수id
   class_l NUMBER, --학년
   majorNo NUMBER CONSTRAINT major_majorNo_fk3 REFERENCES major(majorNo)
);
ALTER TABLE lecture RENAME COLUMN class_1 TO class_l;
SELECT * FROM lecture;
ALTER TABLE lecture ADD class NUMBER;
ALTER TABLE lecture DROP COLUMN major;
ALTER TABLE lecture ADD majorNo CONSTRAINT major_majorNo_fk3 REFERENCES major(majorNo);
DELETE FROM lecture;
INSERT INTO lecture values(000123,'강의1','강의실1','강의계획서1',2022,1,2,'월12','전공','20191000',1,10);
INSERT INTO lecture values(000256,'강의2','강의실2','강의계획서2',2022,1,3,'월12','교양','20191001',2,11);
INSERT INTO lecture values(000278,'강의3','강의실3','강의계획서3',2022,1,2,'월34','전공','20191002',3,12);
INSERT INTO lecture values(000754,'강의4','강의실4','강의계획서4',2022,1,2,'월34','전공','20201003',3,10);
INSERT INTO lecture values(000446,'강의5','강의실5','강의계획서5',2022,2,1,'화56','전공','20192000',3,20);
INSERT INTO lecture values(000784,'강의6','강의실6','강의계획서6',2022,2,3,'수56','전공','20192001',3,20);
INSERT INTO lecture values(000102,'강의7','강의실7','강의계획서7',2022,2,2,'목67','전공','20192002',4,21);
INSERT INTO lecture values(000321,'강의8','강의실8','강의계획서8',2022,2,3,'금67','교양','20202003',1,21);
INSERT INTO lecture values(000951,'강의9','강의실9','강의계획서9',2022,2,2,'수78','전공','20202004',2,22);
INSERT INTO lecture values(000451,'강의10','강의실10','강의계획서10',2022,2,2,'수78','전공','20193000',2,30);
INSERT INTO lecture values(000226,'강의11','강의실11','강의계획서11',2022,2,2,'수67','전공','20193001',2,31);


SELECT lecNum,majorName,class,sort,lecName,lecLoc,times,grade from
(SELECT lecNum,majorName,class,sort,lecName,lecLoc,times,grade FROM lecture l,major m WHERE l.majorNo=m.majorNo)
WHERE majorName LIKE '%'||'농산학과'||'%' AND class='3';

SELECT lecName,lecLoc,l.times,substr(times,1,1) DAY,substr(times,2,1) t01,substr(times,3,1) t02 FROM lecture l,STDLECTURE s  
WHERE l.lecNum=s.lecNum AND s.id='20195000';
SELECT times FROM lecture l,STDLECTURE s  
WHERE l.lecNum=s.lecNum AND s.id='20195000';

SELECT lecNum,majorName,class_l,sort,lecName,lecLoc,times,grade FROM lecture l,major m WHERE l.majorNo=m.majorNo;
SELECT lecNum,majorName,class_l,sort,lecName,lecLoc,times,grade FROM 
lecture l,major m WHERE l.majorNo=m.majorNo AND sort='전공' AND lecName LIKE '%'||'3'||'%';

SELECT l.lecNum,majorName,class_l,sort,lecName,lecLoc,times,grade FROM
lecture l,major m,STDLECTURE s  WHERE l.majorNo=m.majorNo AND s.LECNUM = l.LECNUM AND s.id='20191000';


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
SELECT * FROM STDLECTURE;
DELETE FROM STDLECTURE;


DELETE from stdlecture WHERE id='20193000' AND lecNum=226;


SELECT lecNum,id FROM STDLECTURE WHERE id='20193000';
--수강 시간 중복 체크 
SELECT a.t01,a.t02 from
(SELECT substr(l.times,1,2) t01, concat(substr(l.times,1,1),substr(l.times,3,1)) t02, l.times,sl.id,l.lecNum 
FROM STDLECTURE sl, LECTURE l
WHERE sl.LECNUM = l.LECNUM AND sl.id='20191000' AND times LIKE '%'||'수78'||'%') a 
WHERE a.id='20191000' AND a.times='수78' or a.lecNum='123';


SELECT substr(l.times,1,2) t01, concat(substr(l.times,1,1),substr(l.times,3,1)) t02, l.times,sl.id,l.lecNum 
FROM STDLECTURE sl, LECTURE l
WHERE sl.LECNUM = l.LECNUM AND sl.id='20191000';

-- 수강신청 유효성 체크 --
SELECT a.lecNum,a.t01,a.t02 from
(SELECT substr(l.times,1,2) t01, concat(substr(l.times,1,1),substr(l.times,3,1)) t02, l.times,sl.id,l.lecNum 
FROM STDLECTURE sl, LECTURE l
WHERE sl.LECNUM = l.LECNUM AND sl.id='20191000') a WHERE a.lecNum='226' OR a.t01=substr('수67',1,2) 
OR a.t02=substr('수67',1,2)
OR a.t01=concat(substr('수67',1,1),substr('수67',3,1))
OR a.t02=concat(substr('수67',1,1),substr('수67',3,1));

SELECT a.lecNum,a.t01,a.t02,a.majorName from
(SELECT substr(l.times,1,2) t01, concat(substr(l.times,1,1),substr(l.times,3,1)) t02, l.times,sl.id,l.lecNum,m.MAJORNAME  
FROM STDLECTURE sl, LECTURE l, major m, student s
WHERE sl.LECNUM = l.LECNUM AND s.majorNo = m.majorNo  AND l.majorNo = m.MAJORNO AND sl.id='20191000')a 
WHERE a.lecNum='226' OR a.t01=substr('수67',1,2) 
OR a.t02=substr('수67',1,2)
OR a.t01=concat(substr('수67',1,1),substr('수67',3,1))
OR a.t02=concat(substr('수67',1,1),substr('수67',3,1))
OR a.majorName not LIKE '%'||'농산학과'||'%';


SELECT substr(l.times,1,2) t01, concat(substr(l.times,1,1),substr(l.times,3,1)) t02, l.times,sl.id,l.lecNum,m.MAJORNAME  
FROM STDLECTURE sl, LECTURE l, major m, student s
WHERE sl.LECNUM = l.LECNUM AND s.majorNo = m.majorNo  AND l.majorNo = m.MAJORNO AND sl.id='20191000';

SELECT * FROM Student s , major m WHERE s.MAJORNO = m.MAJORNO;

INSERT INTO stdLecture(id,lecNum) values('20191000',451);
INSERT INTO stdLecture(id,lecNum) values('20191000',226);
INSERT INTO stdLecture(id,lecNum) values('20191000',951);

SELECT times,l.LECNAME FROM lecture l,STDLECTURE s WHERE l.lecNum=s.lecNum AND s.id='20191000';


DELETE FROM STDLECTURE;
DROP TABLE STDLECTURE;
INSERT INTO stdLecture(id,lecNum) values(
	SELECT lecNum, id FROM LECTURE WHERE lecNum=?
);
SELECT * FROM LECTURE;

DELETE FROM STDLECTURE;
SELECT s.lecNum,l.lecName FROM LECTURE l ,STDLECTURE s WHERE l.LECNUM = s.LECNUM;

CREATE TABLE tuition(
   id varchar2(20) CONSTRAINT member_s_id_fk REFERENCES member_s(id),
   fileName varchar2(50),
   filePath varchar2(100)
);
SELECT fileName FROM tuition WHERE id='20195000';
DELETE FROM tuition WHERE id='20191000';

INSERT INTO tuition(id,FILENAME) values('20201003','tui_20201003.png');
CREATE TABLE professor_s(
   id varchar2(20) CONSTRAINTS member_s_id_fk2 REFERENCES member_s(id),
   majorNo NUMBER CONSTRAINT major_majorNo_fk2 REFERENCES major(majorNo),
   proName varchar2(30),
   proEmail varchar2(100),
   proPhone varchar2(30)
);