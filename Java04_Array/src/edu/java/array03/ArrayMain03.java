package edu.java.array03;

public class ArrayMain03 {

	public static void main(String[] args) {
		
		
		//Ex 1.
		// 정수(int) 10개를 저장할 수 있는 배열 선언.
		// 배열에 순서대로 0, 2, 4, 6, 8, 10, ... 18을 저장.
		// 배열의 원소들을 한 줄로 출력.
		
		int[] numbers = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18};
		
		for (int a : numbers) {
			System.out.print(a + " ");
		}
			
		System.out.println();
		System.out.println("----다른 방법----");
		
		//다른 방법

		int[] answers = new int [10];
		answers[0] = 0;
		answers[1] = 2;
		answers[2] = 4;
		answers[9] = 18;
		for (int i = 0; i < answers.length; i++) {
			answers[i] = i * 2;
		}
		
		for (int x : answers) {
			System.out.print(x + " ");
		}
		
		System.out.println();
		
		//Ex 2.
				// boolean 10개를 저장할 수 있는 배열 선언.
				// 배열에 순서대로 true, false, true, false, ..., false를 저장.
				// 배열의 원소들을 한 줄로 출력.
		
		boolean[] isEven = new boolean [10];
		
		for (int i = 0; i < isEven.length; i++) {
			if  (i % 2 == 0) {
				isEven[i] = true;
			} else {
				isEven[i] = false;
			}
		}
		
		for (boolean b : isEven) {
			System.out.print(b + " ");
		}
		
		System.out.println();
		
		
	}

}
