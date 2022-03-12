package exam;

//예외 발생시키기

public class ThrowException {
	public static void main(String[] args) {
		try {
			Exception e = new Exception("고의로 발생시켰음");//발생시키려는 예외 클래스의 객체를 만듬
			throw e;		//예외 발생
			//throw new Exception("고의로 발생시켰음"); 위 두줄은 한줄로도 가능
		}catch (Exception e){
			System.out.println("에러 메시지 : " + e.getMessage());
			e.printStackTrace();
		}finally {
			System.out.println("반드시 실행되는 finally 블럭");
		}
		System.out.println("종료");
		
		test1();
		
	}
	
	static void test1() {
		throw new RuntimeException();	//런타임오류 발생(컴파일에는 문제없으나 실행시키면 발생)
	}
	
	//메서드에 예외선언하기
	//이 메서드를 사용할때 어떤 예외가 발생될 수 있는지 알 수 있다.(어떤 예외를 처리해야 할지)
	//메서드에 throws를 사용하면 메서드 정의에서는 예외가 처리 된것처럼 보이지만 사실은 그냥 넘겨주는것이다. 
	//호출해서 사용하는 사람은 별도로 예외 처리해야한다.
	static void test2() throws Exception, RuntimeException{
		
	}
	
}
