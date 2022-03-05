package review_dataStructure_algorithm;

//주어진 트리가 이진검색트리인지를 확인하는 함수를 구현하시오
//기본적으로 이진검색트리는 현재노드를 기준으로 
//좌측 서브트리는 작은 값, 우측 서브트리는 큰 값을 가진다.
// inorder 순회는 순서가 L,root,R인데 순회 순서가 이진검색트리의 값의 순서와 일치한다.(아래 그림으로 확인)
//그러므로 inorder순회를 하면 BST를 값으로 정렬이된 상태로 배열에 담을 수 있다. 
//즉, 결과가 담긴 배열의 정렬 유무만 확인하면 된다.

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
	
	Tree03(int size){
		this.size = size;
		root = makeBST(0,size-1);
		//BST가 아닐때 false반환하는지 확인하기 위한 코드
//		root.right.right.right.left = new Node(9);this.size++;
//		root.right.right.right.left.left = new Node(9);this.size++;
//		root.right.right.right.left.right = new Node(9);this.size++;
//		root.right.right.right.left.left.left = new Node(8);this.size++;
//		root.right.right.right.left.left.right = new Node(9);this.size++;
	}
	Node makeBST(int start, int end) {
		if(start>end) return null;
		int mid = (start + end)/ 2;
		Node node = new Node(mid);
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		return node;
	}
	
	//BST가 맞는지 확인하여 boolean값을 반환하는 메소드
	boolean isValidateBST1() {
		int[] array = new int[size];
		inorder(root, array);//inorder 순회
		for(int i=1; i<array.length; i++) {//순회가 끝나면 배열이 완성됨
			if(array[i] < array[i-1]) {
				return false;
			}
		}
		return true;
	}
	
	int index = 0; //배열에 저장할 때 사용할 index
	void inorder(Node root, int[] array) {
		if(root != null	) {
			inorder(root.left, array);	//L
			array[index] = root.data;	//root
			index++;
			inorder(root.right, array);	//R
		}
	}
	
//=============================================================================
	//위 방식은 배열이 공간을 N만큼 추가로 사용한다. 그런데 어차피 data를 비교할 때 직전의 data와 비교하므로
	//비교할 data를 저장할 저장공간 1개만 만들어도 구현이 가능한다.
	
	//이전 노드의 값을 저장할 공간을 만드는데 정수객체에 주소를 넘길 수 있도록 class타입으로 선언
	//단순하게 생각해서 메소드 내부에서 동일한 값으로 사용하기 위함
	Integer last_printed = null; 
	boolean isValidateBST2() {
		return isValidateBST2(root); //인자가 없이 호출 되면 root를 기준으로 재귀호출
	}
	boolean isValidateBST2(Node n) { 
		if(n == null) return true; //마지막 노드를 지나면 true를 반환함 
		if(!isValidateBST2(n.left)) return false;//여기서 정렬에 문제 유무에 따라 if문이 작동됨
		if(last_printed != null && n.data < last_printed) {//정렬 유무를 확인
			return false;
		}
		last_printed = n.data;//정렬 상태에 문제가 없으면 비교대상을 현재 노드로 변경함
		if(!isValidateBST2(n.right)) return false;
		return true;
	}
	
//========================================================================================
	//다른 관점으로 접근한 문제해결
	//root에서 내려가면서 노드가 가질 수 있는 값의 영역을 제안한다. root에서 좌측으로 내려가면
	//좌측 서브트리의 노드들은 root.data 보다 작아야한다. 그렇게 도착한 노드(N)에서 
	//좌측으로 내려가면 N.data 보다 작아야하며 (부모보다 작아야함) 
	//우측으로 내려가면 root.data보다는 작고 N.data보다는 커야한다.(부모보단 크고 root노드보단 작아야함)
	
	//좌측으로 내려가면 Maximum 조건을 변경하고
	//우측으로 내려가면 Minimum 조건을 변경해야한다.(현재 노드값으로 변경)
	
	//그러므로 노드를 호출하며 이동하다가 조건에 벗어나는 노드를 발견하면 false를 반환한다.
	
	boolean isValidateBST3() {
		return isValidateBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	boolean isValidateBST3(Node n, int min, int max) {
		if(n==null) {
			return true;
		}
		if(n.data < min || n.data > max) {
			return false;
		}
			//좌측으로 가면 max 변경					//우측으로 가면 min 변경
		if(!isValidateBST3(n.left, min, n.data) || !isValidateBST3(n.right, n.data, max)) {
			return false;
		}
		return true;
	}
	
}

public class BSTree03 {
	public static void main(String[] args) {
		Tree03 t = new Tree03(10);
		System.out.println("Solution 1 - using inorder : " + t.isValidateBST1());
		System.out.println("Solution 2 - without array : " + t.isValidateBST2());
		System.out.println("Solution 3 - min/max : " + t.isValidateBST3());
		
		//이 문제에서는 BST에 중복값에 대한 제한이 없으므로 중복값 이여도 정렬만 잘 되어있다면 true로 나온다.
		//그러나 대부분의 BST에서는 중복허용을 안하므로 문제를 풀기이전에 잘 확인하여야한다.
	}
}




































