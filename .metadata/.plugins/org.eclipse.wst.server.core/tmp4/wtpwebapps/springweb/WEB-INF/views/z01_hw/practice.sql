SELECT DISTINCT e.mgr code, e.ename val
FROM emp100 e, emp100 m
WHERE e.mgr = m.empno
ORDER BY code;

SELECT deptno code, dname val
FROM dept100
ORDER BY code;

INSERT INTO emp100 values(1001,'마길동','부장',7839,sysdate,7000,1000,10);
INSERT INTO emp100 values(1002,'마동석','차장',1001,sysdate,6000,1000,10);

SELECT losal code, grade val 
FROM salgrade;
SELECT * FROM salgrade;