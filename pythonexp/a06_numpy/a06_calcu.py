'''
Created on 2023. 1. 3.

@author: LeeYoonAh
# ndarray의 산술연산자 
1. 배열의 숫자 데이터 연산은 배열의 각 요소에 연산 결과를 리턴한다. 
2. 동일 크기를 갖는 배열은 동일한 위치의 요소 데이터까지 연산 수행한다.
    list01 = np.array([1,2,3])
    list02 = np.array([3,4,5])
    list03 = list01*2 ==> 각 요소들 마다 데이터를 *2로 처리한다.
                [2,4,6]
    list04 = list01+list02 ==> 각 요소의 같은 index 위치에 데이터끼리
            연산 처리 ==> [4,6,8]
# ndarray의 비교연산자
1. 배열의 각 데이터를 비교하여 논리값을 저장하는 연산처리를 말한다.
2. ex) 
    boolist = np.equal(list01, list02)
        두 배열 데이터의 각 요소들을 비교하여 bool값의 배열을 만든다.
        1==3    3==4    3==5
        [False, False, False]
3. 종류
    not_equals(); greater(), greater_equal(), less()
    less_equal()

'''
import numpy as np 
list01 = np.array([1,2,3])
list02 = np.array([4,5,6])
list03 = list01*3
list04 = list01 + list02 
print(list01)
print(list02)
print(list03)
print(list04)

# 비교 연산자를 이용하여 배열간의 데이터 비교 및 bool 배열 출력
print("equal(==):", np.equal(list01, list02))
print("not equal(!=):", np.not_equal(list01, list02))
print("greater(>):", np.greater(list01, list02))
print("greater_equal(>=):", np.greater_equal(list01, list02))
print("less(<):", np.less(list01, list02))
print("less_equal(<=):", np.less_equal(list01, list02))

#ex) nparray형태로 이름 3명, 3명의 국어점수, 영어점수, 수학점수
# 설정
student = np.array(["홍길동","김길동","박길동"])
st01 = np.array([80,70,100])
st02 = np.array([40,60,70])
st03 = np.array([75,90,85])
avg01 = (st01[0]+st01[1]+st01[2])/3
avg02 = (st02[0]+st02[1]+st02[2])/3
avg03 = (st03[0]+st03[1]+st03[2])/3
print(student[0],"70점 이상 합격여부:", np.greater_equal(avg01,70))
print(student[1],"70점 이상 합격여부:", np.greater_equal(avg02,70))
print(student[2],"70점 이상 합격여부:", np.greater_equal(avg03,70))
snames = np.array(["또치","둘리","희동"])
kors = np.array([90,80,70])
engs = np.array([80,60,20])
maths = np.array([40,50,70])
avgs = (kors+engs+maths)//3
print("평균점수",avgs)
isPass =np.greater_equal(avgs,70)
print("힙격여부:",isPass)
len01 = len(snames) #길이를 도출
print("이름\t평균점수\t합격여부")
for idx in range(len01):
    print(snames[idx],end="\t")
    print(avgs[idx],end="\t")
    print(isPass[idx],end="\n")