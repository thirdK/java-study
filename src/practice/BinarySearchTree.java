package practice;
//정렬된 배열을 가지고 이진탐색트리를 구현한다.

class Tree1 {
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node root;
	
	void makeTree(int[] a) {
		root = makeTreeR(a,0,a.length-1);
	}
	
	Node makeTreeR(int[] a, int start, int end) {
		if(start > end) return null;
		int mid = (start+end)/2;
		Node n = new Node(a[mid]);
		
		n.left = makeTreeR(a, start, mid-1);
		n.right = makeTreeR(a, mid+1, end);
		
		return n;
	}
	
	void searchBTree(Node root, int find) {
		
		if(find < root.data) {
			System.out.println("Data is smaller than " + root.data);
			searchBTree(root.left, find);
		}else if(find > root.data) {
			System.out.println("Data is bigger than " + root.data);
			searchBTree(root.right, find);
		}else {
			System.out.println("Data found!");
		}
	}
	
}

public class BinarySearchTree {
	public static void main(String[] args) {
		int[] a = new int[10];
		for(int i=0; i<a.length; i++) {
			a[i] = i;
		}
		
		Tree1 t = new Tree1();
		t.makeTree(a);
		t.searchBTree(t.root, 2);
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