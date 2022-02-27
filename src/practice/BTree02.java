package practice;
//주어진 이진트리의 Balance가 맞는지 확인하는 함수를 구현하시오
//여기서 Balance가 맞다는 의미는 어떤 부모노드의 양쪽 서브트리의 길이가 2이상
//차이나지 않는것을 뜻함 
//즉, 부모노드에서 자식노드까지의 길이차이가 1개까지는 허용됨


//우선 노드들을 돌면서 자식노드들을 재귀호출한다. 그리고 서브트리의 길이를 측정하는 함수를 만들어서 결과값을 받아온다.
//결과값을 가지고 양쪽 서브트리의 길이를 비교한다. 차이가 2이상 나면 false를 반환하면 된다.

class Tree2{
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		}
	}
	
	Node root;
	
	public Tree2(int size) {
		// TODO Auto-generated constructor stub
		root = makeBST(0,size-1);
	}
	
	Node makeBST(int start, int end) {
		if(start > end) return null;
		
		int mid = (start+end) / 2;
		Node node = new Node(mid);
		
		node.left = makeBST(start, mid - 1);
		node.right = makeBST(mid+1, end);
		
		return node;
	}
	
	boolean isBalanced(Node root) {
		if(root == null) return true;
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1) {
			return false;
		}else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	int getHeight(Node root) {
		if(root == null) return -1;
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	int checkHeight(Node root) {
		if(root == null) return -1;
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		int heightDiff = leftHeight - rightHeight;
		
		if(Math.abs(heightDiff)>1) {
			return Integer.MIN_VALUE;
		}else {
			return Math.max(leftHeight, rightHeight)+1;
		}
	}
	
	boolean isBalanced2(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	
	class Level{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
	}
	
	boolean isBalanced3(Node root){
		Level obj = new Level();
		checkBalanced(root, obj, 0);
		if(Math.abs(obj.min - obj.max)>1) return false;
		else return true;
	}
	
	void checkBalanced(Node node, Level obj, int level) {
		if(node == null) {
			if(level < obj.min) obj.min = level;
			else if(level > obj.max) obj.max = level;
			return;
		}
		checkBalanced(node.left, obj, level+1);
		checkBalanced(node.right, obj, level+1);
	}
	
}

public class BTree02 {
	public static void main(String[] args) {
		Tree2 t = new Tree2(10);
		System.out.println(t.isBalanced3(t.root));
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
	
}
































