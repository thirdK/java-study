import java.util.function.BinaryOperator;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface Math1{
	public int tt(int n1, int n2);
}

public class LambdaTest01 {
	public static void main(String[] args) {
		Math1 test = (n1, n2) -> n1 + n2;
		System.out.println(test.tt(3, 4));
		
		Math1 test2 = (n1, n2) -> n1 - n2;
		System.out.println(test2.tt(10, 2));
		
		
		//Java에서 지원하는 함수 인터페이스
		IntFunction<Integer> intSum = (x) -> x+1;
		System.out.println(intSum.apply(1));
		
		BinaryOperator<String> strSum = (x, y) -> x + " " + y;
		System.out.println(strSum.apply("Lambda", "practice.."));
		
		//그 외에도 여러가지 존재함...
		
		
		
	
	}
}
