package exam;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/*
스트림의 최종 연산

최종 연산은 스트림의 요소를 소모해서 결과를 만들어낸다. 
그래서 최종 연산후에는 스트림이 닫히게 되고 더이상 사용할 수 없다.
 */

public class Stream06 {
	public static void main(String[] args) {
		String[] strArr = {
				"Inheritance", "Java", "Lambda", "stream",
				"OptionalDouble", "IntStream", "count", "sum"
		};
		
		Stream.of(strArr).forEach(System.out::println);
		
		//조건 검사 noneMatch(),findFirst()	최종 연산이다.
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);
		Optional<String> sWord = Stream.of(strArr)
				.filter(s -> s.charAt(0) == 's')
				.findFirst();	//조건에 맞는 첫번째 요소만 반환
		
		System.out.println("noEmptyStr = " + noEmptyStr);
		System.out.println("sWord = " + sWord.get());
		
		//Stream<String[]>을 IntStream으로 변환
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
		
		int count = intStream1.reduce(0, (a,b) -> a + 1);
		int sum = intStream2.reduce(0, (a,b) -> a+b);
		
		OptionalInt max = intStream3.reduce(Integer::max);
		//reduce(Integer.MIN_VALUE, (a,b) -> a>b ? a: b)
		//reduce((a,b) -> a>b ? a: b)
		
		OptionalInt min = intStream4.reduce(Integer::min);
		//reduce(Integer.MAX_VALUE, (a,b) -> a<b ? a: b)
		//reduce((a,b) -> a<b ? a: b)
		
		System.out.println("count = " + count);
		System.out.println("sum = " + sum);
		System.out.println("max = " + max.getAsInt());
		System.out.println("min = " + min.getAsInt());
	}
}






















