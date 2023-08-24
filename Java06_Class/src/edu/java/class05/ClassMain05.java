package edu.java.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		
		
		Rectangle rectangle1 = new Rectangle();
		
		rectangle1.height = 3.0;
		rectangle1.width = 4.0;
		System.out.printf("height:" + rectangle1.height); 
		System.out.println("  width:" + rectangle1.width);
		System.out.println("둘레는: " + rectangle1.perimeter());	
		System.out.println("넓이는: " + rectangle1.area());
		
		System.out.println("--------------------------");
		Rectangle rectangle2 = new Rectangle();
		rectangle2.height = 5.0;
		rectangle2.width = 10.0;
		System.out.printf("height:" + rectangle2.height);
		System.out.println(" width:" + rectangle2.width);
		System.out.println("둘레는:" + rectangle2.perimeter());
		System.out.println("넓이는:" + rectangle2.area());
	}

}
