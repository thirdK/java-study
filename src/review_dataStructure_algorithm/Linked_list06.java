package review_dataStructure_algorithm;

class LinkedList6 extends LinkedList {

	Node getFirst() {
		Node n = header;
		return n.next;
	}
	
}


public class Linked_list06 {
	public static void main(String[] args) {
		
		LinkedList6 ll = new LinkedList6();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		
		int k = 3; 
		
		Node found = KthToLast(ll.getFirst(), k);
		System.out.println(found.data);
	}
	
	//공간을 사용하지 않는 알고리즘(정석적인 느낌은아님)
	private static Node KthToLast(Node first, int k) {  
		Node p1 = first;//두개의 포인터를 사용함
		Node p2 = first;
		
		for(int i=0; i<k; i++) {//p1을 k만큼 먼저 이동시킴
			if(p1 == null) return null;//null이면 뒤에서 k번째는 존재하지 않으므로 null반환
			p1 = p1.next;
		}
		
		while(p1 != null) {//이제 포인터 2개를 동시에 이동시키는데 p1이 null에 도달하면 멈춤
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;//이때 p2의 위치가 뒤에서 k번째 노드
	}
//	시간은 O(N), 공간은 O(1) -> 별도의 공간을 사용하지 않기때문
}
