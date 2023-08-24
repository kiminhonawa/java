package edu.java.array04;

import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {
		 // 정수 5개를 저장할 수 있는 배열을 선언.
		
        // 0 이상 9 이하의 정수 난수 5개를 배열에 저장.
        // 배열의 내용을 출력.
        // 배열의 모든 원소의 합을 계산하고 출력.
        // 배열 원소들의 평균을 double 타입으로 계산하고 출력.
		// int를 double 로 변환.
		// numbers.length를 난수의 갯수로 나누면 평균.
		
		int[] numbers = new int [5];
		Random random = new Random();
		for (int x = 0; x < numbers.length; x++) {
			int z = random.nextInt(0, 9);
			numbers[x] = z;
		} 
		//배열의 내용을 출력.
		int sum = 0; 
		for (int o : numbers) {
			System.out.print(o + " ");
			sum = sum + o;
			// sum += o;
		}
		System.out.println();
		System.out.println("total = " + sum);
			
//			System.out.print("Total =" + (numbers[0] + numbers [1] + numbers [2] + numbers [3] + numbers [4]));
		// 합을 배열의 갯수로 나눈다.	
		double avg = (double)sum/numbers.length;
		System.out.println("AVG = " + avg);
		
	
	}

}
