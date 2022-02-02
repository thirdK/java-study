

import java.util.ArrayList;
import java.util.List;

interface methodIf {				//인터페이스를 만들어서 람다를 사용해본다.
	public String call(String str);
}


public class LambdaPractice01 {
	
	
	public String call(String str) {	//일반적인 메소드 생성
		return str;
	}
	
	
	public static void main(String[] args) {

		methodIf Lambda = (str) -> {return str;};			//인터페이스를 이용하여 람다를 사용
		System.out.println(Lambda.call("람다를 이용한 메소드 호출"));
		
		
		LambdaPractice01 test = new LambdaPractice01();			//일반 메소드를 이용하여 사용
		System.out.println(test.call("일반 메소드를 정의하여 출력"));
		
		//이처럼 람다는 기존의 클래스에 메소드를 만들고 객체화 한 뒤에 사용하는 방식이 아니라
		//그때 그때 바로 만들어서 사용하는 식이다. 인터페이스를 통해 메소드를 만들 수 있도록 해두고
		
		//인터페이스명 객체명 = (파라미터) -> {수행할코드;};
		//위와 같이 인터페이스 객체와 람다 메소드를 생성하고
		//객체명.메소드명() 으로 사용한다.
		
		//결국 인터페이스로 추상메소드인 껍데기만 만들어두고 필요할 때, 필요한 메소드로 구체화하여 사용한다는거 같다 
		//즉 1회성으로 사용하는 메소드를 만드는 거 같다.
		
//		*람다의 핵심은*
//		(파라미터) -> {수행할 코드}를 통해 메소드를 정의하지 않고도	메소드처럼 사용할 수 있다는 것
//===========================================================================================
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);		
		
		list.forEach(val -> System.out.println(val));	//람다를 이용한 리스트 출력
		list.forEach(System.out::println);
		
	}
	
}




























