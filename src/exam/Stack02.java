package exam;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Stack02 {
	public static void main(String[] args) {
		//커맨드라인을 통해 args를 받아오는 예제인데 Scanner로 입력받는걸로 변형함
		Scanner sc =new Scanner(System.in);
		System.out.print("input : ");
		String str = sc.nextLine();
		
		if(str.length() < 1) {	//입력 없을시 예제출력
			System.out.println("Usage : \"Expression\"");
			System.out.println("Example : \"((2+3)*1)+3\"");
			System.exit(0);
		}
		
		Stack st = new Stack();
		String expression = str; //str 사용해도 되는데 이미 아래코드를 작성하고 수정한거라 expression에 대입함
		System.out.println("expression:" + expression); //입력받은 식을 출력
		
		try {	//스택을 pop()할때 공백스택일 경우 오류가 발생하므로 예외처리함
			for(int i=0; i<expression.length(); i++) {
				char ch = expression.charAt(i);	//문자열을 1개씩 문자로 뽑아줌
				
				if(ch=='(') {//char인 ch가 '('이면
					st.push(ch+"");//스택에 문자열로 저장
				} else if(ch == ')') {//닫기 괄호가 나오면
					st.pop();//pop()메소드를 호출    즉, 여는 괄호와 닫는 괄호의 빈도수가 동일한지 체크하게됨
				}
			}
			
			if(st.isEmpty()) { //push(), pop()이 동일하게 호출됐으면 비어있을 것이므로
				System.out.println("괄호가 일치합니다.");//일치
			} else {
				System.out.println("괄호가 일치하지 않습니다.");//남아있다면 불일치
			}
			
		}catch(EmptyStackException e) {//예외처리
			System.out.println("괄호가 일치하지 않습니다."); //비었는데 또 pop()하면 괄호가 불일치하다는것
		}
	}
}
