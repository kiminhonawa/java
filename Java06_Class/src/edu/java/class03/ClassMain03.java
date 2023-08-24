package edu.java.class03;

public class ClassMain03 {

	public static void main(String[] args) {
		// User 타입 변수 선언, User 타입(클래스) 객체를 생성하고 저장.
		User user1 = new User(); // 기본 생성자
		user1.printUserInfo();
		
		//아규먼트 3개를 갖는 생성자를 호출해서 객체를 생성.
		User user2 = new User("jake", "jake1234", 26);
		user2.printUserInfo();
		
		//아규먼트 2개를 갖는 생성자를 호출해서 객체를 생성.
		User user3 = new User("jake", "jake0000");
		user3.printUserInfo();
		
		
		
	}

}
