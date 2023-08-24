package edu.java.loop05;

public class LoopMain05 {

	public static void main(String[] args) {
		
		int a = 2;
		while (a < 10) {
			System.out.println("--- " + a + "단 ---");
			
			int b = 1;
			while (b < 10) {
				System.out.printf("%d x %d = %d\n", a, b, a*b);
				if (a == b) {
					break;
				}
				b++;
			}
				
			a++;
		}

		System.out.println("\n =============\n");
		
		int c = 1;
		while (c < 10) {
			System.out.println("--- " + c + "단 ---");
		
			int d = 1;
			while (d <= c) {
				System.out.printf("%d x %d = %d\n", c, d, c*d);
				d++;
			}
		}
		
			c++;
	}

}
