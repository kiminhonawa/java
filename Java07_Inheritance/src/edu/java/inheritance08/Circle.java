package edu.java.inheritance08;

public class Circle extends Shape {
	//field
		private double radius;
		
	public Circle (String type, double radius) {
		super(type);
		this.radius = radius;
	}
	
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return Math.PI * radius * 2;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
	
}
