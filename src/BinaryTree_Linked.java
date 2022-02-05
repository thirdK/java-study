

//연결 자료형식의 이진트리를 순회하는 프로그램

class TreeNode{		//연결 자료구조 이진트리는 노드의 좌/우 양쪽에 참조값을 저장할 공간이 필요하다.
	Object data;
	TreeNode left;
	TreeNode right;
}

class LinkedTree {
	private TreeNode root;
	
	//노드를 만드는 makeBT메소드
	public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2) {
		TreeNode root = new TreeNode();
		root.data = data;
		root.left = bt1;	//좌측 참조값
		root.right = bt2;	//우측 참조값
		return root;	//매개변수로 받아온 값들을 저장한 root 반환
	}
	
	//현재 노드 n을 방문 : D
	//현재 노드 n의 왼쪽 서브트리로 이동 : L
	//현재 노드 n의 오른쪽 서비트리로 이동 : R
	
	
	public void preorder(TreeNode root) {	//전위순회(DLR)
		if(root != null) {
			System.out.printf("%c", root.data);//D
			preorder(root.left);//L
			preorder(root.right);//R
		}
	}
	
	public void inorder(TreeNode root) {	//중위순회(LDR)
		if(root != null) {
			inorder(root.left);//L
			System.out.printf("%c", root.data);//D
			inorder(root.right);//R
		}
	}
	
	public void postorder(TreeNode root) {	//후위순회(LRD)
		if(root != null) {
			postorder(root.left);//L
			postorder(root.right);//R
			System.out.printf("%c", root.data);//D
		}
	}
	
}

public class BinaryTree_Linked {
	public static void main(String[] args) {
		LinkedTree T = new LinkedTree();
		
//lv0				n1(-)
//lv1		n2(*)			n3(/)
//lv2	n4(A)	n5(B)	n6(C)	n7(D)
		
		
		//가장 아래위치하는 level2 는 더이상 자식노드가 없으므로 참조값은 양쪽 모두 null
		TreeNode n7 = T.makeBT(null, 'D', null);
		TreeNode n6 = T.makeBT(null, 'C', null);
		TreeNode n5 = T.makeBT(null, 'B', null);
		TreeNode n4 = T.makeBT(null, 'A', null);
		
		//level1 은 자식노드가 존재하므로 참조값을 넘겨준다.
		TreeNode n3 = T.makeBT(n6, '/', n7);
		TreeNode n2 = T.makeBT(n4, '*', n5);
		
		//level0 도 자식노드의 참조값을 넘겨준다.
		TreeNode n1 = T.makeBT(n2, '-', n3);
		
		System.out.print("Preorder : ");//전위식이 출력됨
		T.preorder(n1);
		
		System.out.print("\ninorder : ");//중위식이 출력됨
		T.inorder(n1);
		
		System.out.print("\nPostorder : ");//후위식이 출력됨
		T.postorder(n1);
	}
}


















