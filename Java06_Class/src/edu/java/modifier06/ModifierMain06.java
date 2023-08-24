package edu.java.modifier06;

// final 수식어: 최종적인. 변경할 수 없는.
// final 지역 변수: 변경할 수 없는 지역 변수. 초기화 이후에는 값을 변경할 수 없는 변수.
// final 클래스 멤버(필드, 메서드): 변경할 수 없는 클래스 멤버.
// final 필드는 반드시 초기화하는 문장을 명시해야 함.
// - 필드 선언과 동시에 값을 초기화.
// - 아규먼트를 갖는 생성자를 사용해서 값을 초기화.


public class ModifierMain06 {

	private static final int VERSION = 1;
	
	private final int test; //final 필드가 선언할 때 초기화하지 않는 경우에는
	//반드시 생성자를 이용해서 final 필드를 초기화해야 함.
	
	public ModifierMain06(int test) {
		this.test = test;
	}
	
	public static void main(String[] args) {
		final int x = 1;
		
		//	VERSION = 2; -> final 필드는 변경 할 수 없음.
		
		
		
		
	}

}
