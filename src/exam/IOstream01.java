package exam;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOstream01 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		//메모리, 즉 바이트배열에 데이터를 입출력하는데 사용되는 스트림
		//주로 임시로 바이트배열에 담아 변환 등의 작업을 하는데 사용함
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data = 0;
		
		while((data = input.read()) != -1) {	//read()는 읽어올 데이터가 없으면 -1을 반환함
			output.write(data); 	//void write(int b)
		}
		
		outSrc = output.toByteArray(); //스트림의 내용을 byte배열로 반환
		System.out.println("Input Source    : "  + Arrays.toString(inSrc));
		System.out.println("Output Source   : "  + Arrays.toString(outSrc));
		
		//read()와 write(int b)를 사용하기 때문에 1byte만 읽고 쓰므로 작업효율이 떨어짐
	}
}
