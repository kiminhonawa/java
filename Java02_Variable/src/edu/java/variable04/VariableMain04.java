package edu.java.variable04;

import java.util.Scanner;

public class VariableMain04 {

	public static void main(String[] args) {
		// 콘솔 창에서 키보드로 정수를 입력받아서 변수에 저장하는 방법.
		// 1. Scanner 타입의 변수를 선언하고 초기화.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수입력>>>");
		
		// 2. Scanner 객체를 사용해서 콘솔 창에서 정수를 입력받고 변수에 저장.
		int x = sc.nextInt();
		System.out.println("x=" + x);
		
		
		System.out.println("두번째 정수 입력>>>");
		//변수 y에 입력받은 정수를 저장.
		//x+y,x-y,x*y,x/y,x%y 결과를 출력.
		
		int y = sc.nextInt();
		int result = x+y;
		System.out.println("더하기" + result);
		result = x-y;
		System.out.println("빼기" + result);
		result = x*y;
		System.out.println("곱하기" + result);
		result = x/y;
		System.out.println("나누기" + result); //나눈 몫
		result = x%y;
		System.out.println("나눈몫" + result); //나눈 나머지
		
		
		
	}
}
