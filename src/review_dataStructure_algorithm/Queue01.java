package review_dataStructure_algorithm;

import java.util.NoSuchElementException;

//Queue는 FIFO구조이다.
//Queue를 구성하는 기능은
//add() 제일 끝에 데이터를 추가
//remove() 제일 앞에 데이터 꺼내기(반환하고 삭제)
//peek() 제일 앞의 데이터 보기
//isEmpty() 빈 Queue인지 확인

class Queue<T>{	//제네릭사용
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> first; // Queue는 두 개의 포인터가 필요함(가장 앞, 가장 뒤를 가리키는 참조변수)
	private Node<T> last;
	
	public void enqueue(T item) {//데이터 삽입은 뒤에서 이루어짐
		Node<T> t = new Node<T>(item);
		
		if(last != null) {//빈 Queue가 아니라면
			last.next = t; //last가 가진 참조값의 link필드와 연결
		}
		last = t;//last가 다시 마지막 노드를 가리키게하고
		if(first == null) {//first가 null이면(공백 Queue상태였다면)
			first = last;//첫노드가 추가되면서 first와 last는 같은 노드를 가리키게됨
		}
	}
	
	public T dequeue() {//데이터의 삭제는 앞에서 이루어짐
		if (first == null) {//공백이면 에러 던지고
			throw new NoSuchElementException();
		}
		
		T data = first.data;//삭제하기 전에 반환할 값 백업
		first = first.next;//삭제
		
		if (first == null) {//삭제하고 공백 Queue가 되면
			last = null;//last 또한 null
		}
		return data;//반환
	}
	
	public T peek() {//앞에 있는 데이터를 반환함
		if(first == null) {//null이면 반환 값이 없으므로 던지고
			throw new NoSuchElementException();
		}
		return first.data;//data 반환
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
}

public class Queue01 {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.peek());
		System.out.println(q.dequeue());
		System.out.println(q.isEmpty());
		System.out.println(q.dequeue());
		System.out.println(q.isEmpty());
//		System.out.println(q.peek());
	}
}






























