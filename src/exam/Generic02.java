package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Fruit2 {
	String name;
	int weight;
	
	Fruit2(String name, int weight){
		this.name = name;
		this.weight = weight;
	}
	
	public String toString() { return name + "(" + weight + ")"; }
}

class Apple2 extends Fruit2 {
	Apple2(String name, int weight){
		super(name, weight);
	}
}

class Grape2 extends Fruit2 {
	Grape2(String name, int weight){
		super(name, weight);
	}
}

//Comparator구현

//static <T> void sort(List<T> list, Comparator<T> c) 라면
//아래와 같이 일일이 구현을 해줘야한다.
class AppleComp implements Comparator<Apple2>{
	public int compare(Apple2 t1, Apple2 t2) {
		return t2.weight - t1.weight;
	}
}

class GrapeComp implements Comparator<Grape2>{
	@Override
	public int compare(Grape2 o1, Grape2 o2) {
		return o2.weight - o1.weight;
	}
}
//여기서 Collections.sort()에 사용할 Comaprator를 구현하는데 
//Collections.sort()는 다음과 같이 정의되어 있다.

//static <T> void sort(List<T> list, Comparator<? super T> c)

//즉, 부모타입까지 포함시키므로 위와 같이 두개로 나누어서 만들필요가 없고
//아래와 같이 부모클래스인 Fruit2타입으로 한번만 구현하면 자식인 Grape2, Apple2모두 사용이가능하다.
//이부분이 헤깔리는데 아래처럼 생각해보면된다.

//Apple2가 대입되면 다음과 같다.
//static void sort(List<Apple2> list, Comparator<? super Apple2> c) 
//												 ? 는 Apple2에서 조상까지 허용

//Collections.sort(appleBox.getList(), new FruitComp()); 
//					(Apple2의 인스턴스, 부모타입으로 정의한 Comparator(를 구현한 클래스 인스턴스))
//===============================================================================

class FruitComp implements Comparator<Fruit2>{
	@Override
	public int compare(Fruit2 o1, Fruit2 o2) { //여기만 구분을 위해 오름차순
		return o1.weight - o2.weight;
	}
}

class FruitBox2<T extends Fruit2> extends Box2<T>{}

class Box2<T>{
	ArrayList<T> list = new ArrayList<T>();
	
	void add(T item) {
		list.add(item);
	}
	
	T get(int i) {
		return list.get(i);
	}
	
	ArrayList<T> getList() { return list; }
	
	int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
	
}

public class Generic02 {
	public static void main(String[] args) {
		FruitBox2<Apple2> appleBox = new FruitBox2<>();
		FruitBox2<Grape2> grapeBox = new FruitBox2<>();
		
		appleBox.add(new Apple2("GreenApple", 300));
		appleBox.add(new Apple2("GreenApple", 100));
		appleBox.add(new Apple2("GreenApple", 200));
		
		grapeBox.add(new Grape2("GreenGrape", 400));
		grapeBox.add(new Grape2("GreenGrape", 300));
		grapeBox.add(new Grape2("GreenGrape", 200));
		
		Collections.sort(appleBox.getList(), new AppleComp());
		Collections.sort(grapeBox.getList(), new GrapeComp());
		System.out.println(appleBox);
		System.out.println(grapeBox);
		System.out.println();
		Collections.sort(appleBox.getList(), new FruitComp());
		Collections.sort(grapeBox.getList(), new FruitComp());
		System.out.println(appleBox);
		System.out.println(grapeBox);
		
	
	}
}


































