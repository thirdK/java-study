package exam;

public class Thread02 {
	static long startT = 0;
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("-")); //속도를 늦추기위해 new String()사용
		}
		
		System.out.print("소요시간 : " + (System.currentTimeMillis() - startTime));
		
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("|"));
		}
		
		System.out.print("소요시간 : " + (System.currentTimeMillis() - startTime));
		
		System.out.println();
		System.out.println();
		System.out.println();
		//============================================================================
		//멀티쓰레드
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		startT= System.currentTimeMillis();
		
		for(int i=0; i<300; i++) {
			System.out.printf("%s", new String("-"));
			if(i%50 == 0) System.out.println();
		}
		System.out.println("소요시간3 : " + (System.currentTimeMillis() - Thread02.startT));
	}
}

class ThreadEx5_1 extends Thread {
	public void run() {
		for(int i=0; i < 300; i++) {
			System.out.printf("%s", new String("|"));
			if(i%50 == 0) System.out.println();
		}
		System.out.println("소요시간 4 : " + (System.currentTimeMillis() - Thread02.startT));
	}
}
