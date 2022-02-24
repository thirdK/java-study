

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice01 {
	public static void main(String[] args) {
		int[] arr = {1,1,10,2,5,30,4,2};	//stream 없이 배열의 중복 값을 없에고 내림차순으로 정렬해보자
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		Iterator<Integer> iter = set.iterator();
		
		for(int i=0; iter.hasNext(); i++) {
			list.add(iter.next());
		}
		
		list.sort(Comparator.reverseOrder());
		
		System.out.println("stream()을 사용하지 않고 출력 : " + list.toString());
//		=======================================================================================================
		//stream() 을 사용해보자
		
		System.out.println("Stream()을 사용한 출력 " + 
				Arrays.stream(arr).boxed()			//Stream 생성
				.distinct()							//중복제거
				.sorted(Comparator.reverseOrder())	//역정렬
				.collect(Collectors.toList()) );	//List로 반환
		
//		Stream은 선언 -> 가공 -> 반환의 순서로 이루어진다.
		
//		Stream을 선언하는 방법들
//		Stream<데이터타입> stream명 = Arrays.stream(배열명);		//배열을 스트림으로
//		Stream<데이터타입> stream명 = 리스트명.stream();			//collection을 스트림으로
//		Stream<데이터타입> stream명 = Stream.of('값', '값'....);//직접 값을 넣어 스트림으로
//		꼭 stream을 선언한 후 값을 넣고 사용하는 것이 아니라
//		Arrays.stream(배열명).가공메소드...
//		리스트명.stream.가공메소드...
//		이런 식으로 바로 사용해도 된다
		System.out.println("==================================================================");
		System.out.println("count() 배열, 컬렉션 크기 확인");
		System.out.println(Arrays.stream(arr).count());
		System.out.println(list.stream().count());
		System.out.println();
		System.out.println("sorted() 정렬");
		System.out.println(Arrays.stream(arr).boxed().sorted().collect(Collectors.toList()));
		System.out.println(list.stream().sorted().collect(Collectors.toList()));
		System.out.println();
		System.out.println("sorted(Comparator.reverseOrder() 역정렬");
		System.out.println(Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
		
		
		System.out.println();
		System.out.println("==================================================================");
		//Stream 연습
		System.out.print("스트림 연습 >> ");
		IntStream.range(1,11).filter(i->i%2 == 0).forEach(System.out::println);
				
		//500이상의 숫자중 짝수이면서 5의 배수인 수의 합
		System.out.println("스트림 연습 >> "+IntStream.range(0, 1001).skip(500).filter(i -> i%2==0).filter(i -> i%5==0).sum());		
		
	}
}











































