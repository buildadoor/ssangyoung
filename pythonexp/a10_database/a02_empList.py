'''
Created on 2023. 1. 4.

@author: LeeYoonAh
'''
# ex) a02_empList.py를 만들어서 사원 정보 리스트 출력하세요.
import cx_Oracle as oci
conn = oci.connect("scott/tiger@localhost:1521/xe")
if conn != None:
    print("연결 성공! 버전:", conn.version)
cursor = conn.cursor()
ename = input("검색할 사원명을 입력하세요(키워드):")
sql = """
select *
from emp
where ename like '%'||'{}'||'%'
""".format(ename)
cursor.execute(sql)
empDup = cursor.fetchall()
empList = []
for emp in empDup:
    empList.append(list(emp))
    # 튜플(읽기) ==> 리스트(읽기/쓰기)
    print("{}\t{}\t{}\t{}\t{}\t{}\t{}\t{}".format(emp[0],emp[1],emp[2],emp[3],emp[4],emp[5],emp[6],emp[7]))
print(empList)