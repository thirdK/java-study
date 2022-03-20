package exam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap02 {
	static HashMap phoneBook = new HashMap();
	public static void main(String[] args) {
		//addPhoneNo( phoneBook의 키 , phoneBook의 값을 또 해쉬맵으로(키, 값) );
		//해쉬맵 안에 해쉬맵을 넣는 이 방식으로 1개의 키로 여러 값을 갖을 수 있다.
		
		//아래를 예시로 들면 친구/회사/세탁같은 그룹[key1], 정보[value1(이름[key2], 번호[value1])] 라는 구조이다.
		//친구라는 키로 여러 정보(값)을 담고 있다.
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-222-2222");
		addPhoneNo("친구", "김자바", "010-333-3333");
		addPhoneNo("회사", "김대리", "010-444-4444");
		addPhoneNo("회사", "김대리", "010-555-5555");
		addPhoneNo("회사", "박과장", "010-666-6666");
		addPhoneNo("회사", "이과장", "010-777-7777");
		addPhoneNo("세탁", "010-888-8888");
		
		printList();
	}
	
	//그룹에 전화번호 추가
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName); //새로운 그룹명이면 그룹에 추가함
		HashMap group = (HashMap)phoneBook.get(groupName);
		//phoneBook에서 일치하는 그룹명(key)으로 값(HashMap 인터페이스)를 가져옴
		//phoneBook이라는 해쉬맵에 저장된 값이 또 해쉬맵이라서 group을 HashMap참조변수로 선언한 것이다.
		group.put(tel, name);
		//가져온 해쉬맵 인스턴스에 이름과 전화번호를 입력한다.
		//여기서 이름은 중복될 수 있으므로 전화번호를 key로 설정한다.
	}
	//오버로딩
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}
	
	//그룹추가
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName)) { //HashMap의 인스턴스 phoneBook에 존재하지 않는 Key이면
			phoneBook.put(groupName, new HashMap());//phoneBook에 새 그룹명추가 -> put(키,값)
			//즉, phonBook인스턴스는 (key :그룹명, value : HashMap객체)의 형태이다
		}
	}
	
	
	//정화번호부 전체를 출력하는 메서드
	static void printList() {
		Set	set = phoneBook.entrySet();
		Iterator it = set.iterator(); //map의 엔트리 -> set -> iterator
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next(); //it의 요소는 엔트리이므로 Map.Entry 참조변수로 받음
			
			Set subSet = ((HashMap)e.getValue()).entrySet(); //여기서 e의 값은 또다시 해쉬맵 그 해쉬맵의 엔트리
			Iterator subIt = subSet.iterator();//내부에 있는 해쉬맵의 iter
			
			System.out.println(" * " + e.getKey() + " [" + subSet.size() + "]");
			
			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry)subIt.next(); //내부에 있는 해쉬맵의 엔트리 
				String telNo = (String)subE.getKey();//키와 값 분리
				String name = (String)subE.getValue();
				System.out.println(name + " " + telNo);
			}
			System.out.println();
		}
		
	}

}























