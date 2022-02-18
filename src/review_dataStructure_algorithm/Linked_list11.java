package review_dataStructure_algorithm;

//Linked List 안에서 Loop 찾기
//루프가 잇는지 확인하고 루프가 시작되는 지점을 찾는다.
//1 -> 2 -> 3 -> 4 -> 5 -> 6 --> 3 --> 4 --> 5 --> 6 --> 3 --> 4 -->......
//3~6이 루프

//2개의 포인터 s, f를 만들어서 s는 1칸씩, f는 2칸씩 움직이게하고 둘이 만나는 지점을 찾으면됨
//여기서 f가 s를 계속 뛰어넘을지 확인하는 방법은
//s가 i에 있고 f가 s를 뛰어넘어 i+1에 있을 때 이전 자리를 계산해보면
//s = i-1
//f = (i+1)-2 -> i-1 이므로
//반드시 만나게 되어있다. 그런데 s와 f가 만난지점이 루프의 시작지점이 아니라면?
//s를 다시 처음 시작지점으로 보내고 f는 루프를 돌게한다 그리고 다시 만나게되면 그곳은 루프의 시작지점이다.

//루프에 들어가기 전 노드들을 직선코스, 루프에 들어가면 원형코스라고 비유한다.
//직선코스의 길이를 k라고 하면 s가 k에 도달하면 f는 시작지점에서는 2k만큼 원형코스(루프)안에서는 k만큼 움직인것이다.
//즉, f의 위치는 K = k % (루프의 길이)
//여기서 s와 k의 거리는 K만큼 벌어진 상태 -> s가 루프에 진입하면 k는 K만큼 앞서있다. -> f는 (루프길이-K) 만큼 뒤에있다.
//*f는 (루프길이-K) 만큼 뒤에있다.*
// |-----|-----|
// k     s
//그렇다면 k는 s보다 2배로 움직이므로 s가 앞서있는 만큼 움직이면 둘은 만나게 되어있다.
//즉, s가 (루프길이 - K) 만큼 움직이면 따라잡힌다.
//그러면 s가 (루프길이 - K)만큼 움직여서 따라잡혔을 때의 위치는 다시말하면 루프의 시작지점에서 K만큼 뒤에 있다는 것이다.
//그러므로 만난 지점에서 K만큼 더 가면 루프의 시작지점이 나온다. 하지만 K의 길이를 모르므로
//s를 다시 직선코스의 출발지점으로 보내어 원형코스(루프)에 들어오기 전까지 이동을 시키면 그 거리가 K이며 
//여기부터 r과 f를 둘 다 1만큼 움직이면 r이 루프에 들어오는 순간 r과 f는 루프의 시작지점에서 만나게된다.

public class Linked_list11 {
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = n1.addNext(2);
		Node n3 = n2.addNext(3);
		Node n4 = n3.addNext(4);
		Node n5 = n4.addNext(5);
		Node n6 = n5.addNext(6);
		Node n7 = n6.addNext(7);
		Node n8 = n7.addNext(8);
		
		n8.addNext(n4); //루프를 걸어줌
		Node n = findLoop(n1);
		
		if(n != null) {
			System.out.println("Start of loop: " + n.data);
		}else {
			System.out.println("Loop not found");
		}
	}
	
	private static Node findLoop(Node head) {//루프 시작지점을 찾는 메소드
		Node fast = head;//두 개의 포인터 객체 동일한 시작지점으로
		Node slow = head;//fast는 2칸씩 slow는 1칸씩 이동시킴
		
		while(fast != null && fast.next != null) {
			slow = slow.next;//1칸씩
			fast =fast.next.next;//2칸씩
			if(fast == slow) {//만나면 반복문 탈출
				break;
			}
		}
		
		if(fast == null || fast.next == null) {//먼저 출발한 fast가 null을 발견하면 루프가 아니므로 null반환
			return null;
		}
		slow = head;//slow를 다시 출발지점으로 보내고
		
		while(fast != slow) {//만날때까지 둘 다 1칸씩 이동
			slow = slow.next;
			fast = fast.next;
		}
		return fast;//만난 지점이 루프의 시작지점이므로 둘 중 아무거나 반환
	}
}
