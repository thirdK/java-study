package exam;



public class Test {
	public static void main(String[] args) {
		Game game = new Game();
		
		for(int i=1; i<=100; i++) {
			System.out.print(game.check1(i) + "\t");
			if(i % 10 == 0) System.out.println();
		}
	}
}

class Game{
	//1번
	String check1(int num) {
		int n = num;
		String answer = "";
		while(n != 0) {
			if(n%10 != 0 && (n%10)%3==0)
				answer += "짝";
			n /= 10;
		}
		
		if(answer.equals("")) return String.valueOf(num);
		
		return answer;
	}
	
	//2번
	String check2(int num) {
		String answer = "";
		
		int x = num/10;
		int y = num%10;
		
		if(x != 0 && x%3 == 0) answer+="짝";
		if(y != 0 && y%3 == 0) answer+="짝";
		
		if(answer.equals("")) return String.valueOf(num);
		
		return answer;
	}
}

























