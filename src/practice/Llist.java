package practice;


class Node {
	int data;
	Node link = null;

	public Node() {
	}

	public Node(int d) {
		this.data = d;
		this.link = null;
	}
	
	Node addNext(int d) {
		Node n = new Node(d);
		this.link = n;
		
		return n;
	}
	
	Node addNext(Node n) {
		this.link = n;
		return n;
	}
	
	void print() {
		Node p = this;
		
		while(p.link != null) {
			System.out.print(p.data + " -> ");
			p = p.link;
		}
		System.out.println(p.data);
	}
	
	Node get1(int d) {
		Node n = this;
		for(int i=0; i<d; i++) {
			n = n.link;
		}
		return n;
	}
}

class Reference {
	int count = 0;
}

class Storage {
	int carry = 0;
	Node n = null;
}

public class Llist {
	Node header;

	public Llist() {
		header = new Node();
	}

	void append(int d) { // data를 받아 마지막 노드에 추가
		Node p = header;
		Node n = new Node(d);

		while (p.link != null) {
			p = p.link;
		}
		p.link = n;
	}

	void delete(int d) {
		Node p = header;
		while (p.link != null) {
			if (p.link.data == d) {
				p.link = p.link.link;
			} else {
				p = p.link;
			}
		}
	}

	void retrieve() {
		Node p = header.link;

		while (p.link != null) {
			System.out.print(p.data + " -> ");
			p = p.link;
		}
		System.out.println(p.data);
	}

	void removeDups() {
		Node p = header.link;

		while (p != null) {
			Node n = p;
			while (n.link != null) {
				if (p.data == n.link.data) {
					n.link = n.link.link;
				} else {
					n = n.link;
				}
			}
			p = p.link;
		}

	}

	Node getFirst() {
		return header.link;
	}

	int KthToLast(Node node, int d) {
		// 탈출지점
		if (node == null) {
			return 0;
		}

		// 재귀호출
		int count = KthToLast(node.link, d) + 1;

		if (count == d) {
			System.out.println(node.data);
		}

		return count;

	}

	Node KthToLast2(Node node, int d, Reference r) {
		// 탈출지점
		if (node == null) {
			return null;
		}
		// 재귀호출
		Node found = KthToLast2(node.link, d, r);
		r.count++;
		if (r.count == d) {
			return node;
		}
		return found;
	}

	// 1의 자리가 헤더에 오도록 거꾸로담은 Linked List가 두개가 있다고 가정한다.
	// 이 두개의 Linked List를 합산하고 같은식으로 Linked List에 담아서 반환하는 문제
	// 1->2->3 = 321
	// 4->5->6 = 654
	// 둘의 합은 975 = 5->7->9 로 반환
	// 자리수가 다르거나, 10이넘어 자리수가 넘어가는 상황도 생각

	static Node sumLists(Node n1, Node n2, int d) {
		// 탈출지점
		if (n1 == null && n2 == null && d == 0) {
			return null;
		}

		Node result = new Node();
		// 자리수 별로 합치고 값을 저장해야함
		// 자리수가 넘어가는 값을 처리해야함 처리하고 다음자리수에 가져가야함(매개변수필요)
		int value = d;
		if (n1 != null) {
			value += n1.data;
		}
		if (n2 != null) {
			value += n2.data;
		}

		// %10
		result.data = value % 10;

		// 재귀호출
		Node next = sumLists(n1 == null ? null : n1.link, n2 == null ? null : n2.link, value >= 10 ? 1 : 0);

		result.link = next;

		return result;
	}

	Node get(int d) { //d번째 노드를 반환받는 메소드
		Node n = header;
		int cnt=0;
		while(n != null) {
			if(cnt == d) return n;
			cnt++;
			n = n.link;
		}
		return null;
	}

	// 이번에는 Linked List에 숫자가 거꾸로 저장되지 않고
	// 정방향으로 저장되어 있다면? (마지막노드가 1의 자리)
	// 1->2->3 == 123
	// 4->5 == 45

	// 두 리스트의 길이를 구한다.
	// 길이가 다르다면 리스트의 길이를 맞추기위해 자릿수가 안맞으면 앞을 0으로 채운다.

	// 자리수를 더하는데 이번에는 1의 자리가 가장 끝에 있으므로 끝에서부터 더하면서 자릿수를 넘어가는 값을 받아온다

	// 가장 앞의 자릿수가 넘어가면 새 노드를 붙여줘야 한다.

	// 두 리스트의 길이를 구한다.
	static int listLenght(Node node) {
		int count = 0;

		while (node != null) {
			count++;
			node = node.link;
		}
		return count;
	}

	// 앞에 삽입
	static Node insertBefore(Node node, int data) {
		Node before = new Node(data);
		if (node != null) {
			before.link = node;
		}
		return before;
	}

	// 길이가 다르다면 리스트의 길이를 맞추기위해 자릿수가 안맞으면 앞을 0으로 채운다.
	static Node zero(Node node, int length) {
		Node n = node;
		for (int i = 0; i < length; i++) {
			n = insertBefore(n, 0);
		}
		return n;
	}

