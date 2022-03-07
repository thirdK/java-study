package practice;

import java.util.NoSuchElementException;

class Queue2<T>{
	class Node<T>{
		T data;
		Node<T> link;
		public Node() {
			// TODO Auto-generated constructor stub
		}
		
		Node(T data){
			this.data = data;
		}
	}
	
	Node<T> front, rear;
	
	public Queue2() {
		front = new Node<>();
		rear = new Node<>();
	}
	
	void enqueue(T data) {
		Node<T> node = new Node<>(data);
		if(!isEmpty()) {
			rear.link.link = node;
		}
		rear.link = node;
		
		if(front.link == null) front.link = node;
	}
	
	T dequeue() {
		if(front.link == null) {
			throw new NoSuchElementException();
		}
		T tmp = front.link.data;
		front.link = front.link.link;
		
		if(front.link == null) rear.link = null;
		return tmp;
	}
	
	T peek() {
		if(front.link == null) {
			throw new NoSuchElementException();
		}
		return front.link.data;
	}
	
	boolean isEmpty() {
		return front.link == null;
	}
}

public class Queue_Test2 {
	public static void main(String[] args) {
		Queue2<Integer> q = new Queue2<>();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.peek());
		System.out.println(q.isEmpty());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.isEmpty());
	}
}





















