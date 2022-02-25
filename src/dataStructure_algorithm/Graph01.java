package dataStructure_algorithm;
//그래프는 연결되어있는 원소간의 관계를 표현하는 자료구조이다. 지하철 노선처럼 여러 관계가 연결되어 있으면
//연결 구조가 너무 다양하여 선형 자료구조나 트리로는 표현이 불가능하다 이러한 자료들을 표현하기 윈한 자료구조가 그래프다.
//그래프는 모든 연결 구조를 표현할 수 있다.


//정점(vertex) -> 연결할 객체
//간선(edge) -> 객체를 연결하는 일종의 선
//그래프(G) = (정점의 집합(V), 간선들의 집합(E)) 
//G = (V,E)

//그래프의 두 정점 Vi, Vj가 연결되어 간선(Vi,Vj)가 있다면 두 정점은 인접(adjacent)되어 있다고 하며
//간선(Vi,Vj)는 정점 Vi와 Vj에 부속(incident)되어 있다고 한다.
//정점에 부속되어 있는 간선의 수를 차수(degree)라고 한다. 
//방향그래프에서는 간선의 방향에 따라 진입차수(in-degree)와 진출차수(out-degree)로 나누며, 전체차수 = 진입차수+진출차수 이다.

//그래프에서 간선을 따라갈 수 있는 길을 순서대로 나열한 것을 -> 정점 Vi에서 Vj까지 간선으로 연결된 정점을 순서대로 나열한 리스트를
//Vi에서 Vj까지의 경로(path)라고 하며 경로를 구성하는 간선의 수는 경로의 길이(Path Length)가 된다.

//단순 경로(Simple Path) : 모두 다른 정점으로 구성된 경로 -> A-B-C
//사이클(cycle) : 단순경로중에서 경로의 시작 정점과 마지막 정점이 같은 경로 -> A-B-C-D-A

//연결 그래프(Connected Graph) : 떨어져 있는 정점이 없는 그래프
//단절 그래프(Disconnected Graph) : 연결되지 않은 정점이 있는 그래프

// 순차 자료구조 방식을 이용한 그래프의 구현 : 인접 행렬
// n개의 정점을 가진 그래프는 n*n 정방 행렬을 사용하고 인접하면 1 인접하지 않으면 0으로 표현
// 간선의 개수와 무관하게 n*n개의 메모리를 사용하기 때문에 간선의 수가 적은 희소 그래프의 경우 희소행렬이 되므로 메모리낭비가 심함

// 연결 자료구조 방식을 이용한 그래프의 구현 : 인접 리스트
// 각 정점에 대한 인접 정점들을 연결리스트로 만든다. 리스트의 각 노드는 정점을 저장하는 필드와 다음 인접 정점을 연결하는 링크 필드로 구성
// 어떤 정점의 연결 리스트는 그 정점에 인접한 정점의 수만큼, 즉 그 정점의 차수만큼 노드가 연결되어 있다.
// 리스트 내의 노드는 저장하는 정점에 대해서 오름차순으로 연결한다.
// **각 정점에 대한 참조변수를 배열로 구성하고 각 정점에 대한 헤드노드는 인접 정점ㅇ의 노드번호에 오름차순으로 정렬하고 연결한 리스트를 가리킴

//*************************************************************************************************
// n개의 정점과 e개의 간선을 가진 
// 무방향 그래프에 대한 인접 리스트는 크기가 n인 헤드 노드 배열과 2e개의 노드가 필요하다.
// 방향 그래프에 대한 인접 리스트는 크기가 n인 헤드 노드 배열이 필요하며 각 헤도 노드에 연결되는 노드의 수는 각 정점의 진출 차수가 된다.

class AdjMatrix{	//그래프 인접 행렬
	private int matrix[][] = new int[10][10]; //인접 행렬은 2차원 배열을 사용한다.
	private int totalV = 0;		//총 정점의 수
	
	public void insertVertex(int v) { 	//정점 삽입 메소드
		totalV++;						//삽입되면 totalV 1증가
	}
	
