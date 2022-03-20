package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap01 {
	public static void main(String[] args) {
		String[] data = {"A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D"};
		//TreeMap은 이진검색트리의 형태이다.
		//즉, 정렬되어있다.
		TreeMap map = new TreeMap();
		
		for(int i=0; i<data.length; i++) {
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], new Integer(value.intValue() + 1));
			} else {
				map.put(data[i], new Integer(1));
			}
		}
		
		Iterator it = map.entrySet().iterator();
		
		//기본정렬은 key값을 기준으로 정렬되며
		//key값이 String 인스턴스이므로 String클래스에 정의된 정렬기준에 맞게 정렬된다.(a~z) 
		System.out.println("= 기본정렬 =");
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
		
		System.out.println();
		
		//map을 ArrayList로 변환 후 Collections.sort()로 정렬
		Set set = map.entrySet();
		List list = new ArrayList(set); // ArrayList(Collection c)
		
		//static void sort(List list. Comparator c)
		Collections.sort(list, new ValueComparator());
		//오버라이딩한 compare()메소드가 정의된 ValueComparator의 인스턴스를 sort()에 넘겨주면
		//list는 해당 기준에 맞게 정렬된다.
		
		it = list.iterator();
		
		System.out.println("= 값의 크기가 큰 순서로 정렬 =");
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
	}
	//inner class로 ValueComparator를 만든다. 이유는 sort()에 사용할 Comparator 구현(정렬할 기준을 만듬)
	static class ValueComparator implements Comparator {
		//Comparator는 두개의 인자를 받는 compare(Object o1, Object o2) 메소드를 오버라이딩하면 됨
		//Comparable은 한개의 인자를 받는 compareTo(Object o1) 메소드를 오버라이딩하면 됨
		//return 타입은 int이며 양수를 반환시 교환 음수를 반환시 유지
		public int compare(Object o1, Object o2) {
			if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
				Map.Entry e1 = (Map.Entry)o1;
				Map.Entry e2 = (Map.Entry)o2;
				
				int v1 = ((Integer)e1.getValue()).intValue();
				int v2 = ((Integer)e2.getValue()).intValue();
				return v2 - v1; //여기서 음수, 양수에따라 자리교환 여부가 결정됨
			}
			return -1;	//둘중 하나라도 엔트리가 아니면 비교할 필요없이 -1반환
		}
	}
	
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for(int i=0; i<bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar);
	}
}
























