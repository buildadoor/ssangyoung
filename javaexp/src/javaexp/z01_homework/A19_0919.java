package javaexp.z01_homework;

public class A19_0919 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-09-19
[1단계:개념] 1. 사용자 정의 예외 클래스의 기본 형식과 Exception 클래스의 기본 생성자2개, 주요메서드2개를 기술하세요
사용자 정의 예외 클래스  기본 형식
public class xxxException extends [Exception|RuntimeException]
	 		public XXXException(){
	 		public XXXException(String message){
	 			super(message);
	 		}
	 	}
	 	 # 예외 발생 시키기 
	 1. 코드에서 예외 발생 시키는 법
	 	throw new XXXException()
	 	throw new XXXException("메시지")
	 	public void method throws XXXException{
	 		throw new XXXEception("메시지");
	 	}
	 2. 호출된 곳에서 발생한 예외를 처리하도록 한다.
	 # 예외 정보 
	 1. getMessage() : 예외 발생 시킬때, 생성자 매개값으로 사용한 메시지 리턴
	 		throw new XXXException("예외 메세지")
	 		원인 세분화하기	 위해 예외 코드 포함
	 		catch()절에서 활용
	 		}catch(Exception e){
	 			String msg = e.getMessage();
	 		} 
	 2. printStackTrace()
	 	예외 발생 코드 추적한 내용을 모두 콘솔에 출력
	 	프로그램 테스트하면서 오류 찾을때 유용하게 활용된다. 


[1단계:코드] 2. User03Exception을 통해 생성자를 매개변수로 문자열을 넘기고, getMessage()를 재정의하여 [사용자정의]라는 문자열을
         포함하여, 이 사용자 정의 예외가 11~20 반복문에서 짝수일 때, 처리되게 하세요
         		for(int cnt=11;cnt<=20;cnt++) {
			try {
				if(cnt%2==0) {
					throw new User03Exception("번호"+cnt);
				}
			}catch(User03Exception ue) {
				System.out.println("# 예외 #");
				System.out.println(ue.getMessage());
				}
			}
		}
	}
			class User03Exception extends Exception{
				public User03Exception(String message) {
					super(message);
				}
				public User03Exception(String message, String name) {
					super(message+":예외명-"+name);
				}
				@Override
				public String getMessage() {
					// TODO Auto-generated method stub
					return "[사용자정의]"+super.getMessage();
				}
			}
         
[1단계:개념] 3. Object클래스가 기본적으로 가지고 있는 메서드(equals(), toString(), hashCode())를 기술하세요.
				equals 
				두개의 instance 값을 비교하여 true/false로 반환한다
				재정의 하영 두 인스턴스가 논리적으로 동일함의 여부를 구현
				인스턴스가 달라도 논리적으로 동일한 경우 true 재정의 가능
				#equals() VS ==
				==는 주소값을 비교하고 equals는 내 용을 비교한다.  
				
				toString
				객체의 정보를 String으로 바꾸어서 사용할때 쓰임
				String이나 Integer 클래스에서는 이미 재정의 되어있고
				String은 문자열 반환, Integer은 정수값 반환한다. 
				
				hashCode
				instance의 저장 주소를 반환한다
				heap메모리에 인스턴스가 저장되는 방식이 hash방식
				자료의 특정 값에 대한 저장 위치를 반환해주는 해시 함수를 사용한다.
				두 인스턴스에 대한 equals() 의 반환값이 true면, 동일한 hashCode()값을 반환
				논리적으로 동일함을 위해 equals() 메서드를 재정의 하였다면 hashCode() 메서드도 재정의하여 
				동일한 hashCode() 값이 반환되도록 한다.


[1단계:코드] 4. 같은 클래스의 두개 객체의 속성값이 같으면 hashCode가 동일하게 처리할려고 한다.  Bus(번호,행선지)를 기준으로 처리하세요.
				Bus b01 = new Bus (6716,"서교동");
				Bus b02 = new Bus (6628,"영등포역");
				Bus b03 = new Bus (6628,"여의도");
				System.out.println(b01.hashCode());
				System.out.println(b02.hashCode());
				System.out.println(b03.hashCode());
				System.out.println(b01.hashCode()==b03.hashCode());
				}
		}
class Bus{
	private int num;
	private String to;
	public Bus(int num, String to) {
		this.num = num;
		this.to = to;
	}
	@Override
	public int hashCode() {
		int hashCode = to.hashCode()+num;
		return hashCode;	
	}
	
}		
[1단계:코드] 5. 특정 프로그램의 실행 시간을 확인할려고 한다. 해당 코드의 메서드와 결과를 설명하세요.
		long start = System.currentTimeMillis();
		System.out.println("시작"+start);
		long sum = 0;
		for(long cnt=1;cnt<(long)1000000;cnt++) {
			sum+=cnt;
			System.out.println(cnt+":"+sum);
		}
		long end = System.currentTimeMillis();
		System.out.println("종료"+start);
		long time = end-start;
		System.out.println("결과:"+sum);
		System.out.println(time+"time");
		System.out.print(time/1000+"초");
		System.out.print(time/1000/60+"분");
		System.out.print(time/1000/60/60+"시");
	}

}
[1단계:코드] 6. 문자열로 대문자/소문자/특수문자를 선언하고, 이 중에서 8자를 추출하여 비번호를 처리할려고 한다.
      charAt를 활용하여 처리하세요.
      	String password = "QWERTYqwertyuikjhgfdsXCVBNM!@#$%^&*()";
			System.out.println("비밀번호 8자리 생성");
			System.out.print(password.charAt(3));
			System.out.print(password.charAt(18));
			System.out.print(password.charAt(0));
			System.out.print(password.charAt(26));
			System.out.print(password.charAt(27));
			System.out.print(password.charAt(14));
			System.out.print(password.charAt(23));
			System.out.print(password.charAt(10));
		} 
}
 */
		
		
		
		//2번
		
		
		long start = System.currentTimeMillis();
	for(int cnt = 11;cnt<=20;cnt++) {
		try {
		if(cnt%2==0) {
			throw new User03Exception(cnt+"번 예외발생");
		}
		}catch(User03Exception e) {
			System.out.println("예외처리 block:"+e.getMessage());
		}finally {
			System.out.println("예외처리(상관없이)");
		}
	}
	
	
	//5번
	//1. 시작 시간을 check해서 가져오고 
	//2. 프로그램 수행
	//3. 마지막 시간을 체크
	//4. 시작 시간과 마지막 시간 차이 확인
	//long start = System.currentTimeMillis();
	long end = System.currentTimeMillis();
	long time = end  - start;
	System.out.println("걸린 시간:"+time/1000.0+"초");
	}

}
/*
//사용자 정의 클래스
//1. extends Exception
//2. 생성자 매개변수 처리
//3. 재정의 메서드 선언
//4. 상황에 맞게 해당 객체 강제 예외 처리 throw new 사용자정의 예외클래스 생성자();
//		try{
			throw new User03Exception("예외메시지내용");
		}catch(User03Exception e){
			System.out.println("예외 메시지:"+e.getMessage());
//		}catch(Exception e){
 			System.out.println("최상위 예외")
  		}finally{
  			System.out.println("예외 상관없이 처리할 내용");
  		}
 * */
 
class User03Exception extends Exception{
//매개변수로 getMesaa
	//gte()를 통해 나타나는 문자열 전달가능하게처리
	public User03Exception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "[재정의된 메서드 메시지]"+super.getMessage();
	}
	
}