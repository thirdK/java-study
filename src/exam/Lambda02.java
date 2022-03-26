package exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda02 {
/*
함수형 인터페이스(Functional Interface)
자바에서 모든 메서드는 클래스 내에 포함되어야 하는데 람다식은 어떤 클래스에 포함되어 있는 것일까?
람다식이 메서드와 동등하게 보이지만 사실 람다식은 익명 클래스의 객체와 동등 하다.

그렇다면 람다식으로 정의된 익명 객체의 메서드를 어떻게 호출할 수 있을 것인가?
참조변수가 있어야 객체의 메서드를 호출 할 수 있다.

참조변수는 클래스와 인터페이스 형태가 가능하며 익명 객체의 메서드와 람다식의 매개변수의 타입과 개수, 반환값이 일치하면
사용이 가능하다. 그러므로 하나의 메서드가 선언된 인터페이스를 정의하여 람다식을 다루면된다.
이렇게 기존의 자바 규칙을 어기지 않으면서 람다식을 다루도록 인터페이스를 이용하도록 결정되었으며
람다식을 다루기 위한 인터페이스를 '함수형 인터페이스'라고 부르기로 했다.

단, 함수형 인터페이스에는 오직 하나의 추상 메서드만 정의되어 있어야 한다는 제약이 있다.
(static메서드, default메서드는 개수 무관)
@FunctionalInterface 라는 어노테이션을 사용하면 컴파일러가 올바르게 정의했는지 확인해주므로 사용을 권장함

 */
	public static void main(String[] args) {
		//기존의 인터페이스 메서드를 구현하는 방식
		List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
		Collections.sort(list, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		});
		System.out.println(list);
		
		//람다식을 이용한 방식
		
		List<String> list2 = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
		Collections.sort(list2, (s1, s2) -> s2.compareTo(s1));
		System.out.println(list2);
	}
}


















