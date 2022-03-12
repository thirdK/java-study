package exam;

import java.util.Random;

public class Random01 {
	public static void main(String[] args) {
		Random rand = new Random();
		int[] number = new int[100];	// 0~9까지의 난수 100개를 저장할 배열
		int[] counter = new int[10];	// 0~9까지의 숫자가 몇번 나왔는지 저장할 배열
		
		for(int i=0; i<number.length ; i++) {
			System.out.print(number[i] = rand.nextInt(10)); //저장과 동시에 출력
			//(int)(Math.rand() * 10);
		}
		System.out.println();
		
		for(int i=0; i<number.length; i++) {
			counter[number[i]]++;
		}
		
		for(int i=0; i < counter.length; i++) {
			System.out.println(i + "의 개수 : " + printGraph('#', counter[i]) + " " + counter[i]);
		}
	}
	
	public static String printGraph(char ch, int value) {
		char[] bar = new char[value];	//문자(ch)를 value수만큼 저장할 char배열
		for(int i=0; i<bar.length; i++) {
			bar[i] = ch;
		}
		return new String(bar); //String은 결국 char[]이다. 
	}
}
