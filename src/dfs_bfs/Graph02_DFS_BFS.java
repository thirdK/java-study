package dfs_bfs;

//DFS : 깊이우선탐색	BFS : 너비우선탐색


//DFS는 LIFO구조의 스택을 사용한다.
class StackNode {	//스택에 노드를 구현	
	int data;
	StackNode link;
}

class LinkedStack {	//LinkedStack을 구현(연결 자료구조 방식을 이용한 스택)
	StackNode top;	//Stack은 항상 마지막에 들어온 값을 가리키는 참조변수가 필요하다(top)
					//스택의 삽입과 삭제는 top을 통해 이루어진다.

	public boolean isEmpty() {
		return (top == null);	//스택의 초기상태(공백 스택)는 참조변수 top을 null로 설정한다.
	}

	public void push(int item) {	//stack에 노드를 삽입하는 push() 메소드
		StackNode newNode = new StackNode();	//새로운 노드 객체를 생성
		newNode.data = item;	//생성된 노드의 data필드에 매개변수로 받은 값을 저장
		newNode.link = top;		//생성된 노드의 link필드에 top이 가진 참조값을 저장
		top = newNode;			//top에 newNode의 주소를 저장
	}

	public int pop() {		//stack의 top이 가리키는(마지막에 삽입된) 노드를 반환하고 삭제하는 pop()메소드
		if (isEmpty()) {	//비어 있으면
			System.out.println("삭제 실패! Linked Stack이 비어있습니다.");
			return 0;
		} else {	//노드가 있으면
			int item = top.data;//top이 가리키는(마지막에 삽입된) 노드의 data필드에 
								//저장된 값을 item에 저장(반환을 해야하므로)
			top = top.link;		//top이 기존에 가진 참조값은 이제 삭제해야하므로 top이 가리키던 노드가 가진 참조값을 대입 
			return item;		//삭제하기전에 저장해둔 data 반환
		}
	}
}

//BFS는 FIFO구조의 큐를 사용한다.
class QNode {	//큐에 사용할 노드 구현
	int data;
	QNode link;
}

class LinkedQueue {	//LinkedQueue를 구현(연결 자료구조 방식의 큐)
	QNode front;
	QNode rear;

	public LinkedQueue() { 	//연결큐는 한쪽에서는 노드가 삽입되고 반대쪽에서는 노드가 삭제된다.
		front = null;		//front 참조변수는 삭제하는 방향
		rear = null;		//rear는 삽입하는 방향이며 공백상태를 표현하기 위해 둘다 null로 초기화한다.
	}						//front는 항상 가장먼저들어온 노드를 rear는 가장 나중에들어온 노드를 가리킨다.

	public boolean isEmpty() {
		return (front == null);	//front는 항상 가장 먼저 들어온 노드를 가리키는데
	}							//front가 null이면 큐는 공백상태이다.

	public void enQueue(int item) {	//큐에 노드를 삽입하는 enQueue()메소드
		QNode newNode = new QNode();//새 노드를 만들고
		newNode.data = item;	//새 노드의 data필드에 매개변수로 가져온 값을 저장
		newNode.link = null;	//link필드에는 null을 저장
		if (isEmpty()) {		//Queue가 비어있다면?
			front = newNode;	//지금 삽입되는 노드가 첫 노드이기 때문에 큐의 첫번째와 마지막 노드는
			rear = newNode;		//같은 노드이므로 font와 rear는 같은 노드를 가리킨다.(참조값 저장)
		} else {				//Queue에 다른 노드가 존재한다면?
			rear.link = newNode;//rear가 가리키는 노드의 link필드에 새 노드의 참조값을 대입(기존 노드와의 연결)
			rear = newNode;		//rear는 항상 마지막 노드의 참조값을 가져야하므로 새 노드의 주소값을 대입
		}
	}

