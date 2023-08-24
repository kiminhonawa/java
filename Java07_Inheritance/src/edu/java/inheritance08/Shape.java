package edu.java.inheritance08;

public abstract class Shape {
	//field
	protected String type;
	
	
	//constructor
	protected Shape(String type) {
		this.type = type;
	}
	
	//method
	//추상 메서드
	public abstract double area(); //도형의 넓이를 리턴.
	
	public abstract double perimeter(); //도형의 둘레 길이를 리턴.
	
	//일반 메서드
	public final void draw() {
		String info = String.format("%s: 넓이=%f, 둘레=%f",
				this.type, area(), perimeter());
		System.out.println(info);
		
	}
}
