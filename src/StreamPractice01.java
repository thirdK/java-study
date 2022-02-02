

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamPractice01 {
	public static void main(String[] args) {
		int[] arr = {1,1,10,2,5,30,4,2};	//stream 없이 배열의 중복 값을 없에고 내림차순으로 정렬해보자
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		
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
		
		
		
	}
}











































