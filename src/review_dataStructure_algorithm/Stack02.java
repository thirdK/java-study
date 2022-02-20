package review_dataStructure_algorithm;

//stack 정렬하기
//stack을 정렬하는 함수를 만든다. 단, 하나의 stack을 추가로 사용할 수 있으며
//Array등의 다른 데이터 구조는 사용 불가능
//두 개의 stack을 s1, s2로 만들고
//s1에 있는 정렬되지 않은 데이터들을 s2로 옮겨주는데
//옮길 데이터를 임시변수에 넣고 s2에 있는 값이 자기보다 작을 때에만 옮기고 크면
//s2에 있는 값을 다시 s1으로 옮긴다.
//반복이 끝나면 s2의 데이터를 전부 s1으로 옮겨준다.

public class Stack02 {
	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(3);
		s1.push(5);
		s1.push(1);
		s1.push(6);
		sort(s1);
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
	}
	
	private static void sort(Stack<Integer> s1) {//정렬이 안된 스택을 받고
		Stack<Integer> s2 = new Stack<Integer>();//임시 스택 s2를 만들어줌
		while(!s1.isEmpty()) {//s1이 비어있지 않다면 반복
			int tmp = s1.pop();//임시 변수에 옮길 데이터를 넣고 s2의 값과 비교해야함
			while(!s2.isEmpty() && s2.peek() > tmp) {//s2에 데이터가 있고 그 데이터가 tmp보다 크면
				s1.push(s2.pop());//다시 s1으로 옮김
			}
			s2.push(tmp);//아니면 s2로 이동
		}
		
		while(!s2.isEmpty()) {//s2가 공백이 될 때까지
			s1.push(s2.pop());//s1에 데이터를 옮김
		}
	}
}
