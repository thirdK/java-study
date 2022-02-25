package dataStructure_algorithm;

//순차 자료구조를 이용해 최대 힙 프로그램 만들기
//Heap은 완전 이진트리에 있는 노드 중 키값이 가장 크거나 가장 작은 노드를 찾기위해 만든 자료구조이다
//최대 힙은 부모노드의 키값이 자식노드보다 항상 크거나 같다. 즉 루트노드가 가장 큰 키값이다. (최소 힙은 루트가 가장 작은 키값)
//

class Heap{
	private int heapSize;
	private int itemHeap[];	
	//순차 자료구조를 이요하기때문에 배열을 만들며 인덱스계산의 편의를 위해 
	//배열의 첫번째 칸(0번 index)는 비우고 1번 index부터 사용한다.
	//기본적으로 완전 이진트리기 때문에 배열의 중간 index가 비워지지 않는다.
	//(6개의 값이 저장되어 있으면 0번 index를 제외하고 6번 index까지 키값이 들어있다.)
	//위의 상황에 의해  부모노드인덱스==(자식노드인덱스/2)  이다.
	
	public Heap() {
		heapSize = 0;
		itemHeap = new int[50];
	}
	
	//insertHeap() 키값을 추가하는 메소드
	public void insertHeap(int item) {
		int i = ++heapSize;		//heapSize는 하나의 값이 추가 될 때마다 증가되어 i에 대입(0번인덱스는 사용안함)
		while((i != 1) && (item > itemHeap[i/2])) {
			//i != 1(첫노드가 아니고) item>itemHeap[i/2](추가되는 값 > 부모노드)
			itemHeap[i] = itemHeap[i/2];//새로들어온 키값이 들어가려고 했던 인덱스에 부모값을 넣고
			i/=2;	// i는 부모자리의 인덱스로 바뀐다.
			//반복문을 통해 트리의 위로 올라가며 자신의 자리를 찾아간다.
		}
		itemHeap[i] = item;	
		//while문에 들어가지 않으며 첫 키값이거나 부모보다 작은 값이므로 itemHeap[i]에 저장되며
		//while문에 들어갔다오면 자신보다 작은 부모키값
	}
	
	public int getHeapSize() {
		return this.heapSize;
	}
	
	//deleteHeap() 키값을 삭제하는 메소드
	//root의 키값을 삭제하며 나머지 키값들을 비교하여 root를 채운다.
	public int deleteHeap() {
		int parent, child;
		int item, temp;
		item = itemHeap[1];	
		//기존 root 키값은 item에 저장 후 마지막에 반환
		//(사실상 1번 인덱스는 비어있는것과 마찬가지이며 이제 부터는 [비어있다]고 말함)
		temp = itemHeap[heapSize--]; //현재 가장 마지막 인덱스에 저장된 키값을 temp에 넣고 힙사이즈를 줄인다.(마지막 1칸이 사라짐)
		parent = 1;	//[비어있는] 1번 index와
		child = 2;	//자식 index부터 비교한다.
		
		//이제 temp값을 어디에 넣을지 자리를 찾아야함
		while(child <= heapSize) {
			if((child < heapSize) && (itemHeap[child] < itemHeap[child+1])) {
				//아직 전체힙을 검사하지 않았고 2개의 자식노드를 비교하여
				child++;
			}
			if(temp >= itemHeap[child]) break;
			//2개의 자식노드중 키값이 큰 노드와 temp를 비교하며 temp가 크거나 같으면 반복문에서 나간다.
			
			itemHeap[parent] = itemHeap[child];//temp가 크지 않다면 [비어있는]부모자리에 자식노드를 올리고
			parent = child;//이제 [비어있는] 자리는 올라간 자식의 기존 자리이다.
			child *= 2;//비교할 대상인 다음 level의 자식노드의 인덱스 번호로 변경 (*2)
		}
		
		itemHeap[parent] = temp;//반복문이 끝나면 temp에 임시로 저장된 값을 올바른 자리에 대입
		return item;//삭제한 키값 반환
	}
	
	public void printHeap() {
		System.out.print("\nHeap >> ");
		for(int i=1; i<=heapSize; i++) {
			System.out.printf("[%d] ", itemHeap[i]);
		}
	}
	
}
public class Heap_Array {
	public static void main(String[] args) {
		int n, item;
		Heap h = new Heap();
		
		h.insertHeap(13);
		h.insertHeap(8);
		h.insertHeap(10);
		h.insertHeap(15);
		h.insertHeap(20);
		h.insertHeap(19);
		
		h.printHeap();
		
		n = h.getHeapSize();
		for(int i=0; i<=n; i++) {
			item = h.deleteHeap();
			System.out.printf("\n deleted Item : [%d]", item);
		}
		
		h.printHeap();
	}
}





















