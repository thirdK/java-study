package practice;

class Node1{
	int data;
	Node1 link= null;
}

class Llist1{
	Node1 header;
	public Llist1() {
		header = new Node1();
	}
	
	void append(int d) {
		Node1 n = new Node1();
		Node1 p = header;
		n.data = d;
		
		while(p.link != null) {
			p = p.link;
		}
		p.link = n;
	}
	
	void retrieve(){
		Node1 p = header.link;
		
		while(p.link != null) {
			System.out.print(p.data + " -> ");
			p = p.link;
		}
		System.out.println(p.data);
	}
}

public class Test {
	public static void main(String[] args) {
//		Llist1 l1 = new Llist1();
//		Node1 n = new Node1();
//		n.data = 77;
//		n = null;
//		System.out.println(n.link);
//		
//		
//		l1.append(1);
//		l1.append(2);
//		l1.append(3);
//		
//		l1.retrieve();
		
		String s1 = "aa";
		String s2 = "aa";
		String s3 = new String("aa");
		
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		
		s1="bb";
		System.out.println(s1+", "+s2);
		
		Integer num = new Integer(1); //박싱
		System.out.println(num);
		
		int n = num.intValue();//언박싱
		System.out.println(n);
		
		Integer num2 = 10; //오토박싱
		int n2 = num2; //오토 언박싱
		
		System.out.println(num2 + ", " + n2);
		
		String str = "10";
		String str1 = "10.5";
		String str2 = "true";
		
		int nn = Integer.parseInt(str);
		double dd = Double.parseDouble(str1);
		boolean isB = Boolean.parseBoolean(str2);
		
		System.out.println(nn + ", " + dd + ", " + isB);
		
		System.out.println(str.getClass().getName()); 
	}
}



















