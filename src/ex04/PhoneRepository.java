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

public class PhoneRepository {
	
	List<Phone> pList;
	

	//생성자
	public PhoneRepository() {
		this.pList = new ArrayList<Phone>();
		loadList();
	}
	
	//메소드 gs
	public List<Phone> getpList() {
		return pList;
	}


	//메소드 일반
	

	//파일 읽어와서 pList에 저장
	public void loadList() {
		try {
			Reader fr = new FileReader("./PhoneDB-copy.txt");
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				String readDb = br.readLine();
				if(readDb == null) {
					break;
				}
				String[] sp = readDb.split(",");
				pList.add(new Phone(sp[0],sp[1],sp[2]));
			}
			br.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//pList에 정보 등록
	public void addInfo(Phone p) {
		pList.add(p);
		saveList(pList);
	}
	
	
	//pList에서 정보 삭제
	public void delInfo() {
		saveList(pList);
	}
	
	
	//파일에 저장
	public void saveList(List<Phone> pList) {
		try {
			Writer fw = new FileWriter("./PhoneDB-copy.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			//DB파일에 pList 덮어씌우기
			for(Phone p : pList) {
				String str = p.getName()+","+p.getHp()+","+p.getCompany();
				bw.write(str);
				bw.newLine();//줄바꿈
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
