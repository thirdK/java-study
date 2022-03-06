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

public class Stack_Test2 {
	public static void main(String[] args) {
		Stack00<Integer> s = new Stack00<>();
		s.push(6);
		s.push(1);
		s.push(3);
		s.push(4);
		s.push(2);
		s.push(5);
		
		sort(s);
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		
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



























