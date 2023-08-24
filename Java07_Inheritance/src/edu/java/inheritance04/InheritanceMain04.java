package edu.java.inheritance04;

public class InheritanceMain04 {

	public static void main(String[] args) {
//		// 다형성과 타입 변환(casting) 연산자
//		Parent ch1 = new Child();
//		ch1.testParent();
//		// -> 실제 생선된 객체는 Child 타입이지만, 변수 선언이 Parent 타입으로 되어 있어서
//		// Parent 타입에서 정의된 메서드들만 보이고 사용할 수 있음.
//		((Child) ch1).testChild();
//		// -> Parent 타입으로 선언된 변수를 Child 타입으로 강제 타입 변환(casting)을 하면
//		// Child 타입에서 정의된 메서드들도 보이고 사용할 수 있음.
//
//		Parent ch2 = new AnotherChild();
//
//		if (ch2 instanceof Child) {
//			((Child) ch2).testChild();
//		} else if (ch2 instanceof AnotherChild) {
//			((AnotherChild) ch2).testAnotherChild();
//		} else {
//			ch2.testParent();
//		}
//
//	}

	class Parent {
		public void testParent() {
			System.out.println("I'm your father!");
		}
	}

	class Child extends Parent {
		public void testChild() {
			System.out.println("child");
		}
	}

	class AnotherChild extends Parent {
		public void testAnotherChild() {
			System.out.println("another child");
		}
	}
}}