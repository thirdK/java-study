package exam;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap01 {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김자바", new Integer(100));	//오토박싱으로 생략이 가능함
		map.put("이자바", 100);
//		map.put("이자바", 10);
		map.put("강자바", new Integer(80));
		map.put("안자바", 90);
		
		Set set = map.entrySet();//키와 값을 엔트리(키와 값의 결합) 형태로 set에 저장하여 반환
		Iterator it = set.iterator();
		//Iterator it = map.entrySet().iterator(); -> 어차피 set을 활용안하므로 바로 변환해서 사용해도됨
		
		//Map.Entry는 Map인터페이스에 정의된 static inner interface이다.
		//HashMap은 내부에서 Entry라는 내부클래스를 정의하고(key, value 필드가 존재함) 
		//Entry타입의 배열을 선언하여 key와 value를 하나의 배열로 관리한다.
		//이 방식이 객체지향적이며 무결성 적인 특면에서 더 좋다.
		
		//Object[] key;			Entry[] table;
		//Object[] value;		class Entry{
		//							Object key;
		//							Object value;
		//						}
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next(); //it의 요소는 엔트리이므로 Map.Entry 참조변수로 받음
			System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
		}
		
		set = map.keySet();
		System.out.println("참가자 명단 : " + set);
		
		Collection values = map.values();
		it = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			Integer i = (Integer)it.next();
			total += i.intValue(); //intValue()안써도 자동 언박싱됨
		}
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
	}
}




















