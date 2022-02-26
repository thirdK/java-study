package review_dataStructure_algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

//이진트리의 노드들을 각 레벨별로
//LinkedList에 담는 알고리즘을 구현하시오
//(예를 들어 5개의 깊이를 가지는 트리라면 5개의 LinkedList를 만들어야 함)

//2가지 방법으로 구현하려고 함

//(1)
//함수가 호출될때마다 현재 노드의 level이 몇 번째 level인지를 함수의 인자로 받는다.
//레벨을 표시할 변수(level)만들어서 노드를 방문하고 level=0부터 자식노드로 갈때마다 level를 1씩증가시키면
//각 노드들이 어느 리스트에 들어가야하는지 알 수 있음
//(2)
//bfs를 변형하는 방법
//시작하자마자 root를 LinkedList에 담고 새로운 리스트를 추가함
//직전에 만든 리스트에 담긴 노드의 자식노드를 새로만든 리스트에 추가함
//다시 새 리스트를 만들고 직전에 만든 리스트에 담긴 노드의 자식노드를 추가함... (반복)

//두가지 방법은 각 노드들을 방문하여 레벨별로 리스트를 만들어서 모든 노드를 담아야 하므로
//시간 : O(N) , 공간 : O(N)
//첫 번째 방법은 재귀호출을 사용하므로 반환하기전에 내부적으로 stack이 쌓이게됨(반환할 함수를 기억하는 역할)
//그래서 첫번째 방법은 O(logN)의 공간을 추가적으로 사용하게 됨

class Tree2{
	class Node {
		int data;
		Node left;
		Node right;
		Node (int data){
			this.data = data;
		}
	}
	Node root;
	Tree2 (int size){ 	//객체 생성과 동시에 이진트리 생성
		root = makeBST(0,size-1);
	}
	
	Node makeBST(int start, int end) {	//이진 탐색 트리 생성 메소드
		if(start > end) return null;	//재귀 종료 지점
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		return node;
	}
	
	//LinkedList를 ArrayList에 담아서 사용하려고 함
	//(새 LinkedList를 만들었을 때 직전 LinkedList를 찾기 위함?)
	ArrayList<LinkedList<Node>> BSTtoList(){	//재귀호출하기 전에 초기값만 던져줄 메소드
		ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
		BSTtoList(root, lists, 0);	//이진 트리의 시작노드, 결과를 담을 배열, level초기값을 넘겨줌
		return lists;				//재귀 호출을 통해 획득한 배열을 반환
	}
	
	
	//재귀함수 정의 (매개변수 노드, LL(리스트)를 담을 AL(배열), 현재 레벨을 표시할 level)
	void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level) {
		if(root == null) return;		//넘겨받은 노드가 null이면 그냥 나감(재귀 탈출 지점)
		LinkedList<Node> list = null;	//해당 노드를 담을 list 선언만 초기화는 아래서
		if(lists.size() == level) {		//새로운 level의 노드를 처음 호출할 때 해당 level의 list는 배열방에 존재하지 않는다.
			list = new LinkedList<Node>();//새 리스트 생성
			lists.add(list);			//배열에 새 리스트 추가
		}else {	//이미 배열에 해당 레벨의 방이 존재하면
			list = lists.get(level);	//배열의 해당 level방에 있는 리스트의 시작주소를 획득해옴(노드를 추가해야하므로)
			//list의 get()은 해당 인덱스의 요소를 반환하는데 여기서 요소가 LinkedList이므로 주소가 반환된다.
		}
		list.add(root);		//새로 만들었든, 기존의 리스트를 가져왔든 리스트에 현재노드 추가
		BSTtoList(root.left, lists, level + 1);	//현재노드의 좌측 자식노드들로 재귀호출 (레벨+1)
		BSTtoList(root.right, lists, level + 1);//현재노드의 우측 자식노드들로 재귀호출
	}
	
	//BFS를 변형한 방법
	ArrayList<LinkedList<Node>> BSTtoList2() {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();//결과값을 받을 배열 생성
		LinkedList<Node> current = new LinkedList<Node>();//현재 level의 노드를 담을 리스트 생성
		if(root != null) {//값이 존재하면
			current.add(root); //초기 값으로 root노드를 먼저 담아준다.
		}
		while(current.size() > 0) {//current 리스트에 현재 level의 노드를 계속 담을것이므로 노드가 존재하면 반복됨
			result.add(current);//while 이전에 실행한 결과를 배열에 추가하고 새로운 level이 시작됨
			LinkedList<Node> parents = current; // parents참조변수에 현재 리스트 저장하고(==현재레벨을 부모레벨로 설정)
			current = new LinkedList<Node>();//새 리스트 생성(==현재 레벨 새로시작)
			for(Node parent : parents) {//직전 리스트의 노드들을 꺼내와서(==부모레벨의 모든 노드들을 돌면서)
				if(parent.left != null) current.add(parent.left);//좌측에 자식이 존자하면 현재 레벨에 모든 노드 추가
				if(parent.right != null) current.add(parent.right);//우측에 자식이 존자하면 현재 레벨에 모든 노드 추가
			}
		}
		return result; //더 이상 담을 자식노드가 없다면 결과를 담은 배열을 반환한다.
	}
	
	//결과를 출력할 메소드(결과를 담은 배열을 받음)
	void printList(ArrayList<LinkedList<Node>> arr) {
		for(LinkedList<Node> list : arr) {//배열방의 리스트를 가져오고
			for(Node node: list) {//그 리스트에서 노드들을 가져오고
				System.out.print(node.data + " ");//출력해줌
			}
			System.out.println();//리스트가 끝날때마다 줄바꿈
		}
	}
}

public class Binary_Tree02 {
	public static void main(String[] args) {
		Tree2 t = new Tree2(10);
		t.printList(t.BSTtoList());
		t.printList(t.BSTtoList2());
	}
}

/*
----------------------------------------------
			(4)
		    /  \
		   /    \
		  /      \
		(1)      (7)
	   /   \    /   \
	 (0)   (2)(5)   (8)
	         \  \     \
	         (3)(6)   (9)

----------------------------------------------
*/




























