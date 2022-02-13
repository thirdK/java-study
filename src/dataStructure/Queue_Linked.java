package dataStructure;

//연결 자료구조 방식으로 연결 큐를 구현

class QNode {
	char data;
	QNode link;
}

class LinkedQueue implements Queue {
	QNode front;	//가장 처음 들어온 노드를 가리키는 front
	QNode rear;		//가장 마지막에 들어온 노드를 가리키는 rear
	
	public LinkedQueue() {		//생성시 초기값은 front/rear 둘다 null이다.
		front = null;
		rear = null;
	}
	
	public boolean isEmpty() {
		return (front == null);		//front가 null이면 비어있는 큐이다.(비었다면 true반환) 
	}
	
	public void enQueue(char item) { //데이터를 삽입하는 인큐메소드
		QNode newNode = new QNode();
		newNode.data = item;	//새노드를 추가할때 매개변수로 가져온 값을 새 노드의 data필드에
		newNode.link = null;	//노드를 추가하면 항상 마지막 노드이기때문에 link필드에 참조값은 null
		if(isEmpty()) {
			front = newNode;	//비어있는 큐라면 처음 추가하는 노드가 유일한 노드이므로
			rear = newNode;		//front/rear가 같은 곳을 가리킨다.
		}else {
			rear.link = newNode;//비어있지 않다면 rear가 가리키는 노드의 link에 새 노드의 참조값을 넣는다.
			rear = newNode;		//그리고 rear는 새 노드를 가리킨다.(rear는 항상 마지막노드의 참조값을 가져야한다.)
		}
		System.out.println("Inserted Item : " + item);
	}
	
	public char deQueue() {	//데이터를 삭제하고 삭제한 값을 반환하는 디큐
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Queue is empty!!");
			return 0;
		}else {
			char item = front.data;	//삭제한 값을 반환하기위해 item변수에 저장 
			front = front.link;		
			//front가 가리키는 노드의 link에 저장된 값을 front에 넣는다.
			//front가 가지는 참조값이 항상 첫노드의 주소이므로 위의 코드는 삭제의 기능을 한다. 
			if(front == null) {	//삭제 후 front가 null이면 빈 큐가되므로 front/rear둘다 null이여야 한다.
				rear = null;
			}
			return item;
		}
	}
	
	public void delete() {	//데이터를 삭제하는 딜리트메소드
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Queue is empty!!");
		}else {
			front = front.link;	//삭제하는 방식은 deQueue()메소드와 같다.
			if(front == null) {
				rear = null;
			}
		}
	}
	
	public char peek() {	//검색을하는 픽메소드 front가 가리키는 값을 반환
		if (isEmpty()) {
			System.out.println("Peeking fail! Linked Queue is empty!!");
			return 0;
		} else {
			return front.data; // front가 가리키는 노드의 data를 반환.
		}
		
	}
	
	public void printQueue() {
		if(isEmpty()) {
			System.out.println("Linked Queue is empty!!\n");
		}else {
			QNode temp = front;
			System.out.print("Linked Queue >> ");
			while(temp != null) {
				System.out.printf("%c ", temp.data);
				temp = temp.link;
			}
			System.out.println("\n");
		}
	}
}

public class Queue_Linked {
	public static void main(String[] args) {
		char deletedItem;
		LinkedQueue LQ = new LinkedQueue();
		
		LQ.enQueue('A');
		LQ.printQueue();
		
		LQ.enQueue('B');
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if(deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		LQ.printQueue();
		
		LQ.enQueue('C');
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if(deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if(deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if(deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		LQ.printQueue();
	}
}
































