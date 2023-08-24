package edu.java.loop02;

public class LoopMain02 {

	public static void main(String[] args) {
		// 복합 할당 연산자: +=, -=, *=, /=, %=, ...
		int x = 10;
			x += 2;
		System.out.println("x = " + x);
		
		// System.out.println() : print line. 출력하고 줄바꿈.
		System.out.println("test");
		
		// System.out.print : 출력하고 줄바꿈이 일어나지 않음. 출력이 끝난 위치에 커서가 위치.
		System.out.print("test1");
		System.out.print("test2");
		System.out.println("test3");
		
		// 0 2 4 6 8 10
		
		for (int n = 0; n<= 10; n += 2) {
			System.out.print(n + "");
		}
			System.out.println();
		
		for (int n = 0; n <= 5; n++) {
			System.out.print((2 * n) + "");
		}
		
		System.out.println();
		
	//1 3 5 7 9  홀수들 한줄에 출력
		for (int o = 1; o <= 9; o += 2) {
			System.out.print(o + " ");
		}
		
		System.out.println();
		
		
		
		
		
		
	}

}
