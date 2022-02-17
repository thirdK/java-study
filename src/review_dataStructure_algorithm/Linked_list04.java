package review_dataStructure_algorithm;
//노드는 Node 클래스로 뺐음

class LinkedList4 extends LinkedList{
//	상속으로 처리함
	
	Node getFirst() { //이름처럼 첫 노드를 찾아서 return하는 메소드
		Node n = header;
		return n.next;
	}

	
}


public class Linked_list04 {
	public static void main(String[] args) {
		
		LinkedList4 ll = new LinkedList4();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		
		int k = 1; //뒤에서 몇 번째를 찾는지 알려줄 변수
		
		KthToLast(ll.getFirst(), k);
		
	}
	
	private static int KthToLast(Node n, int k) { //역순으로 노드를 탐색하는 메소드
		if(n == null) { //n이 null이라는 건 마지막 노드 다음으로 넘어간것
			return 0; //재귀호출을 통해 0을 반환하고
		}
		
		int count = KthToLast(n.next, k)+1; //재귀호출을 하는데 반환하는 값에 1을 더해서 count에 저장
		if(count == k) {//count와 k가 일치하는지 확인하고 아래 코드실행
			System.out.println(k+"th to last node is " + n.data);
		}
		return count; //다시 count반환 (마지막 호출에서 반환되기 시작하면 +1씩 늘어남)
	}
	
}
