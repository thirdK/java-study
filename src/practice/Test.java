package practice;

import java.util.LinkedList;
import java.util.Stack;

class Graph2 { 
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
	
	public Graph2(int size) {
		nodes = new Node[size];
		for(int i=0; i<size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	public void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n2);
		}
	}
	
	public void dfs(int index) {
		Stack<Node> stack = new Stack<Node>();
		Node r = nodes[index];
		r.marked = true;
		stack.push(r);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			for(Node n : node.adjacent) {
				n.marked = true;
				stack.push(n);
			}
			visit(node);
		}
	}
	
	public void dfs() {
		dfs(0);
	}
	
	public void bfs(int index) {
		Queue<Node> queue = new Queue<Node>();
		Node r = nodes[index];
		
		r.marked = true;
		queue.enqueue(r);
		
		while(!queue.isEmpty()) {
			Node node = queue.dequeue();
			for(Node n : node.adjacent) {
				n.marked = true;
				queue.enqueue(n);
			}
			visit(node);
		}
	}
	
	public void bfs() {
		bfs(0);
	}
	
	public void dfsR(Node r) {
		if(r==null) return;
		
		r.marked = true;
		visit(r);
		
		for(Node n : r.adjacent) {
			if(!n.marked) {
				n.marked = true;
				dfsR(n);
			}
		}
	}
	
	public void dfsR(int index) {
		dfsR(nodes[index]);
	}
	
	public void dfsR() {
		dfsR(0);
	}
	
	void visit(Node node){
		System.out.print(node.data);
	}
	
	
}



public class Test {
	public static void main(String[] args) {
		Graph2 g = new Graph2(9);
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



















