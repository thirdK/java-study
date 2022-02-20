package review_dataStructure_algorithm;

//단방향 Linked List에서 중간에 있는 노드를 삭제하기
//단, 첫번째 노드가 어딨는지 모르고, 오직 삭제할 노드만 갖고 있다.


class LinkedList7 extends Linked_List {
	
	Node getFirst() {
		Node n = header;
		return n.next;
	}
	
	Node get(int d) { //d번째 노드를 반환받는 메소드
		Node n = header;
		int cnt=0;
		while(n != null) {
			if(cnt == d) return n;
			cnt++;
			n = n.next;
		}
		return null;
	}
	
}


public class Linked_list07 {
	public static void main(String[] args) {
		
		LinkedList7 ll = new LinkedList7();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		
		deleteNode(ll.get(3));
		ll.retrieve();
	}
	
	private static boolean deleteNode(Node n) {//중간 노드를 제거하는 메소드
		if(n == null || n.next == null) {//삭제 성공여부를 반환하기 위해 조건문
			return false;
		}
		Node next = n.next;//중간노드만 알고 있기때문에 알고있는 노드의 다음노드의 data와 link를 가져오면 끝
		n.data = next.data;//단 이 메소드는 끝 노드는 건들 수 없다.
		n.next = next.next;
		return true;
	}

}

























