package edu.java.modifier07;

// 객체(object): 프로그램에서 사용하려는 대상.
// 클래스(class): 객체를 만들기 위해서 작성한 코드.
// - 객체의 속성을 필드로 선언하고, 속성을 초기화하는 생성자를 가질 수 있고,
// 객체의 속성을 사용한 기능을 메서드로 정의하는 데이터 타입.
// 인스턴스(instance): 생성된 객체.

// 인스턴스 멤버(필드, 메서드):
// - static 수식어가 사용되지 않은 멤버.
// - 객체를 생성한 후에 참조 변수를 사용해서 접근(사용).
// - JRE (Java Runtime Environment)이 사용하는 메모리 공간 중에는 힙(heap)에 생성됨.

// static 멤버 (필드, 메서드): 
// - static 수식어 사용된 멤버.
// - 객체를 생성하지 않고 사용할 수 있는 멤버.
// - 프로그램 로딩 시점(main 메서드 시작 전) 
// JRE이 사용하는 메모리 공간 중에서 메서드(method) 영역에 생성됨.
// - 클래스 이름을 사용해서 사용하는 멤버.
// - static 멤버들은 static 멤버에서만 사용 가능.
// -> static 메서드는 인스턴스 멤버(필드, 메서드)를 사용할 수 없음.


public class ModifierMain07 {

	public static void main(String[] args) {
		// Test 타입의 객체 생성.
		Test test = new Test();
		// 참조변수 test를 사용해서 인스턴스 메서드 호출.
		test.printInfo();
		// 참조변수 test를 사용해서 인스턴스 변수(필드)를 사용
		test.x = 100;
		Test.y = 200;
		test.printInfo();
		
		Test.y = 123;
		Test.printStaticInfo();
		
		
	}

}
