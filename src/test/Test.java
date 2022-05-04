package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		list.add(8);
		list.add(1);
		int[] a = list.stream().mapToInt(Integer::intValue).toArray();
		Object[] arr = list.toArray();
		Integer[] arr2 = list.toArray(Integer[]::new);
		Integer[] arr3 = list.toArray(new Integer[list.size()]);
		for(Integer i : arr2) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(Integer i : arr3) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for(Object i : arr) {
			System.out.println(i);
		}
		
		for(int i : a) {
			System.out.println(i);
		}
		System.out.println(list.get(0).getClass().getName());
		System.out.println(list.get(0) + list.get(2)); 
		
	}
}

