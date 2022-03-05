package review_dataStructure_algorithm;

//이진검색트리에서 주어진 노드의 다음노드를 찾는 함수를 구현하시오
//(단, 다음노드의 순서는 inorder traverse에 입각함)
//inorder 는 L > root > R
//어떤 노드(N)의 다음순서의 노드(T)는 (N)의 위에 있을수도 있고, 아래 있을수도 있다.
//만약 (N)의 오른쪽에 자식노드가 있다면 (T)는 아래 있는것이고
//(N)의 오른쪽에 자식노드가 없다면 (T)는위에 있는것이다.

//N의 오른쪽에 자식노드가 있는 경우 오른쪽으로 이동하고 inorder의 순서대로 진행
//**즉, 오른쪽으로 이동하고 이후에는 계속 왼쪽으로 이동하면 T가 나옴**

//N의 오른쪽에 자식노드가 없는 경우 해당 노드선상에서는 방문을 완료했다는 의미이므로 호출한 부모노드에게 반환되고
//이때 N은 부모의 오른쪽 자식이였는지 왼쪽 자식이였는지를 알아야함 
//**inorder의 순서 L,root,R을 기억한다.**

//N이 왼쪽자식 이였다면 root가 T이다.

//N이 오른쪽 자식이였다면 N의 부모노드는 이미 출력된 상태이므로 부모의 부모노드로 이동하여 재확인한다.
//위를 반복하다가 어느순간 왼쪽자식으로서 호출된 경우를 만난다면 그 부모노드가 (T)가 된다.

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



class Tree04{
	class Node{
		int data;
		Node left;
		Node right;
		Node parent; //이 경우에는 부모노드의 주소가 필요함
		
		public Node(int data) {
			this.data = data;
		}
	}
	Node root;
	Tree04 (int size) {
		root = makeBST(0, size - 1, null);
	}
	
	Node makeBST(int start, int end, Node parent) {
		if(start > end) return null;
		int mid = (start+end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1, node);
		node.right = makeBST(mid+1, end, node);
		node.parent = parent;
		return node;
	}
	
	void findNext(Node node) { 
		//오른쪽 노드가 없는 경우 -> 위에서 찾아야함
		//재귀 호출에서 부모노드와 현재노드를 넘겨주어서 현재노드가 어느쪽 자식이였는지 알아냄
		if(node.right == null) {
			System.out.println(findAbove(node.parent, node).data + " is " + node.data + "'s next"); 
		}else { //오른쪽자식이 있으면 아래에서 찾음
			System.out.println(findBelow(node.right).data + " is " + node.data + "'s next");
		}
	}
	
	//위에서 찾기
	//재귀 호출에서 부모노드와 현재노드를 넘겨주어서 현재노드가 어느쪽 자식이였는지 알아냄
	Node findAbove(Node root, Node child) {
		if(root == null) return null; //기본적으로 null예외처리
		if(root.left == child) return root;//부모의 왼쪽노드가 나와 같으면 그 부모가 찾는 값이다.
		return findAbove(root.parent, root);//그렇지 않으면 부모의 부모를 가지고 함수 재호출
	}
	//아래에서 찾기
	Node findBelow(Node root) {
		if(root.left == null) return root;//왼쪽에 자식노드가 없을때 해당노드가 찾는 값이다.
		return findBelow(root.left);
	}
}

public class BSTree04 {
	public static void main(String[] args) {
		Tree04 t = new Tree04(10);
		t.findNext(t.root.left.right.right);
		t.findNext(t.root.left);
		t.findNext(t.root);
		t.findNext(t.root.left.left);
		t.findNext(t.root.right.left.right);
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






















