package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
java.util.funcion 패키지
일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓은 패키지
매번 새로운 함수형 인터페이스를 정의할 필요 없이 이 패키지의 인터페이스를 활용하면 된다.

주요 함수형 인터페이스는 다음과 같다.
Runnable		void run()			매개변수 x, 반환값 x
Supplier<T>		T get()				매개변수 x, 반환값 o
Consumer<T>		void accept(T t)	매개변수 o, 반환값 x
Function<T,R>	R apply(T t)		매개변수 o, 반환값 o (하나의 매개변수 T받아 하나의 반환 R)
Predicate<T>	boolean test(T t)	매개변수 o, 반환값 o (반환값이 boolean 타입)

매개변수가 두 개인 함수형 인터페이스
BiConsumer<T>		void accept(T t, U u)	매개변수 o, 반환값 x
BiFunction<T,U,R>	R apply(T t, U u)		매개변수 o, 반환값 o
BiPredicate<T>		boolean test(T t, U u)	매개변수 o, 반환값 o (반환값이 boolean 타입)

매개변수 3개 이상은 만들어 써야함
@FunctionalInterface
interface TriFunction<T,U,V,R> {
	R apply(T t, U u, V v);
}
 */
public class Lambda05 {
	public static void main(String[] args) {
		Supplier<Integer> s = () -> (int)(Math.random()*100) + 1;
		Consumer<Integer> c = i -> System.out.print(i + ", ");
		Predicate<Integer> p = i -> i%2==0;
		Function<Integer, Integer> f = i -> i/10*10;	//i의 1의 자리를 없앤다.
		//하나의 매개변수 Integer를 받아 하나의 반환 Integer을 함
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list);
		System.out.println(list);
		printEvenNum(p, c, list);
		List<Integer> newList = doSomething(f,list);
		System.out.println(newList);
	}
	
	static <T> List<T> doSomething(Function<T, T> f, List<T> list){
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i));
		}
		return newList;
	}
	
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for(T i : list) {
			if(p.test(i)) {
				c.accept(i);
			}
		}
		System.out.println("]");
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for(int i=0; i<10; i++) {
			list.add(s.get());
		}
	}
}






















