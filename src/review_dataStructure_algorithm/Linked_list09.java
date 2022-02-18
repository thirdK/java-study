package review_dataStructure_algorithm;

//이번에는 Linked List에 숫자가 거꾸로 저장되지 않고
//정방향으로 저장되어 있다면? (마지막노드가 1의 자리)
//1->2->3 == 123
//   4->5 == 45
//이런 경우에는 두 리스트의 길이를 먼저 알아내고 짧은 리스트의 앞에 0을 채운다
//그리고 가장 뒤의 노드가 1의 자리이므로 뒤에서부터 계산을 해야한다.
//이전 방식은 자리수가 거꾸로된 형태여서 더한 값이 10이 넘으면 carry에 1을 넣고
//함수에 carry값과 2개의 노드를 함께보내는 방법이였는데
//여기서는 거꾸로 carry에 값을 돌려 받아야하는데 그러면 정작 합계결과를 가지는 노드를 받아올 수 없다. 
//그래서 carry와 node를 객체에 넣어서 받아낸다.

class LinkedList9 extends LinkedList{
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

class Storage{//자리수를 넘겨줄 carry와 Node를 같은 객체에 묵어줘야함
	int carry = 0;
	Node result = null;
}

public class Linked_list09 {
	public static void main(String[] args) {
		LinkedList9 l1 = new LinkedList9();
		l1.append(9); //다른길이의 리스트도 잘 작동함
		l1.append(1);
//		l1.append(4);
		l1.retrieve();
		
		LinkedList9 l2 = new LinkedList9();
		l2.append(1);
		l2.append(1);
//		l2.append(3);
		l2.retrieve();
	
//		int a = getListLength(l1.get(1));
//		System.out.println(">>"+a);
		Node n = sumLists(l1.get(1), l2.get(1));
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
	
	
	private static Node sumLists(Node l1, Node l2) {//뒤에서 부터 합해주는 메소드
		int len1 = getListLength(l1);//각각 길이를 받아옴
		int len2 = getListLength(l2);
		
		if(len1 < len2) {//비교하여 길이의 차이만큼 0으로 채우게함
			l1 = LPadList(l1, len2-len1);
		}else {
			l2 = LPadList(l2, len1-len2);
		}
		
		Storage storage = addLists(l1, l2);
		
		if(storage.carry != 0) {//carry가 0이 아니면 carry를 새 노드 data에 저장하고 앞노드로 추가한다.
			storage.result = insertBefore(storage.result, storage.carry);
		}//carry가 0이면 계산이 끝났으므로 storage의 result를 반환한다.
		return storage.result;
	}
	
	private static Storage addLists(Node l1, Node l2) {
		if(l1 == null && l2 == null) { //두 리스트의 끝에 도달하게되면
			Storage storage = new Storage();//carry와 결과를 저장할 객체
			return storage;//객체반환
		}
		Storage storage = addLists(l1.next, l2.next); //반환되는 객체를 받을 객체
		int value = storage.carry + l1.data + l2.data;//반환된 두 객체의 데이터와 carry를 더함
		int data = value % 10;	//저장해야할 데이터 값은 1의 자리이고 넘어가는 수는 carry에 저장해야함
		storage.result = insertBefore(storage.result, data);//결과값을 노드를 생성하고 data저장 후 앞에 추가하고 storage에 저장함
		storage.carry = value / 10; //넘어가는 자리수 저장
		return storage; //리스트를 연결시키면서 반환함
	}
	
	//리스트의 길이를 반환하는 메소드
	private static int getListLength(Node l) {
		int total = 0;
		while(l != null) {
			total++;
			l = l.next;
		}
		return total;
	}
	
	//노드 앞에 새 노드를 삽입하는 메소드
	private static Node insertBefore(Node node, int data) {
		Node before = new Node(data);//받은 data값을 가진 노드를 생성하여
		if(node != null) {//노드가 존재하면
			before.next = node;//해당 노드 앞에 새로만든 노드를 추가를해준다.
		}
		return before;//연결된 노드 반환
	}
	
	//Linked List와 길이값을 받아서 왼쪽을 0으로 채워주는 메소드
	//자리수가 안맞으면 그만큼 앞을 0으로 채우기 위함 insertBefore() 사용
	private static Node LPadList(Node l , int length) {
		Node head = l;				//받은 노드의 앞을 0으로 채울 것이므로
		for (int i=0; i< length; i++) {//length로 받은 길이의 차이만큼
			head = insertBefore(head, 0);//head앞에 0을 채운다.
		}
		return head;// 연결시킨 노드 반환
	}
}

