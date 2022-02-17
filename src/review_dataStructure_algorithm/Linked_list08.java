package review_dataStructure_algorithm;
//어떤 숫자를 자리수벼로 한개씩 Linked List에 담았는데 

//1의 자리가 헤더에 오도록 거꾸로담은 Linked List가 두개가 있다고 가정한다.
//이 두개의 Linked List를 합산하고 같은식으로 Linked List에 담아서 반환하는 문제
// 1->2->3 = 321
// 4->5->6 = 654
// 둘의 합은 975 = 5->7->9 로 반환
// 자리수가 다르거나, 10이넘어 자리수가 넘어가는 상황도 생각

class LinkedList08 extends LinkedList {

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

public class Linked_list08 {
	public static void main(String[] args) {
		LinkedList08 l1 = new LinkedList08();
		l1.append(9); //다른길이의 리스트도 잘 작동함
		l1.append(9);
//		l1.append(4);
		l1.retrieve();
		
		LinkedList08 l2 = new LinkedList08();
		l2.append(1);
//		l2.append(4);
//		l2.append(3);
		l2.retrieve();
		
		Node n = sumLists(l1.get(1), l2.get(1), 0);
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}

	private static Node sumLists(Node l1, Node l2, int carry) {
		//carry는 자리수가 넘어가는 값을 저장 5+9 -> carry=1, result.data = 4
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		Node result = new Node();
		int value = carry;

		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;

		if (l1 != null || l2 != null) {
			Node next = sumLists(
					l1 == null ? null : l1.next, 
					l2 == null ? null : l2.next, 
					value >= 10 ? 1 : 0
			);
			result.next = next;
		}
		return result;

	}

}
