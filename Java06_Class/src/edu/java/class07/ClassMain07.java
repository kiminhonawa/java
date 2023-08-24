package edu.java.class07;

public class ClassMain07 {

	public static void main(String[] args) {
//		score1.html = 70;
//		score1.java = 80;
//		score1.sql = 90;
//		score1.printScore();
//		System.out.println("Total:" + score1.getTotal() +"점");
//		System.out.println("Average:" + score1.getAverage() + "점");
//		System.out.println("-----------------");
//		Student student1 = new Student();
//		student1.stuNo = 1234;
//		student1.name = "김인호";
//		
//		System.out.print("학번:" + student1.stuNo);
//		System.out.print(" 이름:" + student1.name);
// 		System.out.print(" 점수:" +  );
		
		Score score1 = new Score(70, 80, 90);		
		Student student1 = new Student(1234,"김인호",score1);
		student1.printStudent();
		
		String emptyString = "";
		//System.out.println("길이:" + emptyString.length());
		System.out.println("----------------------------------");
		//String nullString = null;
		//System.out.println("길이:" + nullString.length());
		//->NullPointerException 발생
		// null: 생성된 객체가 없다.
		Score score2 = new Score(90, 60, 95);
		Student student2 = new Student(5678,"김땡땡",score2);
		student2.printStudent();
		
		
	}
}