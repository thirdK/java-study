import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Buffered_RW01 {
	//BufferedReader에서 reedLine을 할때마다 예외처리를 해도 되지만 메소드에 예외던지기를 사용하는게 편함
	public static void main(String[] args) throws IOException{
		System.out.println("a");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine(); //readLine()은 반환값이 String으로 고정된다.
		int n = Integer.parseInt(bf.readLine());//다른 자료형으로 받으려면 형변환을 해야한다.
		
		
		//Read한 데이터는 Line단위로만 나눠지기에 공백단위로 데이터를 가공하려면 따로 작업을 해줘야함
		//StringTokenizer에 nextToken()함수를 쓰면 readLine()을 통해 입력받은 값을 
		//공백단위로 구분하여 순서대로 호출할 수 있다. (일반적으로는 split보다 이방식이 더 좋다.)
		StringTokenizer st = new StringTokenizer(s);	
		int a = Integer.parseInt(st.nextToken());	
		int b = Integer.parseInt(st.nextToken());	
		
		//String.split()함수를 활용하여 배열에 공백단위로 끊어서 데이터를 넣고 사용하는 방식
		String array[] = s.split(" ");
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//할당된 버퍼에 값 넣기
		String s1 = "abcdefg"; //출력할 문자열
		bw.write(s+"\n");// 버퍼에 잇는 값 전부 출력
		bw.flush(); //남아있는 데이터를 모두 출력
		bw.close(); //스트림 닫음
		//BufferedWriter 의 경우 버퍼를 잡아 놓았기 때문에 
		//반드시 flush() / close() 를 반드시 호출해 주어 뒤처리를 해주어야 한다.
		
		

	}
	
}
