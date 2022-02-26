package practice;

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

class Tree02{
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node root;
	
	public Tree02(int size) {
		//생성할 때 size 받아서 트리 만들기
		root = makeBST(0, size-1);
	}
	
	Node makeBST(int start, int end) {
		if(start > end) return null;
		int mid = (start+end) / 2;
		Node n = new Node(mid);
		
		n.left = makeBST(start, mid-1);
		n.right = makeBST(mid+1, end);
		
		return n;
	}
	
	ArrayList<LinkedList<Node>> BSTtoList() {
		ArrayList<LinkedList<Node>> arr = new ArrayList<LinkedList<Node>>();
		BSTtoList(root, arr, 0);
		
		return arr;
	}
	
	//이진 탐색 트리를 레벨별로 리스트를 만들어 저장한다.
	void BSTtoList(Node node, ArrayList<LinkedList<Node>> arr, int level) {
		if(node == null) return;
		LinkedList<Node> list;
		
		if(arr.size()==level) {
			list = new LinkedList<>();
			arr.add(list);
		}else {
			list = arr.get(level);
		}
		list.add(node);
		
		BSTtoList(node.left, arr, level+1);
		BSTtoList(node.right, arr, level+1);
	}
	
	ArrayList<LinkedList<Node>> BSTtoList2() {
		ArrayList<LinkedList<Node>> result = new ArrayList<>();
		LinkedList<Node> current = new LinkedList<>();
		if(root != null) {
			current.add(root);
		}
		
		while(current.size() > 0) {
			result.add(current);
			LinkedList<Node> parents = current;
			current = new LinkedList<>();
			
			for(Node parent : parents) {
				if(parent.left != null) current.add(parent.left);
				if(parent.right != null) current.add(parent.right);
			}
		}
		
		return result;
	}
	
	void printList(ArrayList<LinkedList<Node>> arr) {
		for(LinkedList<Node> list : arr) {
			for(Node node: list) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
	
	
}

public class BSTree02 {
	public static void main(String[] args) {
		Tree02 t = new Tree02(10);
		t.printList(t.BSTtoList());
		t.printList(t.BSTtoList2());
		
	}
}






































