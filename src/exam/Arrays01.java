package exam;

import java.util.Arrays;

public class Arrays01 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 3, 4 };
		int[][] arr2D = { { 11, 12, 13 }, { 21, 22, 23 } };

		System.out.println("arr=" + Arrays.toString(arr)); // toString() 문자열로 요소들 보기쉽게 반환
		System.out.println("arr2D=" + Arrays.deepToString(arr2D));// 다차원 배열은 deppToString() 사용

		System.out.println();
		
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		int[] arr3 = Arrays.copyOf(arr, 3);		//배열복사 arr의 인덱스 3미만까지
		int[] arr4 = Arrays.copyOf(arr, 7);		//배열복사 arr의 인덱스 7미만까지
		int[] arr5 = Arrays.copyOfRange(arr, 2, 4);	//배열복사 arr의 인덱스 2부터 4미만까지
		int[] arr6 = Arrays.copyOfRange(arr, 0, 7);	//배열복사 arr의 인덱스 0부터 7미만까지
		
		System.out.println("arr2="+Arrays.toString(arr2));
		System.out.println("arr3="+Arrays.toString(arr3));
		System.out.println("arr4="+Arrays.toString(arr4));
		System.out.println("arr5="+Arrays.toString(arr5));
		System.out.println("arr6="+Arrays.toString(arr6));
		
		System.out.println();
		
		int[] arr7 = new int[5];
		Arrays.fill(arr7, 9);	//fill은 모든 요소를 지정된 값으로 채운다.
		System.out.println("arr7="+Arrays.toString(arr7));
		
		Arrays.setAll(arr7, i -> (int)(Math.random()*6)+1);	
		//setAll은 모든요소를 채우는데 (함수형 인터페이스/람다식) 을 매개변수로 받는다.
		System.out.println("arr7=" + Arrays.toString(arr7));
		
		System.out.println();
		
		for(int i : arr7) {	//랜덤한 숫자로 채운 arr7의 요소를 가져와서
			char[] graph = new char[i];	//요소만큼의 길이로 char배열 생성
			Arrays.fill(graph, '*');	//생성한 배열에 *을 채움
			System.out.println(new String(graph) + i); //문자 배열을 문자열로
		}
		
		String[][] str2D = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		String[][] str2D2 = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		
		System.out.println(Arrays.equals(str2D, str2D2)); //false
		System.out.println(Arrays.deepEquals(str2D, str2D2)); //true
		
		char[] chArr = {'A', 'D', 'C', 'B', 'E'};
		
		System.out.println("chArr =" + Arrays.toString(chArr));
		System.out.println("index of B =" + Arrays.binarySearch(chArr, 'B'));
		//binarySearch()는 이진탐색법을 사용하므로 정렬되어야 올바른 값이 반환된다.
		System.out.println("= After sorting=");
		Arrays.sort(chArr);
		System.out.println("chArr=" + Arrays.toString(chArr));
		System.out.println("index of B =" + Arrays.binarySearch(chArr, 'B'));

	}
}























