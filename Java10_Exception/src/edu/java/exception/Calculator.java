package edu.java.exception;

public class Calculator {
	
	public int divide(int x, int y) throws Exception {
		if (y !=0) {
			return x/y;
			// 메서드를 종료. 값을 메서드 호출한 곳에 반환.
		}
		throw new Exception("y 는 0이 될 수 없음");
		// throw: 메서드를 호풀한 곳으로 예외 객체를 던짐.
		
		
	}
}
