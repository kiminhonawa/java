package edu.java.modifier01;

import edu.java.class08.Account;

// 클래스 멤버 (필드, 생성자, 메서드)의 접근 제한 수식어(access modifier):
// 1) private : 선언된 클래스 안에서만 직접 접근(사용) 가능.
// 2) (package) : 수식어 없는 경우. 같은 패키지에 있는 클래스들에서 직접 접근(사용) 가능.
// 3) protected : 같은 패키지에 있거나 또는 상속하는 클래스들에서 직접 접근하고 (사용)이 가능.
// 4) public : 어디서든 직접 사용 가능.
// 가시성(visibility) 범위: private < (package) < protected < public

public class ModifierMain01 {

	public static void main(String[] args) {
		AccessTest test = new AccessTest(2, 4, 5, 6);
		System.out.println(test.b);
		test.printInfo();
		
//		test.a=100; = not visible
		test.d=100;
		test.printInfo();
		
		//생성자를 private로 선언하면 다른 클래스에서는 생성자를 호출할 수 없기 때문에
		//객체를 생성할 수 없음.
//		new Math(); //JDK java.lang.math 클래스의 생성자는 private -> 객체 생성 불가능.
		
	}

}
