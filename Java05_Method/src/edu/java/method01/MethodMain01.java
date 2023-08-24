package edu.java.method01;

import java.util.Random;

// 메서드(method): 클래스 안에서 정의하는 기능 (함수, function).
// -함수(function) :프로그램에서 사용될 기능을 코드 블록으로 작성한 것.
// - 메서드: 클래스 안에서 작성된 함수.
// 자바 언어는 메서드만 제공하고, 함수는 제공하지 않음!

// 메서드 호출(call, invoke): 메서드를 사용하는것.
// argument: 메서드를 호출할 때 메서드에게 전달하는 값.
// parameter: 매개변수. 아규먼트를 저장하기 위한 메서드의 지역 변수.
// 반환 값 (return value): 메서드가 모든 기능을 수행한 후 메서드를 호출한 곳으로 되돌려 주는 값.

public class MethodMain01 {

	// main method : 프로그램 시작점.
	public static void main(String[] args) {
		System.out.println("Hello");
		// -> println() 메서드 호출. -> 호출 결과: 콘솔 창에 문자열을 출력.

		Random random = new Random();
		int x = random.nextInt(10);
		// -> nextInt() 메서드(기능) 호출 -> nextInt() 메서드는 난수를 반환(return).
		System.out.println(x);

		System.out.println("테스트1");
		newLine(); // 같은 클래스에 정의(선언)된 메서드를 호출.
		System.out.println("테스트2");

		System.out.println("테스트3");
		newLine(3);
		System.out.println("테스트4");
	}

	/**
	 * 콘솔에 빈 줄 하나를 출력
	 */
	public static void newLine() {
		System.out.println();
	}

	/**
	 *콘솔에 n개의 빈 줄을 출력하는 메서드
	 * @param n 0 이상의 정수. 출력할 빈 줄의 개수.
	 */
	public static void newLine(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println();
		}

		
		int[] iArr = new int[5];//배열 선언.
		int[] iArr2 = { 10, 10, 20 }; //선언과 동시에 초기화.
//		iArr2 [0] iArr2[1] iArr2[2]
		System.out.println(iArr2.length); // 배열의 크기.
		
		for (int i = 0; i < iArr2.length; i++) {
			System.out.println(iArr2[2]);
		}
		
	}


}
