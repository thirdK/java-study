package review_dataStructure_algorithm;

class LinkedList5 {
	Node header;

	public LinkedList5() {
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

	void removeDups() {
		Node n = header;
		while(n != null && n.next != null) {
			Node r = n;
			while(r.next != null) {
				if(n.data == r.next.data) {
					r.next = r.next.next;
				}else {
					r = r.next; 
				}
			}
			n = n.next;
		}
	}
	
	Node getFirst() { //이름처럼 첫 노드를 찾아서 return하는 메소드
		Node n = header;
		return n.next;
	}
	
}
class Reference {
	public int count = 0;
}

public class Linked_list05 {
	public static void main(String[] args) {
		
		LinkedList5 ll = new LinkedList5();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		
		int k = 3; 
		
		Reference r = new Reference();
		Node found = KthToLast(ll.getFirst(), k, r);
		System.out.println(found.data);
	}
	
	private static Node KthToLast(Node n, int k, Reference r) {  
		if(n == null) { 
			return null; 
		}
		
		Node found = KthToLast(n.next,k, r);
		r.count++;
		if(r.count == k) {
			return n;
		}
		return found; 
	}
	//공간 O(N) / 시간 O(N) 
	// 최악은 뒤까지 탐색하고 다시 제일 처음까지 오는경우이며 이 경우에는 O(2N)이지만 Big-O표기로는 그냥 O(N)
}
