package exam;

import java.util.Optional;
import java.util.OptionalInt;
/*
Optiona<T>, OptionalInt
Stream의 최종 연산의 결과 타입이 Optional인 경우가 있다.
Optional<T>은 제네릭클래스이며 T타입 객체를 감싸는 래퍼클래스이다. 
Optional타입의 객체에는 모든 타입의 참조변수를 담을 수 있다.

큰 특징으로는 null체크를 간결하게 하며 null예외로부터 안전하게 코드를 작성하는게 가능하다.
 */
public class Stream05_Optional {
	public static void main(String[] args) {
		//생성은 of()사용, null일 가능성이 있다면 ofNullable()사용
		//of()는 값이 null이면 NullPointerException이 발생함
		Optional<String> optStr = Optional.of("abcde");	
		Optional<Integer> optInt = optStr.map(String::length);
		//객체의 값을 가져올 때 get()사용 -> null이면 NoSuchElementException발생
		//orElse()로 예외발생시 대체할 값 지정가능
		System.out.println("optStr = " + optStr.get());
		System.out.println("optInt = " + optInt.get());
		
		int result1 = Optional.of("123")
				.filter(x -> x.length() > 0)
				.map(Integer::parseInt).get();
		int result2 = Optional.of("")
				.filter(x -> x.length() > 0)
				.map(Integer::parseInt).orElse(-1);
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		
		//isPresent		Optional객체의 값이 null이면 false, 아니면 true
		//ifPresent(Consumer<T> block) 값이 있으면 주어진 람다식 실행 없으면 넘어감
		Optional.of("456").map(Integer::parseInt)
		.ifPresent(x -> System.out.printf("result3 = %d\n", x));
		
		OptionalInt optInt1 = OptionalInt.of(0);	//0을 저장
		OptionalInt optInt2 = OptionalInt.empty();	
		//빈(값이 없는) 객체를 만들때 null보다는 empty()사용을 권장함
		
		System.out.println(optInt1.isPresent()); 	//true
		System.out.println(optInt2.isPresent()); 	//false
		
		//OptionalInt는 get()대신 getAsInt()를 사용하며 기능은 같다.
		System.out.println(optInt1.getAsInt());	//0
		//System.out.println(optInt2.getAsInt());	//NosuchElemenException
		
		System.out.println("optInt1 = " + optInt1);	//0이고
		System.out.println("optInt2 = " + optInt2);	//빈객체이므로 둘은 같지 않다.
		System.out.println("optInt1.equals(optInt2)? " + optInt1.equals(optInt2));
		
		Optional<String> opt = Optional.ofNullable(null);	//null저장
		Optional<String> opt2 = Optional.empty();			//빈 객체를 생성
		System.out.println("opt = " + opt);		//빈객체로 나온다. 
		// ->Optional은 null을 저장하면 비있는것과 동일하게 취급함
		System.out.println("opt2 = " + opt2);	//빈 객체이므로 둘은 같다.
		System.out.println("opt.equals(optInt2)? " + opt.equals(opt2));
		
		int result3 = optStrToInt(Optional.of("123"), 0);
		int result4 = optStrToInt(Optional.of(""), 0);
		
		System.out.println("result3 = " + result3);
		System.out.println("result4 = " + result4);
	}
	
	static int optStrToInt(Optional<String> optStr, int defaultValue) {
		try {
			return optStr.map(Integer::parseInt).get();
		} catch (Exception e) {
			return defaultValue;
		}
	}
}


























