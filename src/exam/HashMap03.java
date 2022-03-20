package exam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap03 {
	public static void main(String[] args) {
		String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};
		
		HashMap map = new HashMap();
		
		//반복문을 통해 data에 저장된 key가 몇번나오는지 저장함
		for(int i=0; i<data.length; i++) {
			if(map.containsKey(data[i])) {	//맵에 이미 해당 키가 존재하면
				Integer value = (Integer)map.get(data[i]);	//해당 값을 가져와 value에 저장
				map.put(data[i], new Integer(value.intValue() + 1));//해당 키에 값을 +1하여 저장
				
			} else {	//map에 (data배열에 저장된 요소로 key, 1) 저장 
				map.put(data[i], new Integer(1));
			}
		}
		
		Iterator it = map.entrySet().iterator();	//엔트리 Iterator 생성
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();	//it의 요소는 엔트리이므로 Map.Entry로 받음
			int value = ((Integer)entry.getValue()).intValue();	//엔트리 값을 래퍼클래스로 변환하여 intValue()메소드 사용
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
		
	}
	
	//문자 ch를 value만큼 반환하는 메소드
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for(int i=0; i<bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);	//new String(char[] chArr) ->문자 배열을 문자열로
	}
}
