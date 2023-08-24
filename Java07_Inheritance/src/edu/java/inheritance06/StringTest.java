package edu.java.inheritance06;

public class StringTest {
	public static void main(String[] args) {
		//상수(constant): final로 선언된 변수.
		//리터럴(literal): 만들어진 값.
		final int x = 1; //-> x=상수, 1=리터럴.
		
		String s1 = "hello"; //-> s1:변수, "hello": 문자열 리터럴
		String s2 = "hello";
		System.out.println(s1 == s2); 
		// -> true: JVM은 같은 문자열은 두 번 생성하지 않음.
		
		String s3 = new String("hello");
		String s4 = new String("hello");
		System.out.println(s3 == s4);
		// -> flase 생성자는 호출할 때마다 새로운 객체를 힙 메모리에 저장.
		
	}
	
}
