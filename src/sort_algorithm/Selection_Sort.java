package sort_algorithm;

//선택정렬 알고리즘
/*
1. 전체를 탐색하여 가장 작은 값(또는 큰 값)을 찾는
2. 찾은 값을 배열의 가장 앞이나 뒤로 보낸다.(교환) 보내진 값은 그자리에 고정된다.(탐색범위에서 제외)
3. 다시 반복한다.

selectionSolt(a[])
	n = a의 길이
	for(i <- 1; i<n; i <- i+1){
		a[i], ..., a[n-1] 중에 가장 작은 원소 a[k]를 선택하여, a[i]와 교환한다;
	}
end selectionSolt()

시간 복잡도는 O(n의 2제곱), O(pow(n,2))
*/


class Sort_s{
	public void selectionSort(int a[]) {	//정렬할 배열을 파라미터로 받는다.
		int min;	//항상 탐색범위의 가장 작은 값을 저장할 min변수
		
		for(int i=0; i<a.length-1; i++) {	
			//성택정렬이 진행되다보면 마지막 요소는 검사할 필요가 없으므로, i<길이-1
			//i는 현재 탐색범위중 가장 작은 값이 들어갈 자리이며, i가 증가하면 탐색범위는 점점 줄어든다.
			min = i;	//min의 초기값은 배열의 처음인덱스(0)를 저장한다.(비교대상)
			for(int j=i+1; j<a.length; j++) {
				//i(min)와 비교할 요소들은 i다음 index부터이다.(j=i+1)
				//i이전은 탐색범위에서 제외된다.
				if(a[j] < a[min]) {	//두 값을 비교한다.
					min = j;//a[min]의 값보다 a[j]값이 더 작으면 min에 작은 값이 들어있는 index를 저장하고
				}			//반복하면 최종적으로 min은 탐색범위에서 가장 작은 값을 갖게된다.
			}
			swap(a, min, i);//swap메소드를 통하여 a배열의 a[min]의 값과 a[i]의 값을 교환한다.
			System.out.printf("\n선택 정렬 %d 단계 : ", i+1);
			for(int j=0; j<a.length; j++) {
				System.out.printf("%3d ", a[j]);
			}
		}
	}
	
	public void swap(int a[], int i, int j) {	//swap()메소드는 파라미터로 받은 index의 값을 교환한다.
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		//배열을 이용해 swap()을 구현
	}
	
}


public class Selection_Sort {
	public static void main(String[] args) {
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		Sort_s S = new Sort_s();
		System.out.print("\n정렬할 원소 : ");
		for(int i=0; i<a.length; i++) {
			System.out.printf(" %d", a[i]);
		}
		System.out.println();
		S.selectionSort(a);
		
	}
}






























