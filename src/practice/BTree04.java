package practice;

//주어진 이진트리의 Balance가 맞는지 확인하는 함수를 구현하시오
//여기서 Balance가 맞다는 의미는 어떤 부모노드의 양쪽 서브트리의 길이가 2이상
//차이나지 않는것을 뜻함 

class Tree05{
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node root;
	
	public Tree05(int size) {
		root = makeBST(0, size-1);
	}
	
	Node makeBST(int start, int end){
		int mid = (start + end) / 2;
		Node node = new Node(mid);
		
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		return node;
	}
	
	boolean isBalanced(Node root) {
		if(root == null) return true;
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1) return false;
		else return isBalanced(root.left) && isBalanced(root.right);
	}
	
	int getHeight(Node root) {
		if(root == null) return -1;
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	//위의 풀이는 O(N logN)의 시간복잡도
	
//====================================================================================
	//노드를 돌면서 동시에 길이를 구하는 방식
	
	int checkHeight(Node root) {
		if(root == null) return -1;
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE;
		}else {
			return Math.max(leftHeight, rightHeight)+1;
		}
		
	}
	
	boolean isBalanced2(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
}

public class BTree04 {

	
	
	
	
	
	
	
}
























