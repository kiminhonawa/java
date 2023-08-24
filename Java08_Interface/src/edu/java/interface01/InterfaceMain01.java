package edu.java.interface01;

//import static 문장
import static edu.java.interface01.DatabaseModule.DB_VERSION;

// 인터페이스 (Interface):
// 사용 목적: 팀/회사 간의 분업/협업을 하기 위해서 메서드(기능)들의 프로토타입 (prototype, signature)을 약속(정의)하는 것.
// 인터페이스가 가질 수 있는 멤버들:
// 1. public static final 필드. 필드 선언할 때 보통 생략 가능.
// 2. public abstract 메서드. 메서드 선언할 떄 보통 생략 가능.


public class InterfaceMain01 {

	public static void main(String[] args) {
	
		System.out.println(DB_VERSION);
		// -> import static 문장을 사용하면 DatabaseModule.DB_VERSION를 간단히 DB_VERSION으로 사용할 수 있음
		
		//OracleDatabaseModule db = new OracleDatabaseModule();
		//MariaDBModule db = new MariaDBModule();
		
		// 다형성: SuperType var = new SubType();
		// 인터페이스 이름도 구현 클래스들의 상위 타입으로 사용할 수 있음.
		DatabaseModule db = new MariaDBModule();
		
		db.insert("abcd", 100);
		db.select();
		
	}

}
