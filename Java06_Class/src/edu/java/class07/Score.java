package edu.java.class07;

public class Score {
	//필드
	int java; 
	int sql;
	int html;
	
	
	//생성자
	public Score() {}
	
	public Score(int java, int sql, int html) {
		this.java = java;
		this.sql = sql;
		this.html = html;
	}
	//메서드
	//1. printScore - 세 과목의점수 출력
	public void printScore() {
		System.out.printf("java:%d점 sql:%d점 html:%d점\n", java, sql, html);
	}
	//2. getTotal - 세 과목의 총점 리턴
	public int getTotal() {
		return this.java + this.sql + this.html;
	}
	//3.getAverage - 세 과목의 평균 (더블) 리턴
	public double getAverage() {
		return (this.java + this.sql + this.html)/3;
	}
	
}