	public void insertEdge(int v1, int v2) {	//두개의 정점을 받아 둘 사이의 간선을 삽입하는 메소드
		if(v1 >= totalV || v2 >= totalV) {		//정점과 총 정점의 수를 비교하여 존재 여부 검사
			System.out.println("그래프에 없는 정점!!");
		}else {
			matrix[v1][v2] = 1;					//존재한다면 인접행렬에 간선 삽입 (0 -> 1)
		}
	}
//	A정점과 B정점이 있다면 인접행렬은 [0][0]부터 [1][1]까지 존재함 C가 추가되면 [2][2]까지 (n*n)
//	무방향 완전 그래프라고 가정하고 
//	자기자신을 간선으로 연결할 수 없으므로 [0][0]=0, [0][1]=1, [1][0]=1, [1][1]=0 이된다.
	public void printMatrix() {	
		for(int i=0; i<totalV; i++) {
			System.out.print("\n\t\t");
			for(int j=0; j<totalV; j++) {
				System.out.printf("%2d", matrix[i][j]);
			}
		}
	}
}

//인접 리스트
class GraphNode{	//노드 클래스
	int vertex;		//정점 필드
	GraphNode link;	//링크 필드
}

class AdjList{
	private GraphNode head[] = new GraphNode[10];	//헤드노드들이 저장될 배열
	private int totalV=0;	//총 정점수
	
	public void insertVertex(int v) {
		totalV++;		//정점 추가시 증가
	}
	
	public void insertEdge(int v1, int v2) {	//정점 2개를 받아 둘 사이의 간선을 삽입
		if(v1 >= totalV || v2 >= totalV) {		//조건확인해서 존재하는 간선인지 판단(총정점보다 많으면 거짓)
			System.out.println("그래프에 없는 정점입니다.");
		} else {
			GraphNode gNode = new GraphNode();	//노드 생성
			gNode.vertex = v2;					//정점필드에 값을 넣고
			gNode.link = head[v1];				//링크필드에 v1헤드배열이 가진 참조값을 넣고
			head[v1] = gNode;					//head[v1]가 생성된 노드의 주소를 저장.
		}										//다음 노드도 위를 반복하여 기존 노드와 연결이 됨
	}
	
	
	public void printAdjList() {
		GraphNode gNode = new GraphNode();
		for(int i=0; i<totalV; i++) {
			System.out.printf("\n정점 %c의 인접리스트 ", i+65); //대문자 알파벳으로 표현하기위해 +65
			gNode = head[i];	//각 정점의 헤드를 gNode로 받아서
			while(gNode != null) {// 노드가 null일때까지 (마지막 노드까지)
				System.out.printf("-> %c", gNode.vertex+65); //대문자 알파벳으로 정점을 출력한다.
				gNode = gNode.link;//다음 노드를 gNode에 넣는다.
			}
		}
	}
}


public class Graph01 {
	public static void main(String[] args) {
		AdjMatrix MG1 = new AdjMatrix();
		
		for(int i=0; i<4; i++) {
			MG1.insertVertex(i);
		}
		MG1.insertEdge(0, 3);
		MG1.insertEdge(0, 1);
		MG1.insertEdge(1, 3);
		MG1.insertEdge(1, 2);
		MG1.insertEdge(1, 0);
		MG1.insertEdge(2, 3);
		MG1.insertEdge(2, 1);
		MG1.insertEdge(3, 2);
		MG1.insertEdge(3, 1);
		MG1.insertEdge(3, 0);
		System.out.print("\n그래프 G1의 인접행렬 : ");
		MG1.printMatrix();
		System.out.println();
		
		AdjList LG1 = new AdjList();
		for(int i=0; i<4; i++) {
			LG1.insertVertex(i);
		}
		LG1.insertEdge(0, 3);
		LG1.insertEdge(0, 1);
		LG1.insertEdge(1, 3);
		LG1.insertEdge(1, 2);
		LG1.insertEdge(1, 0);
		LG1.insertEdge(2, 3);
		LG1.insertEdge(2, 1);
		LG1.insertEdge(3, 2);
		LG1.insertEdge(3, 1);
		LG1.insertEdge(3, 0);
		System.out.println("\n그래프 G1의 인접리스트 : ");
		LG1.printAdjList();
		System.out.println();
		
	}

}







































