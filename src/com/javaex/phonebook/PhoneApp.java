package com.javaex.phonebook;

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
		
		Reader fr = new FileReader("./PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		List<Phone> pList = new ArrayList<Phone>();
		
		
		//PhoneDB를 읽어와서 List에 입력
		while(true) {
			String readDb = br.readLine();
			if(readDb == null) {
				break;
			}
			String[] sp = readDb.split(",");
			pList.add(new Phone(sp[0],sp[1],sp[2]));
		}
		
		System.out.println("**********************************************");
		System.out.println("*           전화번호 관리 프로그램           *");
		System.out.println("**********************************************");

		
		while(flag) {

			System.out.println();
			System.out.println("1.리스트   2.등록   3.삭제   4.검색   5.종료");
			System.out.println("----------------------------------------------");
			System.out.print(">메뉴번호: ");
			int num = sc.nextInt();
			
			switch(num) {
				case 1: //전체 리스트 출력
					
					int i = 1;
					for(Phone p : pList) {
						System.out.println(i+".   "+p.showPhone());
						i++;
					}
					
					break;
					
					
				case 2: //리스트에 등록
					sc.nextLine();
					System.out.print(">이름: ");
					String name = sc.nextLine();
					System.out.print(">휴대전화: ");
					String hp = sc.nextLine();
					System.out.print(">회사전화: ");
					String company = sc.nextLine();
					
					pList.add(new Phone(name,hp,company)); //pList에 추가
					
					for(Phone p : pList) {
						System.out.println(p.showPhone());
					}
					
					//PhoneDB에 추가
					Writer fw = new FileWriter("./PhoneDB.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					
					for(Phone p : pList) {
						
						String str = p.getName()+","+p.getHp()+","+p.getCompany();
						bw.write(str);
						bw.newLine();//줄바꿈
						
					}
					bw.close();
					System.out.println("[등록되었습니다.]");
					break;
					
					
				case 3: //리스트에서 삭제
					break;
					
					
				case 4: //리스트에서 검색
					break;
					
					
				case 5: //종료
					System.out.println("**********************************************");
					System.out.println("*                 감사합니다                 *");
					System.out.println("**********************************************");
					flag = false;
					break;
					
					
				default: //없는 메뉴 입력했을때
					System.out.println("[다시 입력해 주세요.]");
					break;
			}
		}
		sc.close();
		br.close();
		
	}

}
