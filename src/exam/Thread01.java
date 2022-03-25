package exam;

class ThreadEx2_1 extends Thread {
	@Override
	public void run() {	
		throwException();
	}
	
	public void throwException() {	//예외발생 시키는 메서드
		try {		
			throw new Exception();	//예외의 발생지점을 확인해보자
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
//printStackTrace()를 이용하여 예외가 발생한 당시의 호출스택을 출력함
//run메서드가 출력됨
//한 쓰레드가 예외 발생하여 종료되도 다른 쓰레드의 실행에는 영향을 주지 않음
public class Thread01 {
	public static void main(String[] args) {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		t1.start();
		//한 번 실행이 종료된 쓰레드는 다시 실행할 수 없다.
		//한 번 더 수행하려면 새로운 쓰레드를 생성해야한다....
		//t1 = new ThreadEx2_1(); -> 재생성
	}
}
//start는 새 콜스택을 만들어서 run을 호출함 만약 start()가 아닌 run()을 호출한다면????
//run()을 호출하는 것은 생성된 쓰레드를 실행시키는게 아니라 단순히 클래스에 선언된 메서드를 호출할 뿐임

//모든 쓰레드는 독립적인 작업을 수행하기 위해 자신만의 호출스택이 필요함
//새 쓰레드를 생성하고 실행시킬 때마다 새 호출스택이 생성되고 쓰레드가 종료되면 작업에 사용된 호출스택이 소멸됨

//1개의 스택에서 가장 위에 있는 메서드가 실행중인 메서드이며 나머지 메서드는 대기 상태이다
//새 쓰레드가 만들어져서 여러개의 쓰레드가 만들어지면(main쓰레드를 제외하고 1개이상의 호출스택이 추가로 생성되면)
//최상위 메서드라도 대기상태에 있을 수 있다.
//쓰레드의 실행순서는 OS의 스케쥴러가 작성한 스케쥴에 의해 결정된다. 결정된 순서에 따라 실행 순서와 실행 시간을 결정하고
//각 쓰레드들은 자신의 순서가되면 지정된 시간동안 작업을 수행하며 작업을 마치지 못하면 다시 자신의 순서가 올때까지 대기한다.


