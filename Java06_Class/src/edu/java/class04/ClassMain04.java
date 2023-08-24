package edu.java.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		//1. 기본 생성자
		Product product1 = new Product();
		product1.printProductInfo();

		//2.아규먼트 3개를 갖는 생성자
		Product product2 = new Product(1234, "에어팟", 240000);
		product2.printProductInfo();
		
		//3. 상품 아이디와 상품 이름을 아규먼트로 갖는 생성자
		Product product3 = new Product(5678, "에어팟");
		System.out.println();
	
		
	}

}
