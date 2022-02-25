package dataStructure_algorithm;

//연결 자료구조 방식으로 이진 탐색 트리를 구현하고 연산하는 프로그램

class TreeNode1{	//이진트리 노드
	char data;
	TreeNode1 left;
	TreeNode1 right;
}

//이진 탐색 트리(BST)는 다음과 같은 특징이 있다.
//모든 원소는 서로 다른 유일한 키를 갖는다.
//왼쪽 서브 트리에 있는 원소의 키는 루트 키보다 작다
//오른쪽 서브 트리에 잇는 원소의 키는 루트 키보다 크다.
//각각의 서브 트리도 이진 탐색트리의 특징을 갖는다.

class BinarySearchTree{
	//root노드를 생성한다. 최초의 노드는 root에 저장되어 시작지점과 비교대상이 됨
	//이후에 추가되는 node는 root에 트리형식으로 연결될 것이다.
	private TreeNode1 root = new TreeNode1();
		
	
	public TreeNode1 insertKey(TreeNode1 root, char x) {//삽입을 담당하는 메소드
		TreeNode1 p = root;	//현재 위치의 부모노드를 알려줄 참조변수p (p는 새 노드의 자리를 찾기위해 사용됨)
		TreeNode1 newNode = new TreeNode1();	//새 노드 생성
		newNode.data = x;
		newNode.left = null;	//새로 생성한 노드의 좌/우에 null로 초기화
		newNode.right = null;
		
		if(p == null) {	//p가 null을 가지고 있다는건 현재 트리의 가장 마지막 level 의 노드라는 것이므로(*최초 노드도 포함*)
			return newNode;//newNode를 반환한다. (여기서 반환되면 data에 x값을 갖고 좌/우가 가리키는 참조값이 null인 노드가 된다.)
		}else if(newNode.data < p.data){//newNode의 data가 기존 노드보다 작으면 트리의 좌측으로 가야한다
			p.left = insertKey(p.left, x);//기존 노드의 좌측을 타고 내려가며 [반복]된다.
			return p;	//반환되면 다시 값을 비교하는 과정이 반복됨
		}else if(newNode.data > p.data){//크면 우측으로 가야한다.
			p.right = insertKey(p.right, x);
			return p;
		}else {			//같으면 BST의 특징인 유일한 키가 아니게되므로 **추가하지 않고 기존 트리를 반환**
			return p;
		}
	}
	
	
	// insertBST()메소드는 들어오는 data값을 root노드와(트리의 시작지점이며) 함께 insertKey()로 넘겨주고 반환된 값을 root에 저장한다.
	//여기서 반환되는 값은 insertKey()의 조건문을 거쳐서 노드가 추가되거나 그대로 반환될 것이다.
	//기존 root의 트리에 저장된 값들은 유지된 상태로 하나의 노드의 추가 유/무를 정하는것이다.
	public void insertBST(char x) {
		root = insertKey(root, x);
	}
	
	
	public TreeNode1 searchBST(char x) {//탐색기능
		TreeNode1 p = root;
		while(p != null) {	
			if(x < p.data) { 
				p = p.left;
			}else if(x > p.data) {
				p = p.right;
			}else {
				return p;	//검색할 값과 트리에 저장된 data를 비교하여 찾아내면 반환하고
			}
		}
		return p;	//없으면 위의 반복문 때문에 null이 반환된다.(트리의 가장 마지막 level의 node들은 좌/우에 null이 있다.)
	}
	
	public void inorder(TreeNode1 root) {//중위순회(LDR)
		if(root != null) {
			inorder(root.left);
			System.out.printf(" %c", root.data);
			inorder(root.right);
		}
	}
	
	public void printBST() {
		inorder(root);
		System.out.println();
	}
}

public class BinarySearchTree_Linked {
	public static void main(String[] args) {
		BinarySearchTree bsT = new BinarySearchTree();
		bsT.insertBST('G');
		bsT.insertBST('I');
		bsT.insertBST('H');
		bsT.insertBST('D');
		bsT.insertBST('B');
		bsT.insertBST('M');
		bsT.insertBST('N');
		bsT.insertBST('A');
		bsT.insertBST('J');
		bsT.insertBST('E');
		bsT.insertBST('Q');
		
		System.out.print("Binaty Tree >> ");
		bsT.printBST();
		
		System.out.print("Is There \"A\" ? >> ");
		TreeNode1 p1 = bsT.searchBST('A');
		if(p1 != null) {
			System.out.printf("Searching Success! Searched key : %c \n", p1.data);
		}else {
			System.out.printf("Searching fail!! There is no %c\n", p1.data);
		}
		
		System.out.print("Is There \"Z\" ? >> ");
		TreeNode1 p2 = bsT.searchBST('Z');
		if(p2 != null) {
			System.out.printf("Searching Success! Searched key : %c \n", p2.data);
		}else {
			System.out.println("Searching fail!!");
		}
	}
}
































