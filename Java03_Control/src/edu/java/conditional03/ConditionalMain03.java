package edu.java.conditional03;

import java.util.Scanner;

public class ConditionalMain03 {

	public static void main(String[] args) {
		//간단한 성적 처리 프로그램
		//Scanner를 사용해서 세 과목 (Java,Sql,Html)의 점수를 입력하고 변수에 저장
		//세 과목의 총점을 계산하고 출력.
		//세 과목의 평균을 계산하고 출력.
		//학점(A,B,C,D,F)를 출력.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Java 성적을 입력하세요.");
			int Java = sc.nextInt();
				System.out.println("Java 성적:" + Java);
		
		System.out.println("Sql 성적을 입력하세요.");
			int Sql = sc.nextInt();
				System.out.println("Sql 성적:" + Sql);
			
		System.out.println("Html 성적을 입력하세요.");
			int Html = sc.nextInt();
				System.out.println("Html 성적" + Html);	
		
		int result = Java + Sql + Html;
			System.out.println("세 과목의 총점:" + result);
		
		double average = (double)result/3;
			System.out.println("세 과목의 평균:" + average);
		
		if (average >= 90) 
			System.out.println("학점은 A 입니다");
		else if (average >= 80)
			System.out.println("학점은 B 입니다");
		else if (average >= 70)
			System.out.println("학점은 C 입니다");
		else if (average >= 60)
			System.out.println("학점은 D 입니다");
		else 
			System.out.println("학점은 F 입니다");
			
		//ctrl+space: 코드 추천
		
		
		

	}

}
