package dataStructure_algorithm;
//순차 자료구조 방식으로 선형 Queue를 구현하기
//다른 Queue에서도 동일하게 사용할 형태이기 때문에 interface로
interface Queue{
	boolean isEmpty();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
}

class ArrayQueue implements Queue{
	private int front;	//큐는 FIFO구조이므로 앞을 가리키는 front와, 뒤를 가리키는 rear를 만든다.
	private int rear;
	private int queueSize;
	private char[] itemArray;
	
	public ArrayQueue(int queueSize) {	//생성자로 큐의 길이를 받아온다.
		front = -1;						
		rear = -1;						//빈 큐는 front, rear 둘다 -1로 초기화
		this.queueSize = queueSize;		
		itemArray = new char[this.queueSize];
	}
	
	public boolean isEmpty() {			//비어있는지 확인하여 boolean 리턴하는 메소드
		return (front == rear);			//front와 rear가 같으면 비어있다는것
	}
	
	public boolean isFull() {			//Full인지 확인하는 메소드
		return (rear == queueSize-1); 
	}
	
	public void enQueue(char item) {	//삽입을 담당하는 인큐 메소드
		if(isFull()) {
			System.out.println("Inserting fail! Array Queue is full!!");
		}else {
			itemArray[++rear] = item;	
			//큐에서 삽입은 뒤로(rear)
			//rear는 항상 마지막 index를 저장하므로 새 노드를 추가할 때는 증가시켜 index번호로 배열에 요소 저장 
			System.out.println("Inserted Item : " + item);
		}
	}
	
	public char deQueue() {		//삭제를 담당하는 디큐 메소드
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty!");
			return 0;
		}else {
			return itemArray[++front];	
			//큐에서 삭제는 앞으로(front)한다.
			//front가 가리키는 곳은 배열에 속하는 저장공간이 아니다. 그냥 삭제되는 방향이라고 보면된다. 
			//배열의 가장 앞 인덱스는 항상 [front+1]이다.
			//front가 증가되면 맨 앞 index는 더이상 큐에 속해있지 않게된다.
			//즉, front가 증가되면 앞의 요소를 삭제하는것과 같다. 
		}								
	}									
	
	public void delete() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty!!");
		}else {
			++front;
			//deQueue와 같은 방식으로 삭제
		}
	}
	
	public char peek() {
		if(isEmpty()) {
			System.out.println("Peeking fail! Array Queue is empty!!");
			return 0;
		}else {
			return itemArray[front+1];	
			//front+1은 배열의 가장 첫번째 index
		}
	}
	
	public void printQueue() {
		if(isEmpty()) {
			System.out.println("Array Queue is empty!!\n");
		}else {
			System.out.print("Array Queue >> ");
			for(int i=front+1; i<=rear; i++) {
				System.out.printf("%c ", itemArray[i]);
			}
			System.out.println("\n");
		}
	}
	
}

public class Queue_Array01 {
	public static void main(String[] args) {
		int queueSize = 3;
		char deletedItem;
		ArrayQueue Q = new ArrayQueue(queueSize);
		
		Q.enQueue('A');
		Q.printQueue();

		Q.enQueue('B');
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		Q.printQueue();
		
		Q.enQueue('C');
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		Q.printQueue();
		
		
	}
}

































