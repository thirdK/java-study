

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
//	^	문자열 시작
//	$	문자열 종료
//	.	임의의 한 문자(단 \은 넣을 수 없음)
//	*	앞 문자가 없을 수도 무한정 많을 수도 있음
//	+	앞 문자가 하나 이상
//	?	앞 문자가 없거나 하나 있음
//	[ ] 	문자의 집합이나 범위를 나타내며 두 문자 사이는 - 기호로 범위를 나타냅니다. [] 내에서 ^ 가 선행하여 존재하면 not을 나타낸다.
//	{ } 	횟수 또는 범위를 나타냅니다.
//	( )	소괄호 안의 문자를 하나의 문자로 인식
//	|	패턴 안에서 or 연산을 수행할 때 사용
//	\	정규 표현식 역슬래시(\)는 확장문자 (역슬래시 다음에 일반 문자가 오면 특수문자로 취급하고 역슬래시 다음에 특수문자가 오면 그 문자 자체를 의미)
//	\b	단어의 경계
//	\B	단어가 아닌것에 대한 경계
//	\A	입력의 시작 부분
//	\G	이전 매치의 끝
//	\Z	입력의 끝이지만 종결자가 있는 경우
//	\z	입력의 끝
//	\s	공백 문자
//	\S	공백 문자가 아닌 나머지 문자
//	\w	알파벳이나 숫자
//	\W	알파벳이나 숫자를 제외한 문자
//	\d	숫자 [0-9]와 동일
//	\D	숫자를 제외한 모든 문자
//	(?i)	앞 부분에 (?!)라는 옵션을 넣어주게 되면 대소문자는 구분하지 않습니다.
	
	
	
//	정규식
//	^[0-9]*$	숫자
//	^[a-zA-Z]*$	영문자
//	^[가-힣]*$	한글
//	\\w+@\\w+\\.\\w+(\\.\\w+)?	E-Mail
//	^\d{2,3}-\d{3,4}-\d{4}$	전화번호
//	^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$	휴대전화번호
//	\d{6} \- [1-4]\d{6}	주민등록번호
//	^\d{3}-\d{2}$	우편번호
	
	public static void main(String[] args) {
		String str = "123452143214";
		String pattern = "^[0-9]*$";
		
		boolean res = Pattern.matches(pattern, str);	// 패턴 , 비교대상
		System.out.println(res);
		
		System.out.println(str.matches(pattern));	//이 방식으로도 가능

		System.out.println("========================================================================");
		
		Pattern pattern2 = Pattern.compile("^[a-zA-Z]*$"); //영문자만
        String val = "abcdef"; //대상문자열

        Matcher matcher = pattern2.matcher(val);
        System.out.println(matcher.find());

	}
}

//		.			어떤 문자 1개를 의미
//		^regex		^ 다음 regex로 line을 시작하는지
//		regex$		$ 앞의 regex가 line의 마지막으로 끝나는지
//		[abc]		a, b, c 중의 문자 1개
//		[abc][vz]	a, b, c 중에 문자 1개와 v, z 중에 문자 1개의 조합
//		[^abc]		a, b, c를 제외한 문자 1개
//		[a-d1-7]	ad, 17 사이의 문자 1개
//		X|Z			X 또는 Z
//		\d			0~9 사이의 숫자, [0-9]와 동일
//		\D			숫자가 아닌 어떤 문자, [^0-9]와 동일
//		\s			whitespace 1개, [\t\n\x0b\r\f]와 동일
//		\S			whitespace를 제외한 문자
//		\w			Alphanumeric(alphabet, 숫자) 문자, [a-zA-Z_0-9]와 동일
//		\W			Alphanumeric을 제외한 문자(whitespace 등)
//		\S+			whitespace를 제외한 여러 문자
//		\b			단어의 경계(공백)를 찾습니다
