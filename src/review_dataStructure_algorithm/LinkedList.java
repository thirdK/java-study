package review_dataStructure_algorithm;

class Node {
	int data;
	Node next = null;

	public Node() {
		// TODO Auto-generated constructor stub
	}

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	Node get(int d) {
		Node n = this;
		for(int i=0; i<d; i++) {
			n=n.next;
		}
		return n;
	}

//	Node get(int d) { //d번째 노드를 반환받는 메소드
//		Node n = this;
//		int cnt=0;
//		while(n != null) {
//			if(cnt == d) return n;
//			cnt++;
//			n = n.next;
//		}
//		return null;
//	}

	Node addNext(int d) {//다음 노드로 추가
		Node n = this;
		Node next = new Node(d);

		n.next = next;
	
		return next;
	}

	Node addNext(Node node) {//다음 노드로 추가
		Node n = this;
		Node next = node;
		
		n.next = next;
		
		return next;
	}
	
	void print() {//출력
		Node n = this;
		while (n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.print(n.data);
		System.out.println();
	}
}

public class LinkedList {

	Node header;

	public LinkedList() {
		header = new Node();
	}

	void append(int d) {
		Node end = new Node();
		end.data = d;
		Node n = header;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	void delete(int d) {
		Node n = header;
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}

	void retrieve() {
		Node n = header.next;

		while (n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
}
