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

CREATE TABLE admin(
   adminId varchar2(20) PRIMARY KEY,
   adminDept varchar2(30),
   adminPw varchar2(20)
);

INSERT INTO admin values('admin1004', '행정관리부', 'admin');
SELECT *
FROM admin;
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
DELETE FROM member_s;
-- 교수
INSERT INTO member_s values('HGD1000','1000',2);
INSERT INTO member_s values('KGD1001','1001',2);
SELECT *
FROM member_s;
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
INSERT INTO member_s values('20191000','8574',1);
INSERT INTO member_s values('20191001','9657',1);
INSERT INTO member_s values('20191002','0015',1);
INSERT INTO student values('20191000','강호동',2, 2021, '', '', '', '', '', 10);
INSERT INTO student values('20191001','유재석',1, 2022, '', '', '', '', '', 10);
INSERT INTO student values('20191002','이수근',3, 2020, '', '', '', '', '', 10);
INSERT INTO member_s values('20192000','9512',1);
INSERT INTO member_s values('20192001','7946',1);
INSERT INTO member_s values('20192002','7625',1);
INSERT INTO student values('20192000','김종국',2, 2021, '', '', '', '', '', 20);
INSERT INTO student values('20192001','이광수',1, 2022, '', '', '', '', '', 20);
INSERT INTO student values('20192002','송지효',3, 2020, '', '', '', '', '', 20);
INSERT INTO member_s VALUES ('20193000','6588',1);
INSERT INTO member_s VALUES ('20193001','3235',1);
INSERT INTO member_s VALUES ('20193002','6698',1);
INSERT INTO student values('20193000','지석진',2, 2021, '', '', '', '', '', 30);
INSERT INTO student values('20193001','전소민',2, 2021, '', '', '', '', '', 30);
INSERT INTO student values('20193002','양세찬',2, 2021, '', '', '', '', '', 30);
INSERT INTO member_s VALUES ('20194000','6439',1);
INSERT INTO student values('20194000','김구라',2, 2021, '', '', '', '', '', 40);

SELECT s.id, stdName, majorName, stdYear
FROM STUDENT s, MAJOR m, STDLECTURE s2
WHERE s.MAJORNO = m.MAJORNO
AND s.id = s2.id
AND LECNUM=1;

SELECT s.id, stdName, majorName
FROM STUDENT s, MAJOR m
WHERE s.MAJORNO = m.MAJORNO
AND id = '20191000';

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

SELECT *
FROM notice;
CREATE SEQUENCE noticeNo1_seq
	INCREMENT BY 1
	START WITH 1
	MINVALUE 1
	MAXVALUE 9999;

CREATE TABLE lecture(
   lecNum NUMBER PRIMARY KEY,
   lecName varchar2(30),
   lecLoc varchar2(30),
   lecPlan varchar2(500),
   lecYear varchar2(30),
   semester varchar2(30),
   grade NUMBER,
   times varchar2(20),
   sort varchar2(20),
   class_I NUMBER,
   id varchar(20) CONSTRAINTS member_s_id_fk3 REFERENCES member_s(id),
   majorNo NUMBER CONSTRAINTS major_majorNo_fk3 REFERENCES major(majorNo)
);
INSERT INTO lecture VALUES (1, 'JAVA', '공대3호관 13450', '', '2022', '1', 3, '09:00~11:00', '전공', 3, 'HGD1000', 10);
INSERT INTO lecture VALUES (2, 'JS', '공대3호관 13450', '', '2022', '2', 3, '컴퓨터공학과', '14:00~16:00', '전공', 'HGD1000');
INSERT INTO lecture VALUES (3, 'JAVA SPRING', '공대3호관 13450', '', '2021', '2', 3, '컴퓨터공학과', '15:00~17:00', '전공', 'HGD1000');
INSERT INTO lecture VALUES (10, 'JSP', '공대3호관 13450', '', '2020', '2', 3, '컴퓨터공학과', '15:00~17:00', '전공', 'KGD1001');
INSERT INTO lecture VALUES (11, '알고리즘', '공대3호관 13450', '', '2022', '2', 3, '컴퓨터공학과', '15:00~17:00', '전공', 'KGD1001');
INSERT INTO lecture VALUES (12, 'HTML', '공대3호관 13450', '', '2021', '1', 3, '컴퓨터공학과', '15:00~17:00', '전공', 'KGD1001');
SELECT *
FROM lecture;
SELECT lecNum, lecYear, semester, lecName, sort
FROM lecture
WHERE id='HGD1000';
DROP TABLE lecture;
DELETE FROM lecture
WHERE sort = '전공';

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
   midtest number,
   endtest number,
   total varchar2(20),
   lecEval varchar2(500)
);
INSERT INTO stdLecture values(1,'20191000',0, 0, 0, '', '없다.');
INSERT INTO stdLecture values(1,'20191001',0, 0, 0, '', '과제가 너무 좋았음.');
INSERT INTO stdLecture values(1,'20191002',0, 0, 0, '', '한 학기동안 고생하셨습니다!!');
INSERT INTO stdLecture values(2,'20192000',0, 0, 0, '', '매우 유익한 수업이었습니다. 항상 밝고 재밌는 수업해주셔서 감사드립니다.');
INSERT INTO stdLecture values(2,'20192001',0, 0, 0, '', '지루하지 않아서 좋았습니다.');
INSERT INTO stdLecture values(2,'20192002',0, 0, 0, '', '열정적인 강의👍👍');
INSERT INTO stdLecture values(10,'20193000',0, 0, 0, '', '매우 유익한 수업이었습니다. 항상 밝고 재밌는 수업해주셔서 감사드립니다.');
INSERT INTO stdLecture values(10,'20193001',0, 0, 0, '', '지루하지 않아서 좋았습니다.');
INSERT INTO stdLecture values(10,'20193002',0, 0, 0, '', '열정적인 강의👍👍');
SELECT *
FROM stdLecture;
DROP TABLE STDLECTURE;
INSERT INTO stdLecture(lecNum, id, attendance, midtest, endtest, total) 
values(?, ?, ?, ?, ?, ?)

SELECT *
FROM stdLecture
WHERE lecNum = 2;

SELECT attendance, midtest, endtest, total
FROM stdLecture
WHERE id = '20191000';

SELECT s.id, stdName, majorName, attendance, midtest, endtest, total
FROM STUDENT s , MAJOR m, STDLECTURE s2 
WHERE s.MAJORNO = m.MAJORNO
AND s.id = s2.id
AND s.id = '20191000';

SELECT id, stdName, majorName
FROM STUDENT s , MAJOR m 
WHERE s.MAJORNO = m.MAJORNO 
AND id = '20191000';

-- 성적 입력/수정
SELECT * FROM STDLECTURE s ;
UPDATE stdLecture
SET attendance = 28,
	midtest = 'A+',
	endtest = 'A+',
	total = 4.5,
	id='20195000',
	LECEVAL ='최고의 강의'
WHERE LECNUM = '2023';
DELETE FROM STDLECTURE s 
WHERE total = 4.5;
-- 성적 삭제(초기화)
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
INSERT INTO professor_s values('HGD1000',10,'홍길동','HGD1000@naver.com','010-1111-2222');
INSERT INTO professor_s values('KGD1001',20,'김길동','KGD1000@naver.com','010-1234-5678');
SELECT *
FROM professor_s
WHERE id = 'HGD1000';