	public int deQueue() {	//큐의 첫번째 노드의 data를 반환하고 삭제하는 deQueue()
		if (isEmpty()) {	//큐가 비어있다면?
			System.out.println("삭제 실패! Linked Queue가 비어있습니다.");
			return 0;
		} else {	//큐에 노드가 있다면?
			int item = front.data;	//반환하기위해 front가 가리키는 노드의 data를 item변수에 저장 
			front = front.link;		//front가 가진 참조값은 삭제되야하므로 삭제될 노드가 가진 참조값을 front에 대입 
			if (front == null) {	//만약 삭제후 front가 null이라면 이제 공백 큐이므로
				rear = null;		//rear도 null을 저장하여 공백 큐임을 표현한다.
			}
			return item;			//삭제한 노드의 data 반환
		}
	}
}

class GraphNode {	//그래프에서 사용할 노드 구현
	int vertex;		//정점
	GraphNode link;
}

class AdjList {		//인접리스트를 구현
	GraphNode head[] = new GraphNode[10];	//각 정점의 참조값을 저장할 배열(참조변수들이 모인 배열)
											//각 정점의 시작지점인 head들의 배열
	private int totalV = 0;	//총 정점의 수를 저장할 변수

	public void insertVertex(int v) {//정점의 삽입
		totalV++;	//정점이 삽입되므로 totalV는 증가한다.
	}

	public void insertEdge(int v1, int v2) {//매개변수로 받은 정점사이에 간선을 추가하는 메소드
		if (v1 >= totalV || v2 >= totalV) {//정점이 총 정점수보다 클수는 없음
			System.out.println("그래프에 없는 정점입니다!!");
		} else {//존재하는 정점이라면
			GraphNode gNode = new GraphNode();//새 노드를 생성
			gNode.vertex = v2;	//새 노드의 vertex필드에 v2정점값 추가
			gNode.link = head[v1];//새 노드의 link필드에 head[v1]이 가진 참조값을 대입
			head[v1] = gNode;	//head[v1]은 새 노드의 주소값을 대입
			//즉 insertEdge(args1,args2)메소드는 args1 헤드에 args2와 연결되는 간선을 추가한다.
		}
	}

	public void printAdjList() {
		GraphNode gNode = new GraphNode();
		for (int i = 0; i < totalV; i++) {
			System.out.printf("\n정점 %c의 인접리스트 ", i + 65); //대문자 알파벳으로 표현하기 위해 +65
			gNode = head[i];	//모든 정점의 시작지점 head가 가진 참조값을 gNode변수에 저장
			while (gNode != null) {//비어있지 않다면 반복 == 마지막까지 반복
				System.out.printf("-> %c", gNode.vertex + 65);
				gNode = gNode.link;//gNode가 가리키는 노드의 link필드에 저장된 참조값을 gNode에 저장 
			}					//즉, 반복을 거쳐서 모든 노드를 탐색하게됨
		}
	}