	// 자리수를 더하는데 이번에는 1의 자리가 가장 끝에 있으므로 끝에서부터 더하면서 자릿수를 넘어가는 값을 받아온다
	static Node sumList(Node l1, Node l2, Storage r) {
		// 반환되야하는 것은 자릿수 초과여부, 합한 결과를 가진 리스트 -> 두가지를 반환할 수는 없으므로 객체로 묶어버리기

		int len1 = listLenght(l1);
		int len2 = listLenght(l2);

		if (len1 > len2) {
			l2 = zero(l2, len1 - len2);
		} else if (len1 < len2) {
			l1 = zero(l1, len2 - len1);
		}
		
		Storage storage =addList(l1, l2, r);
		
		// 가장 앞의 자릿수가 넘어가면 새 노드를 붙여줘야 한다.
		if(storage.carry != 0) {
			storage.n = insertBefore(storage.n, storage.carry);
		}
		
		return storage.n;
	}

	static Storage addList(Node l1, Node l2, Storage r) {
		// 반환점
		if (l1 == null && l2 == null) {
			Storage storage = new Storage();
			return storage;
		}
		//재귀호출
		Storage storage = addList(l1.link, l2.link, r);
		
		int value = storage.carry + l1.data + l2.data;
		
		storage.n = insertBefore(storage.n, value % 10);
		storage.carry = value/10;
		
		
		return storage;
	}
	
	//두개의 단방향 Linked List에서 교차되는 노드찾기
	//단, 교차점은 값이 아닌 주소로 찾아야한다.
	//여기서 교차점은 2개의 리스트가 합쳐지는 구간을 말한다.
//	5 -> 7 -> 9 ↘
//				  10 -> 7 -> 6
//		 6 -> 8 ↗
	
	//우선 문제를 풀기위해 위의 형태의 리스트를 구현해야함 다음자리에 노드를 추가하는 메소드가 필요(Node 클래스에 생성)
	
	//두 리스트의 길이 확인
	int getListLength(Node l1) {
		int length = 0;
		while(l1 != null) {
			length++;
			l1 = l1.link;
		}
		return length;
	}
	//두 리스트의 길이를 맞춰주기(두 노드가 합쳐진다면 끝 노드는 같을 것이다.)
	//길이는 짧은쪽에 맞춰서 긴 리스트의 앞을 자른다.
	Node getIntersection(Node l1, Node l2) {
		int len1 = getListLength(l1);
		int len2 = getListLength(l2);
		
		if(len1 > len2) {
			l1 = l1.get1(len1-len2);
		}else if(len1 < len2) {
			l2 = l2.get1(len2-len1);
		}
		
		//두 리스트의 노드를 동시에 탐색하면서 참조값이 같으면(교차점이면) 해당 노드 반환하기
		while(l1 != null && l2 != null) {
			if(l1 == l2) {
				return l1;
			}
			l1 = l1.link;
			l2 = l2.link;
		}
		return null;
	}
	
	
	//Linked List 안에서 Loop 찾기
	//Loop가 시작되는 지점을 반환해야함
	
	//2개의 포인터 s,f를 사용 s는 1칸 f는 2칸씩 이동
	//s와 f가 1차로 만나면 f는 두고 s를 출발 노드로 이동
	//s,f 1칸씩 이동하여 만나는지점 반환
	Node findLoop (Node n){
		Node s = n;
		Node f = n;
		
		while(f.link != null) {
			s = s.link;
			f = f.link.link;
			if(s == f) {
				break;
			}
		}
		if (f.link == null || f == null) {
			return null;
		}
		s = n;
		while(s != f) {
			s = s.link;
			f = f.link;
		}
		
		return s;
	}
	
	

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = n1.addNext(2);
		Node n3 = n2.addNext(3);
		Node n4 = n3.addNext(4);
		Node n5 = n4.addNext(5);
		Node n6 = n5.addNext(6);
		Node n7 = n6.addNext(7);
		n7.addNext(n2); //루프 걸기
		
		Llist ll = new Llist();
		
		System.out.println(ll.findLoop(n1).data); 
		
//		System.out.println(ll.getListLength(n1)); 
//		n1.print();
		
		
		
//		Node m1 = new Node(10);
//		Node m2 = m1.addNext(20);
//		Node m3 = m2.addNext(n3);
//		m1.print();
//		
//		Node r = ll.getIntersection(n1, m1);
//		
//		if (r != null) {
//			System.out.println("Intersection : " + r.data); //인터섹션 지점 출력
//		}else {
//			System.out.println("Not found");
//		}
		
		
//		Llist l1 = new Llist();
//		l1.append(1);
//		l1.append(2);
//		l1.append(5);
//
//		l1.retrieve();
//
//		Llist l2 = new Llist();
//		l2.append(9);
//		l2.append(3);
//		l2.append(5);
//
//		l2.retrieve();
//		
//		Storage s = new Storage();
//		
//		Node n = sumList(l1.getFirst(), l2.getFirst(), s);
//		
//		while(n.link != null) {
//			System.out.print(n.data + " -> ");
//			n = n.link;
//		}
//		System.out.println(n.data);
		
		
//		System.out.println(listLenght(l1.getFirst()));
		

//		Node n = sumLists(l1.get(1), l2.get(1), 0);
//		
//		while(n.link != null) {
//			System.out.print(n.data + " -> ");
//			n = n.link;
//		}
//		System.out.println(n.data);

//		Reference r = new Reference();
//		System.out.println(l1.KthToLast2(l1.getFirst(), 3, r).data);

	}
}
