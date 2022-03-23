package exam;

/*
 * 열거형 메소드
 * 아래와 같이 운송수단 종류 별로 상수를 정의하고 각 운송수단의 기본요금 BASIC_FARE가 책정돼 있다고 했을때
 * 기본요금 뿐만 아니라 거리에 따라 요금을 계산하는 방식을 각 운송수단 별로 다르게 만들때 사용한다.(아래예제는 동일하게 만듬)
 * 
 * 사용방법은 열거형 추상메서드를 만들고 각 상수별로 구현하면된다. -> 익명클래스처럼
 * 
 */
enum Transportation{
	BUS(100)	{ int fare(int distance) {return distance*BASIC_FARE;}},//열거형 메소드 구현
	TRAIN(150)	{ int fare(int distance) {return distance*BASIC_FARE;}},
	SHIP(100)	{ int fare(int distance) {return distance*BASIC_FARE;}},
	AIRPLANE(300){ int fare(int distance) {return distance*BASIC_FARE;}};
	
	protected final int BASIC_FARE;
	private Transportation(int basicFare) {
		BASIC_FARE = basicFare;
	}
	
	public int getBasicFare() {return BASIC_FARE;}
	
	abstract int fare(int distance);	//거리에 따른 요금계산
}

public class Enum02 {
	public static void main(String[] args) {
		System.out.println("bus fare=" + Transportation.BUS.fare(100));
		System.out.println("train fare=" + Transportation.TRAIN.fare(100));
		System.out.println("ship fare=" + Transportation.SHIP.fare(100));
		System.out.println("airplane fare=" + Transportation.AIRPLANE.fare(100));
	}
}
