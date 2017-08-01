import java.util.Scanner;

/**
 * A solution to the 2016 ACM ICPC Southeast USA Regional Programming Contest
 * problem: Gravity. Reads in a .txt file containing grid data to simulate
 * an apple falling provided there are no obstacles. Produces a new grid
 * after the apples have fallen.
 *
 * @Author Chase Lirette
 * @Version 8/1/17
 */
public class Gravity {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] vars = input.nextLine().split(" ");
		int rows = Integer.parseInt(vars[0]);
		int columns = Integer.parseInt(vars[1]);
		char[] characters = getCharArray(rows, input);
		char[] result = dropApples(columns, rows, characters);
		printArray(result, columns);
	}

	/**
	 * Takes in the lines following line 1 of the .txt file
	 * as grid data. Returns a char array representation.
	 * @param rows The number of rows of grid data given in line 1.
	 * @param input The Scanner object ready to read after line 1.
	 * @return Char array representation of the grid.
	 */
	public static char[] getCharArray(int rows, Scanner input) {
		String lines = "";
		for (int i = 1; i <= rows; i++) {
			lines += input.nextLine();
		}
		return lines.toCharArray();
	}

	/**
	 * Produces the resulting char array after the apples fall. This is done by
	 * evaluating each character in the last row and traversing upwards.
	 * @param columns The number of columns in the grid. This is necessary to help
	 *                redraw the apples in the resulting grid, as well as setup terminating
	 *                parameters for the for loops.
	 * @param rows The number of rows in the grid. Used only to limit outer for loop to the last
	 *             row of the grid.
	 * @param chars The original char array of the grid data.
	 * @return The resulting char array after the apples have fallen.
	 */
	public static char[] dropApples(int columns, int rows, char[] chars) {
		char[] droppedApples = chars;
		char apple = 'o';
		char obstacle = '#';
		char air = '.';
		for (int i = chars.length - 1; i >= ((rows * columns) - columns); i--) {
			int stepsToMove = 0;
			for (int j = i; j >= 0; j -= columns) {
				if (chars[j] == obstacle) {
					stepsToMove = 0;
					droppedApples[j] = obstacle;
				} else if (chars[j] == air) {
					stepsToMove++;
					droppedApples[j] = air;
				} else if (chars[j] == apple) {
					if (stepsToMove > 0) {
						droppedApples[j + (stepsToMove * columns)] = apple;
						droppedApples[j] = air;
					}
				}
			}
		}
		return droppedApples;
	}

	/**
	 * Prints the array with respect to its rows and columns.
	 * @param arr The resulting array.
	 * @param row Necessary for new line print formatting.
	 */
	public static void printArray(char[] arr, int row) {
		for (int i=0; i<arr.length; i++) {
			if (i % row == 0 && i != 0) {
				System.out.println();
			}
			System.out.print(arr[i]);
		}
		System.out.println();
	}
}