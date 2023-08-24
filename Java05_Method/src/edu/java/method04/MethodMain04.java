package edu.java.method04;

public class MethodMain04 {

	public static void main(String[] args) {
		//메서드 오버로딩 (method overloading)
		// 같은 이름의 메서드를 여러개 정의하는 것.
		// 메서드의 파라미터의 타입 또는 개수가 다를 때 overloading 할 수 있음.
		// (주의)메서드의 파라미터는 같고 리턴 타입만 다르게 overloading 할 수는 없음.
		
		System.out.println();
		System.out.println("안녕"); //string
		System.out.println(10); //int
		System.out.println(3.14); //double
		System.out.println(true); //boolean
		System.out.println(divide(10,4));
		System.out.println(divide(10.0, 4.0));
		System.out.println(divide2(10, 4));
	}
	
	
	public static int divide(int x, int y) {
		return x/y; //x를 y로 나눈 "몫"을 리턴.
	}
	
	public static double divide (double x, double y) {
		return x/y; // 소수점을 포함한 나누기 결과를 리턴.
	}
	
	public static double divide2(int x, int y) {
		return (double) x/y; //위와 동일하나 파라미터가 동일하여 overloading 할 수 없음. (divide2 로 변경)
	}
	
	
	
	
	
	
}
