package edu.java.loop06;

import java.util.Random;

public class LoopMain06 {
	// ctrl+shift+F: 코드 자동 정렬
	public static void main(String[] args) {
		for (int x = 1; x <= 5; x++) {
			for (int y = 1; y <= x; y++) {
				System.out.print('*');
			}
			System.out.println();
		}

		System.out.println("\n=============\n");

		int line = 1;
		while (line <= 5) {
			int count = 1;
			while (count <= line) {
				System.out.print('*');
				count++;
			}
			System.out.println();
			line++;
		}
		System.out.println("\n=============\n");

		for (int x = 1; x <= 5; x++) {
			for (int y = 1; y <= x; y++) {
				System.out.print('*');
			}
			System.out.println();
		}
//		for (int x = 4; x >= 1; x--) {
//			for (int y = 1; y <= x; y++) {
//				System.out.print('*');
//			}
//			System.out.println();
//		}
//		

//		for (int x = 1; x <= 4; x++) {
//			for (int y =4; y >= x; y--) {
//				System.out.print('*');
//			}
//			System.out.println();
//		}

		for (int x = 6; x <= 9; x++) {
			for (int y = 4; y >= x - 5; y--) {
				System.out.print('*');
			}
			System.out.println();
		}

		System.out.println("\n=========================\n");
		
		for (int x = 1; x <= 9; x++) {
			if (x <= 5) {
				for (int y = 1; y <= x; y++) {
					System.out.print('*');
				}

			} else {
				for (int y = 4; y >= x - 5; y--) {
					System.out.print('*');
				}
			}
			System.out.println();
		}

		
		System.out.println("\n=============================\n");
		Random rand = new Random();	
		for(;;) {
			int dice1 = rand.nextInt(6) + 1;
			int dice2 = rand.nextInt(1,7); // 1  <= r < 7
			System.out.printf("(%d, %d)\n", dice1, dice2);
			if (dice1 + dice2 == 5) {
				break;
			}
	
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
