package exam;

/*
 * 데몬 쓰레드(daemon thread)
 * 작업을 돕는 보조적인 역할을 수행하는 쓰레드이며 일반쓰레드가 모두 종료되면 데몬 쓰레드는 강제적으로 자동 종료됨
 * boolean isDaemon() -> 쓰레드가 데몬 쓰레드인지 확인
 * void setDaemon(boolean on) -> 쓰레드를 데몬 쓰레드 또는 사용자 쓰레드로 변경함
 * 								 매개변수 on의 값을 true로 지정하면 데몬 쓰레드가 된다.
 */

public class Thread05 implements Runnable{
	static boolean autoSave =false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new Thread05());
		t.setDaemon(true);	//이부분이 없으면 종료되지 않는다.
		t.start();	//여기서 start()메서드를 호출하여 쓰레드 실행됨
		//setDaemon()메서드는 당연히 start()메서드보다 먼저 호출해야한다.
		
		for(int i=1; i<=10; i++) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			System.out.println(i);	// -> 1초마다 i출력
			
			if(i==5) autoSave = true; // -> i가 5면 autoSave를 true로 변경
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(3*1000); //3초마다
			} catch(InterruptedException e) {}
			
			if(autoSave) { //3초마다 작동하지만 autoSave를 조건으로 두어서 true가 되야 아래 메서드가 실행됨
				autoSave();
			}
		}
		//run()은 동작하게되면 쓰레드 종료시점이 존재하지 않아서 무한히 반복될 것이다.
		//하지만 이 쓰레드는 데몬 쓰레드 이므로 이 쓰레드를 제외한 일반쓰레드가 종료되면 데몬쓰레드도 자동 종료된다.
		//이 예제에서 존재하는 일반쓰레드는 main쓰레드다.
	}
	
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}
