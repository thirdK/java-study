package exam;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//Date클래스는 JDK1.0부터 제공되어 왔고 그당시에 기능이 부족하여 만든게 JDK1.1의 Calendar이다.
//사실 JDK1.8에서 java.time 패키지로 기존의 단점을 개선하여 새로운 클래스를 추가하였으나.
//Date, Calendar는 오랫동안 사용되어 왔고 지금도 많이 사용되므로 알고 있어야한다.

//Calendar는 추상클래스이기 때문에 직접 객체 생성이 불가능하다. 
//메소드를 통해서 완전 구현된 클래스의 인스턴스를 얻어야한다.
//Calendar cal = new Calendar(); <--에러 getInstance()메소드를 사용해야함

//완전히 구현된 클래스는 두 종류이다. GregorianCalendar(전세계공통), BuddhistCalender(태국만)
//getInstance()는 국가와 지역설정을 확인하여 위의 두개중 1가지의 인스턴스를 반환한다.
//즉 Calendar car = new GregorianCalendar();가 가능하다. (그냥 getInstance()메서드 쓰자)

public class Date_Calendar {
	public static void main(String[] args) {
		//Calendar -> Date
		Calendar cal1 = Calendar.getInstance();	//기본적으로 현재날짜와 시간으로 설정됨
		Date d1 = new Date(cal1.getTimeInMillis()); //Date(long date)
		
		//Date -> Calendar
		Date d2 = new Date();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(d2);
		
		
		
		
		System.out.println(cal1.get(Calendar.YEAR));// Calendar 인스턴스는 get()메소드로 가져옴
		System.out.println(cal1.get(Calendar.MONTH));//MONTH는 0~11로 표시된다. 1을 더해야 지금 월이 나옴
		System.out.println(cal1.get(Calendar.WEEK_OF_YEAR));//올해의 몇째 주
		
		cal2.set(2000, 7, 15);	//set()메소드로 2000년 8월 15일로 설정함 (MONTH는 0~11이다. 주의하자)
		System.out.println(cal2.get(Calendar.YEAR));
		
		//요일은 아래와 같이
		final String[] DAY_OF_W = {"","일", "월","화","수","목","금","토"};
		System.out.println(DAY_OF_W[cal1.get(Calendar.DAY_OF_WEEK)]);
		
		//두 날짜의 차이는 getTimeInMillis()를 이용하여 천분의 일초 단위로 변환해야함
		long diff = (cal1.getTimeInMillis() - cal2.getTimeInMillis()) / 1000;
		System.out.println("그날(cal1)부터 지금(cal2)까지 " + diff + "초 지났습니다.");
		//1일은 24*60*60이므로
		System.out.println("그날(cal1)부터 지금(cal2)까지 " + diff/(24*60*60) + "일 지났습니다.");
		
		//출력을 위와같이 할 수도 있지만 SimpleDateFormat을 사용하는게 더 간편한다.
		
		Date today = new Date();
		
		SimpleDateFormat sdf1, sdf2;
		
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf1.format(today));
		//사용 방법은 간단하다. SimpleDateFormat 클래스로 인스턴스를 생성하는데
		//생성자에 형식을 올바른 패턴기호로 입력하면된다.
		
		//자주 사용하는 패턴기호는
		//y 년도 / M 월 / w 년의 몇 번째 주 / W 월의 몇 번째 주 / D년의 몇번째 일 / d 월의 몇번째 일
		//E 요일 / H 시간 0-23 / h 시간 1-12....
		//등등이 있다.
	}
}






















