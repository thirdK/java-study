package exam;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream03 {
	public static void main(String[] args) {
		Student3[] stuArr = {
				new Student3("이자바", 3, 300),
				new Student3("김자바", 1, 200),
				new Student3("안자바", 2, 100),
				new Student3("박자바", 2, 150),
				new Student3("소자바", 1, 200),
				new Student3("나자바", 3, 290),
				new Student3("감자바", 3, 180),
		};
		Stream<Student3> stuStream = Stream.of(stuArr);
		
		stuStream.sorted(Comparator.comparing(Student3::getBan)
				.thenComparing(Comparator.naturalOrder()))
		.forEach(System.out::println);;
		
		stuStream = Stream.of(stuArr);	//스트림 재생성;
		IntStream stuScoreStream = stuStream.mapToInt(Student3::getTotalScore);
		
		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();	
		//스트림은 최종연산을 여러번 할 수 없으므로 IntStream(primitive자료형 Stream)에서 
		//summaryStatistics()라는 메서드를 제공하는데 이메서드는 해당 자료형에 맞는 SummaryStatistics로 변환해줌
		//IntSummaryStatistics라는 클래스는 아래와 같은 메서드를 제공하며 여러차레 최종연산이 가능함
		//(사실상 스트림은 아니고 스트림을 변환해서 받아오는거니까 소모가 안되는거 같다.)
		System.out.println("count = " + stat.getCount());
		System.out.println("sum = " + stat.getSum());
		System.out.printf("average = %.2f\n", stat.getAverage());
		System.out.println("min = " + stat.getMin());
		System.out.println("max = " + stat.getMax());
	}
}

class Student3 implements Comparable<Student3>{
	String name;
	int ban;
	int totalScore;
	
	public Student3(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
	}
	
	String getName() {return name;}
	int getBan() { return ban; }
	int getTotalScore() { return totalScore; }
	
	public int compareTo(Student3 s) {
		return s.totalScore - this.totalScore;
	}
	
}