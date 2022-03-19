package exam;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;

public class Queue01 {
	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		
		while(true) {
			System.out.print(">>");
			try {
				//화면으로 부터 라인단위로 입력받는다.
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine().trim();
				
				if("".equals(input)) continue;	//아무 입력도 없었으면 재반복(다시입력)
				if(input.equalsIgnoreCase("q")) {//q입력시 종료
					System.exit(0);
				}else if(input.equalsIgnoreCase("help")) {//help입력시 도움말
					System.out.println("help - 도움말을 보여줍니다.");
					System.out.println("q 또는 Q - 프로그램을 종료합니다.");
					System.out.println("history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
				}else if(input.equalsIgnoreCase("history")) { //history도 명령어로 저장
					int i=0;
					// 입력받은 명령어를 저장하고
					save(input);
					
					//LinkedList의 내용을 보여준다.
					LinkedList tmp = (LinkedList)q;//Queue는 인터페이스이고 Queue를 구현한 LL로 다운캐스팅
					ListIterator it = tmp.listIterator(); //ListIterator 생성
					//Iterator와 다른점은 양방향 기능이 추가되었다는 것
					
					while(it.hasNext()) {
						System.out.println(++i + "." + it.next());
					}
				} else {//그 외 모든 입력 명령어로 저장
					save(input);
					System.out.println(input);
				} 
			} catch(Exception e) {
				System.out.println("입력오류입니다.");
			}
		}
	}
	
	public static void save(String input) {
		//queue에 저장한다.
		if(!"".equals(input)) {//뭐라도 입력했으면
			q.offer(input);	//큐 인스턴스 q에 추가
		}
		
		
		//queue의 최대 크리를 넘으면 제일 처음 입력된 것을 삭제한다.
		if(q.size() > MAX_SIZE) { //사이즈가 넘어가면
			q.remove();	//가장 먼저 입력된것을 날려버림
		}
	}
}
