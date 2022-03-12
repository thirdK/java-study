package exam;

//예외 되던지기(exception re-throwing)
//한 메서드에서 발생 가능한 예외가 여러개인 경우는 일부는 try-catch문으로 자체적으로 처리하고
//나머지는 메소드 선언부에 throws로 지정하여 호출한쪽에서 처리하도록 할 수 있다.(양쪽에서 나눠서 처리함)

//그리고 하나의 예외가 발생해도 양쪽에서 처리하도록 할 수 있다.
//예외를 처리하고 인위적으로 예외를 다시 발생시켜 처리하도록 하는것이다.
//이 방법을 예외 되던지기 라고 한다.
//즉, 해당 메소드에서 try catch로 예외를 처리하고 다시 예외를 발생시켜서 (throw)
//메소를 호출한 쪽에서도 예외처리를하게끔 하는것이다.

public class Throwing {

	public static void main(String[] args) {
		try {
			method1();
		}catch(Exception e){//메소드에서 처리했지만 다시 발생시켰으므로 호출할때도 처리를해야함
			System.out.println("main메서드에서 예외처리");
		}
	}
	
	static void method1() throws Exception { //예외를 다시 발생시킬것 이므로 throws사용
		try {
			throw new Exception(); //예제를위해 예외발생(예외가 발생되었을 때 라고 생각하면 될듯)
		} catch(Exception e) {	//예외를 처리하고
			System.out.println("method1메서드에서 예외처리");
			throw e;	//다시 발생시킨다.
		}
	}
}
