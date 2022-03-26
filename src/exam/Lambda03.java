package exam;

@FunctionalInterface
interface MyFunction2 {
	void myMethod();
}

public class Lambda03 {
/*
람다식의 타입과 형변환
함수형 인터페이스로 람다식을 참조할 수 있는 것일 뿐 람다식의 타입이 함수형 인터페이스의 타입과 일치하지는 않는다.
람다식은 익명 객체이고 익명 객체는 타입이 없다. (정확히는 컴파일러가 익명객체 명을 정하므로 우리는 알 수 없다.)
그래서 대입연산자의 양변의 타입을 일치시키려면 형변환이 필요하다
	MyFunction f = (MyFunction) (() -> {});		//형변환은 생략이가능하여 일반적으로 표기하지 않는다.
	람다식은 분명 객체이지만 오직 함수형 인터페이스로만 형변환이 가능하다.(Object로 형변환이 불가능함)
	굳이 Object로 변환하려면 함수형 인터페이스로 먼저 형변환 해야한다.
	Object obj = (Object)(MyFunction)(() -> {});
	String str = (((Object)(MyFunction)(() -> {})).toString();
 */
	public static void main(String[] args) {
		MyFunction2 f = () -> {};	//(MyFunction)(() -> {});
		Object obj = (MyFunction)(() -> {});	//Object타입으로 형변환이 생략됨
		String str = ((Object)(MyFunction)(() -> {})).toString();
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
//		System.out.println(()->{});  에러 람다식은 Object타입으로 형변환 안됨
		System.out.println((MyFunction)(() -> {}));
//		System.out.println((MyFunction)(() -> {}).toString());	에러
		System.out.println(((Object)(MyFunction)(()->{})).toString());
	}
}
