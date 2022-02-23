package review_dataStructure_algorithm;

//두 개의 stack으로 하나의 Queue만들기
//new 스택과 old스택을 만들고
//새로 저장되는 데이터는 new스택에 넣고 peek(), remove()같이 데이터를 꺼내야하는 상황이 오면
//new 스택에 쌓여있는 데이터를 위에서부터 old스택으로 옮긴다. 그러면 먼저들어온 데이터가 위로가게 되고
//Queue와 동일하게 작동시킬 수 있다.
//여기서 중요한건 old스택이 비어있으면 new스택의 데이터를 옮기고
//old스택에 데이터가 남아있다면 먼저 소진해야한다.

class MyQueue<T>{
	Stack<T> stackNewest, stackOldest;//두 개의 스택을 만든다. 
	MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public int size() {//사이즈를 반환하는 메소드(두 스택의 사이즈를 합하여 반환한다.)
		return stackNewest.size() + stackOldest.size();
	}
	
	public void add(T value) {//데이터의 추가는 stackNewest에
		stackNewest.push(value);
	}
	
	private void shiftStacks() {//stackNewest의 데이터를 stackOldest로 옮긴다.
		if (stackOldest.isEmpty()) {//stackOldest가 공백이여야만 옮길 수 있다.
			while(!stackNewest.isEmpty()) {//stackNewest가 공백이 될때까지 모든 데이터를 
				stackOldest.push(stackNewest.pop());//stackOldest에 push하며 삭제한다.(pop())
			}
		}
	}
	
	public T peek() {
		shiftStacks();//stack의 상황에 맞게 옮겨주고
		return stackOldest.peek();//peek()실행
	}
	
	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}
}
public class Stack03 {
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
	}

}

































