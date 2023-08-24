package edu.java.class06;

public class ClassMain {

	public static void main(String[] args) {
		
		Circle circle1 = new Circle();
		
		circle1.printCircleInfo();
		
		System.out.println("원의 둘레: " + circle1.perimeter());
		System.out.println("원의 넓이:" + circle1.area());
	
		System.out.println("--------------------------");
		Circle circle2 = new Circle(5.6);
		circle2.printCircleInfo();
		
		
		System.out.println("원의 둘레: " + circle2.perimeter());
		System.out.println("원의 넓이: " + circle2.area());
	}

}
