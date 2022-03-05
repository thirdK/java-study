package practice;
//LinkedList 구현
class LinkedList00<T>{
	class Node<T>{
		T data;
		Node<T> link;
		
		public Node() {};
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	Node<T> header;
	
	public LinkedList00() {
		header = new Node<>();
	}
	
	void append(T data) {
		Node<T> node = new Node<>(data);
		Node<T> p = header;
		
		while(p.link != null) {
			p = p.link;
		}
		p.link = node;
	}
	
	void delete(T data) {
		Node<T> p = header;
		
		while(p.link != null) {
			if(p.link.data == data) {
				p.link = p.link.link;
			}else {
				p = p.link;
			}
		}
	}
	
	void retrieve() {
		Node<T> p = header.link;
		
		while(p.link != null) {
			System.out.print(p.data + " -> ");
			p = p.link;
		}
		System.out.println(p.data);
	}
	//중복값 제거
	void removeDups() {
		Node<T> p = header.link;
		
		while(p != null && p.link != null) {
			Node<T> n = p;
			
			while(n.link != null) {
				if(p.data == n.link.data) {
					n.link = n.link.link;
				}else {
					n = n.link;
				}
			}
			p = p.link;
		}
		
	}
	//역순으로 찾아서 print 출력하기
	void KthToLast(T data) {
		KthToLast(header.link, data);
	}
	int KthToLast(Node<T> n, T data) {
		if(n == null) return 1;
		
		int cnt = KthToLast(n.link, data);
		if(n.data == data) {
			System.out.println(data + " 뒤에서 " + cnt + "번째 입니다.");
		}
		return ++cnt;
	}
	//역순으로 찾아서 노드 반환하기
	
	class Count{ //Node반환해야해서 cnt는 인스턴스로 넘겨줌
		int cnt; //기본값이 0이라 초기화 불필요
	}
	
	Node<T> KthToLast2(T data) {
		Count c = new Count();
		Node<T> node = KthToLast2(header.link, data, c);
		return node;
	}
	
	Node<T> KthToLast2(Node<T> n, T data, Count c){
		if(n == null) return null;
		
		Node<T> node = KthToLast2(n.link, data, c);
		
		c.cnt++;
		if(n.data == data) {
			node = n;
			System.out.println("뒤에서 "+c.cnt + "번째에 위치");
		}
		return node;
	}
	
	//단방향 노드에서 [중간]노드 삭제하기
	//단 오직 삭제할 노드만 알고 있다.
	
	Node<T> getNode(int d){ //d번째 노드를 반환
		Node<T> p = header;
		for(int i=0; i<d; i++) {
			if(p == null) return null;
			p=p.link;
		}
		return p;
	}
	
	void deleteNode(int d) {
		Node<T> node = getNode(d); //반환받는 d번째 노드를 삭제 (끝 노드는 못건든다.)
		if(node == null || node.link == null) return;
		node.data = node.link.data;
		node.link = node.link.link;
	}
	
	//어떤 숫자를 자리수별로 한개씩 Linked List에 담았는데 

	//1의 자리가 헤더에 오도록 거꾸로담은 Linked List가 두개가 있다고 가정한다.
	//이 두개의 Linked List를 합산하고 같은식으로 Linked List에 담아서 반환하는 문제
	// 1->2->3 = 321
	// 4->5->6 = 654
	// 둘의 합은 975 = 5->7->9 로 반환
	// 자리수가 다르거나, 10이넘어 자리수가 넘어가는 상황도 생각
	
	// 두개의 리스트를 받는 메소드가 필요하다.
	// 첫 리스트(1의자리) 합치고 결과를 저장하는 새 리스트에 추가하고 
	// 자리수가 넘어가는 경우 1을 가지고 다음 자리수로 넘어간다. 반복
	// 두 리스트의 길이가 다를 수 있으므로 한쪽이 null인 경우도 생각한다. 
	// 마지막 리스트(가장큰 자리수)가 10이 넘으면 리스트를 추가로 생성한다.
	
	Node<Integer> sumLists(Node<Integer> n1, Node<Integer> n2, int carry) {
		if(n1 == null && n2 == null && carry == 0) return null;
		Node<Integer> node = new Node<>();
		int total = carry;
		
		if(n1 != null && n2 != null) {
			total += n1.data + n2.data;
		}else if(n1 != null) {
			total += n1.data; 
		}else if(n2 != null) {
			total += n2.data;
		}
		
		node.data = total%10;
		carry = total/10;
		node.link = sumLists(
				n1==null ? null : n1.link, 
				n2 == null ? null : n2.link, 
				carry);
		return node;
	}
	
	void sumResult(Node<Integer> n1, Node<Integer> n2, int carry) {
		Node<Integer> node = sumLists(n1, n2, carry);
		
		while(node.link != null) {
			System.out.print(node.data + " -> " );
			node = node.link;
		}
		System.out.println(node.data);
	}
}

public class Llist2 {
	public static void main(String[] args) {
//		LinkedList00<Integer> ll = new LinkedList00<>();
		LinkedList00<Integer> l1 = new LinkedList00<>();
		LinkedList00<Integer> l2 = new LinkedList00<>();
		
		l1.append(1);
		l1.append(2);
		l1.append(3);
		
		l2.append(3);
		l2.append(5);
		l2.append(8);
		
		
		l1.sumResult(l1.getNode(1), l2.getNode(1), 0);
		
		
		
		
		
		
		
		
		
		
//		ll.append(1);
//		ll.append(2);
//		ll.append(3);
//		ll.append(4);
//		ll.append(5);
//		ll.append(6);
//		
//		ll.retrieve();
//		
//		ll.removeDups();
//		
//		ll.retrieve();
//		
//		ll.deleteNode(6);
//		
//		ll.retrieve();
		
//		ll.KthToLast(6);
//		
//		System.out.println(ll.KthToLast2(1).data);
	}
}




































