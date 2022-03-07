package practice;

import java.util.EmptyStackException;

class Stack00<T>{
	class Node<T>{
		T data;
		Node<T> link;
		
		Node(){};
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	Node<T> top;
	
	public Stack00() {
		top = new Node<>();
	}
	
	void push(T data) {
		Node<T> node = new Node<T>(data);
		
		node.link = top.link;
		top.link = node;
	}
	
	T pop() {
		if(top.link == null) {
			throw new EmptyStackException();
		}
		T tmp = top.link.data;
		top.link = top.link.link;
		
		return tmp;
	}
	
	T peek() {
		if(top.link == null) {
			throw new EmptyStackException();
		}
		return top.link.data;
	}
	
	boolean isEmpty() {
		return top.link == null;
	}
}

//두 개의 stack으로 하나의 Queue만들기
//old/new stack을 만들고 
//큐의 back(rear)의 기능 -> 새로 추가되는 기능은 new satck
//큐의 front의 기능 -> 지우거나 peek의 기능은 old stack

//new에 노드를 담아두다가 delete/peek 같은 기능을 호출하면
//new에 있는 노드를 전부 old로 push한다.(단 old는 isEmpty() == true)
//new가 공백 stack이 되면 old를 pop/peek 한다.

class MyQueue00<T>{
	Stack00<T> stackOldest, stackNewest;
	
	public MyQueue00() {
		stackOldest = new Stack00<>();
		stackNewest = new Stack00<>();
	}
	
	void add(T data){
		stackNewest.push(data);
	}
	
	void shiftStacks() {
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop()); 
			}
		}
	}
	
	T peek() {
		shiftStacks();
		return stackOldest.peek();
	}
	
	T delete() {
		shiftStacks();
		return stackOldest.pop();
	}
	
}



public class Stack_Test2 {
	public static void main(String[] args) {
		MyQueue00<Integer> q = new MyQueue00<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		System.out.println(q.delete());
		System.out.println(q.delete());
		System.out.println(q.delete());
		System.out.println(q.delete());
		System.out.println(q.delete());
		
		
//		Stack00<Integer> s = new Stack00<>();
//		s.push(6);
//		s.push(1);
//		s.push(3);
//		s.push(4);
//		s.push(2);
//		s.push(5);
//		
//		sort(s);
//		
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.isEmpty());
		
	}
	
	//stack 정렬하기
		//stack을 정렬하는 함수를 만든다. 단, 하나의 stack을 추가로 사용할 수 있으며
		//Array등의 다른 데이터 구조는 사용 불가능
		
		//데이터가 있는 스택 a, 데이터가 없는 스택 b
		//a스택에서 데이터 하나를 꺼내고 b에있는 데이터와 비교함
		//b에 데이터가 없거나 a에서 꺼낸 데이터보다 작으면 push
		//a에서 꺼낸 데이터보다 크면 b스택 pop하여 a로 이동;
		//반복
		
		static void sort(Stack00<Integer> s1) {
			Stack00<Integer> s2 = new Stack00<>();
			
			while(!s1.isEmpty()) {
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



























