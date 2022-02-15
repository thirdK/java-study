package dataStructure;

//덱은 큐의 양끝에서 삽입과 삭제가 모두 가능하다.
//이중 연결 리스트를 이용한 덱 구현

class DQNode {	//이중 연결 리스트에서 노드는 양방향으로 link를 가져야한다.
	char data;
	DQNode rlink;
	DQNode llink;
}

class DQueue{
	DQNode front;
	DQNode rear;
	
	public DQueue() {	//연결큐와 마찬가지로 생성시(비어있는 큐) front/rear는 null
		front = null;
		rear = null;
	}

	public boolean isEmpty() {	//비었다면 front는 null이다.
		return (front == null);
	}
	
	//덱은 양방향으로 삽입 삭제가 가능하기때문에
	//front에서 삽입/삭제, rear에서 삽입/삭제하는 메소드를 만들어야한다.
	//큐가 가로로 긴 띠모양이라고 가정하고 (front,좌측) / (rear,우측)으로 가정하여 설명함
	
	public void insertFront(char item) {	//front에서 삽입하는 메소드
		DQNode newNode = new DQNode();		
		newNode.data = item;
		if(isEmpty()) {			//비어있다면
			front = newNode;	//첫 노드이므로 front와 rear가 newNode의 주소를 저장.
			rear = newNode;
			newNode.rlink = null;//첫 노드인 newNode는 가리킬 노드가 없으므로 양쪽의 link에 null
			newNode.llink = null;
		}else {
			front.llink = newNode;//첫 노드가 아니라면 llink에 newNode의 참조값을(front방향에서 삽입하므로)
			newNode.rlink = front;//newNode의 rlink에는 front의 참조값을
			newNode.llink = null;//front 방향에서 newNode는 가장 끝이므로 newNode.llink에는 null을 
			front = newNode;	//front에 newNode 주소 저장
		}//(양방향이라 앞, 뒤로 표현하기 애매한거 같아서 양쪽의 끝으로 표현)
		System.out.println("Front Inserted Item : " + item);
	}
	
	public void insertRear(char item) {	//rear에서 삽입하는 메소드
		DQNode newNode = new DQNode();
		newNode.data = item;
		if(isEmpty()) {			
			front = newNode;	
			rear = newNode;
			newNode.rlink = null;
			newNode.llink = null;
		}else {
			rear.rlink = newNode;
			newNode.rlink = null;
			newNode.llink = rear;
			rear = newNode;		
		}
		System.out.println("Rear Inserted Item : " + item);
	}
	
//	==========================================================================================================
	
	public char deleteFront() {	//front에서 삭제하고 삭제한 값을 반환하는 메소드
		if(isEmpty()) {
			System.out.println("Front Deleting fail! DQueue is empty!!");
			return 0;
		}else {
			char item = front.data;	//반환할 값을 저장할 item변수
			if(front.rlink == null) {//프론트의 rlink가 null이면(노드가 1개면)
				front = null;		//어차피 더이상 노드는 존재하지 않으므로 front/rear 에 null
				rear = null;
			}else {
				front = front.rlink;//삭제 후에도 노드가 남아있다면 front는 rlink에서 가리키던 참조값을 가져온다.
				front.llink = null;	//이제 front가 새로 받아온 참조값의 노드가 덱의 front방향의 끝이므로 llink에 null을 넣는다. 
			}//위 과정을 통해 기존 노드 1개는 삭제 처리가 된다.
			return item;
		}
	}
	
	public char deleteRear() {	//rear에서 삭제하고 삭제한 값을 반환하는 메소드
		if(isEmpty()) {
			System.out.println("Rear Deleting fail! DQueue is empty!!");
			return 0;
		}else {
			char item = rear.data;
			if(rear.llink == null) {	//deleteFront()메소드와 방향만 반대고 나머지는 동일하다.
				rear = null;
				front = null;
			}else {
				rear = rear.llink;
				rear.rlink = null;
			}
			return item;
		}
	}
	
//	=================================================================================================================
	
	public void removeFront() {	//front에서 삭제하는 메소드
		if(isEmpty()) {
			System.out.println("Front Removing fail! DQueue is empty!!");
		}else {
			if(front.rlink == null) {//값의 반환 유무를 제외하면 deleteFront()와 동일하다.
				front = null;
				rear = null;
			}else {
				front = front.rlink;
				front.llink = null;
			}
		}
	}
	
	public void removeRear() {	//rear에서 삭제하는 메소드
		if(isEmpty()) {
			System.out.println("Rear Removing fail! DQueue is empty!!");
		}else {
			if(rear.llink == null) {//removeFront()와 방향만 다르다.
				rear = null;
				front = null;
			}else {
				rear = rear.llink;
				rear.rlink = null;
			}
		}
	}
	
//	=================================================================================================================
	
	public char peekFront() {	//front방향에서 검색(front가 가리키는 노드의 data 반환)
		if(isEmpty()) {
			System.out.println("Front Peeking fail! DQueue is empty!!");
			return 0;
		}else {
			return front.data;
		}
	}
	
	public char peekRear() {	//rear방향에서 검색(rear가 가리키는 노드의 data 반환)
		if(isEmpty()) {
			System.out.println("Rear Peeking fail! DQueue is empty!");
			return 0;
		}else {
			return rear.data;
		}
	}
	
//	================================================================================================================
	
	public void printDQueue() {
		if(isEmpty()) {
			System.out.println("DQueue is empty!!\n");
		}else {
			DQNode temp = front;
			System.out.print("DQueue >> ");
			while(temp != null) {
				System.out.printf("%c ", temp.data);
				temp = temp.rlink;
			}
			//printDQueue()는 출력을 담당하는데 front방향에서 출력하는 메소드이다.
			System.out.println("\n");
		}
	}
}


public class Queue_Deque {
	public static void main(String[] args) {
		char deletedItem;
		DQueue DQ = new DQueue();
		
		DQ.insertFront('A');
		DQ.printDQueue();
		
		DQ.insertFront('B');
		DQ.printDQueue();
		
		DQ.insertFront('C');
		DQ.printDQueue();
		
		deletedItem = DQ.deleteFront();
		if(deletedItem != 0) {
			System.out.println("Front deleted Item : " + deletedItem);
		}
		DQ.printDQueue();
		
		deletedItem = DQ.deleteRear();
		if(deletedItem != 0) {
			System.out.println("Rear deleted Item : " + deletedItem);
		}
		DQ.printDQueue();
		
		DQ.insertRear('D');
		DQ.printDQueue();
		
		//삽입하는 방향에따라 결과도 다르다.
		DQ.insertFront('E');
		DQ.printDQueue();

		DQ.insertRear('F');
		DQ.printDQueue();
		
	}
}
























