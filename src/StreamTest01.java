import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

//다음과 같은 정수 배열이 있다.
//int[] data = {5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8};
//이 배열에서 짝수만 찾아 중복을 제거한 후에 역순으로 정렬하는 프로그램을 작성하시오.

//즉, 프로그램의 수행 결과는 다음과 같아야 한다.
//int[] result = {8, 6, 4, 2};

public class StreamTest01 {
	public static void main(String[] args) {
		int[] data = {5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8};
		
		int[] result = Arrays.stream(data)	//IntStream을 생성한다.
				.boxed()	//IntStream을 Stream<Integer>로 변경한다. 
				//(Comparator.reverseOrder와 같은 메소드는 원시타입인 int 대신 Integer를 사용해야한다.)
				.filter(i -> i%2==0)	//짝수만 걸러낸다.
				.distinct()	//중복을 제거한다.
				.sorted(Comparator.reverseOrder())	//역순으로 정렬한다.
				.mapToInt(Integer::intValue)	//Stream<Integer>를 IntStream으로 변경한다.
				.toArray();	//int[] 배열로 반환한다.
		
		for(int i:result) {
			System.out.println(i);
		}
		
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		
//		for(int i : data) {
//			if(i%2==0) list.add(i);
//		}
//		
//		HashSet<Integer> hs = new HashSet<>(list);
//		ArrayList<Integer> list2 = new ArrayList<>(hs);
//		
//		list2.sort(Comparator.reverseOrder());
//		
//		int[] result = new int[list2.size()];
//		for(int i=0; i<list2.size(); i++) {
//			result[i] = list2.get(i);
//		}
//		
//		for(int i : result) {
//			System.out.println(i);
//		}
		
	}
}
