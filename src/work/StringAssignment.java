package work;

import java.util.Arrays;
import java.util.Scanner;

public class StringAssignment {
	
	StringAssignment() {
		//do nothing
	}
	
	public void question1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		String input = sc.nextLine();
		String[] parts = input.split(" ");
		System.out.println("Output:");
		for(int i = parts.length - 1; i >= 0; i--) {
			System.out.print(parts[i] + " ");
		}
		
		sc.close();
	}
	
	public void question2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter statement :");
		String input = sc.nextLine();
		String[] parts = input.split("");
		int count = 0;
		
		for(int i = 0; i < parts.length; i++) {
			if(parts[i].equals("a") || parts[i].equals("e") ||
					parts[i].equals("i") || parts[i].equals("o") ||
					parts[i].equals("u")) {
				count++;
			}
		}
		System.out.println("Number of vowels in string --> " + count);
		
		sc.close();
	}
	
	public void question3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter first name --> ");
		String fname = sc.nextLine();
		System.out.print("Please enter last name --> ");
		String lname = sc.nextLine();
		//TODO ensure format
		System.out.print("Please provide date of birth (dd-mm-yyyy) --> ");
		String dob = sc.nextLine();
		
		String[] password = new String[10];
		password[0] = fname.substring(0, 1).toUpperCase();
		password[1] = fname.substring(1, 2).toUpperCase();
		password[2] = lname.substring(lname.length()-2, lname.length()-1).toUpperCase();
		password[3] = lname.substring(lname.length()-1).toUpperCase();
		password[4] = dob.substring(0, 1);
		password[5] = dob.substring(1, 2);
		password[6] = dob.substring(3, 4);
		password[7] = dob.substring(4, 5);
		password[8] = dob.substring(8, 9);
		password[9] = dob.substring(9, 10);
		
		System.out.print("The generated password is: ");
		for(int i = 0; i < password.length; i++) {
			System.out.print(password[i]);
		}
		
		sc.close();
	}
	
	/* replace tags in a given sentence? */
	public void question4() {
		
	}
	
	public void question5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		String input = sc.nextLine();
		String[] parts = input.split("");
		
		for(int i = 0; i < parts.length; i++) {
			if(parts[i].equals("a") || parts[i].equals("e") ||
					parts[i].equals("i") || parts[i].equals("o") ||
					parts[i].equals("u")) {
				parts[i] = "!";
			}
		}
		
		String output = Arrays.toString(parts).replaceAll(", |\\[|\\]", "");
		System.out.println("Output: " + output);
		
		sc.close();
	}
	
	/* Palindrome */
	public void question6() {
		String fword = "Never odd or even";
		String sword = "";
		
		sword = fword.replaceAll("\\s+", "");
		System.out.println(sword);
		String reverse = new StringBuffer(sword).reverse().toString();
		System.out.println(reverse);
		
		if(reverse.equalsIgnoreCase(fword)) {
			System.out.println("\"" + fword +"\"" + " is a palindrome.");
		} else {
			System.out.println("\"" + fword +"\"" + " is not a palindrome.");
		}
	}
	
	public void question7() {
		
	}

	public static void main(String[] args) {
		StringAssignment assignment = new StringAssignment();
		
//		assignment.question1();
//		assignment.question2();
//		assignment.question3();
//		assignment.question4();
//		assignment.question5();
		assignment.question6();
	}
}
