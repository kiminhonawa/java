package edu.java.inheritance06;

class T {
	@Override
	public String toString() {
		// 객체를 문자열로(toString)변환해서 리턴.
		return "T 타입 인스턴스";
	}
}

public class InheritanceMain06 {

	public static void main(String[] args) {
		// java.lang.Object 클래스: 자바의 최상위 클래스.
		// java의 모든 클래스는 object의 protected 또는 public 멤버(메서드)를 상속 받아서 사용 가능하고,
		// 재정의(override)를 할 수 있음.
		// Object 클래스의 메서드 재정의: toString, equals, hashCode, ...

		// System.out.println(Obejct x): argument로 전달된 객체의 tString() 메서드가 리턴하는 문자열을 콘솔창에
		// 출력.
		// 클래스를 정의할 때, toString() 메서드를 override해서 원하는 문자열이 출력될 수 있도록 할 수 있음.
		T t = new T();
		System.out.println(t);
		System.out.println("----------------------------------");

		Point p1 = new Point(0, 0);
		System.out.println("pt1:" + p1);

		Point p2 = new Point(0, 0);
		System.out.println("pt2:" + p2);
		System.out.println("== 연산자: " + (p1 == p2));
		// -> ==연산자는 지역 변수 pt1의 값과 pt2의 값을 비교
		// 클래스 타입의 지역 변수가 저장하는 값은 객체가 생성된 힙(heap)의 주소.
		System.out.println("equlas 메서드" + p2.equals(p1));
		// -> equals 메서드를 override하면, 두 객체가 같은 지에 대한 정의를 새로 내릴 수 있음.
		System.out.println(p1.getClass());
		
		System.out.println("pt1 hashCode:" + p1.hashCode());
		System.out.println("pt2 hashCode:" + p2.hashCode());
		//-> equals가 true를 리턴하는 두객체(p1,p2)는 hashCode 리턴 값이 같다.
	
		System.out.println("----------------------------------");
		
		String s1 = new String ("안녕하세요");
		String s2 = new String ("안녕하세요");
		System.out.println("== 연산자:" + (s1 == s2));
		System.out.println("equals 메서드:" + s1.equals(s2));
		//-> java.lang.String 클래스는 equals를 override(재정의)하고 있음.
		//-> 문자열의 내용이 같은 지를 비교하도록 재정의.
		
		System.out.println();
		System.out.println("---------------------------------------");
		User user1 = new User("user", "1234");
		User user2 = new User("user", "0000");
		System.out.println("User1: " + user1);
		System.out.println("User2: " + user2);
		System.out.println("===연산자: " + (user1 == user2));
		System.out.println("equals 메서드:" + user1.equals(user2));
		System.out.println("user1 hashCode:" + user1.hashCode());
		System.out.println("user2 hashCode:" + user2.hashCode());
	}

}