package review_dataStructure_algorithm;

import java.util.LinkedList;

//Depth-First Search(DFS)
//Breadth-First Search(BFS)

//깊이우선탐색(DFS) -> Stack 구현
//너비우선탐색(BFS) -> Queue 구현
//DFS - Recursion(재귀를 사용하여 DFS 구현)


//Queue, Stack은 이전에 만들어둔 클래스를 사용함
class Graph1 {
	
	class Node{
		int data;		//노드 클래스 만드는데 data는 정수형으로 간단히
		LinkedList<Node> adjacent;	//인접노드는 LinkedList로 표현
		boolean marked;	//방문여부를 마킹할 marked
		
		//생성자는 데이터 받고 marked는 false로 초기화 LinkedList 준비
		Node(int data){
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}
	
	Node[] nodes;	//그래프는 노드들을 저장할 배열이 필요함
	
	//간단한 구현을 위해 그래프의 노드 개수는 고정함
	Graph1(int size){
		nodes = new Node[size];		//노드 개수를 받아서 그 수만큼 배열을 생성
		for (int i=0; i<size; i++) {//편의를 위해 데이터와 배열방 번호를 동일하게 만듬
			nodes[i] = new Node(i);//생성자를 통해 배열의 i번째 방에 i data를 가진 노드들이 할당됨
		}
	}
	
	//두 노드의 관계를 저장하는 메소드
	void addEdge(int i1, int i2) {
		//data와 index가 동일하므로 아래와 같이 사용가능
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		//두 노드의 인접노드에 서로가 존재하는지 알아보고 없으면 서로를 추가함
		if(!n1.adjacent.contains(n2)) {//contains()는 LinkedList의 메소드이며 값의 유무를 boolean타입으로 반환함
			n1.adjacent.add(n2);		//add()는 추가
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	void dfs() { //dfs()메소드를 그냥 호출하면 0번부터
		dfs(0);
	}
	void dfs(int index) {//시작 index를 받으면 실행할 메소드
		Node root = nodes[index];	//해당 인덱스의 노드를 root로 가져오고
		Stack<Node> stack = new Stack<Node>(); //stack 생성
		stack.push(root);		//현재노드 stack에 추가
		root.marked = true;		//stack에 추가여부를 표시
		while(!stack.isEmpty()) {	//stack이 공백이 될때까지 반복
			Node r = stack.pop();	//stack에서 노드하나를 가져옴
			for(Node n : r.adjacent) {	//가져온 노드의 인접노드들 중
				if (n.marked == false) {//stack에 추가된적이 없는 노드들만
					n.marked = true;	//스택에 추가하면서 marked로 표시
					stack.push(n);
				}
			}
			visit(r);//출력
		}
	}
	void bfs() {//bfs() 메소드가 인자 없이 호출되면 0부터
		bfs(0);
	}
	void bfs(int index) {//시작 index를 받으면 실행할 메소드
		Node root = nodes[index]; //해당 인덱스의 노드를 root로 가져옴
		Queue<Node> queue = new Queue<Node>();//Queue 생성
		queue.enqueue(root);//큐에 추가
		root.marked = true;//추가 여부 마킹
		while(!queue.isEmpty()) {//큐가 공백이 될 때까지 반복
			Node r = queue.dequeue();	//큐에서 노드 하나를 꺼내옴
			for (Node n : r.adjacent) {//노드의 인접노드들 중
				if(n.marked == false) {//큐에 들어간적이 없으면
					n.marked = true;	//마킹하고
					queue.enqueue(n);	//큐에 추가
				}
			}
			visit(r); //출력
		}
	}
	
	void dfsR(Node r) { //재귀호출을 이용한 dfs (주소를 가지고있는 Node 객체를 받아야함)
		if (r == null) return; //받은 노드가 null이면 그냥 나감
		r.marked = true;	//노드에 마킹
		visit(r);	//재귀호출은 출력먼저
		for (Node n : r.adjacent) { //인접노드들 중
			if(n.marked == false) {//호출이 안됐던 노드들만
				dfsR(n);	//호출을함
			}
		}
	}
	
	void dfsR(int index) { //시작노드를 다양하게 테스트하기 위해 시작 index를 받아서
		Node r = nodes[index];//해당 index에 해당하는 노드를
		dfsR(r);//재귀호출 메소드로 인자로 넘겨주어 재귀 실행
	}
	
	void dfsR() {//넘겨받은 인자가 없으면 0번 index부터
		dfsR(0);
	}
	
	void visit(Node n) {//방문시 출력하기위해 만든 메소드
		System.out.print(n.data + " ");
	}
	
}

/*
---------------------
	0
   /
  1---3    7
  |  /| \ /
  | / |  5
  2---4   \
           6--8
---------------------
*/
public class DFS_BFS {
	public static void main(String[] args) {
		Graph1 g = new Graph1(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
//		g.dfs();
//		g.bfs();
//		g.dfsR();
//		g.dfs(3);
//		g.bfs(3);
		g.dfsR(3);
	}
}





















