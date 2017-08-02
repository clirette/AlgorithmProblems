/**
 * A solution to Cracking The Coding Interview problem
 * 1.6 - String Compression. Counts repeating characters
 * in a String and places the count after the first occurence
 * of the character.
 * @Author Chase Lirette
 * @Version 8/1/17
 */
public class StringCompression {
    //Requires test String as a command line arg
	public static void main(String[] args) {
		if (args.length != 1) {
            System.out.println("Requires test String as a command line argument.");
            System.exit(1);
        }
        String testString = args[0];
        System.out.println(compress(testString));
	}

    /**
     * Compresses a String to show the number of repeated characters.
     * @param input The String to compress.
     * @return The resulting String or the input String - whichever is
     * shorter in length.
     */
	public static String compress(String input) {
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		for (int i=0; i<input.length()-1; i += counter) {
			counter = 1;
			for (int j=i+1; j<input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					counter++;
				}
			}
			sb.append(input.charAt(i));
			sb.append(counter);
		}
		String resultString = sb.toString();
		if (resultString.length() < input.length()) {
			return resultString;
		} else {
			return input;
		}
	}
}