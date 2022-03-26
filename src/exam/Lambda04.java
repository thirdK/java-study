package exam;

/*
외부 변수를 참조하는 람다식
람다식도 익명 객체, 즉 익명 클래스의 인스턴스이므로 람다식에서 외부에 선언된 변수에 접근하는 규칙은
익명 클래스와 동일하다.
 */

@FunctionalInterface
interface MyFunction4{
	void myMethod();
}

class Outer{
	int val = 10;	//Outer.this.val
	
	class Inner{
		int val = 20; //this.val
		
		void method(int i) {	//void method(final int i)
			int val=30;		//final int val=30;
			//i = 10;		//에러 상수값은 변경 불가
			
			//람다식 내부에서 외부의 변수에 접근하는 방법은 아래와 같다.
			//람다식 내에서 참조하는 지역변수는 final이 붙지 않았어도 상수로 간주된다.
			//람다식 내에서 지역변수 i와 val을 참조하고 있으므로 람다식내에서든 다른 곳에서도 이 변수의 값을
			//변경하는것을 허용하지 않는다.
			//반면에 Inner클래스와 Outer클래스의 인스턴스 변수인 this.val과 Outer.this.val은 상수로 간주하지 않는다.
			//그리고 외부 지역변수와 같은 이름의 람다식 매개변수는 허용하지 않으니 주의한다.
			MyFunction4 f = () -> {	
				System.out.println("             i : " + i);
				System.out.println("           val : " + val);
				System.out.println("      this.val : " + ++this.val);
				System.out.println("Outer.this.val : " + ++Outer.this.val);
			};
			f.myMethod();
		}
	}
}
public class Lambda04 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.method(100);
	}
	
}
