package exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//정규식 예제 2
//정규식의 일부를 괄호로 나누어 묶어서 그룹화할 수 있다.
//그룹화된 부분은 하나의 단위로 묶이는 셈이 되어서 한 번 또는 그 이상의 반복을 의미하는
//'+'나 '*'가 뒤에 오면 그룹화된 부분이 적용대상이 된다.
//그리고 그룹화된 부분은 group(int i)를 이용하여 나누어 얻는다.

public class Regular_Expression02 {
	public static void main(String[] args) {
		String source = "HP: 011-1111-1111, HOME:02-999-9999 ";
		String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})"; 
		// 문자열("") 안에서 이스케이프 문자(\)는 2번사용해야 이스케이프 문자로 인정된다.
		//(0\\d{1,2})	-> 0\d{1,2} -> 0으로 시작하고 뒤에 1~2자리의 숫자가 나옴(0을 포함 총 2~3자리)
		//(\\d{3,4})	-> \d{3,4}	-> 3~4자리의 숫자
		//(\\d{4})		-> \d{4}	-> 4자리의 숫자
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		
		int i=0;
		//find()는 주어진 소스 내에서 패턴과 일치하는 부분을 찾아내면 true 반환
		//StringTokeizer의 nextToken()처럼 연속적으로 실행시 다음 값을 반환
		while(m.find()) {	
			System.out.println(
					++i + ": " + m.group() + " -> " + m.group(1)
					+ ", " + m.group(2) + ", " + m.group(3)
			);
		}
	}
}
