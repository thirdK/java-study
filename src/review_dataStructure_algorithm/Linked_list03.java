package review_dataStructure_algorithm;


class LinkedList3 {
	Node3 header;

	static class Node3 { 
		int data;
		Node3 next = null;
	}

	public LinkedList3() {
		header = new Node3();
	}

	void append(int d) {
		Node3 end = new Node3();
		end.data = d;
		Node3 n = header;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	void delete(int d) {
		Node3 n = header;
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}

	void retrieve() {
		Node3 n = header.next; 

		while (n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}

	void removeDups() {//중복값을 삭제하는 메소드
		Node3 n = header;//n포인터
		while(n != null && n.next != null) {
			Node3 r = n;//r포인터는 n부터 시작해서 list의 끝까지 검사
			while(r.next != null) {
				//r의 다음 노드가 null이 아니면 반복되므로 마지막노드에는 가지 않는다.(마지막노드 위치에서 반복문 실행안한다.)
				if(n.data == r.next.data) {//만약 n의 data와 r 다음 노드의 data가 일치한다면
					r.next = r.next.next;//r을 이용하여 노드를 삭제한다.
					//삭제할 노드의 위치에 있는것 보다 그전에 있는게 더 좋다.
					//(다음 주소를 다다음 주소로 변경만 하면되니까)
				}else {
					r = r.next; //일치하는 값이 없다면 r을 다음 노드로 옮긴다.
				}
			}
			n = n.next;//n을 다음 노드로 옮긴다.
			//여기서 r이 마지막 노드를 지웠는데 n이 마지막으로 이동할 경우 오류가 난다.
			//(r의 삭제와 n의 이동이 같은 반복문 블록에서 실행 되므로 r이 마지막 노드를 삭제하면 발생된다.)
			//그래서 바깥 while의 조건에 n!=null이 붙는다.
		}
	}
//	removeDups()의 시간은 O(N^2) 공간은 O(1)
	
}

public class Linked_list03 {
	public static void main(String[] args) {
		LinkedList3 ll = new LinkedList3();
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
