'''
Created on 2022. 12. 21.

@author: LeeYoonAh

#파이썬에서 문자열 추출
1. 파이썬도 문자열을 문자 + 배열로 인식하기에
    추출하는 방법도 배열형식으로 하나씩 호출할 수 있다.
     str01 = "홍길동"
     str01[0] : "홍"
     str01[1] : "길"
     str01[2] : "동"
2. 파이썬은 범위를 지정하여 문자열을 추출할 수도 있다.
    자바나 오라클의 substring()을 통한 추출방식과 동일하지만
    보다 간편한 기능으로 처리한다.
    문자열[시작index:마지막count] 형식으로 추출한다.
    str01[1:] 두번째 문자열부터 마지막까지 "길동"
    str01[:2] 첫번째부터 두번째 문자열까지 마지막까지 "홍길"
    str01[1:3] 두번째 문자열부터 세번째문자열까지 "길동" 
    
'''
str01 = "홍길동"
print(str01[0])
print(str01[1])
print(str01[2])
print(str01[1:])
print(str01[:2])
print(str01[1:3])

#ex) 임의의 주민번호를 통해 생년월일 남자인지 여부/성별출력 를 출력하세여.

#답
rrn = "920902-1209021"
yyyy="19"+rrn[0:2]
mm=rrn[2:4]
dd=rrn[4:6]
isMale = rrn[7] == "1"
print("생년월일:{}년{}월{}일".format(yyyy,mm,dd))
print("남자여부:", isMale)
#내가 푼 것
print(rrn[:2],"년",rrn[2:4],"월",rrn[4:6],"일")
print("남자여부",rrn[7]=="1")
# 파이썬의 3항 연산자
# true일때 처리 데이터 if조건 else false일때 처리 데이터
print("성별:","남자" if isMale else "여자")

