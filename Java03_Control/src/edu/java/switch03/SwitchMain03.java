package edu.java.switch03;

import javax.swing.Spring;

public class SwitchMain03 {

	public static void main(String[] args) {
		// enum 타입을 사용하는 switch-case 구문
		// enum Season 타입 변수를 선언하고 값을 겨울(WINTER)로 초기화.
		Season s = Season.WINTER;
		switch (s) {
		case SPRING:
			System.out.println("SPRING");
			break;
		case SUMMER:
			System.out.println("SUMMER");
			break;
		case FALL:
			System.out.println("FALL");
			break;
		case WINTER:
			System.out.println("WINTER");
			break;
		}
		
	}

}
