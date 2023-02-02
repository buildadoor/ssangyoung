package z03_kurlyproject;

import java.net.SecureCacheResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javaexp.a13_database.DB;
import z03_kurlyproject.vo.User;


public class A0_Practice {
	
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A0_Practice dao = new A0_Practice();
		
		System.out.println("메뉴선택");
		System.out.println("1.로그인 2.회원가입");
		
		switch(sc.nextInt()) {
		case 1:
			boolean check = true;
			String loginId;
			String loginPass;
			User empLogin = new User();
			do {
				if (!check) {
					System.out.println("로그인 실패! 다시입력해주세요.");
				}
				System.out.println("# 로그인 #");
				System.out.println("# 로그인할 정보를 입력해주세요 #");
				System.out.print("id:");
				loginId = sc.next();
				System.out.print("pass:");
				loginPass = sc.next();
				
				empLogin.setId(loginId);
				empLogin.setPassword(loginPass);

				check = false;
			} while (!dao.login(empLogin));
			System.out.println("로그인 성공!!");
			
			String auth = "null";
			List<User> list = dao.userInfo(loginId);
			
			if(list.get(0).getAuth().equals("관리자")) {
				System.out.println("관리자로 로그인하셨습니다.");
				int n = 1;
				while(n != 0) {
					System.out.println("# 관리자 메뉴 #");
					System.out.println("1.물품관리 2.고객센터 3.회원조회 0.로그아웃");
					System.out.print("메뉴 입력:");
					switch(sc.nextInt()) {
					case 1:
						System.out.println("물품관리 메뉴입니다.");
						System.out.println("┌──────────────────────────┐");
						System.out.println("│ 1.물품등록 2.물품수정 3.물품삭제 │");
						System.out.println("└──────────────────────────┘");
						System.out.print("원하는 카테고리를 선택해주세요:");
						
						switch(sc.nextInt()) {
						case 1:
							System.out.println("# 물품 등록 #");
							System.out.println("등록할 물품의 정보를 입력해주세요!");
							System.out.print("카테고리:");
							String category = sc.next();
							System.out.print("이름:");
							Scanner sc1 = new Scanner(System.in);
							String productName = sc1.nextLine();
							System.out.print("가격:");
							int price = sc.nextInt();
							System.out.println("제품설명(입력 완료시 Q를 입력해주세요):");
							StringBuilder sb = new StringBuilder();
							while(true) {
								Scanner sc2 = new Scanner(System.in);
								String st = sc2.nextLine();
								if(st.equals("Q")) break;
								sb.append(st+"\n");
							}
							System.out.print("판매자:");
							String manufacturer = sc.next();
							
							dao.insertProduct(category, productName, price, sb.toString(), manufacturer);
							System.out.println("제품 등록 완료!");
							break;
						case 2:
							System.out.println("# 물품 수정 #");
							System.out.print("수정할 물품의 번호를 입력해주세요:");
							int productNo = sc.nextInt();
							
							List<Product> plist = dao.schProNo(productNo);
							if(plist.size()==0) {
								System.out.println("등록된 물품이 없습니다. 메뉴로 돌아갑니다.");
								break;
							}
							System.out.print("제품번호\t카테고리\t이름\t\t가격\t판매자\t제품등록일자\t할인률\n");
							System.out.print(plist.get(0).getProductNo()+"\t"+plist.get(0).getCategory()+"\t"+String.format("%-10s", plist.get(0).getName())+"\t"+plist.get(0).getPrice()+"\t"+plist.get(0).getManufacturer()+"\t"+plist.get(0).getRegidate()+"\t"+plist.get(0).getDiscount()+"%\n");
							System.out.println("# 제품 상세 설명 #");
							System.out.print(plist.get(0).getInfo());
							System.out.println("수정할 정보를 선택해주세요.");
							System.out.println("1.카테고리 2.이름 3.가격 4.판매자 5.할인율 6.제품상세설명");
							System.out.print("입력:");
							switch(sc.nextInt()) {
							case 1:
								System.out.print("변경할 카테고리명을 입력하세요:");
								String category1 = sc.next();
								plist.get(0).setCategory(category1);
								dao.updateProduct(plist.get(0), productNo);
								System.out.println("변경 완료! 메뉴로 돌아갑니다.");
								break;
							case 2:
								System.out.print("변경할 이름을 입력해주세요:");
								Scanner sc2 = new Scanner(System.in);
								String productName1 = sc2.nextLine();
								plist.get(0).setName(productName1);
								dao.updateProduct(plist.get(0), productNo);
								System.out.println("변경 완료! 메뉴로 돌아갑니다.");
								break;
							case 3:
								System.out.print("변경할 가격을 입력해주세요:");
								int price1 = sc.nextInt();
								plist.get(0).setPrice(price1);;
								dao.updateProduct(plist.get(0), productNo);
								System.out.println("변경 완료! 메뉴로 돌아갑니다.");
								break;
							case 4:
								System.out.print("변경할 제조사를 입력해주세요:");
								String manufacturer1 = sc.next();
								plist.get(0).setManufacturer(manufacturer1);;
								dao.updateProduct(plist.get(0), productNo);
								System.out.println("변경 완료! 메뉴로 돌아갑니다.");
								break;
							case 5:
								System.out.print("변경할 할인율을 입력해주세요:");
								int discount = sc.nextInt();
								plist.get(0).setDiscount(discount);;
								dao.updateProduct(plist.get(0), productNo);
								System.out.println("변경 완료! 메뉴로 돌아갑니다.");
								break;
							case 6:
								System.out.println("변경할 상세설명을 입력해주세요(종료시 Q):");
								StringBuilder sb1 = new StringBuilder();
								while(true) {
									Scanner sc3 = new Scanner(System.in);
									String st = sc3.nextLine();
									if(st.equals("Q")) break;
									sb1.append(st+"\n");
								}
								plist.get(0).setInfo(sb1.toString());
								dao.updateProduct(plist.get(0), productNo);
								System.out.println("변경 완료! 메뉴로 돌아갑니다.");
							default:
								System.out.println("잘못된 입력값입니다. 메뉴로 돌아갑니다.");
							}
							break;
						case 3:
							System.out.println("# 물품 삭제 #");
							System.out.print("삭제할 물품의 번호를 입력해주세요:");
							
							int productNo1 = sc.nextInt();
							
							List<Product> plist1 = dao.schProNo(productNo1);
							
							System.out.print("제품번호\t카테고리\t이름\t\t가격\t판매자\t제품등록일자\t할인률\n");
							System.out.print(plist1.get(0).getProductNo()+"\t"+plist1.get(0).getCategory()+"\t"+String.format("%-10s", plist1.get(0).getName())+"\t"+plist1.get(0).getPrice()+"\t"+plist1.get(0).getManufacturer()+"\t"+plist1.get(0).getRegidate()+"\t"+plist1.get(0).getDiscount()+"%\n");
							System.out.println("# 제품 상세 설명 #");
							System.out.print(plist1.get(0).getInfo());
							
							System.out.println("삭제하시겠습니까?(Y/N)");
							String c = sc.next();
							if(c.equals("Y")) {
								dao.deleteProduct(productNo1);
								System.out.println("삭제 완료. 메뉴로 돌아갑니다.");
							} else if(c.equals("N")) {
								System.out.println("취소. 메뉴로 돌아갑니다.");
							} else {
								System.out.println("잘못된 입력값입니다. 메뉴로 돌아갑니다.");
							}
							break;
						}
						break;
					case 2:
						System.out.println("공지사항 메뉴입니다.");
						System.out.println("┌────────────────────────────────────────────────┐");
						System.out.println("│ 1.공지사항 등록 2.공지사항 수정 3.공지사항 삭제 4.문의하기 답변│");
						System.out.println("└────────────────────────────────────────────────┘");
						System.out.print("원하는 카테고리를 선택해주세요:");
						
						switch(sc.nextInt()) {
						case 1:
							System.out.println("# 공지사항 등록 #");
							System.out.print("공지사항명을 입력해주세요:");
							Scanner sc02 = new Scanner(System.in);
							String noticeName = sc02.nextLine();
							
							System.out.println("내용을 입력해주세요(종료시 Q)");
							StringBuilder sb1 = new StringBuilder();
							while(true) {
								Scanner sc3 = new Scanner(System.in);
								String st = sc3.nextLine();
								if(st.equals("Q")) break;
								sb1.append(st+"\n");
							}
							
							System.out.print("공지 종료 일자를 입력해주세요(YYYY/MM/DD):");
							String noticeEndDate = sc.next();
							int userno = list.get(0).getUserno();
							dao.insertNotice(userno, noticeName, sb1.toString(), noticeEndDate);
							System.out.println("등록 완료. 메뉴로 돌아갑니다.");
							break;
						case 2:
							System.out.println("# 공지사항 수정 #");
							System.out.println("공지사항 목록");
							
							List<Notice> nlist = dao.noticeList();
							if(nlist.size()==0) {
								System.out.println("등록된 공지가 없습니다. 메뉴로 돌아갑니다.");
								break;
							}
							for(Notice n1:nlist) {
								System.out.println("공지번호\t등록자번호\t공지사항명\t공지등록일자\t공지종료일");
								System.out.print(n1.getNoticeNo()+"\t"+n1.getUserno()+"\t"+n1.getNoticeName()+"\t"+n1.getRegidate()+"\t"+n1.getEndDate()+"\n");
								System.out.println("내용");
								System.out.println(n1.getContents());
							}
							
							System.out.print("수정할 공지의 번호를 입력해주세요:");
							int noticeN = sc.nextInt();
							
							List<Notice> nlist1 = dao.schNoticeNo(noticeN);
							System.out.println("1.공지사항명 2.공지종료일 3.내용");
							switch(sc.nextInt()) {
							case 1:
								System.out.print("변경할 공지사항명을 입력해주세요:");
								Scanner sc03 = new Scanner(System.in);
								String noticeName1 = sc03.nextLine();
								
								nlist1.get(0).setNoticeName(noticeName1);
								
								dao.updateNotice(nlist1.get(0), noticeN);
								break;
							case 2:
								System.out.print("변경할 공지종료일을 입력해주세요(YYYY/MM/DD):");
								String endDate = sc.next();
								
								nlist1.get(0).setEndDate(endDate);
								
								dao.updateNotice(nlist1.get(0), noticeN);
								break;
							case 3:
								System.out.println("변경할 공지 내용을 입력해주세요(종료시 Q)");
								StringBuilder sb2 = new StringBuilder();
								while(true) {
									Scanner sc3 = new Scanner(System.in);
									String st = sc3.nextLine();
									if(st.equals("Q")) break;
									sb2.append(st+"\n");
								}
								nlist1.get(0).setContents(sb2.toString());
								dao.updateNotice(nlist1.get(0), noticeN);
								System.out.println("변경 완료! 메뉴로 돌아갑니다.");
								break;
							}
							break;
						case 3:
							System.out.println("# 공지 삭제 #");
							System.out.println("공지사항 목록");
							
							List<Notice> nlist2 = dao.noticeList();
							System.out.println("공지번호\t등록자번호\t공지사항명\t공지등록일자\t공지종료일");
							for(Notice n1:nlist2) {
								System.out.print(n1.getNoticeNo()+"\t"+n1.getUserno()+"\t"+n1.getNoticeName()+"\t"+n1.getRegidate()+"\t"+n1.getEndDate()+"\n");
								System.out.println("내용");
								System.out.println(n1.getContents());
							}
							
							System.out.print("삭제할 공지의 번호를 입력해주세요:");
							int noticeN1 = sc.nextInt();
							
							System.out.println("삭제하시겠습니까?(Y/N)");
							String c = sc.next();
							if(c.equals("Y")) {
								dao.deleteNotice(noticeN1);
								System.out.println("삭제 완료. 메뉴로 돌아갑니다.");
							} else if(c.equals("N")) {
								System.out.println("취소. 메뉴로 돌아갑니다.");
							} else {
								System.out.println("잘못된 입력값입니다. 메뉴로 돌아갑니다.");
							}
							break;
						case 4:
							System.out.println("# 문의 목록 #");
							dao.schQna();
							
							System.out.print("답변을 등록할 문의의 번호를 입력해주세요:");
							int QnaNum = sc.nextInt();
							
							System.out.println("답변을 입력해주세요(종료시 Q)");
							StringBuilder sb2 = new StringBuilder();
							while(true) {
								Scanner sc3 = new Scanner(System.in);
								String st = sc3.nextLine();
								if(st.equals("Q")) break;
								sb2.append(st+"\n");
							}
							dao.updateAns(QnaNum, sb2.toString());
							System.out.println("답변 등록 완료. 메뉴로 돌아갑니다.");
							break;
						}
						break;
					case 3:
						System.out.println("# 회원 리스트 조회 #");
						List<User> list01 = dao.userList();
						
						System.out.print(String.format("%-5s %-5s %-14s %-12s %-9s %-9s %-9s %-5s\n", "회원번호","이름","주민번호","주소","아이디","비밀번호","포인트","권한"));
						
						for(User u:list01) {
							System.out.print(String.format("%-6s %-5s %-15s %-11s %-10s %-10s %-10s %-5s\n", u.getUserno(),u.getUsername(),u.getRrn(),u.getAddress(),u.getId(),u.getPassword(),u.getPoint(),u.getAuth()));
						}
						break;
					case 0:
						System.out.println("로그아웃 하겠습니다.");
						n = 0;
						System.exit(0);
					default:
						System.out.println("잘못된 입력값입니다. 다시입력해주세요");	
					}
				}
			} else {
				System.out.println("사용자로 로그인하셨습니다.");
				int n = 1;
				while(n != 0) {
					System.out.println("# 사용자 메뉴 #");
					System.out.print("1.카테고리 ");
					System.out.print("2.물품 검색 ");
					System.out.print("3.신상품 목록 ");
					System.out.print("4.알뜰쇼핑 ");
					System.out.print("5.장바구니 ");
					System.out.print("6.고객센터 ");
					System.out.print("7.회원탈퇴 ");
					System.out.println("0.로그아웃");
					System.out.print("메뉴 입력:");
					switch(sc.nextInt()) {
					case 1:
						System.out.println("카테고리 메뉴입니다.");
						System.out.println("┌────────────────┐");
						System.out.println("│ 1.채소 2.정육/계란 │");
						System.out.println("└────────────────┘");
						System.out.print("원하는 카테고리를 선택해주세요:");
						switch(sc.nextInt()) {
						case 1:
							List<Product> plist1 = dao.schProCategory("채소");
							if(plist1.size()==0) {
								System.out.println("채소 카테고리에 등록된 상품이 없습니다. 메뉴로 돌아갑니다.");
								break;
							}
							System.out.println("# 채소 카테고리 목록 #");
							for(int i=0; i<plist1.size(); i++) {
								System.out.print("제품번호\t카테고리\t이름\t\t가격\t판매자\t제품등록일자\t할인률\n");
								System.out.print(plist1.get(i).getProductNo()+"\t"+plist1.get(i).getCategory()+"\t"+String.format("%-10s", plist1.get(i).getName())+"\t"+plist1.get(i).getPrice()+"\t"+plist1.get(i).getManufacturer()+"\t"+plist1.get(i).getRegidate()+"\t"+plist1.get(i).getDiscount()+"%\n");
								System.out.println("# 제품 상세 설명 #");
								System.out.print(plist1.get(i).getInfo());
							}
							
							break;
						case 2:
							List<Product> plist2 = dao.schProCategory("정육/계란");
							if(plist2.size()==0) {
								System.out.println("정육/계란 카테고리에 등록된 상품이 없습니다. 메뉴로 돌아갑니다.");
								break;
							}
							System.out.println("# 정육/계란 카테고리 목록 #");
							for(int i=0; i<plist2.size(); i++) {
								System.out.print("제품번호\t카테고리\t이름\t\t가격\t판매자\t제품등록일자\t할인률\n");
								System.out.print(plist2.get(i).getProductNo()+"\t"+plist2.get(i).getCategory()+"\t"+String.format("%-10s", plist2.get(i).getName())+"\t"+plist2.get(i).getPrice()+"\t"+plist2.get(i).getManufacturer()+"\t"+plist2.get(i).getRegidate()+"\t"+plist2.get(i).getDiscount()+"%\n");
								System.out.println("# 제품 상세 설명 #");
								System.out.print(plist2.get(i).getInfo());
							}
							
						}
						break;
					case 2:
						System.out.print("검색어를 입력해주세요:");
						String searchName = sc.next();
						List<Product> plist1 = dao.schProSearch(searchName);
						if(plist1.size()==0) {
							System.out.println("검색어와 일치하는 상품이 없습니다. 메뉴로 돌아갑니다.");
							break;
						}
						System.out.println("# 검색 목록 #");
						System.out.print("제품번호\t카테고리\t이름\t\t가격\t판매자\t제품등록일자\t할인률\n");
						System.out.print(plist1.get(0).getProductNo()+"\t"+plist1.get(0).getCategory()+"\t"+String.format("%-10s", plist1.get(0).getName())+"\t"+plist1.get(0).getPrice()+"\t"+plist1.get(0).getManufacturer()+"\t"+plist1.get(0).getRegidate()+"\t"+plist1.get(0).getDiscount()+"%\n");
						System.out.println("# 제품 상세 설명 #");
						System.out.print(plist1.get(0).getInfo());
						break;
					case 3:
						System.out.println("# 신상품 목록 #");
						List<Product> plist2 = dao.schPro();
						if(plist2.size()==0) {
							System.out.println("등록된 상품이 없습니다. 메뉴로 돌아갑니다.");
							break;
						}
						int num = 1;
						if(plist2.size()>=10) {
							for(int i=plist2.size()-1; i>plist2.size()-11; i--) {
								System.out.println(num+++"번");
								System.out.print("제품번호\t카테고리\t이름\t\t가격\t판매자\t제품등록일자\t할인률\n");
								System.out.print(plist2.get(i).getProductNo()+"\t"+plist2.get(i).getCategory()+"\t"+String.format("%-10s", plist2.get(i).getName())+"\t"+plist2.get(i).getPrice()+"\t"+plist2.get(i).getManufacturer()+"\t"+plist2.get(i).getRegidate()+"\t"+plist2.get(i).getDiscount()+"%\n");
								System.out.println("# 제품 상세 설명 #");
								System.out.println(plist2.get(i).getInfo());
							}
						} else {
							for(int i=plist2.size()-1; i>=0; i--) {
								System.out.println(num+++"번");
								System.out.print("제품번호\t카테고리\t이름\t\t가격\t판매자\t제품등록일자\t할인률\n");
								System.out.print(plist2.get(i).getProductNo()+"\t"+plist2.get(i).getCategory()+"\t"+String.format("%-10s", plist2.get(i).getName())+"\t"+plist2.get(i).getPrice()+"\t"+plist2.get(i).getManufacturer()+"\t"+plist2.get(i).getRegidate()+"\t"+plist2.get(i).getDiscount()+"%\n");
								System.out.println("# 제품 상세 설명 #");
								System.out.println(plist2.get(i).getInfo());
							}
						}
						
						System.out.println("신상품 조회 완료. 메뉴로 돌아갑니다.");
						break;
					case 4:
						System.out.println("# 알뜰쇼핑 #");
						List<Product> plist = dao.schPro();
						if(plist.size()==0) {
							System.out.println("등록된 상품이 없습니다. 메뉴로 돌아갑니다.");
							break;
						}
						
						Comparator<Product> cp = new Comparator<Product>() {
							@Override
							public int compare(Product data1, Product data2) {
								int a = data1.getDiscount();
								int b = data2.getDiscount();
								
								if(a > b) {
									return -1;
								} else if (a<b) {
									return 1;
								} else {
									if(data1.getName().compareTo(data2.getName()) < 0)
										return -1;
									else
										return 1;
								}
							}
						};
						
						Collections.sort(plist, cp);
						
						if(plist.size()>=10) {
							for(int i=0; i<10; i++) {
								System.out.println((i+1)+"번");
								System.out.print("제품번호\t카테고리\t이름\t\t가격\t판매자\t제품등록일자\t할인률\n");
								System.out.print(plist.get(i).getProductNo()+"\t"+plist.get(i).getCategory()+"\t"+String.format("%-10s", plist.get(i).getName())+"\t"+plist.get(i).getPrice()+"\t"+plist.get(i).getManufacturer()+"\t"+plist.get(i).getRegidate()+"\t"+plist.get(i).getDiscount()+"%\n");
								System.out.println("# 제품 상세 설명 #");
								System.out.println(plist.get(i).getInfo());
							}
						} else {
							for(int i=0; i<plist.size(); i++) {
								System.out.println((i+1)+"번");
								System.out.print("제품번호\t카테고리\t이름\t\t가격\t판매자\t제품등록일자\t할인률\n");
								System.out.print(plist.get(i).getProductNo()+"\t"+plist.get(i).getCategory()+"\t"+String.format("%-10s", plist.get(i).getName())+"\t"+plist.get(i).getPrice()+"\t"+plist.get(i).getManufacturer()+"\t"+plist.get(i).getRegidate()+"\t"+plist.get(i).getDiscount()+"%\n");
								System.out.println("# 제품 상세 설명 #");
								System.out.println(plist.get(i).getInfo());
							}
						}
						
						System.out.println("조회완료. 메뉴로 돌아갑니다.");
						break;
					case 5:
						break;
					case 6:
						System.out.println("고객센터 메뉴입니다.");
						System.out.println("┌─────────────────────┐");
						System.out.println("│ 1.문의 및 답변 2.공지사항 │");
						System.out.println("└─────────────────────┘");
						System.out.print("원하는 카테고리를 선택해주세요:");
						
						switch(sc.nextInt()) {
						case 1:
							System.out.println("문의 및 답변");
							System.out.println("┌─────────────────────┐");
							System.out.println("│ 1.문의하기 2.내 문의 목록 │");
							System.out.println("└─────────────────────┘");
							System.out.print("원하는 카테고리를 선택해주세요:");
							
							switch(sc.nextInt()) {
							case 1:
								System.out.println("문의하실 내용을 입력해주세요(종료시 Q)");
								StringBuilder sb1 = new StringBuilder();
								while(true) {
									Scanner sc3 = new Scanner(System.in);
									String st = sc3.nextLine();
									if(st.equals("Q")) break;
									sb1.append(st+"\n");
								}
								dao.insertQna(list.get(0).getUserno(), sb1.toString());
								System.out.println("문의 등록 완료. 메뉴로 돌아갑니다.");
								
								break;
								
							case 2:
								System.out.println("# 내 문의 목록 #");
								System.out.println("내 회원번호:"+list.get(0).getUserno());
								dao.mySchQna(list.get(0).getUserno());
								
								System.out.print("답변을 확인할 문의의 번호를 입력해주세요:");
								int no = sc.nextInt();
								dao.schAns(no);
								System.out.println("답변 확인 완료. 메뉴로 돌아갑니다.");
								break;
							}
							
							
							
							
							break;
						case 2:
							System.out.println("공지사항");
							System.out.println("공지사항 목록");
							
							List<Notice> nlist2 = dao.noticeList();
							System.out.println("공지번호\t등록자번호\t공지사항명\t공지등록일자\t공지종료일");
							for(Notice n1:nlist2) {
								System.out.print(n1.getNoticeNo()+"\t"+n1.getUserno()+"\t"+n1.getNoticeName()+"\t"+n1.getRegidate()+"\t"+n1.getEndDate()+"\n");
							}
							
							System.out.print("조회할 공지사항의 번호를 입력해주세요:");
							int noticeNo2 = sc.nextInt();
							
							List<Notice> nlist3 = dao.schNoticeNo(noticeNo2);
							System.out.println("# 내용 #");
							System.out.println(nlist3.get(0).getContents());
							
							System.out.println("공지사항 조회 완료. 메뉴로 돌아갑니다.");
							break;
							
						}
						break;
					case 7:
						System.out.println("# 회원 탈퇴 #");
						System.out.print("이름을 입력해주세요:");
						String name = sc.next();
						System.out.print("주민번호를 입력해주세요(000000-0000000):");
						String rrn = sc.next();
						System.out.print("비밀번호를 입력해주세요:");
						String password = sc.next();
						
						if(!(list.get(0).getPassword().equals(password)&&list.get(0).getUsername().equals(name)&&list.get(0).getRrn().equals(rrn))) {
							System.out.println("입력하신 정보가 일치하지 않습니다. 메뉴로 돌아갑니다.");
						} else {
							System.out.println("탈퇴하시겠습니까?(Y/N):");
							String y = sc.next();
							
							if(y.equals("Y")) {
								dao.deleteUser(list.get(0).getUserno());
								System.out.println("탈퇴완료");
								System.exit(0);
							} else {
								System.out.println("탈퇴를 취소하겠습니다.");
							}
						}
						break;
					case 0:
						System.out.println("로그아웃 하겠습니다.");
						n = 0;
						System.exit(0);
					default:
						System.out.println("잘못된 입력값입니다. 다시입력해주세요");
					}
				}
			}
			break;
		case 2:
			System.out.println("# 회원가입 #");
			System.out.print("등록할 아이디를 입력해주세요:");
			String id = sc.next();
			while(true) {
				
				List<User> list01 = dao.userInfo(id);
				
				if(list01.size() == 0) {
					System.out.println("아이디 중복체크 검사 통과!");
					break;
				} else {
					System.out.println("중복된 아이디가 있습니다. 다시입력해주세요");
					System.out.print("등록할 아이디를 입력해주세요:");
					id = sc.next();
				}
			}
			System.out.print("이름을 입력해주세요:");
			String name = sc.next();
			System.out.print("주민번호를 입력해주세요(000000-0000000):");
			String rrn = sc.next();
			System.out.print("주소를 입력해주세요:");
			Scanner sc01 = new Scanner(System.in);
			String address = sc01.nextLine();
			System.out.print("비밀번호를 입력해주세요:");
			String password = sc.next();
			
			dao.insertUser(name, rrn, address, id, password);
			System.out.println("회원 등록 완료!!");
			
			break;
		}

	}

	// 등록된 id 정보조회
	public List<User> userInfo(String id) {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM userlist where id=?";
		try {
			con = DB.con();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				User e = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7), rs.getString(8));
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB관련 에러 발생:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타 예외 발생:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return list;
	}
	
	// 회원 조회
	public List<User> userList() {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM userlist";
		try {
			con = DB.con();

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				User e = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7), rs.getString(8));
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB관련 에러 발생:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타 예외 발생:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return list;
	}
	
	// 회원 등록
	public void insertUser(String name, String rrn, String address, String id, String password) {
		String sql = "INSERT INTO userlist VALUES(USERNO_seq.nextval, ?, ?, ?, ?, ?, 0, '사용자')";
		try {
			con = DB.con();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, rrn);
			pstmt.setString(3, address);
			pstmt.setString(4, id);
			pstmt.setString(5, password);
			
			pstmt.executeUpdate();
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("입력 형식이 잘못되었습니다!");
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	//로그인 메서드
	public boolean login(User sch) {
		String sql = "SELECT * FROM userlist WHERE id LIKE ? AND password LIKE ?";
		boolean isLogin = false;
		try {

			con = DB.con();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getId());
			pstmt.setString(2, sch.getPassword());
			rs = pstmt.executeQuery();

			isLogin = rs.next();
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback 예외:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
	         DB.close(rs, pstmt, con);
		}

		return isLogin;
	}
	
	// 회원 탈퇴
	public void deleteUser(int userno) {
		String sql = "DELETE userlist WHERE userno=?";
		try {
			con = DB.con();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userno);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB 처리:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("");
			}
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 제품 등록
	public void insertProduct(String category, String productName, int price, String information, String manufacturer) {
		String sql = "INSERT INTO product02 values(productno_seq.nextval,?,?,?,?,?,sysdate,0)";
		try {
			con = DB.con();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, productName);
			pstmt.setInt(3, price);
			pstmt.setString(4, information);
			pstmt.setString(5, manufacturer);
			pstmt.executeUpdate();
			con.commit();

		} catch (SQLException e) {
			System.out.println("DB관련 예외:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 제품 전체 검색
		public List<Product> schPro() {
			List<Product> list = new ArrayList<Product>();
			String sql = "SELECT productno, classification, productname, price, manufacturer, to_char(regidate,'YYYY/MM/DD'),"
					+ "discount, information FROM product02";
			try {

				con = DB.con();
				con.setAutoCommit(false);

				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
					list.add(p);
				}
			} catch (SQLException e) {
				System.out.println("DB 에러:" + e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
					System.out.println("rollback 예외:" + e1.getMessage());
				}
			} catch (Exception e) {
				System.out.println("일반 예외:" + e.getMessage());
			} finally {
		         DB.close(rs, pstmt, con);
			}
			
			return list;
		}
		
	
	
	// 제품 번호로 검색
	public List<Product> schProNo(int productNo) {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT productno, classification, productname, price, manufacturer, to_char(regidate,'YYYY/MM/DD'),"
				+ "discount, information FROM product02 WHERE productno = ?";
		try {

			con = DB.con();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
				list.add(p);
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback 예외:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
	         DB.close(rs, pstmt, con);
		}
		
		return list;
	}
	
	// 제품 카테고리로 검색
	public List<Product> schProCategory(String category) {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT productno, classification,\r\n"
				+ "productname, price, manufacturer,\r\n"
				+ "to_char(regidate,'YYYY/MM/DD'), discount, information\r\n"
				+ "FROM product02 WHERE classification LIKE '%'||?||'%'";
		try {

			con = DB.con();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
				list.add(p);
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback 예외:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
	         DB.close(rs, pstmt, con);
		}
		
		return list;
	}
	
	// 검색어로 제품 조회
	public List<Product> schProSearch(String searchName) {
		List<Product> list = new ArrayList<Product>();
		String sql = "SELECT productno, classification,\r\n"
				+ "productname, price, manufacturer,\r\n"
				+ "to_char(regidate,'YYYY/MM/DD'), discount, information\r\n"
				+ "FROM product02 WHERE productname LIKE '%'||?||'%'";
		try {

			con = DB.con();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchName);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8));
				list.add(p);
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback 예외:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
	         DB.close(rs, pstmt, con);
		}
		
		return list;
	}
	
	
	// 물품 수정
	public void updateProduct(Product prod, int productNo) {
		String sql = "UPDATE product02\r\n"
				+ "SET classification = ?,\r\n"
				+ "	productname = ?,\r\n"
				+ "	price = ?,\r\n"
				+ "	manufacturer = ?,\r\n"
				+ "	discount = ?,\r\n"
				+ "	information = ? where productno = ?";
			try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, prod.getCategory());
			pstmt.setString(2, prod.getName());
			pstmt.setInt(3, prod.getPrice());
			pstmt.setString(4, prod.getManufacturer());
			pstmt.setInt(5, prod.getDiscount());
			pstmt.setString(6, prod.getInfo());
			pstmt.setInt(7, productNo);
			pstmt.executeUpdate();
			con.commit();
			} catch (SQLException e) {
			System.out.println("DB관련 예외:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 물품 삭제
	public void deleteProduct(int productno) {
		String sql = "DELETE FROM product02 WHERE productno = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productno);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB 처리:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 공지 등록
	public void insertNotice(int userno, String noticeName, String contents, String noticeEndDate) {
		String sql = "INSERT INTO notice values(noticeno_seq.nextval,?, ?, ?, sysdate, to_date(?,'YYYY/MM/DD'))";
		try {
			con = DB.con();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userno);
			pstmt.setString(2, noticeName);
			pstmt.setString(3, contents);
			pstmt.setString(4, noticeEndDate);
			pstmt.executeUpdate();
			con.commit();

		} catch (SQLException e) {
			System.out.println("DB관련 예외:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 공지 조회
	public List<Notice> noticeList() {
		List<Notice> list = new ArrayList<Notice>();
		String sql = "SELECT noticeno, userno, noticename, contents, TO_char(regidate,'YYYY/MM/DD'), TO_char(enddate,'YYYY/MM/DD') FROM notice";
		try {
			con = DB.con();

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Notice n = new Notice(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5),rs.getString(6));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB관련 에러 발생:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타 예외 발생:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return list;
	}
	
	// 공지 번호로 조회
	public List<Notice> schNoticeNo(int noticeNo) {
		List<Notice> list = new ArrayList<Notice>();
		String sql = "SELECT noticeno, userno, noticename, contents, TO_char(regidate,'YYYY/MM/DD'), TO_char(enddate,'YYYY/MM/DD') FROM notice where noticeno = ?";
		try {

			con = DB.con();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Notice N = new Notice(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				list.add(N);
			}
		} catch (SQLException e) {
			System.out.println("DB 에러:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback 예외:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 예외:" + e.getMessage());
		} finally {
	         DB.close(rs, pstmt, con);
		}
		
		return list;
	}
	
	// 공지 수정
	public void updateNotice(Notice notice, int noticeN) {
		String sql = "UPDATE notice\r\n"
				+ "SET noticename = ?,\r\n"
				+ "	contents = ?,\r\n"
				+ "	enddate = to_date(?,'YYYY/MM/DD') where noticeno = ?";
			try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, notice.getNoticeName());
			pstmt.setString(2, notice.getContents());
			pstmt.setString(3, notice.getEndDate());
			pstmt.setInt(4, noticeN);
			pstmt.executeUpdate();
			con.commit();
			} catch (SQLException e) {
			System.out.println("DB관련 예외:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 공지 삭제
	public void deleteNotice(int noticeNo) {
		String sql = "DELETE FROM notice WHERE noticeno = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB 처리:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 문의 등록
	public void insertQna(int userno, String content) {
		String sql = "INSERT INTO qna values(callno_seq.nextval, ?, ?, null)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userno);
			pstmt.setString(2, content);
			pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB관련 예외:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 문의 목록 조회
	public void schQna() {
		String sql = "SELECT callno, userno, question, NVL2(answer, '답변완료','답변없음') FROM qna";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println("등록번호\t회원번호\t답변");
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getString(4) + "\n");
				System.out.println("문의 내용");
				System.out.print(rs.getString(3) + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB관련 에러 발생:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타 예외 발생:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 내 문의 목록 조회
	public void mySchQna(int userno) {
		String sql = "SELECT callno, userno, question, NVL2(answer, '답변완료','답변없음') FROM qna where userno = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("등록번호\t회원번호\t답변");
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getString(4) + "\n");
				System.out.println("문의 내용");
				System.out.println(rs.getString(3) + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB관련 에러 발생:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타 예외 발생:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 답변 등록
	public void updateAns(int callno, String answer) {
		String sql = "UPDATE qna\r\n"
				+ "SET answer = ?\r\n"
				+ "WHERE callno = ?";
			try {
			con = DB.con();
			con.setAutoCommit(false);
				pstmt = con.prepareStatement(sql);
			pstmt.setString(1, answer);
			pstmt.setInt(2, callno);
			pstmt.executeUpdate();
			con.commit();
			} catch (SQLException e) {
			System.out.println("DB관련 예외:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	// 답변 조회
	public void schAns(int callno) {
		String sql = "SELECT QUESTION, nvl(answer, '답변이 등록되지 않았습니다.') FROM qna WHERE callno = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, callno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("# 문의 내용 #");
				System.out.print(rs.getString(1) + "\n");
				System.out.println("# 답변 내용 #");
				System.out.println(rs.getString(2) + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB관련 에러 발생:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("기타 예외 발생:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
}