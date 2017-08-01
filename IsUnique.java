import java.util.Scanner;

/**
 * A class that is a solution to Cracking The Coding Interview problem 1.1 - Is Unique.
 * Asks user for a String and returns true if the string contains all unique characters,
 * false otherwise.
 * @Author Chase Lirette
 * @Version 7/2/17
 */
public class IsUnique {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String testString = "";
		System.out.println("IsUnique returns true if a string contains all unique characters.");
		System.out.println("Enter test string:");
		testString = input.nextLine().trim().toLowerCase();
		System.out.println(isUnique(testString));
	}

    /**
     * Checks if a String contains all unique characters ignoring whitespace.
     * @param testString The String to test for unique characters.
     * @return True if there are no identical characters, false otherwise.
     */
	public static boolean isUnique(String testString) {
		for (int i=0; i<testString.length()-1; i++) {
			if (testString.charAt(i) == ' ') {
				i++;
			}
			char testChar = testString.charAt(i);
			if (testString.substring(i+1).indexOf(testChar) >= 0) {
				return false;
			}
		}
		return true;
	}
}