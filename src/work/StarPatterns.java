package work;

import java.util.Scanner;

/*
 * Resources:
 * http://www.sitesbay.com/java-program/java-triangle-of-star
 */

public class StarPatterns {
	
	public void starTriangle(int number) {
		int i,j,k;
		for(i = 1; i <= number; i++) {
			for(j = number - 1; j >= i; j--) {
				System.out.print(" ");
			}
			for(k = 1; k <= (2*i-1); k++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		StarPatterns pattern = new StarPatterns();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number: ");
		pattern.starTriangle(sc.nextInt());
		
		sc.close();
	}
}