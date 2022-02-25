package practice;

import java.util.LinkedList;
import java.util.Stack;

//Depth-First Search(DFS)
//Breadth-First Search(BFS)

//깊이우선탐색(DFS) -> Stack 구현
//너비우선탐색(BFS) -> Queue 구현
//DFS - Recursion(재귀를 사용하여 DFS 구현)

class Graph1{
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		
		public Node(int data) {
			this.data = data;
			adjacent = new LinkedList<Node>();
			marked = false;
		}
	}
	
	Node[] nodes;
	
	public Graph1(int size) {
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
	
	void dfs() {
		dfs(0);
	}
	
	void dfs(int index){
		Stack<Node> stack = new Stack<Node>();
		Node root = nodes[index];
		
		root.marked = true;
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node r = stack.pop();
			for(Node i : r.adjacent) {
				if(!i.marked) {
					i.marked = true;
					stack.push(i);
				}
			}
			visit(r);
		}
	}
	
	void bfs() {
		bfs(0);
	}
	
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new Queue<Node>();
		
		root.marked = true;
		queue.enqueue(root);
		
		while(!queue.isEmpty()) {
			Node r = queue.dequeue();
			for(Node i : r.adjacent) {
				if(!i.marked) {
					i.marked = true;
					queue.enqueue(i);
				}
			}
			visit(r);
		}
	}
	
	void dfsR(Node r) {
		if(r==null) return;
		r.marked = true;
		visit(r);
		for(Node i : r.adjacent) {
			if(!i.marked) {
				dfsR(i);
			}
		}
	}
	
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	
	void dfsR() {
		dfsR(0);
	}


	
	void visit(Node r) {
		System.out.print(r.data + " ");
	}
}

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
		g.dfsR();
//		g.dfs(3);
//		g.bfs(3);
//		g.dfsR(3);
	}
}

































