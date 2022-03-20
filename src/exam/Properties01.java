package exam;

import java.util.Enumeration;
import java.util.Properties;

public class Properties01 {
	public static void main(String[] args) {
		//Properties는 HashMap의 구버전인 Hashtable을 상속받아 구현한 것이다.
		//Hashtable과 차이점은 (키,값)을 (Object, Object)가 아니라 (String, String)으로 저장하는
		//단순한 컬렉션 클래스다.
		//주로 어플리케이션의 환경성정과 관련된 속성(property)을 저장하는데 사용함
		//데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공하므로 간단한 입출력은 Properties를 사용하는게 쉽다.
		
		Properties prop = new Properties();
		
		//prop에 키와 값(key, value)을 저장한다.
		prop.setProperty("timout", "30");	//모든 요소들을 String으로만 저장함
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		//prop에 저장된 요소들을 Enumeration을 이용해서 출력한다.
		Enumeration e = prop.propertyNames(); //propertyNames()메소드는 모든 key를 Enumeration으로 반환
		while(e.hasMoreElements()) {
			String element = (String)e.nextElement();//e가 가진 모든 키를 하나씩 가져와서 element에 저장
			System.out.println(element + " = " + prop.getProperty(element));//해당 키로 값을 가져옴
		}
		
		System.out.println();
		prop.setProperty("size", "20");	//값을 수정 (없는 key면 추가)
		System.out.println("size=" + prop.getProperty("size"));
		System.out.println("capacity=" + prop.getProperty("capacity", "20"));
		//"20"은 디폴트값이며 "capacity"가 존재하지 않으면 디폴트값이 출력된다.
		System.out.println("loadfactor=" + prop.getProperty("loadfactor", "0.75"));
		System.out.println(prop); //prop에 저장된 요소들을 출력
		prop.list(System.out);	//prop에 저장된 요소들을 화면(System.out)에 출력한다.
	}
}
