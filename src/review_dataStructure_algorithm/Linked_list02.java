package review_dataStructure_algorithm;

class LinkedList{
	Node2 header; 
	//header의 역할만 하게될 data필드가 비어있는 노드
	//link필드는 list의 시작지점을 알려줌
	
	static class Node2{ //static 내부클래스로 Node클래스 생성
		int data;
		Node2 next = null;
	}
	
	public LinkedList() {
		header = new Node2(); 
		//LinkedList클래스로 객체를 생성하면 header에 새 노드가 할당되는데 이 노드는 list의 시작노드를 알려주는 역할만 함
	}
	
	void append(int d) {
		Node2 end = new Node2();
		end.data = d;
		Node2 n = header;//포인터로 사용할 n(header는 항상 처음노드를 가리켜야하므로 n을 이용해서 탐색한다.)
		while(n.next != null) {//다음 노드가 null이 아니면 반복
			n = n.next;
		}
		n.next = end;
	}
	
	void delete(int d) {
		Node2 n = header;
		while(n.next != null) {//이제 list의 첫번째 요소도 검사가 가능
			if(n.next.data == d) {//다음 노드의 data와 d가 같으면
				 n.next = n.next.next;//n과 다다음 노드를 연결(n의 link필드에 다음 노드 link필드에 저장된 참조값을 저장)
			}else {
				n = n.next;
			}
		}
	}
	

	void retrieve() {
		Node2 n = header.next; //반복문에서 n부터 출력을 하므로 n에 header의 다음노드 즉, 시작노드를 넣어줌

		while(n.next != null) {
			System.out.print(n.data + " -> ");//n의 데이터를 출력
			n = n.next;
		}
		System.out.println(n.data);
	}
}



public class Linked_list02 {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(10);
		ll.append(20);
		ll.append(30);
		ll.append(40);
		ll.append(50);
		
		ll.retrieve();
		
		ll.delete(30);
		ll.delete(10);
		ll.retrieve();
	}

}
