/**
 * A solution to Cracking The Coding Interview problem 1.2 - Check Permutation.
 * Takes in two Strings as command line arguments and returns true if one is
 * a permutation of the other. This is done by creating a char array of one
 * String and a StringBuilder object of the other. The StringBuilder removes
 * each character found in the char array, and if the StringBuilder has length
 * 0 it must be an Anagram.
 * @Author Chase Lirette
 * @Version 5/15/17
 */
public class Anagram {
	//Usage: java Anagram string1 string2
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Enter Strings as command line args");
			System.exit(1);
		}
		System.out.println(isAnAnagram(args[0], args[1]));
	}

	/**
	 * Initially checks the length of the two Strings and returns false
	 * if differ. Then passes off the Strings to helper methods.
	 * @param string1 The first String to consider.
	 * @param string2 The second String to consider.
	 * @return True if the Strings are anagrams, false otherwise.
	 */
	public static boolean isAnAnagram(String string1, String string2) {
		if(string1.length() != string2.length()) {
			return false;
		}
		StringBuilder sb = new StringBuilder(string2);
		char[] string1Array = string1.toLowerCase().toCharArray();
		int stringLength = getStringLength(sb, string1Array);
		return checkLength(stringLength);
	}

	/**
	 * Gets the length of a resulting String by creating a
	 * StringBuilder object of one String, then removing matching
	 * characters between the two Strings.
	 * @param sb The StringBuilder to delete matching chars from.
	 * @param string1Array The char array to iterate through.
	 * @return The length of the StringBuilder after all matching
	 * chars have been removed.
	 */
	public static int getStringLength(StringBuilder sb, char[] string1Array) {
		for (int i=0; i<string1Array.length; i++) {
			for (int j=0; j<sb.length(); j++) {
				if(string1Array[i] == sb.charAt(j)) {
					sb.deleteCharAt(j);
				}
			}
		}
		return sb.length();
	}

	/**
	 * Checks the StringBuilder length.
	 * @param stringLength The length of the StringBuilder.
	 * @return If it is nonzero, return false. Return true otherwise.
	 */
	public static boolean checkLength(int stringLength) {
		if(stringLength > 0) {
			return false;
		} else {
			return true;
		}
	}
}
