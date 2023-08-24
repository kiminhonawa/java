package edu.java.modifier03;

//데이터 캡슐화 (encapsulation)


public class ModifierMain03 {

	public static void main(String[] args) {
		//person 타입의 객체 생성.
		Person person1 = new Person("기미노", 111);
		
		
// 		public일 경우만 가능.		
//		person1.age = -111; //필드 값 변경
//		System.out.println(person1.age); //필드 값 읽기

// 		privae으로 감춰진 필드의 값 읽기 -> public으로 공개된 getter 메서드 사용.
		System.out.println("이름:" + person1.getName());
		System.out.println("나이:" + person1.getAge());
		
		person1.setAge(-111);
		System.out.println("나이:" + person1.getAge());
	
		System.out.println("----------------------------------------------");
	
		User user1 = new User(1234, "ihk0802" , "0802ih");
		System.out.println("UserNo: " + user1.getUserNo());
		System.out.println("ID: " + user1.getUserId());
		System.out.println("Password: " + user1.getPassword());
		
		user1.setPassword("0802i");
		System.out.println("비밀번호: " + user1.getPassword());
	}

}
