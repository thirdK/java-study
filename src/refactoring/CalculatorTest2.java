package refactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest2 {
	private Calculator cal;
	
	@Before
	public void setup() {
		cal = new Calculator();
		System.out.println("Before");
	}
	
	@Test		//Test어노테이션을 사용해야 메소드가 실행이된다.
	public void add() {
//		System.out.println(cal.add(6, 3));
		assertEquals(9, cal.add(6, 3));	
		//assertEquals()를 사용하면 콘솔창 확인 안하고 원하는 값이 나오는지 확인 가능하다.
		//빠르고 편함
		System.out.println("add");
	}
	
	@Test
	public void subtract() {
//		System.out.println(cal.subtract(6, 3));
		assertEquals(3, cal.subtract(6, 3));
		System.out.println("subtract");
	}
	
	@After
	public void teardown() {
		System.out.println("teardown");
	}
}
