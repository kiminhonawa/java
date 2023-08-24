package edu.java.loop03;

public class LoopMain03 {

	public static void main(String[] args) {
		
		for (int n = 1; n < 10; n++) {
			//System.out.println(" 2 X " + n + " + " + (2 * n)); 또는
			System.out.printf("2 x %d = %d\n", n, 2 * n);
			
			}
		
		for (int z = 1; z <= 100; z++) {
			System.out.print(z + "\t");
			if (z % 10 == 0) {
				System.out.println();
			}
		}
	
		
		
		
		
		
		
	}	
}