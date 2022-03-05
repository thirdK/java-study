package practice;

//이진검색트리에서 주어진 노드의 다음노드를 찾는 함수를 구현하시오
//(단, 다음노드의 순서는 inorder traverse에 입각함)

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
		Node parent;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node root;
	
	public Tree04(int size) {
		root = makeBST(0,size-1,root);
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
		if(node.right == null) {
			System.out.println(findAdove(node.parent, node).data+" is " + node.data + "'s next");
		}else {
			System.out.println(findBelow(node.right).data+" is " + node.data + "'s next" );
		}
	}
	
	Node findAdove(Node root, Node child) {
		if(root == null) return null;
		if(root.left == child) return root;
		return findAdove(root.parent, root);
	}
	
	Node findBelow(Node root) {
		if(root.left == null) return root;
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















