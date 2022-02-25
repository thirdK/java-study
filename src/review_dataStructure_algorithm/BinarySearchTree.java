package review_dataStructure_algorithm;

//정렬이 되어있고, 고유한 정수로만 이루어진 배열이 있다.
//이 배열로 이진검색트리를 구현하시오.
//정렬이 되어있기 때문에 배열을 반씩 잘라가면서 찾으면됨(Binary Search)

//중간점을 찾는다 -> 두 개로 나눈다. -> 중간점을 찾는다 -> 두 개로 나눈다.....
//하는 일이 반복되므로 같은 일을 처리하는 함수를 하나 만들고 재귀적으로 호출하면 좋을거 같음 
//함수에 필요한 정보는 
// - Array			Tree로 만들 배열이 필요함
// - start index	매번 처리해야하는 데이터의 그룹들이 달라지므로
// - end index		해당 그룹이 시작하는 인덱스, 끝나는 인덱스를 받아와 트리로 구현하는 범위를 함수에게 인자로 전달해줌

// 중간값을 찾는 방법은 시작과 끝의 평균 
// (start index + end index) / 2

class Tree1{
	class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node root;
	
	//배열 정보를 받아 트리를 만드는 일을 시작해주는 메소드
	//이 메소드는 재귀호출을 하기전에 재귀호출에 필요한 데이터를 처음으로 넘겨주는 역할을 함
	//그리고 재귀가 끝나면 가장 꼭대기의 root노드의 주소를 받아서 맴버 변수에 저장함
	public void makeTree(int[] a) { 
		root = makeTreeR(a, 0, a.length-1); //처음 탐색범위는 0부터 마지막 index까지
	}
	
	//재귀함수 선언
	public Node makeTreeR(int[] a, int start, int end) {
		
		//재귀반복을 하다가 start가 end보다 커지면 null을 반환
		//(재귀 종료 지점을 명확히하는건 재귀호출에서 가장 중요함)
		if(start > end) return null;
		
		int mid = (start+end)/2; //중간지점 계산
		Node node = new Node(a[mid]); //중간지점에 있는 값으로 노드 생성
		
		//여기서 재귀 호출
		node.left = makeTreeR(a, start, mid -1);//생성한 노드의 좌측 -> 시작지점 ~ 중간-1
		node.right = makeTreeR(a, mid+1, end);//생성한 노드의 우측 -> 중간+1 ~ 끝지점
		return node;//노드 반환
	}
	
	//트리가 잘 만들어졌는지 확인하기 위해 2진검색 메소드를 만듬
	public void searchBTree(Node n, int find) { //시작 노드와 찾을 데이터를 인자로 받음
		if(find < n.data) {
			System.out.println("Data is smaller than " + n.data); //진행 경로를 보기위해 출력
			searchBTree(n.left, find);//찾는 값이 작으니까 왼쪽 재귀호출
		}else if(find > n.data) {
			System.out.println("Data is bigger than " + n.data);
			searchBTree(n.right, find);
		}else {
			System.out.println("Data found!");
		}
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
























