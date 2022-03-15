package exam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Date_Format01 {
	public static void main(String[] args) {
		String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern);
		//DateFormat클래스는 추상클래스이며 SimpleDateFormat의 부모 클래스이다.
		//추상 클래스이기 때문에 인스턴스 생성이 불가능하며 완전하게 구현한 
		//SimpleDateFormat으로 인스턴스 구현이 가능하다.
		//getDateInstance() 메서드를 사용하여 인스턴스를 가져와도 SDF인스턴스가 반환된다.
		
		Scanner sc = new Scanner(System.in);
		
		Date inDate = null;
		
		System.out.println("날짜를 " + pattern + "의 형태로 입력해주세요");
		
		while(sc.hasNextLine()) { // 다음에 입력받을 라인이 있다면
			try {
				inDate = df.parse(sc.nextLine());
				//parse는 SDF의 조상인 DF에 정의되어 있으며 지정된 형식과 입력된 형식이 일치하지 않으면
				//예외가 발생한다. 예외가 발생하면 break에 도달하지 못하므로 while을 빠져나갈 수 없다.
				
				//parse는 parseInt와 같이 String타입을 해당 데이터 타입으로(여기서는 DF) 변환해줌 
				break;
			} catch(Exception e) {
				System.out.println("날짜를 " + pattern + "의 형태로 다시 입력해주세요.");
			}
		}
		
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(inDate);
		Calendar today = Calendar.getInstance();
		long day = ((cal.getTimeInMillis() - today.getTimeInMillis())/(60*60*1000));
		System.out.println("입력하신 날짜는 현재와 " + day + "시간 차이가 있습니다.");
	}
}
























