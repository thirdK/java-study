package practice;
//주어진 트리가 이진검색트리인지를 확인하는 함수를 구현하시오

class Tree03{
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node root;
	int size;
	
	public Tree03(int size) {
		root = makeBST(0, size-1);
		this.size = size;
	}
	
	Node makeBST(int start, int end) {
		if(start > end) return null;
		int mid = (start+end) / 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		return node;
	}
	
	boolean isValidateBST1() {
		int[] arr = new int[size];
		inorder(root, arr);
		for(int i=1; i<arr.length; i++) {
			if(arr[i] < arr[i-1]) {
				return false;
			}
		}
		return true;
	}
	
	int index;
	void inorder(Node root, int[] arr) {
		if(root != null	) {
			inorder(root.left, arr);
			arr[index] = root.data;
			index++;
			inorder(root.right, arr);
		}
	}
	Integer last;
	boolean isValidateBST2() {
		return isValidateBST2(root);
	}
	boolean isValidateBST2(Node n) {
		if(n==null) return true;
		if(!isValidateBST2(n.left)) return false;
		if(last != null && last > n.data) return false;
		last = n.data;
		if(!isValidateBST2(n.right)) return false;
		return true;
	}
	
	boolean isValidateBST3() {
		return isValidateBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	boolean isValidateBST3(Node n, int min, int max) {
		if(n==null) return true;
		if(n.data > max || n.data <min) return false;
		if(!isValidateBST3(n.left,min,n.data) || !isValidateBST3(n.right, n.data, max)) return false;
		return true;
	}
	
		
	
}

public class BSTree03 {
	public static void main(String[] args) {
		Tree03 t = new Tree03(10);
		System.out.println("Solution 1 - using inorder : " + t.isValidateBST1());
		System.out.println("Solution 2 - without array : " + t.isValidateBST2());
		System.out.println("Solution 3 - min/max : " + t.isValidateBST3());
	}
}












































