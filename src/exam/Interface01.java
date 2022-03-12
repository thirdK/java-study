package exam;

interface Repairable {} //인터페이스 생성 (따로 멤버를 정의하지는 않음)

class Unit{
	int hitPoint;
	final int MAX_HP;
	public Unit(int hp) {
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit{
	public GroundUnit(int hp) {
		super(hp);
	}
}

class AirUnit extends Unit{
	AirUnit(int hp){
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable{//인터페이스 구현으로 클래스를 묶어줌
	Tank() {
		super(150);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "Tank";
	}
}

class Dropship extends AirUnit implements Repairable{
	Dropship() {
		super(125);
		hitPoint = MAX_HP;
	}
	public String toString() {
		return "Dropship";
	}
}
class Marine extends GroundUnit{
	Marine() {
		super(40);
		hitPoint =  MAX_HP;
	}
}

class SCV extends GroundUnit implements Repairable{
	SCV(){
		super(60);
		hitPoint =  MAX_HP;
	}
	
	void repair(Repairable r) {//인터페이스 구현으로 묶여있는 클래스타입을 매개변수로 받을 수 있음
		//하지만 인터페이스에는 아무것도 정의되어있지 않으므로 r이라는 참조변수는 아무 기능도 사용할 수 없음
		//그래서 instanceof를 사용하여 Unit인지 확인하고
		if(r instanceof Unit) {
			Unit u = (Unit) r; //Unit으로 캐스팅을 해줌
			while(u.hitPoint != u.MAX_HP) {
				u.hitPoint++;
			}
			System.out.println(u.toString() + "의 수리가 끝났습니다.");
		}
	}
}

/*
인터페이스로 멤버를 정의한다고 가정하면 우선 위와 같이 대상 클래스들을 implements로 연결시키고
실질적으로 구현을 할 새로운 클래스를 만들어준다.
구현한 클래스를 다른클래스에 [포함]시켜서 인터페이스에서 정의한 맴버들을 완성시켜준다.

interface Liftable { //멤버를 정의한 인터페이스
	//public abstract는 생략되었음
	void liftOff();
	void move(int x , int y);
	void stop();
	void land();
}

class LiftableImpl implements Liftable{//멤버들을 구현하는 클래스
	public void liftOff(){내용...}
	public void move(int x , int y){내용...}
	public void stop(){내용...}
	public void land(){내용...} 
}

class Barrack extends Building implements Liftable{	//기능을 가져야하는 클래스도 인터페이스를 구현하는데
	LiftableImpl l = new LiftableImpl();	//포함관계를 이용하여 구현함
	void liftOff() {l.liftOff();}	//실질적으로 구현된 클래스의 인스턴스로 구현해줌
	void move(int x , int y) {l.move(x,y)}
	void stop(){l.stop()}
	void land(){l.land}
}


*/
public class Interface01 {
	
	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		Marine marine = new Marine();
		SCV scv = new SCV();
		scv.repair(tank);
		scv.repair(dropship);
		
	}
	
}


























