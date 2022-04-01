package exam;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOstream03 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[4];	
		//temp의 크기를 4로 만들어서 아래의 while문에서 데이터를 4개씩 뽑아오게됨 
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		System.out.println("Input Source  : " + Arrays.toString(inSrc));
		
		try {
			//int available()은 스트림으로 부터 읽어 올 수 있는 데이터의 크기를 반환함
			//즉, input.available() > 0 은 input에서 읽어 올 수 있는 데이터가 1이상이면 이라는 뜻
			while(input.available() > 0) {	
				input.read(temp);
				output.write(temp);
//				위의 방법을 사용하면 마지막 결과가 옳지 않음 아래와 같이 사용하는게 원하는 결과가 나옴
//				int len = input.read(temp);	//읽어 온 데이터의 개수를 반환	int read(byte[] b)
//				output.write(temp, 0, len); //읽어 온 만큼만 write함
				
//				System.out.println("temp : " + Arrays.toString(temp));
				System.out.println("output" + Arrays.toString(output.toByteArray()) );
				outSrc = output.toByteArray();
				printArrays(temp,outSrc);
			}
		} catch(IOException e) {}	//read() write()가 IOException을 발생시킬 수 있다.
	}
	
	static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println("temp  : " + Arrays.toString(temp)); 
		System.out.println("Output Source : " + Arrays.toString(outSrc));
	}
}
