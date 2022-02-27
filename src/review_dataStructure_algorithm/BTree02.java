package review_dataStructure_algorithm;

//주어진 이진트리의 Balance가 맞는지 확인하는 함수를 구현하시오
//여기서 Balance가 맞다는 의미는 어떤 부모노드의 양쪽 서브트리의 길이가 2이상
//차이나지 않는것을 뜻함 
//즉, 부모노드에서 자식노드까지의 길이차이가 1개까지는 허용됨

//우선 노드들을 돌면서 자식노드들을 재귀호출한다. 그리고 서브트리의 길이를 측정하는 함수를 만들어서 결과값을 받아온다.
//결과값을 가지고 양쪽 서브트리의 길이를 비교한다. 차이가 2이상 나면 false를 반환하면 된다.

class Tree02 {
	class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node root;
	public Tree02(int size) {
		// TODO Auto-generated constructor stub
		root = makeBST(0, size-1);
		root.right.right.right.right = new Node(10);
		root.right.right.left = new Node(11);
	}
	Node makeBST(int start, int end) {
		if(start > end) return null;
		int mid = (start+end) / 2;
		Node node = new Node(mid);
		
		node.left = makeBST(start, mid-1);
		node.right = makeBST(mid+1, end);
		
		return node;
	}
	
	//Balanced() 밸런스가 맞는지 확인할 메소드 
	boolean isBalanced(Node root) {		//(노드 주소를 받음)
		if(root == null) return true;	//마지막 노드를 지나면 더 이상 진행하지 않음
		int hightDiff = getHeight(root.left) - getHeight(root.right); //양쪽 서브트리의 차이를 구함
		if(Math.abs(hightDiff) > 1) { //차이가 1을 초과하면 (abs()는 절대값을 반환)
			return false;	//false 반환
		}else {	//그렇지 않으면 &&연산자를 통해 둘다 밸런스가 맞는 경우에만 true를 반환
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	//노드를 받으면 그 노드를 root로 이하 서브트리의 가장 긴 줄기의 level이 몇인지를 알아오는 메소드
	int getHeight(Node root) {		//(노드 주소를 받음)
		if(root == null)return -1;	//트리의 마지막 노드를 지나면 -1 반환
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		// 좌/우의 자식노드들을 반복적으로 호출하면서 둘 중에 더 긴 줄기를 선택하여 1을 더하고 반환
		// 반환할 때 1을 더하므로 함수가 끝날 때마다 1씩 증가하며 길이를 세어 나간다.
	}
	
//=================================================================================================	
	
	//위 방식은 노드가 호출될 때마다 길이를 구하므로 O(N logN)의 시간이 걸린다.
	//그래서 노드를 돌면서 동시에 길이를 구하는 방법으로 구현을 한다.
	//마찬가지로 함수에서 돌아올때 +1하여 길이를 가져오는데 만약 중간에 밸런스가 맞지않으면 false를 반환해야한다.
	//이미 정수형태로 길이를 반환하기 때문에 false를 반환할때 문제가 생긴다.
	//그래서 정수중 가장 작은 값인 -2147483648을 반환하면 false인 것으로 정하여 언밸런스를 표현한다.
	//이 방식이 좋은점은 노드를 한번씩만 방문하므로 O(N)의 시간 복잡도를 갖는다.
	
	
	int checkHeight(Node root) { //길이를 재는 메소드
		if (root == null) return -1;
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;//정수의 가장 작은값을 false로 사용함
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int heightDiff = leftHeight - rightHeight;
		if(Math.abs(heightDiff) > 1) { //차이가 2이상나면
			return Integer.MIN_VALUE; //false를 반환함
		}else {
			return Math.max(leftHeight, rightHeight)+1; //아니면 둘중 큰 수(깊은곳)에 1을 더하며 반환
		}
	}
	
	boolean isBalanced2(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE; //false(가장 작은 정수)가 아니면 true를 반환
	}

//	==================================================================================================
//	위의 2가지 방식은 서브트리의 가장 긴 노드들을 비교하여 밸런스 여부를 따졌지만 
//	(긴 노드들만 비교하면 트리 생성자에 10, 11 두 개를 같이 추가했을 때 밸런스는 깨지지 않는다. -> 하단의 그림 참고)
//	이번에는 밸런스를 재정의하여 모든 노드들의 차이가 2이상 나면 안된다라고 해보자 (가장 긴 노드와 가장 짧은 노드의 차이가 2이상 안됨)
	
//	즉, 가장 긴 줄기만 비교하는것이 아닌 그 어떤 서브트리도 2이상의 차이가 나면 안된다는 더 엄격한 기준으로 구현
//	그러면 노드가 길이를 반환할때 [가장 긴 값]과 [가장 짧은 값]을 반환하면 된다. 그러나 자바는 2개의 data를 반환할 수 없으므로
//	Object를 사용한다. 처음 함수를 호출할 때 객체의 주소를 전달하여 호출한 함수의 결과를 반환하지 않고 객체에 저장을 한다.
//	나오면서 길이를 세는게 아니라 들어가면서 세고 각 서브트리의 마지막 노드에 도착했을 때 객체의 값을 업데이트 해준다.
	
	class Level{ //level정보를 저장할 클래스
		int min = Integer.MAX_VALUE;//어떤 값과 비교해도 작을 수 있도록 가장 큰 정수로 초기화
		int max = Integer.MIN_VALUE;//어떤 값과 비교해도 클 수 있도록 가장 작은 정수로 초기화
	}
	boolean isBalanced3(Node root) { //재귀함수를 호출해주는 함수
		Level obj = new Level(); //level 오브젝트 선언
		checkBalanced(root, obj, 0);//인자 (시작노드, 저장할 오브젝트, 0 레벨부터) 재귀 호출
		if(Math.abs(obj.min - obj.max)>1) return false; 
		//재귀가 끝나면 obj의 값이 업데이트 됐을 것임 [가장 긴 서브트리]와 [가장 짧은 서브트리]의 길이가 2이상이면 false반환
		else return true;
	}
	void checkBalanced(Node node, Level obj, int level) {//재귀함수
		if(node == null) {//가장 마지막 노드를 지나면
			//모든 서브트리의 끝에서 obj정보를 업데이트함 다른 예제와 다르게 노드줄기를 타고 내려가면서 level을 증가 시키기 때문에
			//중간에 업데이트할 필요가 없고 마지막에 업데이트 해주면 된다.
			if(level < obj.min) obj.min = level;
			else if (level > obj.max) obj.max = level;
			return;
		}
		checkBalanced(node.left, obj, level+1);
		checkBalanced(node.right, obj, level+1);
	}
	
	
}

public class BTree02 {
	public static void main(String[] args) {
		Tree02 t = new Tree02(10);
		System.out.println(t.isBalanced(t.root));
		System.out.println(t.isBalanced2(t.root));
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
		         \  \   /  \
		         (3)(6)(11)(9)
		                     \
		                     (10)
	----------------------------------------------
	*/
}



























