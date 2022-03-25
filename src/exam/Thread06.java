package exam;

public class Thread06 {
	public static void main(String[] args) {
		Thread06_1 th1 = new Thread06_1();
		Thread06_2 th2 = new Thread06_2();
		
		th1.start();
		th2.start();
		
		try {
			th1.sleep(2000);	 
		} catch(InterruptedException e) {}
		//쓰레드1을 2초 지연시켰지만 여전히 쓰레드1이 가장 먼저 종료된다.
		//이유는 sleep()이 항상 현재 실행중인 쓰레드에 대해 작동하기 때문에 th1.sleep(2000)을 호출해도
		//실제 영향을 받은 쓰레드는 main메서드를 실행하는 main쓰레드이기 때문이다.
		//그래서 sleep()은 static으로 선언되어 있으며 참조변수를 이용해서 호출하기 보다는
		//Thread.sleep()과 같이 사용해야 한다.
		
		System.out.println("<<main 종료>>");
	}
}

class Thread06_1 extends Thread {
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("-");
			if(i%30 == 0) System.out.println();
		}
		System.out.print("<<th1 종료>>");
	}
}

class Thread06_2 extends Thread {
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print("|");
			if(i%30 == 0) System.out.println();
		}
		System.out.print("<<th2 종료>>");
	}
}
