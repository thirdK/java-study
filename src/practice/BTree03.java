package practice;
class NodeT3<T>{
	T data;
	NodeT3<T> left;
	NodeT3<T> right;
	
	NodeT3() {}
	NodeT3(T data){
		this.data = data;
	}
}
class TreeT3<T>{
	
	NodeT3<T> root;
	
	public NodeT3<T> getRoot() {
		return root;
	}
	public void setRoot(NodeT3<T> root) {
		this.root = root;
	}

	NodeT3<T> makeNode(NodeT3<T> left, T data, NodeT3<T> right) {
		NodeT3<T> node = new NodeT3<T>(data);
		node.left = left;
		node.right = right;
		return node;
	}
	
	void preorder(NodeT3<T> node) { //root -> l -> r
		if(node == null) return;
		System.out.println(node.data);
		preorder(node.left);
		preorder(node.right);
	}
	
	void inorder(NodeT3<T> node) { //l -> root -> r
		if(node == null) return;
		inorder(node.left);
		System.out.println(node.data);
		inorder(node.right);
	}
	
	void postorder(NodeT3<T> node) {//l -> r -> root
		if(node == null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.data);
	}
	
	
}
public class BTree03 {
	public static void main(String[] args) {
		TreeT3<Integer> t = new TreeT3<>();
		NodeT3<Integer> n4 = t.makeNode(null, 4, null);
		NodeT3<Integer> n5 = t.makeNode(null, 5, null);
		NodeT3<Integer> n2 = t.makeNode(n4, 2, n5);
		NodeT3<Integer> n3 = t.makeNode(null, 3, null);
		NodeT3<Integer> n1 = t.makeNode(n2, 1, n3);
		
		t.setRoot(n1);
		
		t.preorder(t.getRoot());
		System.out.println();
		t.inorder(t.getRoot());
		System.out.println();
		t.postorder(t.getRoot());
		
		
	}
}


































