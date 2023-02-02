SELECT DISTINCT e.mgr code, e.ename val
FROM emp100 e, emp100 m
WHERE e.mgr = m.empno
ORDER BY code;
SELECT deptno code, dname val
FROM dept100
ORDER BY code;

