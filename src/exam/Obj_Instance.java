package exam;
class TV1{
	//TV의 속성(멤버변수)
	String color;
	boolean power;
	int channel;
	
	//TV의 기능
	void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}

public class Obj_Instance {
	public static void main(String[] args) {
		TV1 t;				//TV인스턴스를 참조하기 위한 변수(참조변수) t
		t = new TV1();		//TV인스턴스 생성
		t.channel = 7;		//TV인스턴스의 맴버변수 channel값을 변경
		t.channelDown();	//메소드 호출
		System.out.println("현재 채널은" + t.channel + " 입니다.");
	}
	
}
