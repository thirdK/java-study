package review_dataStructure_algorithm;
import java.util.EmptyStackException;

//stack은 LIFO 구조이며 기능은
//pop() 가장 마지막 노드를 반환하고 삭제, 
//push() 노드를 stack에 추가, 
//peek() 마지막 노드를 반환, 
//isEmpty() stack이 비었는지 확인

class Stack<T>{	//데이터 타입을 따로 명시하도록 제네릭 사용
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	//stack에서 header역할을 할 top은 항상 마지막노드를 가리키며 노드의 삽입과 삭제는 top의 위치에서 이루어진다.
	private Node<T> top;  
	
	public T pop() {
		if(top == null) {//stack이 비었다면 예외 던지기
			throw new EmptyStackException();
		}
		
		T item = top.data; //삭제하고 반환도 해야해서 백업
		top = top.next;//다음 노드를 top으로, 마지막노드는 삭제
		return item;//반환
	}
	
	public void push(T item) {
		Node<T> t = new Node<T>(item);//추가할 노드 생성
		t.next = top;//top앞에 노드를 위치시키고(top이 가장 마지막 노드의 참조값을 가지고 있음)
		top = t;//새 노드가 top이 됨(top은 항상 마지막 노드를 가리킴)
	}
	
	public T peek() {
		if(top == null) {//빈 stack이면 던지기
			throw new EmptyStackException();
		}
		return top.data;//마지막 노드 데이터 반환
	}
	
	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		Node<T> p = top;
		int count = 0;
		while(p != null) {
			p = p.next;
			count++;
		}
		return count;
	}
}

public class Stack01 {
	public static void main(String[] args) {
		Stack<Integer> s =new Stack<Integer>();
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
	}

}

































