package exam;

import javax.swing.JOptionPane;

public class Thread03 {
	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); //1초
			}catch(Exception e){}
		}
		
		//싱글 쓰레드는 위와 같이 값을 입력받아야 i가 출력된다.
		//=======================================================================
		//멀티 쓰레드는 아래와 같이 메인쓰레드와 별개로 실행된다.
		Thread03_1 th1 = new Thread03_1();
		th1.start();
		
		String input2 = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input2 + "입니다.");
		
	}
	
}

class Thread03_1 extends Thread {
	public void run() {
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				sleep(1000);
			}catch(Exception e) {}
		}
	}
}