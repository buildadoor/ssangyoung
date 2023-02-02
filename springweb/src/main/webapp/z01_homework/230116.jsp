<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("h2").text("안녕하세요")
	});
</script>
</head>
<body>
	  <h2></h2>
	  
	 <!-- 
2023-01-16
[1단계:개념] 1. DI로 설정한 Collections 객체들의 기본 컨테이너 선언 방법을 기술하세요.
	<bean id="prod01" class="@@@.Product"/>
	<bean id="prod02" class="@@@.Product"/>
	<bean id="prod03" class="@@@.Product"/>
	<bean id="mt01" class="@@@.Mart">
		<property name="plist"
			<list>
				<ref bean ="prod01"/>
				<ref bean ="prod01"/>
				<ref bean ="prod03"/>
[1단계:확인] 4. 호주머니 클래스를 선언하고 여기담긴 구슬을 Set로 할당하고, 호출하는 클래스와 di를 설정하고 호출하세요
xml
 <bean id="pk01" class="a01_diexp.z01_vo.Pocket">
      	<property name="ball">
      		<set>
      			<value>초록구슬</value>
      			<value>파랑구슬</value>
      			<value>파랑구슬</value>
      			<value>빨강구슬</value>
      			<value>빨강구슬</value>
      			<value>빨강구슬</value>
      		</set>
      	</property>
        </bean>
        
di
 String path="a01_diexp\\di51.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext();
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      Pocket pk01 = ctx.getBean("pk01",Pocket.class);
      System.out.println("4번 컨테이너 객체 호출:"+pk01);
      System.out.println(pk01.getBall());
      System.out.println("종료");
      ctx.close();
   }
}
[1단계:확인] 4. Car클래스에 Tire클래스(제조사,가격)을 List로 추가하여 1:다로 처리되는 di를 선언하고 호출하세요.
xml
  Car c01 = ctx.getBean("c01",Car.class);
      System.out.println("자동차 컨테이너 객체 호출:"+c01);
      c01.TireList();
      System.out.println("종료");
      ctx.close();
di
 <bean id="c01" class="a01_diexp.z01_vo.Car">
     	 <constructor-arg value="GV90"/>
     	 <constructor-arg value="230"/>
     	 	<property name="tlist">
     	 		<list>
     	 			<ref bean="t01"/>
     	 			<ref bean="t02"/>
     	 		</list>
     	 	</property>
     </bean>
vo
tire 추가 후 
public void TireList() {
		System.out.println(name+" 타이어 정보");
		if(tlist!=null && tlist.size()>0) {
			System.out.println("제조사\t가격");
			for(Tire t:tlist) {
				System.out.print(t.getCompany()+"\t");
				System.out.print(t.getPrice()+"\n");
			}
		}else {
			System.out.println("타이어 정보가 없습니다");
		}
	}
[1단계:확인] 4. Map/Properties의 차이점을 기술하고, 
BaseTeam클래스에 타석 순서별 선수명를 Map으로, 
수비역할별 선수명을 Properties로 DI로 할당하여 출력 처리하세요
map(key/value)
		public void setConfing(Map<String, 
						Integer> config){}
		<propertyp name="config"
			<entry>
				key/value형식 처리			
Properties : key/value형식 collection 
		prop key = ""/value	
		
		
		ㅡㅡㅡㅡ

1) Tire 클래스 company, price
2) Car 클래스
	String kind; 
	List<Tire> tlist;
	public void setTlist(List<Tire> tlist)
	public void showMyTire(){
		System.out.println("차량종류:"+kind)'
		if(tlist!=null && tlist.size()>0){
		for(Tire t:tlist){
			System.out.println(t.getCompany+"\t"+t.getPrice());
		}
	}else{
		 System.out.println("타이어가 장착되지 않았습니다.")
		}
	}
3) DI선언
	<propery name="tlist>
		<list>
			<bean ref="tire01">
			<bean ref="tire02">
			
				
		
		
[1단계:개념] 4. di에서 namespace처리를 위한 ddl 선언과 선언형식을 기술하세요
# namespace를 활용하여, 생성자나 property의 간편한 사용
1. 컨테이너 xml dd 부분 선언
	xmlns:p="XXXX"
	xmlns:c="XXXX"
	형식으로 선언이 되어 있어야 한다.
2. property 선언 변경
	<bean
		<property name="프로퍼티명" value="데이터할당">
		<property name="프로퍼티명" ref="참조명"
		==>
		<bean p:프로퍼티명 ="데이터할당"
		<	  p:프로퍼티명-ref ="참조명"
				
		형식으로 변경하여 보다 코드를 간편화 한다.
