package practice;

//stack은 LIFO 구조이며 기능은

//pop() 가장 마지막 노드를 반환하고 삭제, 
//push() 노드를 stack에 추가, 
//peek() 마지막 노드를 반환, 
//isEmpty() stack이 비었는지 확인

class Stack<T> {

	class Node<T> {
		private T data;
		private Node<T> next = null;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node<T> top;

	void push(T data) {
		Node<T> n = new Node<T>(data);

		n.next = top;
		top = n;
	}

	T pop() {
		if (top == null) {
			throw new NullPointerException();
		}

		T item = top.data;
		top = top.next;
		return item;
	}

	T peek() {
		if (top == null) {
			throw new NullPointerException();
		}
		return top.data;
	}

	boolean isEmpty() {
		return top == null;
	}

}

	//두 개의 stack으로 하나의 Queue만들기
	//new스택과 old스택을 만들고 삽입은 new스택으로 하다가 삭제,반환이 호출되면 new에 있는 모든 데이터를 old로 옮긴다.
	//그 이후 삭제, 반환이 이루어지며 주의할 점은 old에 data가 1개라도 남아있으면 모두 소진하고 이동이 이루어진다.

class MyQueue<T>{
	Stack<T> stackNewest, stackOldest;
	
	public MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public void add(T d) {
		stackNewest.push(d);
	}
	
	private void shiftStacks() {
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}
	
	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}
}

public class Stack_Test {
	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		MyQueue<Integer> q1 = new MyQueue<Integer>();
		
		q1.add(4);
		q1.add(2);
		q1.add(3);
		q1.add(1);
		q1.add(8);
		
		System.out.println(q1.remove());
		System.out.println(q1.remove());
		System.out.println(q1.peek());
		System.out.println(q1.remove());
		System.out.println(q1.remove());
		System.out.println(q1.remove());
		
		
		
		
//		s1.push(5);
//		s1.push(2);
//		s1.push(3);
//		s1.push(7);
//		s1.push(1);
//		s1.push(2);
//
//		stackSort(s1);
//
//		System.out.println(s1.pop());
//		System.out.println(s1.pop());
//		System.out.println(s1.pop());
//		System.out.println(s1.pop());
//		System.out.println(s1.pop());
//		System.out.println(s1.pop());

//		System.out.println(s1.pop()); 
//		System.out.println(s1.pop()); 
//		System.out.println(s1.peek()); 
//		System.out.println(s1.pop());
//		System.out.println(s1.isEmpty());
//		System.out.println(s1.pop());
//		System.out.println(s1.isEmpty());

	}

	// stack 정렬하기
	// stack을 정렬하는 함수를 만든다. 단, 하나의 stack을 추가로 사용할 수 있으며
	// Array등의 다른 데이터 구조는 사용 불가능

	// stack s1에서 s2로 데이터를 옮겨주는데 옮길 데이터(d1)를 잡고 s2에 있는 데이터(d2)와 비교하여
	// d1 > d2 면 옮기고 아니면 d2를 다시 s1으로 옮긴다.

	static void stackSort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		while (!s1.isEmpty()) {
			int tmp = s1.pop();
			
			while(!s2.isEmpty() && tmp < s2.peek()) {
				s1.push(s2.pop());
			}
			
			s2.push(tmp);
		}
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}

	}
}
