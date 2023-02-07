		create table filerep(
			no NUMBER,
			title varchar2(100),
			path varchar2(500),
			tempfile varchar2(100),
			fname varchar2(100),
			etc varchar2(200),
			regte date,
			uptdte date
		);
		create sequence file_seq
			start with 1000
			minvalue 1000;
		insert into filerep values(file_seq.nextval,'첨부파일','경로..',
		'file'||file_seq.currval, 
		'a01.text','',sysdate,sysdate);
		select * from filerep
		where title like '%'||''||'%';