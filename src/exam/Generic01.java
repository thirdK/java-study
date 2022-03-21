package exam;

import java.util.ArrayList;

/*
Generics란 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에 컴파일 시의 타입체크를 해주는 기능
1. 타입 안정성을 제공한다.
2. 타입체크와 형변환을 생략할 수 있으므로 코드가 간결해 진다.

class Box<T>	제네릭 타입 T를 선언. 여기서 T는 타입 변수의 T를 의미하며
ArrayList<E>	여기서 타입변수 E는 Element
Map<K, V>		여기서는 Key, Value를 의미한다.
기호 종류만 다르고 뜻은 '임의의 참조형 타입'을 의미하므로 다른 문자를 사용해도 무관하나 
가능하면 알아보기 쉽게 위와같이 사용한다.

제네릭클래스를 제네릭이 없이도 객체생성이 가능하긴 하지만 권장하지 않는다.  
 */

class Fruit implements Eatable{
	public String toString() { return "Fruit"; }
}
class Apple extends Fruit { public String toString() {return "Apple";} }
class Grape extends Fruit { public String toString() {return "Grape";} }
class Toy { public String toString() { return "Toy"; } }

interface Eatable {}

class FruitBox<T extends Fruit & Eatable> extends Box<T> {}
//제네릭 클래스 FruitBox는 타입변수에 제한이 있다.
//Fruit를 상속받아야 하며 Eatable을 구현한 타입만 대입 가능하다.
//인터페이스를 구현해야한다는 제한을 걸때도 extends를 사용하며
//위와 같이 여러 조건이 붙으면 &를 사용한다.

class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) { list.add(item); }
	T get(int i) { return list.get(i); }
	int size() { return list.size(); }
	public String toString() { return list.toString(); }
}

public class Generic01 {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<>(); //인스턴스 생성시 생성자의 타입은 생략가능
		FruitBox<Grape> grapeBox = new FruitBox<>();
//		FruitBox<Grape> grapeBox = new FruitBox<Apple>(); 타입 불일치 -> 에러
//		FruitBox<Toy> toyBox = new FruitBox<Toy>(); Toy는 FruitBox에서 명시한 타입과 불일치
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		appleBox.add(new Apple());
//		appleBox.add(new Grape());
		grapeBox.add(new Grape());
		
		System.out.println("fruitBox-" + fruitBox);
		System.out.println("appleBox-" + appleBox);
		System.out.println("grapeBox-" + grapeBox);
	}
}
























