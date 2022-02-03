
//스택을 순차 자료구조로 구현해본다.

interface Stack{
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}

class ArrayStack implements Stack{ //interface 구현
	private int top;
	private int stackSize;
	private char itemArray[];	//배열 선언 (참조값을 저장할 공간 할당)
	
	public ArrayStack(int stackSize) {	//stack은 LIFO구조이기에 마지막에 들어온 index를 알아야한다. 
										//top변수를 만들어 마지막 index를 저장할 것이며 stack의 i번째 index는 i-1이다.
		top = -1;		//초기(공백)상태에는 top에 -1을 넣는다. 
						//push()메소드에서 데이터가 추가되면 항상 마지막 index번호를 가지고 있도록 만들것이다.
		this.stackSize = stackSize;
		itemArray = new char[this.stackSize];	//매개변수로 받은 stackSize를 배열의 길이로하여 생성한다.
												//(값이 들어갈 저장공간을 할당받음)
	}
	
	public boolean isEmpty() {	//스택이 비어있는지 확인하는 isEmpty()메소드
		return (top == -1);		//top은 -1이 초기값이므로 같은지 판별하여 반환
	}
	
	public boolean isFull() {
		return (top == this.stackSize-1); 		//top과 배열의 가장 마지막 index가 같은지 비교하여 반환
	}
	
	public void push(char item) {
		if(isFull()) {			//더이상 공간이 없다면 true가 반환되어 아래 메세지 출력
			System.out.println("Inserting fail! Array Stack is full!");
		}else {
			itemArray[++top] = item;	//공간이 남아있다면 top을 증가시킨 후 index로
										//사용하여 매개변수로 받은 값을 저장(처음 top은 -1로 초기화되어 있다.)
			System.out.println("Inserted Item : " + item);
		}
	}
	
	public char pop() {	//마지막 index의 값을 반환하고 삭제하는 pop() 메소드
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!!");
			return 0;
		}else {
			return itemArray[top--];	//마지막 index의 값을 반환 후 top를 감소
										//top은 마지막 인덱스를 저장하고 있으므로 1을 감소시키면
										//마지막 데이터를 삭제하는것과 같다.
		}
	}
	
	public void delete() {	//반환 없이 삭제시키는 delete()메소드
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!!");
		}else {
			top--;						//pop()메소드와 달리 return이 필요없이 삭제만하므로 
										//별다른거 없이 top을 감소
		}
	}
	
	public char peek() {	//가장 마지막 index의 값을 반환하는 peek()메소드
		if(isEmpty()) {
			System.out.println("Peeking fail! Array Stack if empty!!");
			return 0;	//반환할게 없으므로
		}else {
			return itemArray[top];	//마지막 index의 값을 return
		}
	}
	
	public void printStack() {
		if(isEmpty()) {
			System.out.printf("Array Stack is empty!!%n%n");
		}else {
			System.out.println("Array Stack >> ");
			for(int i=0; i<=top; i++) {
				System.out.printf("%c", itemArray[i]);
			}
			System.out.println(); System.out.println();
		}
	}


}

public class Stack_Array {
	public static void main(String[] args) {
		int stackSize = 5;
		char deletedItem;
		ArrayStack S = new ArrayStack(stackSize);	//객체 선언과 생성
		
		S.push('A');
		S.printStack();
		
		S.push('B');
		S.printStack();
		
		S.push('C');
		S.printStack();

		deletedItem = S.pop();
		if(deletedItem != 0) {
			System.out.println("deleted Item : " + deletedItem);
		}
		S.printStack();
		
		System.out.println(S.peek()); 
		System.out.println();
		
		System.out.println("delete()\n");
		S.delete();
		
		S.printStack();
		
	}
	
}
































