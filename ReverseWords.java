import java.util.Scanner;

/**
 * Simple class that reverses the words in a String.
 * Runs in linear time as of version 2.
 * @Author Chase Lirette
 * @Version 8/6/17 
 */
public class ReverseWords {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string to be reversed.");
		String inputString = "";
		inputString = input.nextLine().trim();
		System.out.println(reverseString(inputString));
	}

	public static String reverseString(String testString) {
		StringBuilder sb = new StringBuilder();
		int end = testString.length() - 1;
		int chars = 0;
		int spaceOffset = 0;
		for (int i=end; i>=0; i--) {
			if (testString.charAt(i) == ' ') {
				spaceOffset++;
				if (testString.charAt(i-1) == ' ') {
					continue;
				}
				sb.append(testString.substring(i+spaceOffset, i+spaceOffset+chars));
				sb.append(' ');
				chars = 0;
				spaceOffset = 0;
			} else {
				chars++;
			}
		}
		sb.append(testString.substring(0, chars));
		return sb.toString();
	}
}