3. constructor 선언변경
	<bean
		<constructor-arg>데이터설정
		<constructor-arg>참조명
	==> 
	<bean c:생성자매개변수=데이터할당
		  c:_0 ="데이터할당	
		  c:_1 ="데이터할당
		  c:생성자매개변수-ref="참조명"	
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
Map: generic으로 type지정 <map><entry key="" value="">
Properties : type을 자유롭게 사용 <props><prop key="">값설정</>
class BaseTeam{
	private Map<Integer, String> hitOrders;
	private Properties defends;
	
}
	<property name="hitOrders">
		<map>
			<entry key="1" value="홍길동"/>
			<entry key="2" value="김길동"/>
			<entry key="3" value="신길동"/>
			.
			.
			<entry key="9" value="마길동"/>
	<property name="defends">
		<props>
			<prop key="투수" value="김길동"/>
			<prop key="포수" value="신길동"/>
			<prop key="1루수" value="오길동"/>
			<prop key="2투수" value="마길동"/>
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
[1단계:확인] 5. callback메서드를 이용하여, 등록회원확인하기 누를때, 등록된 회원리스트나오고, alert(조회완료), 다시 등록회원닫기 누를때,
      닫아지면 등록회원확인 완료 alert()이 로딩되게 하세요.	 
      <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	
		$("h2").text("회원 정보 닫기(클릭)").click(function(){
			
		$(this).hide("slow",function(){
			alert("회원 정보 확인 완료")
			})		
		});
	});
</script>
</head>
<body>
	<h2></h2>
</body>
</html>
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
1)화면구현
	<input type="button" id="chBtn" value="등록회원조회">
	<div id="showList">
		<h2>등록회원리스트</h2>
	</div>
2)script
	$("#chBtn").click(function(){
		if($(this).val()=="등록회원확인"){
			$(this).val("등록회원닫기")
			$("#showList").show("slow",function(){
				alert("조회회원 확인")		
			});
		}else{
			$(this).val("등록회원확인")
			$("#showList").gide("slow",function(){
				alert("등록회원확인 완료")		
			});
		}
	});
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
});
</script>
</head>
<body>
	<input type="button" id="chBtn" value="등록회원조회">
	<div id="showList">
		<h2>등록회원리스트</h2>
	</div>
	
</body>
<script>
$("#showList").hide();
$("#chBtn").click(function(){
	if($(this).val()=="등록회원확인"){
		$(this).val("등록회원닫기")
		$("#showList").show("slow",function(){
			alert("조회회원 확인")		
		});
	}else{
		$(this).val("등록회원확인")
		$("#showList").hide("slow",function(){
			alert("등록회원확인 완료")		
			});
		}
	});
</script>
</html>
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script type="text/javascript">
/*
# 데이터 처리 기능 메서드와 callback함수 처리
1. text(), html(), val()
2. text(function(idx){
	// 다중의 요소객체의 경우 index값을 매개변수로 받고
	// 리턴값을 해당 데이터에 대한 처리를 할 수 있다.
	return "처리할 데이터";
})
 */
	$(document).ready(function(){
		$("#show td").text(function(idx, txt){
			console.log(idx+""+txt)
			return idx+" hello"
		})
		// h3를 7개 만들고, 0-6 번호를 붙여 출력하세요
		// h2를 7개 만들고, 무지개 색상을 출력하세요
		var colors = ['red','orange','yellow','green','blue','navy','purple']
		$("h3").text(function(idx, txt){
			$(this).css("color",colors[idx])
			return colors[idx];
		})
		var aligns = ["left","center","right"]
		$(".in01").val(function(idx){
			$(this).css("text-align",aligns[idx%3])
			return colors[idx];
		})
	});
	</script>

</head>
<body>
	  <h2>콜백함수</h2>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <input type="text" class="in01"/>
	  <h3></h3>
	  <h3></h3>
	  <h3></h3>
	  <h3></h3>
	  <h3></h3>
	  <h3></h3>
	  <h3></h3>
	  <table id="show" width="300pt" height="300pt" border>
	  	<tr><td>기존데이터1</td><td></td><td></td></tr>
	  	<tr><td></td><td></td><td></td></tr>
	  	<tr><td></td><td>기존데이터2</td><td></td></tr>
	  </table>
</body>
</html>
	  -->
</body>
</html>