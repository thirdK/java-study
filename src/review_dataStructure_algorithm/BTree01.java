package review_dataStructure_algorithm;

/*
		1
	  ↙   ↘
	2		3
  ↙   ↘
4		5

이진트리에서 가장 마지막 level의 자식노드는 leaf라고도 불린다.

Inorder (Left, Root, Right): 4 2 5 1 3
Preorder (Root, Left, Right): 1 2 4 5 3
Postorder (Left, Right, Root): 4 5 2 3 1

*/

//이진트리의 노드는 좌, 우  두개의 link필드가 필요함
class NodeT {  
	int data;
	NodeT left;
	NodeT right;
}
//트리 클래스
class Tree{
	//root 생성
	public NodeT root; 
	//root의 getter와 setter 생성
	public NodeT getRoot() {
		return root;
	}

	public void setRoot(NodeT root) {
		this.root = root;
	}
	//노드 생성 메소드
	public NodeT makeNode(NodeT left, int data, NodeT right) {
		NodeT node = new NodeT();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	
	public void inorder(NodeT node) {
		if(node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
	}
	
	public void preorder(NodeT node) {
		if(node != null) {
			System.out.println(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public void postorder(NodeT node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);
		}
	}
}


public class BTree01 {
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
