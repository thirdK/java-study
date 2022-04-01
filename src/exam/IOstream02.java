package exam;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOstream02 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[10];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		input.read(temp, 0, temp.length); //데이터를 읽어와서 temp의 0번째부터 최대 temp.length만큼 저장
		output.write(temp,5,5);	//temp[5]부터 5개의 데이터를 write한다.
		
		outSrc = output.toByteArray();
		
		System.out.println("Input Source   : " + Arrays.toString(inSrc));
		System.out.println("temp           : " + Arrays.toString(temp));
		System.out.println("Output Source  : " + Arrays.toString(outSrc));
		
		//read()와 write(int b)를 사용하는것 보다
		//int read(byte[] b, int off, int len)와 void write(byte[] b, int off, int len)을 사용하면
		//byte배열을 이용하여 한 번에 배열의 크기만큼 읽고 쓸 수 있다.(더 효율적임)
		//배열을 이용하면 작업의 효율을 증가시키므로 가능하면 입출력 대상에 맞는 크기의 배열을 사용하는게 좋다.
	}
}
