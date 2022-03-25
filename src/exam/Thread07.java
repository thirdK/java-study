package exam;

/*
 * 쓰레드의 동기화
 * 멀티 쓰레드 프로세스는 여러 쓰레드가 같은 프로세스 내의 자원을 공유해서 작업하기 때문에 서로의 작업에 영향을 주게된다.
 * 만약 쓰레드A가 작업하던 도중에 쓰레드B에게 제어권이 넘어갔을 때 쓰레드 A가 작업하던 공유데이터를 쓰레드B가 임의로
 * 변경한다면 다시 쓰레드A가 제어권을 받아서 나머지 작업을 마쳤을 때 원래 의도한 결과와 다른 결과를 얻을 수 있다.
 * 
 * 이러한 일이 발생하지 않도록 한 쓰레드가 특정 작업을 끝마치기 전까지 다른 쓰레드에 의해 방해받지 않도록 하는 것이 필요하다.
 * 그래서 도입된 개념이 바로 '임계 영역(critical section)'과 '잠금(lock)'이다.
 * 공유 데이터를 사용하는 코드 영역을 임계 영역으로 지정해놓고, 공유 데이터(객체)가 가지고 있는 lock을 획득한
 * 하나의 쓰레드만 이 영역 내의 코드를 수행할 수 있게 한다. 그리고 해당 쓰레드가 임계 영역 내의 모든 코드를 수행하고 
 * 벗어나서 lock을 반납해야만 다른 쓰레드가 반납된 lock을 획득하여 임계 영역의 코드를 수행할 수 있게 된다.
 * 
 * 이처럼 한 쓰레드가 진행 중인 작업을 다른 쓰레드가 간섭하지 못하도록 막는 것을 '쓰레드의 동기화(synchronization)'
 * 이라고 한다.
 * 
 * synchronized 키워드를 사용한 동기화
 * 
 * 1. 메서드 전체를 임계 영역으로 지정
 * 		public synchronized void test(){}
 * 2. 특정 영역을 임계 영역으로 지정
 * 		synchronized(객체의 참조변수){}
 * 		이때 참조변수는 락을 걸고자하는 객체를 참조하는 것이어야 한다.
 * 
 * 두 방법다 lock의 획득과 반납이 자동으로 이루어 지므로 우리는 임계영역만 설정해주면 된다.
 * 
 * 모든 객체는 lock을 하나씩 가지고 있으며, 해당 객체의 lock을 가지고 있는 쓰레드만 임계영역의 코드를 수행할 수 있다.
 * 
 */

public class Thread07 {
	public static void main(String[] args) {
		Runnable r = new Runnable07();
		new Thread(r).start();	//ThreadGroup에 의해 참조되므로 gc대상이 아니다.
		new Thread(r).start();
	}
}

class Account {
	private int balance = 1000;	//잔고
	//private으로 해야 동기화에 의미가있다...
	//외부에서 직접접근을 안막으면 의미가 없다.

	public int getBalance() {
		return balance;
	}
	
	//public void synchronized void withdraw(int money)
	public void withdraw(int money) {
		synchronized (this) {
			if (balance >= money) {	
				try {
					Thread.sleep(1000);	//일부러 if문을 통과하자마자 다른 쓰레드에게 제어권을 넘기도록
				} catch (InterruptedException e) {}
				balance -= money;
			}
		}
		//잔고보다 인출하려는 금액이 적으면 실행되는 조건이지만 잔고가 -가 된다.
		//이유는 다른쓰레드가 중간에 끼어들어서 출금을 먼저 했기 때문이다.
		//잔고를 확이하는 if문과 출금하는 문장은 하나의 임계 영역으로 묶여져야 한다.
		//synchronized 블럭을 사용했다. 이경우는 블럭과 메소드 둘다 같으므로 메서드를 사용하는게 더 낫다고함
	}
}

class Runnable07 implements Runnable {
	Account acc = new Account();

	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			//100, 200, 300중의 한 값을 임의로 선택해서 출금(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance: " + acc.getBalance());
		}
	}
}


















