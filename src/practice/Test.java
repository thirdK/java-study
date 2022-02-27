package practice;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		
		String[] st = {"ab", "c", "def", "ghij"};
		System.out.println(count(st)); 
		
		
	}
	
	static int count(String[] st) {
		if(st.length == 1) return st[0].length();
		return st[0].length() + count(Arrays.copyOfRange(st, 1, st.length));
	}
}
