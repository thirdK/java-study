interface Predator {
	String getFood();

	// 인터페이스는 자바8부터 default 메소드를 추가할 수 있다.
	default void printFood() {
		System.out.printf("my food is %s\n", getFood());
	}

	// 인터페이스는 자바8부터 static 메소드를 추가할 수 있다.
	int LEG_COUNT = 4; // 인터페이스 상수는 public static final이 자동으로 붙는다.

	static int speed() {
		return LEG_COUNT * 30;
	}
}

interface Barkable{
	void bark();
}

class Animal {
	String name;

	public void setName(String name) {
		this.name = name;
	}
}

class Tiger extends Animal implements Predator, Barkable {
	public String getFood() {
		return "apple";
	}
	public void bark() {
		System.out.println("어흥");
	}

}

class Lion extends Animal implements Predator, Barkable {
	public String getFood() {
		return "banana";
	}
	public void bark() {
		System.out.println("으르렁");
	}
}

class ZooKeeper {
	void feed(Predator predator) {
		System.out.println("feed " + predator.getFood());
	}
//	void feed(Tiger tiger) {
//		System.out.println("feed apple");
//	}
//	
//	void feed(Lion lion) {
//		System.out.println("feed banana");
//	}
//	동물의 종류가 추가되면 계속 feed메소드를 추가해야 하므로 interface를 활용
}

class Bouncer{
	void barkAnimal(Barkable animal) {//매개변수 타입을 Animal 대신 Barkable을 사용함
		animal.bark();
		
//		tiger, lion 객체는 각각 Tiger, Lion 클래스의 객체이면서 
//		Animal 클래스의 객체이기도 하고 Barkable, Predator 인터페이스의 
//		객체이기도 하다. 이러한 이유로 barkAnimal 메소드의 입력 자료형을 
//		Animal에서 Barkable 로 바꾸어 사용할 수 있는 것이다.
		
//		즉, tiger를 다음과 같이 여러 자료형으로 표현이 가능하다.
//		Tiger tiger = new Tiger();  // Tiger is a Tiger
//		Animal animal = new Tiger();  // Tiger is a Animal
//		Predator predator = new Tiger();  // Tiger is a Predator
//		Barkable barkable = new Tiger();  // Tiger is a Barkable
		
//		여기서 알아두어야 할 사항은 Predator 로 선언된 predator 객체와 Barkable 로 
//		선언된 barkable 객체는 사용할 수 있는 메소드가 서로 다르다는 점이다. 
//		predator 객체는 getFood() 메소드가 선언된 Predator 인터페이스의 객체이므로 getFood 메소드만 호출이 가능하다. 
//		이와 마찬가지로 Barkable 로 선언된 barkable 객체는 bark 메소드만 호출이 가능하다.
		
//		만약 두가지 메소드를 다 사용하고 싶다면 Predator와 Barkable을 상속받은 새로운 interface를 만들면된다.
		
		
		
		
		//instanceof는 어떤 객체가 특정 객체인지 비교할 때 사용
		//animal instanceof Tiger  --> (매개변수로 받은)animal이 Tiger 클래스로 만든 객체인가?  
//		if(animal instanceof Tiger) {
//			System.out.println("어흥");
//		}else if(animal instanceof Lion) {
//			System.out.println("으르렁");
//		}
//		동물의 종류가 추기되면 계속 조건문을 추가해야 하므로 interface를 활용
	}
}



public class Interface01 {
	public static void main(String[] args) {
		ZooKeeper zooKeeper = new ZooKeeper();
		Tiger tiger = new Tiger();
		Lion lion = new Lion();
		zooKeeper.feed(tiger);
		zooKeeper.feed(lion);

		tiger.printFood();
		lion.printFood();

		System.out.println(Predator.speed());
		
		Bouncer bouncer= new Bouncer();
        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);
	}
}
































