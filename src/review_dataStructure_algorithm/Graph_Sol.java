package review_dataStructure_algorithm;

import java.util.LinkedList;

//Graph에서 두개의 노드가 서로 찾아 갈수있는 
//경로가 있는지 확인하는 함수를 구현하시오

class Graph {
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		
		public Node(int data) {
			this.data = data;
			adjacent = new LinkedList<>();
			this.marked = false;
		}
	}
	Node[] nodes;
	
	Graph(int size) {
		nodes = new Node[size];
		for(int i=0; i<size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	void initMarks() { //marked 를 전부 false로 초기화하는 메소드(생성자를 통해 false를 했지만 확실히 하기위해)
		for(Node n : nodes) {
			n.marked = false;
		}
	}
	
	boolean search(int i1, int i2) { //배열방번호로 호출하면 노드로 변환해서 호출하는 메소드
		return search(nodes[i1], nodes[i2]);
	}
	
	//두 개의 노드를 start, end로 받아 연결 유무를 boolean타입으로 반환하는 메소드
	//bfs로 구현함(구조에따라 dfs,bfs중 선택을 하게됨)
	//bfs는 Queue를 사용하는데 LinkedList에서 제공하는 메소드를 이용하여 Queue처럼 사용함
	boolean search(Node start, Node end) {
		initMarks();//전부 flag를 false로 초기화해줌
		LinkedList<Node> q = new LinkedList<>(); //Queue에 사용할 LinkedList를 만들고
		q.add(start);//시작노드를 q에 추가
		while(!q.isEmpty()) {
			Node root = q.removeFirst();//q에서 데터를 1개 꺼냄(dequeue)
			if(root == end) {//꺼낸 노드가 end노드인지 확인함
				return true;//end노드면 true반환
			}
			for(Node n : root.adjacent) {//인접노드를 탐색하여
				if(n.marked == false) {//마킹안됐으면 접근
					n.marked = true;//노드 마킹하고
					q.add(n);	//Queue에 추가
				}
			}
		}
		return false; //마지막까지 못찾으면 false반환
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

public class Graph_Sol {
	public static void main(String[] args) {
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
//		g.addEdge(1, 3);
//		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		System.out.println(g.search(1, 8));
	}
}




























