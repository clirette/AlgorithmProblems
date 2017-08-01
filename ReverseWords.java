import java.util.Scanner;

/**
 * Simple class that reverses the words in a String.
 * @Author Chase Lirette
 * @Version 4/15/17
 */
public class ReverseWords {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		System.out.println("Enter a string to be reversed.");
		String testString = "";
		testString = input.nextLine();
		int end = testString.length() - 1;
		int start = end;
		for (int i = testString.length() - 1; i >= 0; i--){
			if (testString.charAt(i) == ' ' || i == 0) {
				if (i == 0) {
					start = i;
				} else {
					start = i + 1;
				}
				for (int j = start; j <= end; j++){
					sb.append(testString.charAt(j));
				}
				if (i != 0) {
					sb.append(" ");
				}
				end = i-1;
			}
		}
		System.out.println(sb.toString());
	}
}