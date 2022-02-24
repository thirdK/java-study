package practice;

import java.util.LinkedList;

//Queue는 FIFO구조이다.
//Queue를 구성하는 기능은
//add() 제일 끝에 데이터를 추가
//remove() 제일 앞에 데이터 꺼내기(반환하고 삭제)
//peek() 제일 앞의 데이터 보기
//isEmpty() 빈 Queue인지 확인


class Queue<T> {
	
	private class Node<T> {
		private T data;
		private Node<T> next = null;
		
		public Node(T d) {
			this.data = d;
		}
	}
	
	private Node<T> front;
	private Node<T> rear;
	
	void enqueue(T d) {
		Node<T> n = new Node<T>(d);
		if(rear != null) {
			rear.next = n;
		}
		rear = n;
		if(front == null) {
			front = rear;
		}
	}
	
	T dequeue() {
		if(front == null) {
			throw new NullPointerException();
		}
		T temp = front.data;
		front = front.next;
		if(front == null) {
			rear = null;
		}
		
		return temp;
	}
	
	T peek() {
		if(front == null) {
			throw new NullPointerException();
		}
		return front.data;
	}
	
	boolean isEmpty() {
		return front==null;
	}
	
	
}

//LinkedList로 Queue구현하기
//개와 고양이만 분양하는 분양소가 있다.
//분양받는 사람은 동물의 종류만 고를 수 있고, 분양소에서 가장 오래 머무른 순서로
//자동으로 분양될 동물이 정해지는 클래스를 구현하시오
//단 java에서 제공하는 Linked List로 구현하시오

//개/고양이를 고르면 선택한 종 중에 오래된 개체
//별도로 고르지 않으면 전체에서 오래된 개체를 반환한다.

enum AnimalType{
	DOG, CAT
}

abstract class Animal{
	AnimalType type;
	String name;
	int order;
	
	public Animal(AnimalType type, String name) {
		this.type = type;
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	String info() {
		return order + ") " + type + " = " + name;
	}
}

class Dog extends Animal{
	public Dog(String name) {
		super(AnimalType.DOG, name);
	}
}

class Cat extends Animal{
	public Cat(String name) {
		super(AnimalType.CAT, name);
	}
}

class AnimalShelter {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int order;
	
	public AnimalShelter() {
		order = 1;
	}
	
	void enqueue(Animal animal) {
		animal.setOrder(order);
		order++;
		
		if(animal.type == AnimalType.DOG) {
			dogs.addLast((Dog)animal);
		}else if(animal.type == AnimalType.CAT) {
			cats.addLast((Cat)animal);
		}
	}
	
	Animal dequeueDog() {
		return dogs.poll();
	}
	
	Animal dequeueCat() {
		return cats.poll();
	}
	
	Animal dequeue() {
		if(dogs.size() == 0 && cats.size() == 0) {
			return null;
		}else if(dogs.size() == 0) {
			return cats.poll();
		}else if(cats.size() == 0) {
			return dogs.poll();
		}
		
		Animal dog = dogs.peek();
		Animal cat = cats.peek();
		
		if(dog.order < cat.order) {
			return dogs.poll();
		}else{
			return cats.poll();
		}		
	}
	
	
}


public class Queue_Test {
	public static void main(String[] args) {
		Dog d1 = new Dog("d1");
		Dog d2 = new Dog("d2");
		Dog d3 = new Dog("d3");
		
		Cat c1 = new Cat("c1");
		Cat c2 = new Cat("c2");
		Cat c3 = new Cat("c3");
		
		AnimalShelter as = new AnimalShelter();
		
		as.enqueue(d1);
		as.enqueue(d2);
		as.enqueue(c1);
		as.enqueue(c2);
		as.enqueue(c3);
		as.enqueue(d3);
		
		System.out.println(as.dequeueCat().name);
		System.out.println(as.dequeue().name);
		System.out.println(as.dequeue().name);
		System.out.println(as.dequeue().name);
		System.out.println(as.dequeue().name);
		System.out.println(as.dequeue().name);
		
		
		
		
		
		
//		Queue<Integer> q1 = new Queue<Integer>();
//		
//		q1.enqueue(1);
//		q1.enqueue(2);
//		q1.enqueue(3);
//		q1.enqueue(4);
//		
//		System.out.println(q1.dequeue());
//		System.out.println(q1.peek());
//		System.out.println(q1.dequeue());
//		System.out.println(q1.dequeue());
//		System.out.println(q1.isEmpty());
//		System.out.println(q1.dequeue());
//		System.out.println(q1.isEmpty());
	}
	
	
	
	
}


































