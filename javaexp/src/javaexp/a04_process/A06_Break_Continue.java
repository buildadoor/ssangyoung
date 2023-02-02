package javaexp.a04_process;

public class A06_Break_Continue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 #break 
 1.반복을 중단 처리
 #continue
 1.특정step의 내용을 중단 다음 내용으로 처리
 */
		for(int cnt=1;cnt<=10;cnt++) {
			if(cnt==5) break;
			System.out.print(cnt+", ");
		}
		System.out.println();
		for(int cnt=1;cnt<=10;cnt++) {
		if(cnt==5) continue;
		System.out.println(cnt+", ");
		}
		
		//ex) 1~12 전기 요금 (120000)출력하되
		//5월은 제외하여 출력하고, 각 월별 누적금액과
		//ex1)함께 출력하되, 총 금액이 800000이상일떄 
		//중단처리 하세요 
		/*
		for(int cnt=1;cnt<=12;cnt++) {
			if(cnt==5) break;
			}
			System.out.println();
			for(int cnt=1;cnt<=10;cnt++) {
			if(cnt==5) continue;
			System.out.println(cnt+"월"+cnt*120000+"원");
			}

			}
		
		*/
		int elePay = 120000;
		int eleTot = 0;
		System.out.println("월\t요금\t누적금액");
		for(int mt= 1;mt <= 12;mt++){
			if(mt==5) continue; //5월만 pass
			eleTot+=elePay;
			System.out.println(mt+"\t"+elePay+"\t"+eleTot);
			if(eleTot>=800000) break;//800000만 이상일때
		}
		}

}
