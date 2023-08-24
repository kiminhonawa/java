package edu.java.conditional01;

public class ConditionalMain01 {

	public static void main(String[] args) {
		// 조건문(conditional statement)
		
		int number =-10;
		if (number > 0) {
			System.out.println("양수");
		}
		if (number % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		

		if (number > 0) {
			System.out.println("양수");
		} else if (number < 0) {
			System.out.println("음수");
		} else {
			System.out.println("zero");
		}
		
		System.out.println("=== 프로그램 끝 ===");
	}

}
