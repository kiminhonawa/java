package edu.java.array09;

import java.util.Random;

public class ArrayMain09 {

    public static void main(String[] args) {
        // 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언.
        int[][] numbers = new int[3][];
    	
    	// 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개 저장.
//        numbers[0] = new int[2];
//        numbers[1] = new int[3];
//        numbers[2] = new int[4];
        
        //반복문도 사용가능
        // 저장하는 난수의 범위는 0 이상 100 이하.
        Random random = new Random();
        
        for (int i = 0; i < numbers.length; i++) {
        	numbers[i] = new int[i + 2];
        	for (int j = 0; j < numbers[i].length; j++) {
        		numbers[i][j] = random.nextInt(101);
        	}
        }
        
        // 2차원 배열의 원소들을 출력.
        for (int[] arr : numbers) {
        	for (int x : arr) {
        		System.out.print(x + " ");
        	}
        	System.out.println();
        }	
        
        // 2차원 배열의 모든 원소들의 합을 계산하고 출력.
        int sum = 0;
        int count = 0;
        for (int[] arr : numbers) {
        	for (int x : arr) {
        		sum += x;
        		count++;
        	}
        }
        System.out.println("sum =" + sum);
        System.out.println("count =" + count);
        
        // 2차원 배열의 모든 원소들의 평균을 계산하고 출력.
        double avg = (double) sum / count ;
        System.out.println("avg =" + avg);
        
        // 최댓값을 찾고 출력.
        int max = numbers[0][0];
        for (int[] arr : numbers) {
        	for (int x : arr) {
        		if (x > max) {
        			max = x;
        		}
        	}
        }
        System.out.println("max =" + max);
        // 연산자 (다른방법)
        // max = (x > max) ? x : max;
  
        // 최솟값을 찾고 출력.
    	int min = numbers[0][0];
    	for (int[] arr : numbers) {
    		for (int x : arr) {
    			min = (x <min) ? x : min;
    			}
    		}
    	System.out.println("min =" + min);
    
    }
 }

   

