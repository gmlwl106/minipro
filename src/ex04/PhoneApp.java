package ex04;


public class PhoneApp {

	public static void main(String[] args) {
		
		//화면 출력
		PhoneView pv = new PhoneView();
		//리스트 생성
		PhoneRepository pr = new PhoneRepository();
		
		boolean flag = true;

		pv.showTitle();

		
		while(flag) {

			int num = pv.showMenu();
			
			switch(num) {
				case 1: //전체 리스트 출력
					pv.showList(pr.getpList());
					break;
					
				case 2: //리스트에 등록
					Phone p = pv.showAdd();
					pr.addInfo(p);
					pv.showAddResult();
					break;
					
					
				case 3: //리스트에서 삭제
					pr.delInfo(pv.showDel());
					pv.showDelResult();
					break;
					
					
				case 4: //리스트에서 검색
					pv.showSearchResult(pr.getpList(), pv.showSearch());
					break;
					
					
				case 5: //종료
					flag = pv.showEnd();
					break;
					
					
				default: //없는 메뉴 입력했을때
					pv.showEtc();
					break;
			}
		}
		
	}

}
