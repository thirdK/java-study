package review_dataStructure_algorithm;

import java.util.LinkedList;

//LinkedList로 Queue구현하기
//개와 고양이만 분양하는 분양소가 있다.
//분양받는 사람은 동물의 종류만 고를 수 있고, 분양소에서 가장 오래 머무른 순서로
//자동으로 분양될 동물이 정해지는 클래스를 구현하시오
//단 java에서 제공하는 Linked List로 구현하시오

//Queue를 2개로 만들어서 개/고양이를 나눈다.
//아무거나 달라고하면 둘 중 오래된 개체를 주고
//특정 종류를 원하면 그 중 오래된 개체를 준다.

enum AnimalType {// 상수의 집합을 만들것이므로 class가 아닌 enum으로 만듬
	DOG, CAT
}

abstract class Animal { // Dog, Cat의 공통 속성을 추상클래스로 만듬
	AnimalType type;// 종
	String name; // 이름
	int order; // 순서

	Animal(AnimalType type, String name) {// 생성할때 입력받기위해 생성자
		this.type = type;
		this.name = name;
	}

	//순서는 생성되는 순서가 아니라 분양소에 들어가는 순서이므로
	//여기서 순서를 정하지 않고 get, set을 만들어줌
	void setOrder(int order) {// 순서 설정
		this.order = order;
	}

	int getOrder() {// 순서 반환
		return order;
	}

	String info() {// 확인을 위해 사용할 메소드
		return order + ") type : " + type + ", name : " + name;
	}
}

class Dog extends Animal {//Animal 상속
	Dog(String name) {// 이름 받아서 부모클래스에 넘겨줌
		super(AnimalType.DOG, name);
	}
}

class Cat extends Animal {//Animal 상송
	public Cat(String name) {// 이름 받아서 부모클래스에 넘겨줌
		super(AnimalType.CAT, name);
	}
}
class AnimalShelter {//분양소
	//이 문제는 자바에서 제공하는 LinkedList로 Queue를 구현하는게 목표이다.
	LinkedList<Dog> dogs = new LinkedList<Dog>(); //자바에서 제공하는 LinkedList
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int order;//순서를 저장할 변수
	
	AnimalShelter() {//생성되면 순서 1로 초기화
		order = 1;
	}
	
	void enqueue(Animal animal) {//삽입메소드
		animal.setOrder(order);//동물이 들어오면 기존 order로 순서를 부여
		order++;//order증가
		if (animal.type == AnimalType.DOG) {//동물 타입이 개면
			dogs.addLast((Dog) animal);//addLast는 자바에서 제공하는 LinkedList클래스의 메소드이다. 리스트 마지막에 데이터추가
			//dogs 가장 마지막에 추가
		}else if(animal.type == AnimalType.CAT) {
			cats.addLast((Cat) animal);
		}
	}
	
	Animal dequeueDog() {
		return dogs.poll();//자바에서 제공하는 LinkedList클래스의 poll()메소드이다 결과는 pop()과 같다.
	}
	Animal dequeueCat() {
		return cats.poll();
	}
	Animal dequeue() {//타입 지정없이 dequeue
		if (dogs.size() == 0 && cats.size() == 0) {//개, 고양이 둘다 비어있다면
			return null;
		}else if(dogs.size() == 0) {//개가 없다면 고양이를
			return cats.poll();
		}else if(cats.size() == 0) {//고양이가 없다면 개를
			return dogs.poll();
		}
		Animal dog = dogs.peek();//양쪽다 있으면 order를 비교해야하므로 peek()으로 꺼내고
		Animal cat = cats.peek();
		if(cat.order < dog.order) {//개,고양이 order 비교
			return cats.poll();
		}else {
			return dogs.poll();
		}
	}
}

public class Queue02 {
	public static void main(String[] args) {
		Dog d1 = new Dog("puppy");
		Dog d2 = new Dog("chichi");
		Dog d3 = new Dog("choco");
		
		Cat c1 = new Cat("shasha");
		Cat c2 = new Cat("miumiu");
		Cat c3 = new Cat("gaga");
		
		AnimalShelter as = new AnimalShelter();
		as.enqueue(d1);
		as.enqueue(c1);
		as.enqueue(d2);
		as.enqueue(c2);
		as.enqueue(d3);
		as.enqueue(c3);
		
		System.out.println(as.dequeueCat().info());
		System.out.println(as.dequeueDog().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
	}
}
