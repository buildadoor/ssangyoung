'''
Created on 2022. 12. 21.

@author: LeeYoonAh
#문자열 관련 함수
1. len()
    1) 문자열의 길이를 파악할 때 사용한다.
        len(문자열) : 문자열의 길이
    2) 한글, 기호, 영문, 공백, 숫자까지 모두 글자로 취급한다.
2. upper(), lower()
    1) 대문자, 소문자 변환 처리를 해준다.
        문자열.upper()/문자열.lower()
3. isupper(), islower()
    1) bool(True/False)로 모두 대문자인지, 모두 소문자인지 확인
4. count()
    1) 문자열에서 어떤 글자가 몇번 등장하는지 확인한다.
    2) 형식
        문자열.count("갯수확인할문자")
5. find()
    1) 어떤 글자가 문자열의 몇 번째에 위치하는지 찾음
    2) 해당 문자열이 있으면 해당하는 문자가 시작하는
        index(0)번부터 리턴한다.
        없으면 -1이 리턴된다.
    3) 형식
        문자열.find("찾을문자열") : 처음부터 찾음
        문자열.find("찾을문자열", 시작index) : 특정 index시작 위치부터 찾음
'''

print("Hello".upper())
print("Hello".lower())
print("Don't dwell on the past".isupper())
print("believe in yourself".islower())
sen01 = '''난생 처음 파이썬을 처음으로 학습중입니다! 
파이썬은 처음이지만 재미있는거같아요..
처음이 중요하죠 ^_^''' 
print(sen01.count("처음"))
print(sen01.find("처음"))
print(sen01.find("처음",10))

#ex1) 영어 격언을 찾아서 대문자/소문자로 변환해서 출력하세요
print("if you can't climb the wall, build a door".upper())
print("IF YOU CAN'T CLIMB THE WALL, BUILD A DOOR".lower())
#ex2) 위키백과 사전에서 빅 데이터를 검색해서 ''''''안에 붙여넣고,
#가장 많이 보이는 단어 갯수를 확인하세요
bigdata = '''
빅 데이터(영어: big data)란 기존 데이터베이스 관리도구의 능력을 넘어서는 대량(수십 테라바이트)의 정형 또는 심지어 데이터베이스 형태가 아닌 비정형의 데이터 집합조차 포함한[1] 데이터로부터 가치를 추출하고 결과를 분석하는 기술[2]이다. 즉, 데이터 베이스 등 기존의 데이터 처리 응용 소프트웨어(data-processing application software)로는 수집 · 저장 · 분석 · 처리하기 어려울 정도로 방대한 양의 데이터를 의미한다.
'''
print("데이터 검색: ",bigdata.count("데이터"))
#ex3)위 내용의 단어가 2번째로 나오는 위치를 리턴해보세요
print("첫번째 위치:", bigdata.find("데이터"))
print("두번째 위치:", bigdata.find("데이터",4))