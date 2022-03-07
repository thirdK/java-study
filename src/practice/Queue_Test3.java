package practice;

import java.util.LinkedList;

//LinkedList로 Queue구현하기
//개와 고양이만 분양하는 분양소가 있다.
//분양받는 사람은 동물의 종류만 고를 수 있고, 분양소에서 가장 오래 머무른 순서로
//자동으로 분양될 동물이 정해지는 클래스를 구현하시오
//단 java에서 제공하는 Linked List로 구현하시오

//동물종류는 상수집합으로 만들고 enum
//Animal 추상클래스 만들고
//개, 고양이 클래스의 공통 부분은 상속
//개 리스트와 고양이 리스트 따로 분리하고 특정 종류를 원하면 해당 객체의 순서에 맞게
//특정 종류를 지정하지 않으면 두 클래스 객체중 가장 순번이 빠른 객체를 반환

enum AnimalType3{
	CAT, DOG;
}

abstract class Animal3{
	AnimalType3 type;
	String name;
	private int order;
	
	public Animal3(String name, AnimalType3 type) {
		this.name = name;
		this.type = type;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	String info() {
		return order +" "+ type + " - " + name;
	}
}

class Dog3 extends Animal3{
	public Dog3(String name) {
		super(name, AnimalType3.DOG);
	}
}

class Cat3 extends Animal3{
	public Cat3(String name) {
		super(name, AnimalType3.CAT);
	}
}

// 결국 LinkedList로 Queue구현하는게 핵심이다.
class AnimalShelter3{
	LinkedList<Dog3> dogs = new LinkedList<>();
	LinkedList<Cat3> cats = new LinkedList<>();
	
	int order;
	
	public AnimalShelter3() {
		order = 1;
	}
	
	void enqueue(Animal3 animal) {
		animal.setOrder(order++);
		if(animal.type == AnimalType3.DOG) {
			dogs.addLast((Dog3)animal);
		}else if(animal.type == AnimalType3.CAT) {
			cats.addLast((Cat3)animal);
		}
	}
	
	Animal3 dequeueDog() {
		return dogs.pollFirst();
	}
	
	Animal3 dequeueCat() {
		return cats.pollFirst();
	}
	
	Animal3 dequeue() {
		if(dogs.isEmpty() && cats.isEmpty()) return null;
		else if(dogs.isEmpty()) return cats.poll();
		else if(cats.isEmpty()) return dogs.poll();
		
		if(dogs.peek().getOrder() > cats.peek().getOrder()) {
			return cats.pollFirst();
		}
		return dogs.pollFirst();
	}
	
}

public class Queue_Test3 {
	public static void main(String[] args) {
		Dog3 d1 = new Dog3("멍멍1");
		Dog3 d2 = new Dog3("뭉뭉2");
		Dog3 d3 = new Dog3("몽몽3");
		
		Cat3 c1 = new Cat3("냥냥1");
		Cat3 c2 = new Cat3("뇽뇽2");
		Cat3 c3 = new Cat3("늉늉3");
		
		AnimalShelter3 as = new AnimalShelter3();
		as.enqueue(d2);
		as.enqueue(d1);
		as.enqueue(c3);
		as.enqueue(c1);
		as.enqueue(d3);
		as.enqueue(c2);
		
		System.out.println(d1.info());
		System.out.println(c1.info());
		System.out.println();
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
		System.out.println(as.dequeue().info());
	}
}














