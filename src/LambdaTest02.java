import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

@FunctionalInterface	//@FunctionalInterface 어노테이션을 사용하면 1개의 메소드 생성을 강제한다. 
interface Calculator{
	int sum(int a, int b);
}
public class LambdaTest02 {
	public static void main(String[] args) {
		//인터페이스를 객체화해서 사용할 수는 없다 그러므로 클래스에 구현하여 사용해야 하는데
		//람다는 그 과정 없이 객체를 생성할 수 있다. 주의 사항은 Calculator 인터페이스에 1개의 메소드만 존재해야한다.
//		Calculator cc = (int a, int b) -> a+b;
		Calculator cc = (a, b) -> a+b; //입력 타입은 생략이 가능하다(이미 인터페이스에 명시되어 있으므로)
		Calculator cc2 = Integer::sum; 
		//두 수를 더하여 리턴하는 함수[ (a, b) -> a+b ]는 
		//Integer.sum(int a,int b)와 동일하므로 Integer::sum으로 축약이 가능하다.
		//어떤 클래스의 메소드를 사용할 때 ::를 사용하여 클래스와 메소드를 구분한다.
		
		int result = cc.sum(2, 3);
		System.out.println(result);
		result = cc2.sum(10, 20);
		System.out.println(result);
		
//		=========================================================================================
		//이번에는 인터페이스 없이 함수형 프로그래밍을 위해 기본 제공되는 인터페이스를 사용해보자
		BiFunction<Integer, Integer, Integer> mc = (a,b) -> a+b;
		//제네릭은 <입력1, 입력2, 출력> 을 의미한다. 
		//그런데 3가지의 제네릭이 동일하면 아래와 같이 binaryOperator를 사용가능하다.
		BinaryOperator<Integer> mc2 = (a,b) -> a+b;
		int result2 = mc.apply(3, 4);
		System.out.println(result2);
		
	}
}
