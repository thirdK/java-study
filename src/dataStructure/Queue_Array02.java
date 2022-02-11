package dataStructure;

//순차 자료구조 방식으로 원형 큐를 구현
//선형큐는 빈자리를 인식하지 못하는 경우가 생긴다. 그 빈자리를 사용하기위해서
//저장되어 있는 원소를 배열의 앞으로 이동시켜야하는데 드러면 큐의 효율성이 떨어진다.
//그런 선형 큐의 문제를 해결하기 위해 원형 큐를 사용한다.

class ArrayCQueue implements Queue{
	private int front;
	private int rear;
	private int queueSize;
	private char[] itemArray;
	
	public ArrayCQueue(int queueSize) {
		front = 0;					//원형 큐는 front와 rear를 0으로 초기화한다.
		rear = 0;					//원형 큐는 구조상 항상 1칸은 비워둔다.(front가 위치하는곳)
		this.queueSize = queueSize;
		itemArray = new char[this.queueSize];
	}
	
	public boolean isEmpty() {
		return (front == rear);
	}
	
	public boolean isFull() {
		return (((rear+1) % this.queueSize) == front);
		//[rear+1]을 [길이]로 나눈 [나머지]는 원형큐에서 삽입을 할 때 위치를 나타낸다.
		//그 위치가 front와 같다면 큐는 가득찬것이다.(front가 위치하는곳은 항상 비워둔다.)
	}
	
	public void enQueue(char item) {
		if(isFull()) {
			System.out.println("Inserting fail! ArrayCircular Queue is full!!");
		}else {
			rear = (rear+1) % this.queueSize;
			//rear와 front는 계속 움직이므로 index가 끝에서 다시 0으로 돌아가는 경우가 있다.
			//그 경우에도 정상 작동을하기 위해 나머지 연산자를 사용한다.
			//rear의 위치를 다음 index로 옮겨 인큐 한다.
			itemArray[rear] = item;
			System.out.println("Inserted Item : " + item);
		}
	}
	
	public char deQueue() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Circular Queue is empty!!");
			return 0;
		}else {
			front = (front+1) % this.queueSize;
			//front의 위치를 다음 index로 옮겨 디큐 한다.
			return itemArray[front];
		}
	}
	
	public void delete() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Circular Queue is empty!!");
		}else {
			front = (front+1) % this.queueSize;
			//디큐와 동일한 방법으로 삭제한다.
		}
	}
	
	public char peek() {
		if(isEmpty()) {
			System.out.println("Peeking fail! Array Circular Queue is empty!!");
			return 0;
		}else {
			return itemArray[(front+1) % this.queueSize];
			//제일 처음이되는 값을 반환한다.
		}
	}
	
	public void printQueue() {
		if(isEmpty()) {
			System.out.println("Array Circular Queue is empty!!");
		}else {
			System.out.print("Array Circular Queue >> ");
			for(int i=(front+1) % this.queueSize; i!=(rear+1)%this.queueSize; i= ++i%this.queueSize) {
				//처음이 되는 값 부터 ; 마지막 값 까지; i++한다 구조상 0으로 넘어갈 수 있게 처리한다.
				System.out.printf("%c ", itemArray[i]);
			}
			System.out.println("\n");
		}
	}
}

public class Queue_Array02 {
	public static void main(String[] args) {
		int queueSize = 4;
		char deletedItem;
		ArrayCQueue cQ = new ArrayCQueue(queueSize);
		
		cQ.enQueue('A');
		cQ.printQueue();

		cQ.enQueue('B');
		cQ.printQueue();
		
		deletedItem = cQ.deQueue();
		if(deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		cQ.printQueue();
		
		cQ.enQueue('C');
		cQ.printQueue();

		cQ.enQueue('D');
		cQ.printQueue();
		
		cQ.enQueue('E');
		cQ.printQueue();
	}
}























