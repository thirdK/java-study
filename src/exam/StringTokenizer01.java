package exam;

import java.util.StringTokenizer;

//StringTokenizer는 문자열을 구분자로 나누는 클래스이다.
//String의 split(String regex), Scanner의 useDelimiter(String pattern)과 비슷하다.
//차이점은 정규식 표현(Regular expression)을 사용하는 위의 2개와 달리
//일반 String타입의 구분자(delim)를 사용하므로 정규식을 몰라도 사용하기 편하다.
//단, 하나의 문자 밖에 사용하지 못하기 때문에 복잡한 형태의 구분자는 어쩔수 없이 위의 2가지 방법을 사용해야한다.

//만약 StringTokenizer st = new StringTokenizer(str, "+-*", true); 라고 사용하게되면
//"+-*"이라는 구분자가 아니라 "+", "-", "*" 라는 각각의 구분자로 사용된다.
//마지막의 true는 구분자도 token으로 포함 여부를 나타낸다.

public class StringTokenizer01 {
	public static void main(String[] args) {
		String input = "삼십만삼천백십오";
		System.out.println(input);
		System.out.println(hangulToNum(input));
	}
	
	public static long hangulToNum(String input) {
		long result = 0;	//최종 변환결과를 저장
		long tmpResult = 0;	//십백천 단위의 값을 저장할 임시변수 -> 만억조는 아님
		long num = 0;
		
		final String NUMBER = "영일이삼사오육칠팔구";
		//NUMBER 변수에는 영~구 가 저장되어 있으므로 indexOf를 사용하면 0~9와 일치한다.
		
		final String UNIT = "십백천만억조";
		final long[] UNIT_NUM = {10, 100, 1000, 10000, (long)1e8, (long)1e12};
		//UNIT의 indexOf를 사용했을 때 값은 UNIT_NUM배열의 인덱스와 값이 일치한다.
		
		StringTokenizer st = new StringTokenizer(input, UNIT, true); 
		//UNIT의 각각의 문자가 구분자로 사용되며 구분자도 토큰으로 포함된다.
		//삼, 십, 만, 삼, 천, 백, 십, 오
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			int check = NUMBER.indexOf(token); //숫자인지, 단위(UNIT)인지 확인한다.
			//만약 토큰이 "십백천만억조"같은 단위인 경우는 일치하는 인덱스가 없으므로 -1이 저장된다.
			
			if(check == -1){ //토큰이 단위인 경우
				if("만억조".indexOf(token) == -1) { //단위가 "만억조"가 아닌경우 -> 단위가 작은경우
					tmpResult += (num != 0 ? num : 1) * UNIT_NUM[UNIT.indexOf(token)];
					//"십오" 처럼 단위가 앞에나오면 0*10이 되므로 num에 1을 넣어 곱해준다.
					
				} else {//단위가 "만억조"인 경우 -> "삼십만"처럼 단위가 2번연속 나올수 있음 30*10000을 해줘야함
					tmpResult += num; //우선 앞에서 저장한 숫자 num을 임시변수에 저장(없으면 0)
					result += (tmpResult != 0 ? tmpResult : 1) * UNIT_NUM[UNIT.indexOf(token)];
					//즉, "만억조"단위는 result에 저장하고 tmpResult를 비워준다.
					tmpResult = 0;
				}
				num = 0;
			} else { //토큰이 숫자인 경우 num에 저장 ->다음 토큰에서 단위가 나오므로 계산하기 위해
				num = check;
			}
		}
		return result + tmpResult + num; //최종적으로 전부 합산하여 리턴함
		//result는 "만억조"단위 tmpResult는 "천백십"단위 num은 1의자리
	}
}























