package springweb.z03_hw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.z01_vo.Kimbap;
import springweb.z01_vo.Member;
import springweb.z01_vo.Team;

//springweb.z02_hw.A01_230110
@Controller
public class A01_230110 {
	// http://localhost:7080/springweb/point.do
	   @GetMapping("/point.do")
		public String point01() {
			return "WEB-INF\\views\\z01_hw\\a01_Point.jsp";
		}
		@PostMapping("/point.do")
		public String point02(
							@RequestParam("point") int point,
							Model d
					){
			return "WEB-INF\\views\\z01_hw\\a01_Point.jsp";
		}
	// http://localhost:7080/springweb/login90.do
		@GetMapping("/login90.do")
		public String login90() {
			return "WEB-INF\\views\\z01_hw\\a04_loginFrm.jsp";
		}
		@PostMapping("/login91.do")
		public String login91(
						@RequestParam("id") String id,
						@RequestParam("pass") String pass,
						Model d
				) {
			String msg = id.equals("himan")&&
					pass.equals("7777")?"로그인 성공":"로그인 실패";
			d.addAttribute("msg", msg);
			return "WEB-INF\\views\\z01_hw\\a04_loginFrm.jsp";
		}
		
		// 3) 초기화면에 임의의 구구단이 나오게 하고 정답을 입력하면 그 결과에 따라 정답/오답 출력되게 처리하세요(get/post 통합)
		/*	 
				 컨트롤 단: defaultValue를 통해 숫자값 처리
				 모델데이터로 임의의 2~9, 1~9 전달되게 처리한다.
				 화면에 form 안에 [ 3 ] X [ 4 ] ? [ @@ ] [정답확인]
				 형식으로 임의의 모델데이터를 input의 value값으로 전달하게 한다.
				 	모델데이터 rGrade, rCnt (문제제출), msg(정답처리)
				 
				 요청값 : grade, cnt, inRelpy로 선언하여 전달한다.
				 ex) @RequestParam(value="grade", defaultValue="0") int grade,
				 다시 controller에 요청데이터를 전달하여 
				 해당 값이 맞으면 정답 그렇지 않으면 오답이 되게 처리한다.
				 그 결과 내용을 alert으로 로딩이 되게하고, 다음 문제가 풀어지게 
				 한다.   
		 */
		// http://localhost:7080/springweb/gugu100.do
		@RequestMapping("/gugu100.do")
		public String gugu100(
					@RequestParam(value="grade", defaultValue="0") int grade,
					@RequestParam(value="cnt", defaultValue="0") int cnt,
					@RequestParam(value="inRelpy", defaultValue="0") int inRelpy,
					Model d
				) {
			//rGrade, rCnt
			d.addAttribute("rGrade", (int)(Math.random()*8+2));
			d.addAttribute("rCnt", (int)(Math.random()*9+1));
			if(grade!=0) { // 초기화면과 구분
				String msg = grade*cnt==inRelpy?"정답":"오답";
				d.addAttribute("msg", msg);
						
			}
			return "WEB-INF\\views\\z01_hw\\a05_guguFrm.jsp";
		}
		//   4) 컴퓨터와 하는 가위바위보라는 타이틀로 해당 내용을 선택했을 때, 컴퓨터와 나의 결과에 따라 승/무/패가 처리되게 하세요.(get/post 통합)
		/*	result(승,무,패) 
		 	요청값 가위바위보 선택 index 0,1,2 나의 선택 0,1,2
		 		mySel
		 		<select name="mySel">
		 			<option value="0">가위
		 			<option value="1">바위
		 			<option value="2">보
			모델데이터 
				String [] games=["가위","바위","보"];
				int comIdx = (int)(Math.random()*3);
				com(가위,바위,보), my(가위,바위,보)
				if( comIdx==mySel){
					result = "무승부"
				}else((comIdx+1)%3==mySel){
					result = "컴퓨터 승"
				}else{
					result = "나의 승"
				}
				String com = games[comIdx]
				String my = games[mySel]
				String msg = "컴퓨터:"+com+", 나:"+my+"\n"
					+result
				d.addAttribute("msg",msg);
		 */
		//http://localhost:7080/springweb/game10.do
		@RequestMapping("/game10.do")
		public String game10(
				@RequestParam(value="mySel", defaultValue="-1")int myIdx,
				Model d) {
			System.out.println(" 선택"+ myIdx);
			// 초기화면 구분 
			if(myIdx != -1) {
				String [] games={"가위","바위","보"};
				int comIdx = (int)(Math.random()*3);
				//com(가위,바위,보), my(가위,바위,보)
				String result ="";
				if( comIdx==myIdx){
					result = "무승부";
				//{"가위","바위","보"} 컴퓨터 
				//  0      1     2
				//{"가위","바위","보"}  나 
				//  0      1     2
				}else if((comIdx+1)%3==myIdx){
					result = "나의 승";
				}else{
					result = "컴퓨터의 승";
				}
				String com = games[comIdx];
				String my = games[myIdx];
				String msg = "컴퓨터:"+com+", 나:"+my+"\\n"
					+result;
				d.addAttribute("msg",msg);
			}
			return "WEB-INF\\views\\z01_hw\\a06_gameFrm.jsp";
		}
		
