package edu.java.inheritance02;

public class InheritanceMain02 {

	public static void main(String[] args) {
		BusinessPerson p1 = new BusinessPerson();
		System.out.println("-----------------------------------------");
		BusinessPerson p2 = new BusinessPerson("아이티윌");
		System.out.println("-----------------------------------------");
		BusinessPerson p3 = new BusinessPerson("김인호", "아이티윌");
		
		//하위 클래스의 객체를 생성하기 위해서 생성자를 호출하면
		// 상위 클래스의 생성자가 먼저 실행되고, 그 후에 하위 클래스의 생성자가 실행됨.
		// 하위 클래스의 생성자에서 상위 클래스의 생성자를 호출하려면 super(...)를 사용.
		// 하위 클래스의 생성자에서 상위 클래스의 생성자를 명시적으로 호출하지 않으면,
		// 상위 클래스의 "기본 생성자"(default constructor)가 암묵적으로 호출됨.
		// 상위 클래스의 기본 생성자가 없으면, 하위 클래스에서는 상위 클래스의 다른 생성자를
		// 반드시 명시적으로 호출해야만 함.
		
		// this의 의미:
		// 1. 생성된 (자기 자신) 객체(의 주소): this.field, this.method()
		// 2. 오버로딩된 다른 생성자 호출
		
		// super의 의미:
		// 1. 생성된 상위 클래스의 객체(의 주소): super.field, super.method()
		// 2. 상위 클래스의 생성자: super(), super(...)
		
	}

}
