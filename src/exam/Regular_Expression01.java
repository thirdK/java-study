package exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//정규식은 텍스트 데이터 중 원하는 조건(패턴)과 일치하는 문자열을 찾아내는 것이다.
//미리 정의된 기호와 문자를 이용하여 작성한 [문자열]을 말한다.

//Pattern은 정규식을 정의한다.
//Matcher는 정규식(pattern)과 data를 비교한다.
		
public class Regular_Expression01 {
	public static void main(String[] args) {
		String[] data = 
			{
				"bat", "baby", "bonus", "cA", "ca" , "co", "c.", "c0", 
				"car", "combat", "count", "date", "disc"
			};
		
		//정규식 "c[a-z]*"을 매개변수로 Pattern클래스의 static메서드인 Pattern compile(String regex)을
		//호출하여 Pattern 인스턴스를 얻는다.
		Pattern p = Pattern.compile("c[a-z]*"); 	//c로 시작하는 소문자영단어
		
		for(int i=0; i<data.length; i++) {
			//정규식으로 비교할 대상을 매개변수로 Pattern클래스의 Matcher matcher(CharSequence input)를
			//호출하여 Matcher 인스턴스를 얻는다.
			Matcher m =p.matcher(data[i]);
			if(m.matches()) {//Matcher인스턴스에 boolean matches()를 호출하여 정규식에 부합하는지 확인한다.
				System.out.print(data[i] + ", ");
			}
		}
	}
	

}
