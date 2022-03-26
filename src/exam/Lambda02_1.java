package exam;

@FunctionalInterface
interface MyFunction {
	void run(); //public abstract void run();
}

public class Lambda02_1 {
	//매개변수를 MyFunction(함수형 인터페이스)타입으로 선언한 메서드
	//이 메서드를 호출할 때 람다식을 참조하는 참조변수를 매개변수로 지정해야한다는 뜻
	//또는 참조변수 없이 직접 람다식을 매개변수로 지정
	static void execute(MyFunction f) {	
		f.run();
	}
	
	//반환타입이 MyFuncion(함수형 인터페이스)인 메서드
	//해당 함수형 인터페이스의 추상메서드와 동등한 람다식을 가리키는 참조변수를 반환하거나
	//람다식을 직접 반환
	static MyFunction getMyFunction() {
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}
	
	//람다식을 참조변수로 다룰 수 있다는 것은 메서드를 통해 람다식을 주고받을 수 있다는 것이다.(변수처럼 메서드를 주고받음)
	//사실은 메서드가 아닌 객체를 주고받는 것이라 근본적으로 달라진 것은 없다.(다음예제 반드시 참고)
	//하지만 람다식 덕분에 예전보다 코드가 더 간결하고 이해하기 쉬워졌다.
	
	public static void main(String[] args) {
		MyFunction f1 = () -> System.out.println("f1.run");
		MyFunction f2 = new MyFunction() {
			public void run() {
				System.out.println("f2.run()");
			}
		};
		MyFunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute(() -> System.out.println("run()"));
	}
}
