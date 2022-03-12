package exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular_Expression03 {
	public static void main(String[] args) {
		String source = "A broken hand works, but not a broken heart";
		String pattern = "broken";
		StringBuffer sb = new StringBuffer();
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(source);
		System.out.println("source : " + source);
		
		int i = 0;
		while(m.find()) {
			//find()로 정규식과 일치하는 부분을 찾으면 그 위치를 start()와 end()로 알아 낼 수 있다.
			System.out.println(++i + "번째 매칭:" + m.start() + "~" + m.end());
			
			//"broken"을 "drunken"으로 치환하여 sb에 저장한다.
			//appendReplacement(StringBuffer sb, String replacement);
			m.appendReplacement(sb, "drunken");
		}
		m.appendTail(sb);
		
		//위의 코드는 다음과 같이 작동한다.
		//m.find()로 찾는다 m.appendReplacement(sb, "drunken")가 호출되면 source의 시작부터 
		//"broken"을 찾은 위치까지의 내용에 "drunken"을 더해서 저장한다.
		//-sb에 저장된 내용 : "A drunken"
		
		//m.find()는 첫 번째로 발견된 위치의 끝에서부터 다시 검색을 시작하여 두번 째 "broken"을 찾는다.
		//다시 appendReplacement(..., ...)가 호출
		//-sb에 저장된 내용 : "A drunken hand works, but not a drunken"
		
		//m.appendTail(sb); 호출되면 마지막으로 치환된 이후의 부분을 sb에 덧붙인다.
		//-sb에 저장된 내용 : "A drunken hand works, but not a drunken heart."
		
		System.out.println("Replacement count : " + i);
		System.out.println("result: "  + sb.toString());
	}
}
