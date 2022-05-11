package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
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
					System.out.println("<3.삭제>");
					System.out.print(">번호: ");
					int d_num = sc.nextInt();
					
					pList.remove(d_num-1);
					
					//PhoneDB에 추가
					fw = new FileWriter("./PhoneDB.txt");
					bw = new BufferedWriter(fw);
					
					//DB파일에 pList 덮어씌우기
					for(Phone p : pList) {
						String str = p.getName()+","+p.getHp()+","+p.getCompany();
						bw.write(str);
						bw.newLine();//줄바꿈
					}
					bw.close();
					
					break;
					
					
				case 4: //리스트에서 검색
					sc.nextLine();
					System.out.println("<4.검색>");
					System.out.print(">이름: ");
					String keyword = sc.nextLine();
					
					listNum = 1;
					for(Phone p : pList) {
						if(p.getName().contains(keyword)) {
							System.out.println(listNum+".   "+p.showPhone());
						}
						listNum++;
					}
					
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
