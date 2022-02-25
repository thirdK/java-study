package dataStructure_algorithm;

//버블정렬 알고리즘
/*
버블정렬은 두 개의 값을 비교하여 크거나 작은 값을 한쪽으로 몰아가며 정렬하는 방식
1.배열의 시작지점에서 나란히 있는 두 요소의 값을 비교한다 arr[0] > arr[1] (역순으로 끝에서 시작해도됨)
2.오름차순이나 내림차순에 따라 큰 값 또는 작은 값을 한쪽으로 이동시킨다.
3.배열의 다음요소를 비교한다. arr[1] > arr[2] 배열의 끝까지 반복한다.
4.끝으로 옮겨진 요소는 현재의 탐색범위에서 가장 작은 값이므로 고정한다.(탐색범위에서 제외시킨다.)
5.처음부터 반복한다.

bubbleSort(a[])
	n <- 배열 a의 길이;
	for(i <- n-1; i > 0; i <- i-1){
		for(j <- 0; j < i; j <- j+1){
			if(a[j] > a[j+1]) then{
				temp <- a[j];
				a[j] <- a[j+1];
				a[j+1] <- temp;
			}
		}
	}
end bubbleSort() 
*/

//시간 복잡도는 O(n^2)

class Sort_b{
	public void bubbleSort(int a[]) {
		int temp, size;	//temp는 값 교환을 위해, size는 a배열의 길이를 저장하기위해 생성
		size = a.length;
		for(int i=size-1; i>0; i--) {	//i는 arr의 마지막 index부터 1까지 감소됨
			System.out.printf("\n버블 정렬 %d 단계 : ", size-i);
			for(int j=0; j<i; j++) {	//j는 0부터 현재 i의 값까지 증가됨(탐색범위가 i의 영향을 받아 감소됨)
				if(a[j] > a[j+1]) {	//[j]와 [j+1] 요소를 비교하여 큰 값을 index 끝쪽으로 옮기며 정렬해감
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				System.out.print("\n\t");
				for(int k=0; k<size; k++) {//과정을 보기위해 만든 반복문
					System.out.printf("%3d ", a[k]);
				}
			}
		}
	}
}

public class Bubble_Sort {
	public static void main(String[] args) {
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		Sort_b S = new Sort_b();
		System.out.println("정렬할 원소 : ");
		for(int i=0; i<a.length; i++) {
			System.out.printf(" %d", a[i]);
		}
		System.out.println();
		S.bubbleSort(a);
	}
}




























