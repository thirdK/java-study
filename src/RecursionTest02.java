
public class RecursionTest02 {

	public static void main(String[] args) {
		RecursionTest02 t = new RecursionTest02();
		System.out.println(t.fac1(5, 1, 1)); 
		
		int total=1;
		for(int i=1; i<6; i++) {
			total *= i;
		}
		System.out.println(total);
		
		System.out.println(t.fac2(5));
		
		System.out.println(t.path(1));
	}
	
	
	int fac1(int n, int i, int p) {
		if(i>n) return p;
		return fac1(n,i+1,p*i);
	}
	
	int fac2(int n) {
		if(n==1) return 1;
		return n*fac2(n-1);
	}
	
//	1 2 4 = 7 13
	int path(int n) {
		if(n<0) return 0;
		if(n==0 || n==1) return 1;
		
		return path(n-3) + path(n-2) + path(n-1);
	}
}
