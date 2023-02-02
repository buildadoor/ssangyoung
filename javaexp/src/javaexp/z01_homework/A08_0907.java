package javaexp.z01_homework;

public class A08_0907 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 2022-09-07
		[1단계:개념] 1. 생성자의 this()를 사용하는 경우와 규칙을 예제를 통하여 기술하세요.

		[1단계:코드] 2. 자바의 기본데이터 유형으로 class ExpConst에 데이터를 할당하고, 생성자에 할당된 데이터를 출력하세요.
		[1단계:개념] 3. 메서드의 기능적 구성요소를 기술하고 예제를 통해서 설명하세요.
		[1단계:코드] 4. AutoSeller 클래스 선언 메서드 insertCoin()를 통해서 입력된 동전을 필드 
		      curMoney에 누적 저장하고, getCurMoney()를 통해
		      현재 저장된 돈을 리턴 처리하는 기능을 처리하세요.
				AutoSeller as = new AutoSeller();
		System.out.println("초기 현재 저장된 금액:"+as.getCurMoney());
		as.insertCoin((500);
		as.insertCoin((1000);
		as.insertCoin((1500);
		as.insertCoin((2000);
		System.out.println("현재 저장된 금액: "+as.getCurMoney());

}
	}
class AutoSeller{
  	int curMoney;
  	void insertCoin(int money){
  		this.curMoney+=money; //누적 저장
  		}
  	int getCurMoeny(){
  		return curMoney;
  }
}
		      */
			
		
		/*
		[1단계:코드] 5. GoTravel 클래스를 선언하고  오버로딩의 원칙에 따라 메서드를 선언하되 
		      - 리턴유형을 void
		      1) setTarget : 목적지를 1, 2, 3개로 선언하여 출력
		      2) setTarget : 비용을 선언하는 내용 처리 
		      3) setTarget : 목적지와 비용을 순서를 다르게 선언 출력..
		      	GoTravel gt = new GoTravel();
		gt.setTarget("부산","제주도","런던");
		gt.setTarget("하와이");
		gt.setTarget(200000);
		gt.setTarget(200000,"사이판");
		
	}
	}
class GoTravel{
	void setTarget(String loc1, String loc2, String loc3) {
		System.out.println("# 목적지 3개 메서드 #");
		System.out.println("목적지1:"+loc1);
		System.out.println("목적지2:"+loc2);
		System.out.println("목적지3:"+loc3);
		
	}
	void setTarget(String loc) {
		System.out.println("# 목적지1 메서드 #");
		System.out.println("목적지:"+loc);
	}
	void setTarget(int pay) {
		System.out.println("# 비용 메서드 #");
		System.out.println("비용:"+pay);
	}
	void setTarget(int pay, String loc1) {
		System.out.println("# 매개순서(목적지, 비용)#");
		System.out.println("목적지:"+loc1);
		System.out.println("비용:"+pay);
		[2단계:코드] 6. BuyProduct 클래스를 선언하고, 생성자를 통해서 물건명과 가격을 초기화하고
		      getProdName(), getProdPrice(),  물건명, 가격(정수) 리턴
		      buyProd() 매개변수로 갯수를 할당, 가격과 연산하여 계를 리턴하게 처리하게 하세요.
		[1단계:코드] 7. Member클래스로 선언하여 login()에 매개변수로 id, pass를 입력하여 himan/7777일 때, 로그인
		      성공문자리턴, 그외는 로그인실패문자리턴처리.
		 // 내 답
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		[1단계:개념] 1. 생성자의 this()를 사용하는 경우와 규칙을 예제를 통하여 기술하세요.
		매개변수의 명과 필드 이름이 동일한 경우 구분을 위해 this를 붙여 할당.
		this()는 생성한 그 instance(인스턴스) 를 가리키는데
		여기에 this()를 입력 하게 되면
		this.name = name; 가 실행될 때
		name = ""; 를 가리키게 되는 것

		[1단계:코드] 2. 자바의 기본데이터 유형으로 class ExpConst에 데이터를 할당하고, 생성자에 할당된 데이터를 출력하세요.
				ExpConst c1 = new ExpConst();
				int tot=c1.coffee("아이스아메리카노",4600,11);
			}
		}
		class ExpConst {
			int coffee(String menu, int price,int glass) {
				int tot=price*glass;
					System.out.print(menu+"\t");
					System.out.print(price+"원"+"\t");
			}
		}			

		[1단계:개념] 3. 메서드의 기능적 구성요소를 기술하고 예제를 통해서 설명하세요.
						-매개변수(overloading)
						생성자는 매개변수의  갯수, 타입, 순서가 다르면 여러개 선언이 가능하다.
						Phone p1 = new Phone ("회사",가격,"모델명");
					으로 되어있다면Phone p2 = new Phone에서는 (가격,"모델명","회사);
					이런 식으로 순서 변경이 가능하다. p3,p4등 그 이후에도 변경 가능 

						-리턴유형
						메서드를 호출했을때 나오는 데이터의 유형을 선언한다.
						마지막에 리턴할 데이터의 유형을 선언한다.
						리턴값이 없는 경우에는 void를 적고 리턴처리하지 않는다
						
						-프로세스처리
						
						-실제 리턴값 처리
						리턴값이 없는 경우에는 void를 적고 리턴처리하지 않는다.
						하지만 반환값이 있는 경우 반드시 return이 있어야함.
						int tot (int cnt, int price){
							int price = cnt*price;
								return price;
						}
						-위 구성요소의 혼합예제
						
				int tot(int start, int end){
					int total=0;
						for(int cnt=start;end<=end;cnt++){
							System.out.print(end+"+");
							tot+=end;
							}
								return tot;
					}

						
		[1단계:코드] 4. AutoSeller 클래스 선언 메서드 insertCoin()를 통해서 입력된 동전을 필드 
		      curMoney에 누적 저장하고, getCurMoney()를 통해
		      현재 저장된 돈을 리턴 처리하는 기능을 처리하세요.
		      
		      
		[1단계:코드] 5. GoTravel 클래스를 선언하고  오버로딩의 원칙에 따라 메서드를 선언하되 
		      - 리턴유형을 void
		      1) setTarget : 목적지를 1, 2, 3개로 선언하여 출력
		      2) setTarget : 비용을 선언하는 내용 처리 
		      3) setTarget : 목적지와 비용을 순서를 다르게 선언 출력..
		    
		      **비용선언 ???? 
		      GoTravel g1 = new GoTravel();
						g1.setDes01("남해안");
						System.out.println(g1.des01);
					GoTravel g2 = new GoTravel();
					
		}
		}
				class GoTravel{
					String des01,des02,des03;
					int price01,price02,price03;
					GoTravel(){}
					GoTravel(String des01,String des02,String des03){
						this.des01 = des01;
						this.des02 = des02;
						this.des03 = des03;
		}
						void setDes01(String des01) {
							this.des01 = des01;
			}
						void setDes02(String des01,String des02,String des03) {
							this.des01 = des01;
							this.des02 = des02;
							this.des03 = des03;

					}
					}
		      
		[2단계:코드] 6. BuyProduct 클래스를 선언하고, 생성자를 통해서 물건명과 가격을 초기화하고
		      getProdName(), getProdPrice(),  물건명, 가격(정수) 리턴
		      buyProd() 매개변수로 갯수를 할당, 가격과 연산하여 계를 리턴하게 처리하게 하세요.
	BuyProduct bp = new BuyProduct("사과",1200);
		System.out.println("구매 계:"+bp.buyProd(2));
		System.out.println("구매 계:"+bp.buyProd(3));
		System.out.println("구매 계:"+bp.buyProd(4));
	}
}
class BuyProduct{
	String name;
	int price;
	BuyProduct(String name, int price){
		this.name = name;
		this.price = price;
	}
	String getProdName() {
		return this.name;
	}
	int getProdPrice() {
		return this.price;
	}
	int buyProd(int cnt) {
		System.out.println("#물건구매#");
		System.out.println("물건명:"+this.name);
		System.out.println("가격:"+this.price);
		System.out.println("갯수:"+cnt);
		
		return this.price*cnt;
	}
}
//		class BuyProduct{
		String  getProdName;
		int getProdPrice;

		BuyProduct(){}
		BuyProduct(String getProdName, int getProdPrice){
		this.getProdName = getProdName;
		this.getProdPrice = getProdPrice;
		}
		void buyProd(String getProdName) {
		this.getProdPrice = getProdPrice;
		}
		int total(int start, int end) {
			int tot=0;
			int tot=getProdPrice*end;
			for(int cnt=start;cnt<=end;cnt++) {
				System.out.print(cnt+(cnt!=end?" + ":"\\n"));
				tot +=cnt;
			}
			return tot;
		}
			}
		      
		[1단계:코드] 7. Member클래스로 선언하여 login()에 매개변수로 id, pass를 입력하여 himan/7777일 때, 로그인
		      성공문자리턴, 그외는 로그인실패문자리턴처리.
		      */

				
				
				/*해설
		 
		  [1단계:개념] 1. 생성자의 this()를 사용하는 경우와 규칙을 예제를 통하여 기술하세요.
				      - this()는 생성자를 오버로딩 하게 되면 중복된 코드가 발생하게 되는데 그를 막을 수 있다.
				         예를 들어
				         class a{
				            String name;
				            int age;
				            
				            a(){
				               this.age = 0;
				               this.name = "";
				            }
				            a(String name){
				               this();
				               this.name = name;
				            }
				            a(String name, int age){
				               this(name);
				               this.age = age;
				            }
				         }
				        이런 식으로 this()를 활용할 수 있다.
		[1단계:코드] 2. 자바의 기본데이터 유형으로 class ExpConst에 데이터를 할당하고, 
					 생성자에 할당된 데이터를 출력하세요.
				      
//				      ExpConst ec = new ExpConst();
//				      System.out.println(ec.name);
//				      System.out.println(ec.age);
				      
		[1단계:개념] 3. 메서드의 기능적 구성요소를 기술하고 예제를 통해서 설명하세요.
				         - 메서드의 기본 구성요소는
				           리턴타입 메소드명(매개변수1, 매개변수2...){
				           프로세스 처리
				           return 실제 리턴 데이터;
				           이다.
				          ex) int num01(int a, int b){
				             int c = a+b;
				             return c;
				          }
		[1단계:코드] 4. AutoSeller 클래스 선언 메서드 insertCoin()를 통해서 입력된 동전을 필드 
				     curMoney에 누적 저장하고, getCurMoney()를 통해
				      현재 저장된 돈을 리턴 처리하는 기능을 처리하세요.
				      */
//				      AutoSeller as = new AutoSeller();
//				      as.insertCoin();
//				      System.out.println("누적된 금액 : "+as.getCurMoney());
				      /*
		[1단계:코드] 5. GoTravel 클래스를 선언하고  오버로딩의 원칙에 따라 메서드를 선언하되 
				   - 리턴유형을 void
				   1) setTarget : 목적지를 1, 2, 3개로 선언하여 출력
				   2) setTarget : 비용을 선언하는 내용 처리 
				   3) setTarget : 목적지와 비용을 순서를 다르게 선언 출력.
//				      GoTravel gt = new GoTravel();
//				      gt.setTarget("미국","호주","베트남");
//				      gt.setTarget(100,200,300);
//				      gt.setTarget("서울",10000);
//				      gt.setTarget(20000,"부산");
				    
		[2단계:코드] 6. BuyProduct 클래스를 선언하고, 생성자를 통해서 물건명과 가격을 초기화하고
						getProdName(), getProdPrice(),  물건명, 가격(정수) 리턴
						buyProd() 매개변수로 갯수를 할당, 가격과 연산하여 계를 리턴하게 처리하게 하세요.		           
//				      BuyProduct bp = new BuyProduct("볼펜",1500);
//				      bp.getProdName();
//				      bp.getProdPrice();
//				      System.out.println("총계 : "+bp.buyProd(10));
		[1단계:코드] 7. Member클래스로 선언하여 login()에 매개변수로 id, pass를 입력하여 himan/7777일 때, 로그인
		  				성공문자리턴, 그외는 로그인실패문자리턴처리.
//				      Member m = new Member();
//				      System.out.println(m.login("himan", 7777));
//				      System.out.println(m.login("himan", 0000));
//				      System.out.println(m.login("hiwoman", 7777));
//				      System.out.println(m.login("hiwoman", 0000));3
				   }

				}
				*/
				//////////문제 2///////////////
				//class ExpConst{
				//   String name;
				//   int age;
				//   ExpConst(){
//				      this.name = "기본생성자";
//				      this.age = 100;
				//   }
				//}

				/////////문제 4 ////////////
				//class AutoSeller{
				//   Scanner sc = new Scanner(System.in);
				//   int curMoney;
				//   void insertCoin() {
//				      while(true) {
//				         System.out.println("동전 금액을 입력하세요.(완료시 0을 입력)");
//				         int num = sc.nextInt();
//				         if(num==0) {
//				            break;
//				         }
//				         else {
//				            curMoney += num;
//				         }
//				      }      
				//   }
				//   int getCurMoney() {
//				      return curMoney;
				//   }
				//}

				///////////// 문제 5 //////////
				//class GoTravel{
				//   void setTarget(String des1) {
//				      System.out.println("# 여행지 1개 #");
//				      System.out.println("목적지 1 : "+des1);
				//   }
				//   void setTarget(String des1,String des2) {
//				      System.out.println("# 여행지 2개 #");
//				      System.out.println("목적지 1 : "+des1);
//				      System.out.println("목적지 2 : "+des2);
				//   }
				//   void setTarget(String des1, String des2, String des3) {
//				      System.out.println("# 여행지 3개 #");
//				      System.out.println("목적지 1 : "+des1);
//				      System.out.println("목적지 2 : "+des2);
//				      System.out.println("목적지 3 : "+des3);
				//   }
				//   void setTarget(int price1) {
//				      System.out.println("# 여행지 1개 #");
//				      System.out.println("비용 1 : "+price1);
				//   }
				//   void setTarget(int price1, int price2) {
//				      System.out.println("# 여행지 1개 #");
//				      System.out.println("비용 1 : "+price1);
//				      System.out.println("비용 2 : "+price2);
				//   }
				//   void setTarget(int price1, int price2, int price3) {
//				      System.out.println("# 여행지 3개 #");
//				      System.out.println("비용 1 : "+price1);
//				      System.out.println("비용 2 : "+price2);
//				      System.out.println("비용 3 : "+price3);
				//   }
				//   void setTarget(String des1, int price1) {
//				      System.out.println("목적지 : "+des1);
//				      System.out.println("비용 : "+price1);
				//   }
				//   void setTarget(int price1,String des1) {
//				      System.out.println("목적지 : "+des1);
//				      System.out.println("비용 : "+price1);
				//   }
				//}

				////////// 문제 6 /////////////
				//class BuyProduct{
				//   String pname;
				//   int price;
				//   BuyProduct(){
//				      System.out.println("물건명과 가격이 입력되지 않았습니다.");
				//   }
				//   BuyProduct(String pname, int price){
//				      this.pname = pname;
//				      this.price = price;
//				      System.out.println("물건명 : "+pname);
//				      System.out.println("개당 가격 : "+price);
				//   }
				//   String getProdName() {
//				      return pname;
				//   }
				//   int getProdPrice() {
//				      return price;
				//   }
				//   int buyProd(int cnt) {
//				      return cnt*price;
				//   }
				//}

				//////////// 문제 7 //////////
				//class Member{
				//   String login(String id, int password){
//				      if(id.equals("himan")&&password == 7777) {
//				         return "로그인에 성공하셨습니다.";
//				      }
//				      else {return "로그인에 실패하셨습니다.";}
				//   }
				//}
	}

}
