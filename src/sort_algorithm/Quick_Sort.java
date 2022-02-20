package sort_algorithm;

/*
퀵 정렬은 정렬할 전체 요소에 대해 정렬을 수행하지 않는다.
분할(divide)과 정복(conquer)을 반복 수행하여 완성한다.
	분할 : 정렬할 자료들을 기준값을 중심으로 2개의 부분집합으로 분할함
	정복 : 부분집합의 원소중 기준보다 작은 원소는 왼쪽 집합으로
	 	큰 원소드를 오른쪽 집합으로 정렬하고 부분집합의 크기가 1이하면 순환 호출을 이용해 다시 분할함

설명을 위해 L/R/피봇(pivot)을 사용함
	피봇은 기준값(일반적으로 중앙값)
	L은 왼쪽 끝에서 오른쪽으로 움직이며 피봇보다 크거나 같은 원소를 찾음
	R은 오른쪽 끝에서 왼쪽으로 움직이며 피봇보다 작은 원소를 찾음
	
	1. L과 R이 조건에 맞는 원소를 찾으면 교환한다.
	2. L과 R이 만나면 피봇과 만난위치의 원소를 교환하고 피봇 위치를 확정한다.
	3. 피봇의 확정된 위치를 기준으로 좌, 우를 부분집합으로 나누고 각각의 집합에서 위의 방법을 반복한다.
	4. 부분집합 크기가 1이하가 되면 퀵정렬이 종료된다.
========================================================================================
파티션 분할 알고리즘
partition(a[], begin, end)
	pivot <- (begin + end)/2;
	L <- begin;
	R <- end;
	while(L<R) do{
		while(a[L]<a[pivot] and L<R) do L++;
		while(a[R]>=a[pivot] and L<R) do R--;
		if(L<R) then {	//L의 요소와 R의 요소를 교환
			temp <- a[L];
			a[L] <- a[R];
			a[R] <- temp;
		}
	}
	temp <- a[pivot];	//R의 요소와 피봇 요소 교환
	a[pivot] <- a[R];
	a[R] <- temp;
	return L;
end partition()

퀵 정렬 알고리즘

quickSort(a[], begin, end)
	n <- a의 길이;
	if(m<n) then{
		p <- partition(a, begin, end);
		quickSort(a[], begin, p-1);
		quickSort(a[], p+1, end);
	}
end quickSort()

시간 복잡도 O(nlog2n)
*/

class Sort_q{
	int cnt=0;	//출력을 도울 cnt변수
	public int partition(int a[], int begin, int end) {
		int pivot, temp, L, R; //L,R,pivot변수 만들고 교환을 위한 temp변수
		
		L = begin;
		R = end;
		pivot = (begin + end)/2; //중앙을 pivot으로 설정하기 위해 평균정수 값 대입
		
		System.out.printf("\n [퀵정렬 %d 단계 : pivot=%d]\n", ++cnt, a[pivot]);
		
		while(L<R) {
			while((a[L] < a[pivot]) && (L<R)) L++;
			//중앙의 값(pivot인덱스에 저장된 값)보다 크거나 같은 값을 찾을 때까지 L++
			while((a[R] >= a[pivot]) && (L<R)) R--;
			//중앙의 값보다 작은 값을 찾을 때까지 R--
			
			if(L<R) { 
				//L이 R보다 작다는건 둘다 만나기 전에 조건에맞는 값을 찾았다는 것이므로
				//L과 R의 위치에 있는 요소를 교환한다.
				temp = a[L];
				a[L] = a[R];
				a[R] = temp;
				
				if(L == pivot) {//L과 R 요소를 교환하여, 결과적으로 피봇원소의 위치가 변경된 경우
					//이경우에는 pivot 요소의 위치가 확정되어 고정이된다.
					for(int i=0; i<a.length; i++)
						System.out.printf("%3d ", a[i]);
					System.out.println();
					return R; 
					//위에서 L과 R의 요소를 교환을 했는데 L==pivot(index)이라면 바뀌고난 지금은
					//R의 index에 pivot 요소가 있는것 이므로 R을 반환
				}			
			}
		}
		
		//L<R이 거짓이면 조건에 맞는 값을 못찾은경우이다. 
		//L과 R이 만났으므로 해당 위치의 요소와 pivot의 요소를 교환한다.
		temp = a[pivot]; 
		a[pivot] = a[R];
		a[R] = temp;

		for(int i=0; i<a.length; i++)
			System.out.printf("%3d ", a[i]);
		System.out.println();
		return R; //R값 즉, 교환되어 pivot요소가 확정된 자리의 index를 반환한다.
				
	}
	
	public void quickSort(int a[], int begin, int end) {
		if(begin < end) {
			int p;
			p = partition(a, begin, end); //R값을 리턴받게된 p는
			quickSort(a, begin, p-1);	//부분 집합으로 나누어주는 기준점 역할을 하게된다.
			quickSort(a, p+1, end);
		}
	}
}


public class Quick_Sort {
	public static void main(String[] args) {
		int a[] = {69, 10, 30, 2, 16, 8, 2, 31, 22};
		Sort_q S = new Sort_q();
		System.out.print("정렬할 원소 : ");
		for(int i=0; i<a.length; i++)
			System.out.printf("%3d", a[i]);
		System.out.println();
		S.quickSort(a, 0, 7);
	}
}















































