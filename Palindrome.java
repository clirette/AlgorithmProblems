import java.util.Scanner;

/**
 * A class that is a solution to Cracking The Coding Interview problem 1.4 - Palindrome Permutation.
 * Asks user for a test palindrome and returns true if the user supplied a palindrome, false otherwise.
 * @Author Chase Lirette
 * @Version 5/19/17
 */
public class Palindrome {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String testString = "";
		System.out.println("Enter test palindrome");
		testString = input.nextLine();
		char[] testStringArray = testString.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase().toCharArray();
		System.out.println(isPalindrome(testStringArray, 0, testStringArray.length - 1));
	}

    /**
     * Recursively test a String and returns true if it is a palindrome. This is done by comparing the outer
     * characters then incrementing inwards, ignoring whitespace.
     * @param testStringArray The String as a char array to iterate over.
     * @param firstIndex The index into the String occuring on the left side.
     * @param secondIndex The index into the String occuring on the right side.
     * @return True if the String is a palindrome, false otherwise.
     */
	public static boolean isPalindrome(char[] testStringArray, int firstIndex, int secondIndex) {
		if (testStringArray[firstIndex] == ' ') {
			firstIndex++;
		}
		if (testStringArray[secondIndex] == ' ') {
			secondIndex--;
		}
		if (firstIndex >= secondIndex) {
			return true;
		} else if (firstIndex < secondIndex && testStringArray[firstIndex] == testStringArray[secondIndex]) {
			return isPalindrome(testStringArray, firstIndex+1, secondIndex-1);
		}
		return false;
	}
}