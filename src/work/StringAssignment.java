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
		//TODO ensure date format
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
	
	/* TODO replace tags in a given sentence? */
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
//		String fword = "Never odd or even";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word:");
		String fword = sc.nextLine();
		String sword = "";
		
		sword = fword.replaceAll("\\s+", "");
//		System.out.println(sword);
		String reverse = new StringBuffer(sword).reverse().toString();
//		System.out.println(reverse);
		
		if(reverse.equalsIgnoreCase(sword)) {
			System.out.println("\"" + fword +"\"" + " is a palindrome.");
		} else {
			System.out.println("\"" + fword +"\"" + " is not a palindrome.");
		}
		
		sc.close();
	}
	
	private boolean isPalindrome(String word) {
		String reverse = new StringBuffer(word).reverse().toString();
		return reverse.equalsIgnoreCase(word);
	}
	
	public void question7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input");
		String input = sc.nextLine();
		String output = input.replaceAll("[A-Za-z!@#%&()_\\$ ]", "");
		System.out.println("Output: " + output);
		
		sc.close();
	}
	
	public void question8() {
//		String input = "Numb#er of  vowels!";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter statement:");
		String input = sc.nextLine();
		String forVowels = "[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ!@#%&()_\\$0-9 ]+";
		String vowels = input.replaceAll(forVowels, "");
		String consonants = input.replaceAll("[aeiouAEIOU!@#%&()_\\$0-9 ]+", "");
		String spaces = input.replaceAll("[A-Za-z0-9!@#%&()_\\$0-9]+", "");
		String specialChars = input.replaceAll("[A-Za-z0-9 ]", "");
//		System.out.println(specialChars);
		
		//Number of vowels
		System.out.println("Number of vowels in input: " + vowels.length());
		//Number of consonants
		System.out.println("Number of consonants in input: " + consonants.length());
		//Number of white spaces
		System.out.println("Number of white spaces in input: " + spaces.length());
		//Number of special characters
		System.out.println("Number of special characters in input: " + specialChars.length());
		
		sc.close();
	}
	
	public void question9() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sentence: ");
//		String sentence = "Hello my name is hello my";
		String sentence = sc.nextLine();
		String[] parts = sentence.split(" ");
		for(int i = 0; i < parts.length; i++) {
			for(int j = i+1; j < parts.length; j++) {
				if(parts[i].equalsIgnoreCase(parts[j])) {
					System.out.print(parts[j] + ", ");
				}
			}
		}
		
		sc.close();
	}
	
	public void question10() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter statement: ");
		String palindrome = sc.nextLine();
//		String palindrome = "hanah aba men hannah  cow abba";
		String[] parts = palindrome.split(" ");
		int position = 0;
		int length = 0;
		
		for(int i = 0; i < parts.length; i++) {
			if(isPalindrome(parts[i])){
				if(parts[i].length() > length) {
					length = parts[i].length();
					position = i;
				}
			}
		}
		
		System.out.println(parts[position]);
		
		sc.close();
	}
	
	public void question11() {
		
	}
	
	public void question12() {
		String input = "Hi Jello World";
		String[] parts = input.split(" ");
		String temp1 = parts[0].substring(0, 1);
		String temp2 = "";
		for(int i = 1; i < parts.length; i++) {
			temp2 = parts[i].substring(0, 1);
			parts[i].replaceFirst("[^A-Za-z0-9]{1}", temp1); //TODO fix regex!!!!!!
			temp1 = temp2;
		}
		//TODO assign first letter of last word to the first letter of first word
		
		for(int i = 0; i < parts.length; i++) {
			System.out.print(parts[i] + " ");
		}
		System.out.println();
		System.out.println(temp1);
	}
	
	public void question13() {
//		String input = "This is a sentence with a looooooooooong word";
		Scanner sc = new Scanner(System.in);
		System.out.println("Input:");
		String input = sc.nextLine();
		String[] parts = input.split(" ");
		int length = parts[0].length();
		int position = 0;
		
		for(int i = 1; i < parts.length; i++) {
			if(parts[i].length() > length) {
				length = parts[i].length();
				position = i;
			}
		}
		
		System.out.println("Longest word is: " + parts[position]);
		
		sc.close();
	}
	
	public void question14() {
//		String input = "Sentence to be reversed";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sentence to be reversed:");
		String input = sc.nextLine();
		String[] parts = input.split(" ");
		String[] reversed = new String[parts.length];
		
		for(int i = 0; i < parts.length; i++) {
			reversed[i] = new StringBuffer(parts[i]).reverse().toString();
		}
		
		System.out.println("Original: " + input);
		System.out.print("Reversed: ");
		for(int i = 0; i < reversed.length; i ++) {
			System.out.print(reversed[i] + " ");
		}
		
		sc.close();
	}
	
	//TODO
	public void question15() {
		
	}
	
	public void question16() {
//		String input = "one two three";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sentence:");
		String input = sc.nextLine();
		String[] parts = input.split(" ");
		
		for(int i = 0; i < parts.length; i++) {
			for(int j = 0; j < i+1; j++) {
				System.out.print(parts[i] + " ");
			}
		}
		
		sc.close();
	}
	
	//TODO
	public void question17() {
		
	}
	
	//TODO
	public void question18() {
		
	}

	public static void main(String[] args) {
		StringAssignment assignment = new StringAssignment();
		
//		assignment.question1();
//		assignment.question2();
//		assignment.question3();
//		assignment.question4();
//		assignment.question5();
//		assignment.question6();
//		assignment.question7();
//		assignment.question8();
//		assignment.question9();
//		assignment.question10();
//		assignment.question11();
		assignment.question12();
//		assignment.question13();
//		assignment.question14();
//		assignment.question15();
//		assignment.question16();
//		assignment.question17();
//		assignment.question18();
	}
}