package edu.java.inheritance08;

public class Rectangle extends Shape {
	//field
	private double width; //가로
	private double height; //세로
	
	public Rectangle(String type, double width, double height) {
		super(type); //상위 클래스의 아규먼트를 갖는 생성자를 명시적으로 호출.
		this.width = width;
		this.height = height;
	}
	@Override
	public double area() {
		return width * height;
	}

	@Override
	public double perimeter() {
		return (width + height) * 2;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
