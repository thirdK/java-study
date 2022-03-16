package exam;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayList01 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10); //제네릭 없이 생성 가능
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1,list2);
		
		Collections.sort(list1);	//Collections클래스의 sort()메서드를 사용하여 정렬함
		Collections.sort(list2);
		print(list1, list2);
		
		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
		//list2의 모든 객체를 list1이 포함하는지 boolean반환
		
		list2.add("B");	//따로 제네릭을 선언하지 않아서 다른 객체가 추가됨
		list2.add("C");
		list2.add(3, "A");	//add()는 기존 자리의 객체를 밀어낸다.(추가)
		print(list1, list2);
		
		list2.set(3, "AA");	//set()은 기존 자리의 객체를 덮어쓴다.(수정)
		print(list1, list2);
		
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
		//list1의 객체중 list2의 객체와 겹치는것만 남기고 나머지는 삭제
		print(list1, list2);
		
		for(int i=list2.size() -1 ; i>= 0; i--) {
			if(list1.contains(list2.get(i))) {
				list2.remove(i);
			}
		}//list2에서 list1과 겹치는 객체를 삭제한다.
		//index를 거꾸로 탐색하는 이유는 탐색중 삭제를 하게되면 인덱스 범위가 변경되기 때문이다.
		
		print(list1, list2);
		
		
	}
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list 1 : " + list1);
		System.out.println("list 2 : " + list2);
		System.out.println();
	}
}



