		//  http://localhost:7080/springweb/teamIns.do
		@RequestMapping("/teamIns.do")
		public String callTeam(Team team, Model d) {
			System.out.println("#프리미어리그#");
			System.out.println("팀:"+team.getTname());
			System.out.println("승:"+team.getWin());
			System.out.println("무:"+team.getDraw());
			System.out.println("패:"+team.getLose());
			System.out.println("골득실:"+team.getGoal());
			return "WEB-INF\\views\\z01_hw\\a02_insertTeam.jsp";
		}
		//  http://localhost:7080/springweb/memberIns.do
		@RequestMapping("/memberIns.do")
		public String callMember(Member member, Model d) {
			System.out.println("#프리미어리그#");
			System.out.println("아이디:"+member.getId());
			System.out.println("회원명:"+member.getName());
			System.out.println("패스워드:"+member.getPass());
			System.out.println("권한:"+member.getAuth());
			System.out.println("포인트:"+member.getPoint());
			return "WEB-INF\\views\\z01_hw\\a03_insertMember.jsp";
		}
		/*
		 3) 김밥의 갯수나 가격   가격[0] 갯수 @ 총계 @@@  [다음 1개 확인] 초기화면이고 클릭시 마다 입력된 가격에서 한개씩 갯수가 올라가
                  계산되게 하세요..
                  [3000] 갯수 1  총계 3000  [다음 2개 확인-버튼] 
                  [3000] 갯수 2  총계 6000  [다음 3개 확인-버튼]  
		 요청값 : price, cnt
		 모델값 : tot 
		  Kimbap VO price, cnt, tot
		 매개변수 VO 생성 
		   		Kimbap kb 
		 kb.getPrice()>0
		 	kb.setCnt(kb.getCnt()+1);
		 	kb.setTot(kb.getPrice()*kb.getCnt());
		 name="price" value="${Kimbap.price}"	
		 name="cnt" value="${Kimbap.cnt}"
		 ${Kimbap.tot}	
		 다음 ${Kimbap.cnt+1t}개 확인-버튼	
		 
		 */
		//http://localhost:7080/springweb/kimbap.do
		@RequestMapping("/kimbap.do")
		public String kimbap(Kimbap kb) {
			if(kb.getPrice()>0) {
				kb.setCnt(kb.getCnt()+1);
				kb.setTot(kb.getPrice()*kb.getCnt());
			}
			return "WEB-INF\\views\\z01_hw\\a07_kimbapFrm.jsp";
		}
	}

