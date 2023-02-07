SELECT * FROM board;
INSERT INTO board values(board_seq.nextval,
0, '두번째글','내용','마길동',0, sysdate, sysdate);
/*
 INSERT INTO board values(board_seq.nextval,
#{refno}, #{subject}, #{content},#{writer},0, sysdate, sysdate)
*/