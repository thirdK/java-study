package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream01 {
	public static void main(String[] args) {
		int[] arr = {6,3,7,1,4,6,8,22,5,2,16,9,14};
		Arrays.stream(arr)
		.boxed()
		.distinct()
		.sorted(Comparator.reverseOrder())
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		List<Integer> list = new ArrayList<Integer>();
		
		
		Stream<Integer> st = Arrays.stream(arr).boxed();
		
		st = list.stream();
		System.out.println();
		System.out.println();
		IntStream.range(0, 20).filter(i -> i%2==0).forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.println();
		IntStream.rangeClosed(0, 20) //range와 다르게 end범위를 포함한다.(20포함)
		.filter(i -> i%2==0)	//필터는 필요에따라 여러번 사용가능 (중간연산이니까)
		.skip(3) 	//처음 3개 건너뜀
		.limit(5) 	//앞에서 10개만 뽑음 
		.forEach(i -> System.out.print(i + " "));
		//skip과 limit을 사용하여 범위를 4~8까지로 줄인것(숫자가 아니라 처리범위를 줄인것)
	}
}






















