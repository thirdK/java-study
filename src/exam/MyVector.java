package exam;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class MyVector implements List{
	Object[] data = null;	//객체를 담기위한 객체배열
	int capacity = 0;		//용량
	int size = 0;			//크기
	
	public MyVector(int capacity) {
		if(capacity < 0) {
			throw new IllegalArgumentException("유효하지 않은 값입니다. : " + capacity );
		}
		this.capacity = capacity;
		data = new Object[capacity];
	}
	
	public MyVector() {
		this(10);	//기본크기 10
	}
	
	//최소한의 저장공간(capacity)를 확보하는 메서드
	public void ensureCapacity(int minCapacity) {
		if(minCapacity - data.length > 0) {	//minCapacity가 data의 길이보다 크면
			setCapacity(minCapacity);
		}
	}
	
	public boolean add(Object obj) {
		ensureCapacity(size+1);
		data[size++] = obj;
		return true;
	}
	
	public Object get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		}
		return data[index];
	}
	
	public Object remove(int index) {
		Object oldObj = null;
		
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
		}
		
		oldObj = data[index];
		
		//삭제하고자 하는 객체가 마지막 객체가 아니라면, 배열복사를 통해 빈자리를 채워줘야 한다.
		if(index != size-1) {
			System.arraycopy(data, index+1, data, index, size-1-index);
		}
		
		//마지막데이터를 null로 바꾼다.
		data[size-1] = null;
		size--;
		return oldObj;
	}
	
	public boolean remove(Object obj) {
		for(int i=0; i<size; i++) {
			if(obj.equals(data[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void trimToSize() {
		setCapacity(size);
	}
	

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		if(this.capacity == capacity) return;
		
		Object[] tmp = new Object[capacity];
		System.arraycopy(data, 0, tmp, 0, size);
		data = tmp;
		this.capacity = capacity;
	}
	
	public boolean isEmpty() { return size == 0;}
	public int capacity() { return capacity; }
	public int size() { return size; }
	
	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		ensureCapacity(size+1);
		System.arraycopy(data, index, data, index+1, size-1-index);
		data[index] = element;
	}
	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		Object[] obj = c.toArray();
		if(obj.length == 0) return false;
		
		ensureCapacity(size + obj.length);
		if(this.size == 0) System.arraycopy(obj, 0, data, 0, obj.length);
		else System.arraycopy(obj, 0, data, size, obj.length);
		
		size += obj.length;
		return true;
	}
	@Override
	public boolean addAll(int index, Collection c) {
		// TODO Auto-generated method stub
		Object[] obj = c.toArray();
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(obj.length == 0) return false;
		
		ensureCapacity(size + obj.length);
		System.arraycopy(data, index, data, index + obj.length, size);
		System.arraycopy(obj, 0, data, index, obj.length);
		this.size += obj.length;
		
		return false;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i=0; i<size; i++) {
			data[i] = null;
		}
		this.size = 0;
	}
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		for(int i=0; i<size; i++) {
			if(data[i] == o) return true;
		}
		return false;
	}
	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		for(Object obj : c.toArray()) {
			if(!(contains(obj))) return false; 
		}
		
		return true;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ListIterator listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object set(int index, Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] a = new Object[size];
		for(int i=0; i < size; i++) {
			a[i] = data[i];
		}
		return a;
	}
	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		MyVector v = new MyVector();
		MyVector v2 = new MyVector();
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		
		v2.add(77);
		v2.add(77);
		v2.add(77);
		v2.addAll(2,v);
		
		for(int i=0; i < v.size(); i++) {
			System.out.print(v.get(i) + " "); ;
		}
		System.out.println();
		
		for(int i=0; i < v2.size(); i++) {
			System.out.print(v2.get(i) + " "); ;
		}
		System.out.println();
		
		System.out.println(v.containsAll(v2));
	}
}
