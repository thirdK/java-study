package review_dataStructure_algorithm;


class LinkedList2 {
	Node header;

	static class Node { 
		int data;
		Node next = null;
	}

	public LinkedList2() {
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

	void removeDups() {//중복값을 삭제하는 메소드
		Node n = header;//n포인터
		while(n != null && n.next != null) {
			Node r = n;//r포인터는 n부터 시작해서 list의 끝까지 검사
			while(r.next != null) {//r의 다음 노드가 null이 아니면 반복되므로 마지막노드에는 가지 않는다.
				if(n.data == r.next.data) {//만약 n의 data와 r 다음 노드의 data가 일치한다면
					r.next = r.next.next;//r을 이용하여 노드를 삭제한다.
					//삭제할 노드의 위치에 있는것 보다 그전에 있는게 더 좋다.
					//(다음 주소를 다다음 주소로 변경만 하면되니까)
				}else {
					r = r.next; //일치하는 값이 없다면 r을 다음 노드로 옮긴다.
				}
			}
			n = n.next;//n을 다음 노드로 옮긴다.
		}
	}
//	removeDups()의 시간은 O(N^2) 공간은 O(1)
	
}

public class Linked_list_RemoveDups {
	public static void main(String[] args) {
		LinkedList2 ll = new LinkedList2();
		ll.append(2);
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(4);
		ll.append(2);
		ll.retrieve();
		ll.removeDups();
		ll.retrieve();
	}

}
