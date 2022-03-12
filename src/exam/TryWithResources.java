package exam;

//자동 자원 반환 try - with - resources 문
//입출력과 관련된 클래스를 사용할 대 유용하다. -> 이해를 위해서는 입출력 관련된 공부가 필요함
//클래스 중에는 사용후 꼭 닫아 줘야하는 것들이 있다. 그래야 사용한 자원(resources)이 반환되기 때문이다.

//예를들면 DataInputStream 클래스는 반드시 close()를 사용해야 하는데 close()가 예외를 발생시킨다.
//만약 DataInputStream을 사용할 때 예외처리를 했다면 
//예외 발생 여부를 떠나 반드시 close()를 해야하므로 finally에 close()를 작성을 한다.
//그런데 close()또한 예외가 발생되어서 (finally안에) try-catch문을 작성해야한다.
//이러면 복잡하기도 하고 더 안좋은것은 두곳 모두 예외가 발생하면 첫번째 예외는 무시되고 마지막 예외만 발생한다.

//이렇게 두 예외가 동시에 발생할 수는 없다는 문제점이 있는데 이를 개선하기위한게 try - with - resources 이다.
//처음 발생한 예외가 실제예외로 출력되고 
//두번째 예외는 억제된(suppressed) 예외로 다루어 출력된다. 

//try(객체생성문)
//위와 같은 형태이며 이 객체는 따로 close()를 호출하지 않아도 try문을 벗어나는 순간 자동으로 close()가 호출된다.
//*****단, AutoCloseable 인터페이스를 구현한 클래스의 인스턴스만 가능하다!! *****

class CloseableResource implements AutoCloseable{ //AutoCloseable 구현하는 클래스
	public void exceptionWork(boolean exception) throws WorkException{ 
		System.out.println("exceptionWork(" + exception + ") 가 호출됨");
		if(exception)//'참'이면 예외를 발생시킴
			throw new WorkException("WorkException발생 !!");
	}
	
	public void close() throws CloseException {
		System.out.println("close()가 호출됨");
		throw new CloseException("CloseException발생!!");
	}
}

class WorkException extends Exception {	//Exception을 상속받아 새로운 예외클래스를 정의함(사용자정의 예외)
	WorkException(String msg) {super(msg);}//생성자로 문자열을 받아와서 부모인 Exception의 생성자에게 넘겨줌
}

class CloseException extends Exception { //사용자정의 예외
	CloseException(String msg) {super(msg);}
}

public class TryWithResources {
	public static void main(String[] args) {
		try (CloseableResource cr= new CloseableResource()){
			//여기서 별도의 메소드 호출이 없어도 close()가 호출이되는데
			//딱히 close기능이 아니여도 close라는 이름을 가진 메소드면 자동으로 실행되는듯 하다. 
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================================");
		
		try(CloseableResource cr = new CloseableResource()){
			cr.exceptionWork(false);	//예외발생 안함 -> 그러나 close는 발생
		}catch(WorkException e) {
			e.printStackTrace();
		}catch(CloseException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try(CloseableResource cr = new CloseableResource()){
			cr.exceptionWork(true);	//예외발생 -> close도 같이 발생됨
		}catch(WorkException e) {
			e.printStackTrace();
		}catch(CloseException e) {
			e.printStackTrace();
		}
	}
}

























