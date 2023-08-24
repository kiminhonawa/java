package edu.java.class05;


public class Rectangle {

	//field - 객체 속성
	double width; //가로 길이
	double height; //세로 길이

	// 1. 기본 생성자
	public Rectangle() {}
	
	// 2. 가로/세로 길이를 전달받은 값으로 초기화하는 생성자
	public Rectangle (double width, double height) {
		this.height = height;
		this.width = width;
	}
	
	
	// 메서드 - 객체 기능
	
	// 1. perimeter - 둘레 길이를 리턴.
	public double perimeter() {
		return (this.width +this.height) * 2;		
	}
	// 2. area - 넓이를 리턴.
	public double area() {
		return this.width * this.height;		
	}
}
