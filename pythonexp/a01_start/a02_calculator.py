'''
Created on 2022. 12. 20.

@author: LeeYoonAh
'''
'''
# 사칙연산자이외 연산자
1. // :  나누기(몫)
2. % : 나누기의 값
3. **: 제곱
'''
print(10//3)
print(10%3)
print(10**3)
'''
#대입연산자
1. 왼쪽에서 오른쪽 변수에 대입 
2. 여러개의 데이터 대입(순서에 맞게 처리)
'''
name, age, loc = "홍길동",25,"서울"
print(name, age, loc)
no =1
#no++(X)
no+=1
# print("증가:",no+=1) 대입하면서 출력도 안된다.
no+=1; print(no, end=",");
no+=1; print(no, end=",");
no+=1; print(no, end=",");
no+=1; print(no, end=",");
# ex) 김밥이 단가가 2500이고 !~10개까지 가격을 
# @@개 @@@원 출력하세요 
# @@개 @@@원 
# @@개 @@@원
print()
print("김밥")
price =2500; no=0; tot=0;
no+=1; tot+=price; print(no,"개",tot,"원")
no+=1; tot+=price; print(no,"개",tot,"원")
no+=1; tot+=price; print(no,"개",tot,"원")
no+=1; tot+=price; print(no,"개",tot,"원")
no+=1; tot+=price; print(no,"개",tot,"원")
no+=1; tot+=price; print(no,"개",tot,"원")
no+=1; tot+=price; print(no,"개",tot,"원")
no+=1; tot+=price; print(no,"개",tot,"원")
no+=1; tot+=price; print(no,"개",tot,"원")
no+=1; tot+=price; print(no,"개",tot,"원")

'''
#비교연산자
isPass = pt>70
True/False의 boolean값을 가진다. 대문자 
#논리연산자
and, or, not
'''
# pt = int(input("점수를 입력하세요: "))
# print("합격여부:", pt>=70)
# age = int(input("나이를 입력하세요: "))
# print("청소년요금제 적용유무:", age>=14 and age<=18)
# # 두가지 조건이 모두 참일때,
# print("놀이 공원 무료 여부:", age<3 or age>=65) 
# print("놀이 공원 유료 여부:", not (age<3 or age>=65)) 
#ex) id와 pass를 입력받아 로그인 성공유무를 출력하세요 (himan/7777)
id01 = input("아이디를 입력하세요: ")
pass01 = input("비밀번호를 입력하세요: ")
print("로그인 성공 여부:", id01=='himan' and pass01=='7777')
