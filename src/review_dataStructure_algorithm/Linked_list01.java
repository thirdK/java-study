package review_dataStructure_algorithm;

//단방향 Linked list 구현 복습(이전 공부자료는 별로인것 같아서 새로 만듬)
//우선 개념을 잡기위해 간단하게 구현 
//*완전하지 않음*
//개선된 구현은 Linked_list02

class Node1{
	int data;	//data필드
	Node1 next = null;	//link필드 어차피 첫노드 null이니까 null값 넣어줌 (추가되는 노드는 어차피 따로 참조값 넣을거니까 상관없음)
	
	public Node1(int d) {//노드의 data필드에 값이 들어가야하니 노드를 만들때부터 받을 수 있게 생성자를 이용함
		this.data = d;
	}
	
	void append(int d) {//추가 메소드
		Node1 end = new Node1(d);//추가할 값을 data필드에 넣은 노드 생성
		Node1 n = this;//포인터(참조변수,헤더)
		while(n.next != null) {//다음노드의 link필드가 null이 아닐때까지 반복
			n = n.next;//반복으로 다음노드를 가리킬수 있게함
		}
		n.next = end; //마지막 노드의 link필드에 새 노드를 추가
	}
	
	void delete(int d) {//삭제 메소드
		Node1 n = this;
		while(n.next != null) { //다음 노드의 link필드가 null이 아닐때까지
			if(n.next.data == d) {//다음 노드의 값과 d를 비교 (여기서 문제는 첫번째 노드는 탐색범위에 안들어옴(*불완전)
				 n.next = n.next.next;//(노드의 link필드)에 = (다음 노드의 link필드의 참조값)을 저장함
			}else {
				n = n.next;//일치하는 값이 아니면 다음 노드로 넘어감
			}
		}
	}
	

	void retrieve() {//끝까지 탐색하여 출력하는 메소드
		Node1 n = this;
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
}
//여기서 문제는 Node클래스가 헤더의 역할을 하는데 생성되는 리스트의 시작값이기도 하다.(값을 보유한 헤더)

public class Linked_list01 {
	public static void main(String[] args) {
		Node1 head = new Node1(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.append(5);
		head.append(6);
		head.retrieve();
		
		head.delete(3);
		head.delete(5);
		head.retrieve();
	}

}
