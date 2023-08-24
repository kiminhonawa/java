package edu.java.exception06;

import java.util.Scanner;

public class ExceptionMain06 {
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// inputInteger() 메서드 테스트 코드
	ExceptionMain06 exception = new ExceptionMain06();
	System.out.println("입력한 정수: " + exception.inputInteger());
	}

	public int inputInteger() {
		// Scanner를 사용해서 입력받은 정수를 리턴.
		// integer.parseInt(scanner.nextLine()) 과정에서 NumberFormatException이 발생할 수 있음.
		// 그런경우 "다시 입력하세요" 로 무한 루프
		int x = 0;
		while (true)
		try {
			System.out.print("정수 입력>> ");
			x = Integer.parseInt(sc.nextLine());
			break;
		} catch (NumberFormatException e) {
			System.out.println("다시 입력하세요");
		} return x;
	}
	
	
	
}