package review_dataStructure_algorithm;
//어떤 숫자를 자리수벼로 한개씩 Linked List에 담았는데 

//1의 자리가 헤더에 오도록 거꾸로담은 Linked List가 두개가 있다고 가정한다.
//이 두개의 Linked List를 합산하고 같은식으로 Linked List에 담아서 반환하는 문제
// 1->2->3 = 321
// 4->5->6 = 654
// 둘의 합은 975 = 5->7->9 로 반환
// 자리수가 다르거나, 10이넘어 자리수가 넘어가는 상황도 생각

class LinkedList8 extends Linked_List {

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
		LinkedList8 l1 = new LinkedList8();
		l1.append(9); //다른길이의 리스트도 잘 작동함
		l1.append(1);
//		l1.append(4);
		l1.retrieve();
		
		LinkedList8 l2 = new LinkedList8();
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
		//자리수가 안맞거나 carry가 0이 아니면 한쪽은 null이 아닌 값을 가질 수 있다.
		//그러므로 둘 다 null이고 carry가 0이면 반환점
			return null;
		}

		Node result = new Node();//결과를 저장할 노드를 만들어줌 이 노드는 메소드가 호출될때마다 다른 노드(다른 주소)
		int value = carry;//value에 더하는 값을 임시로 저장함

		if (l1 != null) { //null값을 연산하면 오류가나므로 걸러줌
			value += l1.data; 
		}
		if (l2 != null) {
			value += l2.data;
		}
		//l1, l2 노드의 data 값을 value 더해줌
		
		result.data = value % 10;
		//이제 result의 data필드에 값을 저장하는데 한 자리수 씩 저장하고 10이상이면 다음 자릿수에 1을 더해야함(carry)
		//그러므로 10으로 나눈 나머지만 저장

		if (l1 != null || l2 != null) { //둘 중 하나라도 값이 존재하면 재귀호출 진행
			Node next = sumLists( //결국 재귀의 반환조건이 성립되면 처음에는 null을 반환받아 저장되고 이후에는 각 result의 주소를 저장될것임
					l1 == null ? null : l1.next, //null이 아니면 다음자리수를 메소드에 넘긴다.
					l2 == null ? null : l2.next, //null이면 null을
					value >= 10 ? 1 : 0 //여기서 value가 10이상이면 1을 다음 자리수로 넘겨준다.
			);
			result.next = next; //노드를 연결한다.
		}
		return result;

	}

}
