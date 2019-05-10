import java.util.Arrays;

/**
 * Class that contains a static method to preform merge sort on an int array
 *
 * @author     Theodore Preduta
 * @author     Larry Yuan
 *
 * @version    1, 2019-04-08
 */
public class Merge
{
	/**
	 * Function that sors an array of integers
	 *
	 * @param      target  The target array to be sorted by the function
	 *
	 * @return     A sorted version of the array that is passed to the function
	 */
	public static int[] sortInt(int[] target)
	{
		// base case for when the arrays are of length 1
		if (target.length == 1) return target;
		// create two copies of the array
		int[] lowerTarget = Arrays.copyOfRange(target, 0, target.length / 2);
		int[] upperTarget = Arrays.copyOfRange(target, target.length / 2, target.length);
		lowerTarget = sortInt(lowerTarget);
		upperTarget = sortInt(upperTarget);
		// merge the two arrays
		int[] endArray = new int[target.length]; // array that will be returned
		int endArrayPointer = 0, lowerTargetPointer = 0, upperTargetPointer = 0; // the positions that have been filled
		while (endArrayPointer < endArray.length)
			if (lowerTargetPointer == lowerTarget.length)
				endArray[endArrayPointer++] = upperTarget[upperTargetPointer++];
			else if (upperTargetPointer == upperTarget.length)
				endArray[endArrayPointer++] = lowerTarget[lowerTargetPointer++];
			else if (lowerTarget[lowerTargetPointer] < upperTarget[upperTargetPointer])
				endArray[endArrayPointer++] = lowerTarget[lowerTargetPointer++];
			else
				endArray[endArrayPointer++] = upperTarget[upperTargetPointer++];
		return endArray;
	}
}