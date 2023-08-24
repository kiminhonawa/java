package edu.java.class04;
// 클래스의 멤버들:
//1. 필드
//2. 생성자
//3. 메서드

public class Product {
	int productId; //상품 아이디(코드)
	String productName; //상품 이름
	int productPrice; //상품 가격 기본값 0
	
	//생성자:
	//1. 기본 생성자
	public Product () {}
	
	//2. 아규먼트 3개를 갖는 생성자
	public Product (int productId, String productName, int productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	
	}
	//3. 상품 아이디와 상품 이름을 아규먼트로 갖는 생성자
	public Product (int productId, String productName) {
		this(productId, productName, 0);
	}
	
	//메서드:
	//1. printProductInfo: 상품의 모든 정보를 콘솔에 출력
	//2. setProductPrice: 상품의 가격을 전달받은 값으로 변경하는 메서드.
	public void printProductInfo() {
		System.out.printf("ID: %d, Name: %s, Price: %d\n", productId, productName, productPrice ) ; 
	}
}
