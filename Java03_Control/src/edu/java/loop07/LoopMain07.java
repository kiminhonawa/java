package edu.java.loop07;

import java.util.Scanner;

public class LoopMain07 {

	public static void main(String[] args) {
		boolean run = true; //프로그램을 계속 실행할 지, 종료할 지를 결정할 변수.
		int balance = 0; //은행 예금 잔고.
		Scanner scanner = new Scanner(System.in);
		
		while (run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택>");
			
			int menu = scanner.nextInt();
			switch (menu) {
			case 1:
				System.out.println("예금하실 금액을 입력하세요>>");
				int income = scanner.nextInt();
				balance += income;
				System.out.println("예금액:" + income + "원" );
				System.out.println("잔고:" + balance + "원");
				break;
			case 2:
				System.out.println("출금하실 금액을 입력하세요>>");
				int outcome = scanner.nextInt();
				balance -= outcome;
				
				System.out.println("출금액:" + outcome + "원");
				System.out.println("잔고:" + balance + "원");
				if (balance <= 0) {
					System.out.println("잔고가 부족합니다.");
				}
				break;
			case 3:
				System.out.println("잔고:" + balance + "원");
				break;
			case 4:
				run = false;
				break; //switch 문을 종료
			default:
				System.out.println("메뉴를 잘못 입력했습니다. 다시 선택하세요.");
			}
			
		}

		System.out.println("프로그램 종료");
	}

}
