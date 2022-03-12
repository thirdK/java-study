package exam;
//클래스를 사용하는 쪽(User)과 클래스를 제공하는 쪽(Provider)이 있다.
//메서드를 사용하는 쪽은 사용하려는 메서드의 선언부만 알면 된다.(내용은 몰라도된다.)


/*
class A{	
	//A클래스는 메소드의 매개변수로 B클래스의 인스턴스의 참조값을 받아서 기능을 실행한다.(결국 객체를 받아오는것)
	//즉, A클래스는 메소드를 호출하기위해 B클래스의 인스턴스를 생성하므로 A,B는 직접적인 관계이다. (A-B)
	//직접적인 관계에서는 만약 B에 변경사항이 생기거나 B와 같은 기능을하는 다른 클래스로 대체 되는 등의 일이 일어나면
	//A또한 변경되어야 한다. 즉, 한 쪽(Provider)이 변경 되면 다른 한 쪽(User)도 변경되어야한다.
	  
	public void methodA(B b) {
		b.methodB();
	}
}
만약 인터페이스를 사용한다면???
*/

interface I {
	public abstract void methodB();	//추상메소드 정의 -> B에서 구현을 함
}

class A {
	//이제 A와 B는 (A-I-B) 간접적인 관계가되었다. 클래스 A는 여전히 B의 메서드를 호출하지만 A는 I와 직접적인
	//관계이기 때문에 B의 영향을 받지 않는다. A는 실제 사용하는 클래스의 이름을 몰라도 되고 심지어는 존재하지 않아도
	//문제가 되지 않는다. 직접적인 관계에 있는 I의 영향만 받는다.
	public void methodA(I i) {
		i.methodB();
	}
}

class B implements I{
	public void methodB() {
		System.out.println("methodB()");
	}
}

//위와 같이 매개변수를 통해 동적으로 제공받을 수 있지만 제3의 클래스를 통해 제공받을 수도 있다.
class A1{
	public A1() {
		I i = InstanceManager.getInstance();//static메소드를 호출하여 B인스턴스 반환
		i.methodB();
		System.out.println(i.toString());
	}
}

class InstanceManager{	//제 3의 클래스
	public static I getInstance() {//interface가 리턴타입이라는 것은 구현한 자손인터페이스를 반환한다는 것
		return new B();//B의 인터페이스를 반환함
	}
}


public class Interface02 {
	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B());
	}
}























