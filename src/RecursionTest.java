

import java.util.Arrays;

public class RecursionTest {
	public static void main(String[] args) {
	
		System.out.println(fibo(10));
		
		int[] arr = {1,2,3,4,5};
		System.out.println(sum1(arr));
		
		System.out.println(number_of_path(10)); 
		
		String[] st = {"ab", "c", "def", "ghij"};
		System.out.println(count(st)); 
		
		
	}
	
	//num번째 피보나치
	static int fibo(int num) {
		if(num < 3) return 1;
		return fibo(num-1) + fibo(num-2);
	}
	
	//배열 arr의 총합
	static int sum1(int[] arr) {
		if(arr.length == 1) return arr[0];
		
		return arr[0] + sum1(Arrays.copyOfRange(arr, 1, arr.length));
	}
	
	//1~3칸까지 오를 수 있을때 n개의 계단을 오르는 경우의 수
//	1 2 4 = 7
	static int number_of_path(int n) {
//		if(n<0) return 0;
//		if(n==0) return 0;
//		if(n==1) return 1;
//		if(n==2) return 2;
//		if(n==3) return 4;
		if(n<0) return 0;
		if(n==0 || n==1) return 1;
		return number_of_path(n-1)+number_of_path(n-2)+number_of_path(n-3);
	}
	
	//배열에 속한 모든 문자열 길이의 합
	static int count(String[] st) {
		if(st.length == 1) return st[0].length();
		return st[0].length() + count(Arrays.copyOfRange(st, 1, st.length));
	}
	
	
	
	
}



























