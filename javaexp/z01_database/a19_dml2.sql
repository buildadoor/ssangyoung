SELECT * FROM emp10;
INSERT INTO emp10(empno) values(9002);
--transaction기능에 의해 commit하기전에 rollback에 의해 원복가능 
-- commit전에 접속종료나 외부에 다른 곳에서 계정접속하면 dml
-- 처리가 되지 않는 것을 확인할 수 있다.