package exam;

import java.util.Comparator;
import java.util.stream.Stream;

public class Stream02 {
	public static void main(String[] args) {
		//Stream.of는 가변인자, 배열을 이용하여 스트림을 생성할때 사용하는 메서드이다.
		Stream<Student> studentStream = Stream.of(
				new Student("이자바", 3, 300),
				new Student("김자바", 1, 200),
				new Student("안자바", 2, 100),
				new Student("박자바", 2, 150),
				new Student("소자바", 1, 200),
				new Student("나자바", 3, 290),
				new Student("감자바", 3, 180)
				);
		studentStream.sorted(Comparator.comparing(Student::getBan)//반별 정렬
				.thenComparing(Comparator.naturalOrder()))//기본 정렬
		.forEach(System.out::println);
		//JDK1.8부터 추가된 Comparator 인터페이스의 default메서드와 static메서드가 있다
		//comparing은 그중 하나이며 유용하게 쓰일듯 하니 기억하자.
		//thenComparing은 정렬 조건을 추가할 때 사용한다.
	}
}

class Student implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;
	
	Student(String name, int ban, int totalScore){
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]", name , ban, totalScore);
	}
	
	String getName() { return name; }
	int getBan() { return ban; }
	int getTotalScore() { return totalScore; }
	
	//총점 내림차순을 기본정렬로 한다.
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}
