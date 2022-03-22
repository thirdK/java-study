package exam;

//열거형
//열거형은 서로 관련된 상수를 편리하게 선언하기 위한 것이다.
//여러 상수를 정의할 때 사용하면 유용한다.
//자바의 열거형은 값이 같아도 타입이 다르면 다른것으로 취급한다.
//enum Kind{C, D}		enum Value{E, F}
//Kind.C 와 같이 사용한다.
// == 로 비교가 가능하나 다른 비교연산자는 사용이 불가능하여 compareTo()를 사용한다.

enum Direction{
	//열거형 상수의 값은 ()안에 적어준다. 여러개의 값을 가질때는 아래와 같이 적어준다.
	EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH(4, "^");
	
	private static final Direction[] DIR_ARR = Direction.values();
	//values()는 열거형의 모든 상수를 배열에 담아 반환함 -> 컴파일러가 자동으로 추가해준 메서드
	private final int value;	//반드시 final이여야 할 필요는 없지만 열거형 상수의 값을 저장하므로...
	private final String symbol;
	
	//열거형 상수에 값을 지정했다면 반드시 지정된 값을 저장할 인스턴스 변수와 (위의 value, symbol)
	//생성자를 새로 추가해 주어야 한다.
	Direction(int value, String symbol) {	//생성자가 있지만 외부에서 사용할 수 없다(자동으로 private)
		this.value = value;
		this.symbol = symbol;
	}
	
	//열겨형 상수의 값을 가져올 수 있도록 getter을 정의한다.
	public int getValue() {return value;}
	public String getSymbol() {return symbol;}
	
	public static Direction of(int dir) {
		if(dir < 1 || dir > 4) {
			throw new IllegalArgumentException("Invalid value : " + dir);
		}
		return DIR_ARR[dir-1];
	}
	// 방향을 회전시키는 메서드. num의 값만큼 90도씩 시계방향으로 회전한다.
	public Direction rotate(int num) {
		num = num % 4;
		
		if(num < 0) num += 4;	// num이 음수일 때는 시계반대 방향으로 회전
		
		return DIR_ARR[(value-1+num) % 4];
	}
	
	public String toString() {
		return name() + " " + getSymbol();
	}
}

public class Enum01 {
	public static void main(String[] args) {
		for(Direction d : Direction.values()) {
			System.out.printf("%s = %d\n", d.name(), d.getValue());
			//name()은 열거형 상수의 이름을 문자열로 반환
			//getValue()는 위에서 만든 getter
		}
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.of(1);
		
		System.out.printf("d1=%s, %d\n", d1.name(), d1.getValue());
		System.out.printf("d2=%s, %d\n", d2.name(), d2.getValue());
		System.out.println(Direction.EAST.rotate(1));
		System.out.println(Direction.EAST.rotate(2));
		System.out.println(Direction.EAST.rotate(-1));
		System.out.println(Direction.EAST.rotate(-2));
	}
}
























