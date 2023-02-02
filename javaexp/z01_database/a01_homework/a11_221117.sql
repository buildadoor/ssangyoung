SELECT * 
FROM salgrade
WHERE grade BETWEEN 1 AND 5;

SELECT * 
FROM MEMBER
WHERE name LIKE '%'||''||'%'
AND auth LIKE '%'||''||'%';