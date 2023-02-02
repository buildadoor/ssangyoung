package javaexp.z01_homework;

public class A17_0916 {
	
	static void call01() throws ArrayIndexOutOfBoundsException{
		int[] arry = new int[3]; //0, 1, 2 
		System.out.println(arry[3]);
	}
	static void call02() throws ArrayIndexOutOfBoundsException{
		int[] arry = new int[3]; //0, 1, 2 
		System.out.println(arry[4]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 위임 예외 처리 순서
 1. 해당 예외 내용 파악과 실제 나타날 상황 코드 생성
 	및 예외 copy
 	배열의 범위를 벗어났을때
 	System.out.println(args[1]);
 	에러 코드 ArrayIndexOutOfBoundsException
 2. 위임할 기능 메서드 선언
  	해당 에외와 비슷하게 발생할 내용을 구현 
 3. 위임할 예외 내용 throws 위임 예외
 4. 호출하는 곳에서 try{}catch문으로 예외 처리 

 */
	
		
//System.out.println(args[1]);
try {
call01();
call02();
}catch(ArrayIndexOutOfBoundsException e) {
	System.out.println("배열의 범위를 벗어남: ");
	System.out.println(e.getMessage());
	
}
		/*
 2022-09-16
[1단계:개념] 1. 추상클래스 사용의 기본 형식을 기본 예제와 함께 설명하세요.
			실체 클래스들과 공통되는 필드와 메소드를 정의한 클래스이다.
[1단계:코드] 2. 다각형이라는 추상클래스(필드-종류,실제메서드 도화지를 가져오다(), 추상메서드 drawing() @@을 그리다)를 생성하고 
      상속받은 실제 클래스(삼각형,사각형,오각형)을 처리하세요.
      
		Polygon p1 = new Triangle();
		Polygon p2 = new Quadrangle();
		Polygon p3 = new Pentagon();
	    p1.drawing();
	    p2.drawing();
	    p3.drawing();
	     

	}
	}
		abstract class Polygon{
			private String kind;
			public Polygon(String kind) {
				this.kind = kind;
			}
			public void move() {
				System.out.println(this.kind+" 도화지를 가져오다");
			}
			public String getKind() {
				return kind;
			}
			public abstract void drawing();
		}

		class Triangle extends Polygon{
			public Triangle() {
				super("삼각형");
			}
			@Override
			public void drawing() {
				// TODO Auto-generated method stub
				System.out.println(getKind()+"을 그리다.");
			}
		}
		class Quadrangle extends Polygon{
			public Quadrangle() {
				super("사각형");
			}
			@Override
			public void drawing() {
				// TODO Auto-generated method stub
				System.out.println(getKind()+"을 그리다.");
			}
		}
		class Pentagon extends Polygon{
			public Pentagon() {
				super("오각형");
			}
			@Override
			public void drawing() {
				// TODO Auto-generated method stub
				System.out.println(getKind()+"을 그리다.");
			
		} 
	}
[1단계:개념] 3. 추상클래스와 인터페이스의 차이점을 개념과 함께 정리해보세요.
 추상클래스
 실제 클래스들의 공통되는 필드와 메소드 정의한 클래스
추상 클래스는 실체 클래스의 부모 클래스 역할 (단독으로 객체 생성을 하지 못한다)
	 
 인터페이스
 개발 코드와 객체가 서로 통신하는 접점,개발 코드는 인터페이스의 메소드만 알고 있으면 된다
  - 역할: 개발 코드가 객체에 종속되지 않게 객체 교체할 수 있도록 하는 역할을 한다 
 (개발 코드 변경 없이 리턴값 또는 실행 내용이 다양해질 수 있음)
  
[1단계:코드] 4. 인터페이스 PaintWay를 선언(추상메서드 paint() @@ 색칠을 하다) 상속받은 실제
      클래스(빨강색, 파랑색, 노랑색)을 처리하세요.
      	  Color c1 = new Color();
	      c1.showColor();
	      c1.setColor(new Red());
	      c1.showColor();
	      c1.setColor(new Blue());
	      c1.showColor();
	      c1.setColor(new Yellow());
	      c1.showColor();
	}
}

	      interface PaintWay{
	         public abstract void paint(); 
	      }
	      class Red implements PaintWay{
	         @Override
	         public void paint() {
	            System.out.println("빨간색 색칠을 하다");
	         }
	      }
	      class Blue implements PaintWay{
	         @Override
	         public void paint() {
	            System.out.println("파란색 색칠을 하다");
	         }
	      }
	      class Yellow implements PaintWay{
	         @Override
	         public void paint() {
	            System.out.println("노란색 색칠을 하다");
	         }
	      }
	      class Color{
	         private PaintWay paintway;
	         public void setColor(PaintWay paintway) {
	            this.paintway = paintway;
	         }
	         public void showColor() {
	            if(this.paintway!= null) {
	               this.paintway.paint();
	            }else {
	               System.out.println("페인트가 부족합니다.");
	            }
	         }
	      }
[1단계:개념] 5. 예외 처리의 기본 형식과 처리 순서를 기본 예제에 의해 기술하세요.
 	예외 처리 복사하고 try{}catch(예외 클래스 내용 선언){}finally{}
	catch 매개변수에 발생한 예외 처리 내용 선언한다.
	하위 {} 블럭에 예외 발생시 내용 기술,
 finally{} 예외 발생 상관 없이 처리할 내용 처리하고
	기타 이후 처리할 내용 기술한다
	 
	 	 	
[1단계:확인] 6. args를 통해서 나올 수 있는 예외를 아래에 하나씩 처리하세요
      1) args값을 입력 하지 않았을 때. 
      try {
        System.out.println(args[0]);
     }catch(ArrayIndexOutOfBoundsException e) {
        System.out.println("에러 발생:"+e.getMessage());
     }finally {
        System.out.println("에러 상관없이 처리");
     }

	}
}
      2) args의 값 중에 숫자형 문자를 입력하여야 하는데 문자 자체를 입력했을 때.
      try {
	String[] array = {"오늘은 금요일 ~_~"};
		try {
			System.out.println(Integer.parseInt(array[0]));     
			}catch(NumberFormatException e) {
				System.out.println("에러발생"+e.getMessage());
			}finally {
				System.out.println("에러 상관없이 처리");
		}
	}
}
[1단계:개념] 7. 예외 처리의 계층별 처리란 무엇인지 기술하세요.
계층적으로 하위 예외부터 처리하고 상위 예외를 처리해야한다. 
 또한 예외는 여러가지 예외를 catch block으로 처리할 수 있다.
 
[1단계:개념] 8. 예외의 위임처리하는 내용을 예제를 통해서 기술하세요.
 1. 메서드별로 현재 예외 처리를 이 메서드를 호출하는 곳에서
  	처리하게끔 위임 시키는 것을 말한다.
 2. 예외를 각 메서드별로 처리하기보다 호출되는 곳에서 한꺼번에
 	처리할 때, 활용된다.
 public void 메서드명() throws 위임할 예외1, 위임할 예외2{}
   
[1단계:확인] 9.  call01(), call02()에 배열의 범위를 벗어났을 때, 예외를 위임하는 예제를 처리해보세요.
	static void call01() throws ArrayIndexOutOfBoundsException{
		System.out.println("메서드 1");
		int [] arr = new int[9];		
		for(int i = 0; i <= 9; i++) 
			arr[i]= i;{
		}
	}
	static void call02() throws ArrayIndexOutOfBoundsException{
		System.out.println("메서드 2");
		int [] arr = new int[3];		
		for(int i = 0; i <= 3; i++) 
			arr[i]= i;{
		}
	}
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
		// TODO Auto-generated method stub
	try {
		call01();
		call02();
	}catch (ArrayIndexOutOfBoundsException e) {
		System.out.println("에러: "+e.getMessage());
	}
	}
}

 */
		
	}
}