	public void DFS(int v) {	//DFS 깊이우선탐색 (매개변수로 탐색을 시작할 '시작 정점' v를 받는다.)
		GraphNode w = new GraphNode();	//w는 인접 정점을 나타내는데 사용할 객체
		LinkedStack S = new LinkedStack();//DFS는 LIFO구조의 Stack을 사용한다. 
		boolean visited[] = new boolean[10];
		//정점의 방문 여부를 표시하기 위한 visited배열
		//방문하지 않은 상태에 저장된 값은 전부 false이다.(배열은 초기값 설정안하면 자동 false)
		
		S.push(v);//시작 정점을 구현해놓은 Stack에 추가한다.
		
		visited[v] = true;	//시작 정점의 방문 여부는 true로 바뀐다.
		System.out.printf(" %c", v + 65);//대문자 알파벳으로 표현하기위해 +65
		while (S.top != null) {//S.top 즉, 스택의 top이 null이 아니면 반복(stack이 비어있지 않다면)
			w = head[v];	//w는 정점의 헤드가 가리키는 노드가 대입된다.즉 v와 연결된 다음 정점
			while (w != null) {//w가 null이 아니면 반복(마지막 노드가 가리키는 곳이 null이므로 마지막까지 반복됨)
				if (visited[w.vertex] == false) {//지금 w노드가 가진 정점을 방문 안했다면?
					S.push(w.vertex);	//stack에 정점 삽입하고
					visited[w.vertex] = true;	//visited배열에 해당 점점 방문 여부를 true
					System.out.printf(" %c", w.vertex + 65);//대문자 알파벳으로 출력하고
					v = w.vertex;	//v는 위에서 stack에 삽입된 정점으로 이동이되며
					w = head[v];	//해당 정점의 head를 통해 인접한 정점을 찾아 w에 대입
				} else {	//이미 방문한 정점이라면?
					w = w.link;	//w가 가리키는 노드를 w에 대입한다.
					//즉, 인접한 다른 정점을 체크한다.
					//null이 대입되면 바깥 while문으로 이동
				}
			}
			v = S.pop(); //스택에 마지막에 들어온 정점을 pop --> 값을 반환하고 삭제
			//v에는 마지막에 들어온 정점이 대입됨
			
			//이곳으로 빠져나온것은 인접한 노드가 전부 방문한 노드이기 때문이고
			//이상황에서는 stack에 마지막에 들어온 값을 pop해가면서(이전 정점으로 돌아가면서) 
			//아직 방문하지않은 다른 인접 정점을 찾아나가야한다. 왔던 길을 역순으로 나가면서 찾는다고 생각하면된다. 
			//결국 모든 정점을 방문한 마지막에는 Stack의 모든 data를 pop하여 공백스택이 된다.
		}
	}

	
	public void BFS(int v) {	//BFS 너비우선탐색 (매개변수로 탐색을 시작할 '시작 정점' v을 받는다.)
		GraphNode w = new GraphNode();	//인접 정점을 저장할 w
		LinkedQueue Q = new LinkedQueue();//BFS는 FIFO구조의 Queue를 사용한다.
		boolean visited[] = new boolean[10];//방문 여부를 표시할 visited배열
		visited[v] = true;	//시작 정점 방문표시
		System.out.printf(" %c", v + 65);//대문자 알파벳으로 출력함
		Q.enQueue(v);	//시작 정점 Queue에 삽입
		while (!Q.isEmpty()) {	//공백 큐가 아니라면
			v = Q.deQueue();	//현재 정점 큐에서 deQueue -> 반환하고 삭제
			for (w = head[v]; w != null; w = w.link) {//w는 v의 인접한 모든 정점을 한번씩 대입받게 된다.
				if (visited[w.vertex] == false) {//w가 대입받은 정점을 아직 방문하지 않았다면
					visited[w.vertex] = true;	//방문처리하고
					System.out.printf(" %c", w.vertex + 65);
					Q.enQueue(w.vertex);	//큐에 추가한다.
				}
			}
			//v에 인접한 모든 정점을 방문하면 방문한 정점중 먼저 큐에들어간 정점이 deQueue를 통해
			//v에 저장되며 큐에서는 삭제가된다. v에 새로 저장된 정점의 인접한 정점을 위와같이 반복문을 통해 검사하며 탐색된다.
		}
	}

}

public class Graph02_DFS_BFS {
	public static void main(String[] args) {
		AdjList G9 = new AdjList();

		for (int i = 0; i < 7; i++) {
			G9.insertVertex(i);
		}

		G9.insertEdge(0, 2);
		G9.insertEdge(0, 1);
		G9.insertEdge(1, 4);
		G9.insertEdge(1, 3);
		G9.insertEdge(1, 0);
		G9.insertEdge(2, 4);
		G9.insertEdge(2, 0);
		G9.insertEdge(3, 6);
		G9.insertEdge(3, 1);
		G9.insertEdge(4, 6);
		G9.insertEdge(4, 2);
		G9.insertEdge(4, 1);
		G9.insertEdge(5, 6);
		G9.insertEdge(6, 5);
		G9.insertEdge(6, 4);
		G9.insertEdge(6, 3);


		System.out.print("\n그래프 G9의 인접리스트 : ");
		G9.printAdjList();

		System.out.print("\n\n깊이우선탐색 >> ");
		G9.DFS(0);

		System.out.print("\n\n너비우선탐색 >> ");
		G9.BFS(0);
	}

}
