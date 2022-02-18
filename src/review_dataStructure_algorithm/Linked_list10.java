package review_dataStructure_algorithm;

//두개의 단방향 Linked List에서 교차되는 노드찾기
//단, 교차점은 값이 아닌 주소로 찾아야한다.
//여기서 교차점은 2개의 리스트가 합쳐지는 구간을 말한다.
//	5 -> 7 -> 9 ↘
//				  10 -> 7 -> 6
//		 6 -> 8 ↗

//위와 같은 리스트이고 문제를 푸는 사람에게 주어지는 리스트는 아래와 같음
//5 -> 7 -> 9 -> 10 -> 7 -> 6
//6 -> 8 -> 10 -> 7 -> 6

//일일이 비교하면 시간이 오래 걸리므로 일단 배열의 끝을 맞춰준다.
//5 -> 7 -> 9 -> 10 -> 7 -> 6
//	   6 -> 8 -> 10 -> 7 -> 6

//리스트가 중간에 합쳐진 형태는 결국 끝의 주소가 같다는것 (인터섹션 유무만 물어본다면 끝노드의 주소만 확인하면됨)
//문제는 교차점의 노드를 반환해야함 뒤를 맞춰줬지만 단방향 리스트의 특성상 뒤에서 부터 비교하며 찾을 수는 없음
//그러므로 앞에서 부터 비교를 하는데 뒤를 맞춰준 두 개의 리스트를 짧은 리스트기준으로 잘라줌
//7 -> 9 -> 10 -> 7 -> 6
//6 -> 8 -> 10 -> 7 -> 6
//이렇게 되면 한번돌았을 때 결과값을 찾을 수 있다.


public class Linked_list10 {
	public static void main(String[] args) {
		Node n1 = new Node(5);
		Node n2 = n1.addNext(7);
		Node n3 = n2.addNext(9);
		Node n4 = n3.addNext(10);
		Node n5 = n4.addNext(7);
		Node n6 = n5.addNext(6);
		
		Node m1 = new Node(6);
		Node m2 = m1.addNext(8);
		Node m3 = m2.addNext(n4);
		
		n1.print();
		m1.print();
		
		Node n = getIntersection(n1, m1);
		
		if (n != null) {
			System.out.println("Intersection : " + n.data); //인터섹션 지점 출력
		}else {
			System.out.println("Not found");
		}
		
	}
	
	private static Node getIntersection(Node l1, Node l2) { //인터섹터 지점을 찾아주는 메소드
		int len1 = getListLength(l1);//둘의 길이를 비교하기위해 변수에 저장
		int len2 = getListLength(l2);
		
		if(len1 > len2) {//길이를 비교하여
			l1 = l1.get(len1-len2);//차이가 나는만큼 긴 리스트를 잘라서 저장
		}else if(len1 < len2){
			l2 = l2.get(len2 - len1);
		}
		
		while(l1 != null && l2 != null) {//두 리스트의 길이가 같기 때문에 둘 다 null이 되기전까지(마지막 노드까지)
			if(l1 == l2) {	//두 리스트의 주소가 같은 지점에서 반환
				return l1; 
			}
			l1 = l1.next; //조건에 맞는 지점을 찾을때까지 뒤로 이동
			l2 = l2.next;
		}
		return null;//일치하는 지점이 없다면 null반환
	}
	

	private static int getListLength(Node l) {//길이 반환
		int total = 0;
		while(l != null) {
			total++;
			l = l.next;
		}
		return total;
	}
}
