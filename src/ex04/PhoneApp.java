package ex04;


public class PhoneApp {

	public static void main(String[] args) {
		
		//화면 출력
		PhoneView phoneview = new PhoneView();
		//리스트 생성
		PhoneRepository phonerepository = new PhoneRepository();
		
		boolean flag = true;

		phoneview.showTitle();

		
		while(flag) {

			int num = phoneview.showMenu();
			
			switch(num) {
				case 1: //전체 리스트 출력
					phoneview.showList(phonerepository.getpList());
					break;
					
				case 2: //리스트에 등록
					Phone p = phoneview.showAdd();
					phonerepository.addInfo(p);
					phoneview.showAddResult();
					break;
					
					
				case 3: //리스트에서 삭제
					phonerepository.delInfo(phoneview.showDel());
					phoneview.showDelResult();
					break;
					
					
				case 4: //리스트에서 검색
					phoneview.showSearchResult(phonerepository.getpList(), phoneview.showSearch());
					break;
					
					
				case 5: //종료
					flag = phoneview.showEnd();
					break;
					
					
				default: //없는 메뉴 입력했을때
					phoneview.showEtc();
					break;
			}
		}
		
	}

}
