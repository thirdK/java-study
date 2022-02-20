package review_dataStructure_algorithm;

class LinkedList5 extends Linked_List{	
	Node getFirst() { //이름처럼 첫 노드를 찾아서 return하는 메소드
		Node n = header;
		return n.next;
	}
	
}
//노드를 반환해야하는데 java에서는 return값이 1개만 가능하다. 그렇다고 C처럼 포인터를 사용할 수도 없고 call by reference 또한 지원하지 않는다.
//하지만 객체가 참조값을 저장한다는 점을 이용하여 포인터를 사용하는 것과 비슷한 효과를 낼 수 있다.

class Reference { //Reference 클래스에
	public int count = 0; //count변수를 만든다.
}

public class Linked_list05 {
	public static void main(String[] args) {
		
		LinkedList5 ll = new LinkedList5();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		
		int k = 1; 
		
		Reference r = new Reference(); //Reference 객체를 선언해주고
		Node found = KthToLast(ll.getFirst(), k, r);// Node를 반환받기 위해 found객체 생성, r객체 인수로 넘겨주기
		System.out.println(found.data);
	}
	
	private static Node KthToLast(Node n, int k, Reference r) {  //역순으로 노드를 탐색하여 노드를 반환
		if(n == null) {  //이제 노드를 반환하기 때문에 마지막 노드를 지나서 null이 나오면
			return null; //null을 반환한다. 재귀호출 탈출지점
		}
		
		Node found = KthToLast(n.next,k, r);//여기서 n.next로 재귀호출을 한다.(다음노드로 이동하며 재귀호출)
		r.count++;
		//count멤버변수를 가진 r객체는 매개변수에 참조값을 넘겨주기 때문에 count를 활용할 수 있다.
		if(r.count == k) {//count와 k가 같으면
			return n;	//n반환 --> 지금위치의 노드반환
		}
		return found; //같지 않으면 found를 반환하면서 되돌아감
	}
	//공간 O(N) / 시간 O(N) 
	// 최악은 뒤까지 탐색하고 다시 제일 처음까지 오는경우이며 이 경우에는 O(2N)이지만 Big-O표기로는 그냥 O(N)
}
