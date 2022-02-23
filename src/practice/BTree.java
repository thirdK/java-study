package practice;

class NodeT{
	int data;
	NodeT left;
	NodeT right;
}

class Tree{
	NodeT root;

	public NodeT getRoot() {
		return root;
	}

	public void setRoot(NodeT root) {
		this.root = root;
	}
	
	NodeT makeNode(NodeT left, int data, NodeT right) {
		NodeT n = new NodeT();
		n.left = left;
		n.data = data;
		n.right = right;
		
		return n;
	}
	
	void inorder(NodeT n) {
		if(n!=null) {
			inorder(n.left);
			System.out.println(n.data);
			inorder(n.right);
		}
	}
	
	void preorder(NodeT n) {
		if(n!=null) {
			System.out.println(n.data);
			preorder(n.left);
			preorder(n.right);
		}
	}
	
	void postorder(NodeT n) {
		if(n!=null) {
			postorder(n.left);
			postorder(n.right);
			System.out.println(n.data);
		}
	}
}


public class BTree {
	public static void main(String[] args) {
		Tree t = new Tree();
		NodeT n4 = t.makeNode(null, 4, null);
		NodeT n5 = t.makeNode(null, 5, null);
		NodeT n2 = t.makeNode(n4, 2, n5);
		NodeT n3 = t.makeNode(null, 3, null);
		NodeT n1 = t.makeNode(n2, 1, n3);
		
		t.setRoot(n1);
		t.inorder(t.getRoot());
		System.out.println();
		t.preorder(t.getRoot());
		System.out.println();
		t.postorder(t.getRoot());
	}

}
