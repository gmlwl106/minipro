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
	
	public void showAddResult() {
		System.out.println("[등록되었습니다.]");
	}
	
	
	public void showSearchResult(List<Phone> pList) {
		int listNum = 1;
		for(Phone p : pList) {
			System.out.println(listNum+".   "+p.showPhone());
			listNum++;
		}
	}
	
	//프로그램 종료 출력
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
