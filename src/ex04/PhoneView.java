package ex04;


import java.util.List;
import java.util.Scanner;

public class PhoneView {

	Scanner sc = new Scanner(System.in);
	
	
	//프로그램 타이틀 출력
	public void showTitle() {
		System.out.println("**********************************************");
		System.out.println("*           전화번호 관리 프로그램           *");
		System.out.println("**********************************************");
	}
	
	
	//메뉴 선택 창 출력
	public int showMenu() {
		System.out.println();
		System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
		System.out.println("----------------------------------------------");
		System.out.print(">메뉴번호: ");
		return sc.nextInt();
	}
	
	
	
	//1.리스트 출력
	public void showList(List<Phone> list) {
		System.out.println("<1.리스트>");
		showSearchResult(list);
	}
	
	
	
	//2.리스트에 등록
	public Phone showAdd() {
		Phone person = new Phone();
		
		System.out.println("<2.등록>");
		sc.nextLine();
		System.out.print(">이름: ");
		String name = sc.nextLine();
		System.out.print(">휴대전화: ");
		String hp = sc.nextLine();
		System.out.print(">회사전화: ");
		String company = sc.nextLine();
		
		person.setName(name);
		person.setHp(hp);
		person.setCompany(company);

		return person;
	}
	//등록되었음을 확인하는 글 출력
	public void showAddResult() {
		System.out.println("[등록되었습니다.]");
	}
	
	
	
	//3.삭제
	public int showDel() {
		System.out.println("<3.삭제>");
		System.out.print(">번호: ");
		int num = sc.nextInt();
		
		return num;		
	}
	//등록되었음을 확인하는 글 출력
	public void showDelResult() {
		System.out.println("[삭제되었습니다.]");
	}
	
	
	
	//4.검색
	public String showSearch() {
		sc.nextLine();
		System.out.println("<4.검색>");
		System.out.print(">이름: ");
		String keyword = sc.nextLine();
		
		return keyword;
	}
	
	
	
	
	//pList 전체 출력
	public void showSearchResult(List<Phone> pList) {
		int listNum = 1;
		for(Phone p : pList) {
			System.out.println(listNum+".   "+p.showPhone());
			listNum++;
		}
	}
	//검색결과 출력 (전체출력의 오버라이딩)
	public void showSearchResult(List<Phone> pList, String keyword) {
		int listNum = 1;
		for(Phone p : pList) {
			if(p.getName().contains(keyword)) {
				System.out.println(listNum+".   "+p.showPhone());
				listNum++;
			}
		}
	}
	
	
	
	//프로그램 종료글 출력
	public boolean showEnd() {
		System.out.println("**********************************************");
		System.out.println("*                 감사합니다                 *");
		System.out.println("**********************************************");
		return false;
	}
	
	//없는 메뉴
	public void showEtc() {
		System.out.println("[다시 입력해 주세요.]");
	}
	
	
	
}
