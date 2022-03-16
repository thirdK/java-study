package exam;

import java.util.ArrayList;
import java.util.List;

public class ArrayList02 {
	public static void main(String[] args) {
		final int LIMIT = 10;	//자르고자 하는 글자 개수
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length();
		
		List list = new ArrayList(length/LIMIT + 10); //크기를 여유있게 잡음
		
		for(int i=0; i< length; i += LIMIT) {
			if(i + LIMIT < length) list.add(source.substring(i, i+LIMIT));
			else list.add(source.substring(i));
		}
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
	}
}
