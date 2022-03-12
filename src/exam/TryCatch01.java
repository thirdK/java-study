package exam;

public class TryCatch01 {
	public static void main(String[] args) {
		int number = 100;
		int result =0;
		
		for(int i=0 ; i<5; i++) {
			try {
				result = number / (int) (Math.random() * 10);
				System.out.println(result);
			} catch (ArithmeticException e)  { //난수가 0이되어 오류가 발생
				System.out.println("0");
			}
		}

		System.out.println("===============================\n");
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); //고의로 예외 발생
			System.out.println(4);	//4는 실행되지 않고 catch로 넘어감
		} catch(ArithmeticException e) { //예외의 참조변수
			System.out.println(5);			
		}
		System.out.println(6);
		//try에서 예외가 발생하면 catch의 ()에서 발생한 예외와 같은 타입의 참조변수를 찾는다.
		//instanceof로 참조변수의 종류와 생성된 예외클래스의 인스턴스를 검사한다.
	
		
		System.out.println("===============================\n");
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); //고의로 예외 발생
			System.out.println(4);	//4는 실행되지 않고 catch로 넘어감
		} catch(ArithmeticException ae) { //예외의 참조변수
			if(ae instanceof ArithmeticException)
				System.out.println("true");
			System.out.println("ArithmeticException");
		} catch(Exception e) {	//모든 예외의 부모클래스인 Exception이므로 위에서 처리되지 못한 예외는 여기서 걸린다.
			System.out.println("Exception");
		}
		System.out.println(6);

		System.out.println("===============================\n");
		
		try {
			System.out.println(3);
			System.out.println(0/0); //예외발생지점
			System.out.println(4);	
		} catch(ArithmeticException ae) { //예외의 참조변수
			ae.printStackTrace();
			System.out.println("예외메시지 : " + ae.getMessage());
		} catch(Exception e) {	//모든 예외의 부모클래스인 Exception이므로 위에서 처리되지 못한 예외는 여기서 걸린다.
			System.out.println("Exception");
		}
		System.out.println(6);
	}
	
}


























