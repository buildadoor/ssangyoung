'''
Created on 2022. 12. 23.

@author: LeeYoonAh
'''
class Person:
    name=None #객체의 초기값 null 대신에 None을 사용
    age = 0
p01 = Person()
p01.name='홍길동'
p01.age = 25
print("이름:",p01.name)
print("나이:",p01.age)
# ex) 물건 객체 선언 : 물건명/가격/갯수 : 데이터 할당 후 출력하세요.
class Product:
    pname:None
    price = 0
    cnt = 0 
prod = Product()
prod.pname='사과'
prod.price=2000
prod.cnt=3
print("물건명:",prod.pname)
print("가격:",prod.price)
print("갯수:",prod.cnt)
class Food:
    def __init__(self, name, price):
        self.name = name #self : 구성요소를 지칭
        self.price = price
f01 = Food("짜장면",6000)
f02 = Food("짬뽕",7000)
print(f01.name, f01.price)
print(f02.name, f02.price)
#ex) 축구선수를 클래스로 선언하고 속성으로 팀명 이름 골수를 생성자로 
#    할당하여 출력
class Soccer:
    def __init__(self, tname, name, goals):
        self.tname = tname
        self.name = name 
        self.goals = goals
s01 = Soccer("아르헨티나","메시",7)
s02 = Soccer("프랑스","음바페",8)
print(s01.tname, s01.name, s01.goals)
print(s02.tname, s02.name, s02.goals)

class Calculator:
    def __init__(self, num01, num02):
        self.num01 = num01
        self.num02 = num02
    def plus(self):
        print(self.num01,"+",self.num02,"=",self.num01+self.num02)
c01 = Calculator(25,3)
tot = c01.plus()
print("합산:",tot)
#ex) product02를 선언하고 생성자로 물건명과 가격, 
#    buy(구매갯수)로 해당 물건명과 가격과 구매갯수를 출력하되
#    총계(가격*갯수)를 해당 메서드를 통해서 
#    return 처리하여 호출하세요
class Product02:
    def __init__(self, pname, price):
        self.pname = pname
        self.price = price
    def buy(self, cnt):
        self.cnt = cnt
        print("#구매할 물건 정보#")
        print("물건명:",self.pname)
        print("가격:",self.price)
        print("갯수:",self.cnt)
        return self.price*self.cnt
p01 = Product02("사과",3000)
print("총계:", p01.buy(5))
p02 = Product02("바나나",4000)
print("총계:", p02.buy(3))
