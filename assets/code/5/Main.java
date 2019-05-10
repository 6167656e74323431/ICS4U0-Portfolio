import java.io.*;
import java.util.*;
import java.nio.file.*;

/**
 * Class to test our merge sort implementation
 *
 * @author     Theodore Preduta
 * @author     Larry Yuan
 *
 * @version    1, 2019-04-08
 */
public class Main 
{
	public static String IN_FILE_NAME = "./Array.data";
	public static String OUT_FILE_NAME = "./Sorted.txt";

	/**
	 * Main function to test our implementation of merge sort using data from
	 * Array.data
	 *
	 * @param      args                    The commandline arguments (not used)
	 *
	 * @throws     IOException             If the file in the IN_FILE_NAME
	 *                                     constant is not found, or if there is
	 *                                     an error writing to OUT_FILE_NAME
	 * @throws     InputMismatchException  If the scanner reads a non integer
	 *                                     value from the file
	 */
	public static void main(String[] args) throws IOException, InputMismatchException
	{
		int numberOfLines = (int)Files.lines(Paths.get(IN_FILE_NAME)).count(); // NOTE: this is java 8+ only
		int[] arr = new int[numberOfLines]; 
		Scanner inStream = new Scanner(new File(IN_FILE_NAME));
		for (int i = 0; i < numberOfLines; i++)
			arr[i] = inStream.nextInt();
		inStream.close();

		arr = Merge.sortInt(arr); // sort array

		PrintWriter outStream = new PrintWriter(new FileWriter(OUT_FILE_NAME));
		for (int i : arr)
			outStream.println(i);
		outStream.close();
	}
}