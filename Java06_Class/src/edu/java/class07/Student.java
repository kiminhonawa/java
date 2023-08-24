package edu.java.class07;

public class Student {
	//필드
	int stuNo;//학번
	String name; //이름
	Score score; //학생의 시험점수
	
	//constructor
	//1.기본 생성자 2. 위 세가지를 초기화할 수 있는 생성자
	public Student() {}
	
	public Student(int stuNo, String name, Score score) {
		this.stuNo = stuNo;
		this.name = name;
		this.score = score;
	}
	
	//method
	//printStudent - 학번, 이름, 세 과목 점수, 총점, 평균을 출력하는 메서드.	
	public void printStudent() {
		System.out.printf("학번:%d 이름:%s "
				+ "\njava:%d점 sql:%d점 html:%d점 "
				+ "\n총점:%d점 평균:%f점\n"
				, stuNo, name, score.java, score.sql, score.html, score.getTotal(), score.getAverage());
	}
}
