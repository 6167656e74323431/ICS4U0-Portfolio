import java.io.*;
import java.util.*;
import java.awt.Point;

/**
 * Class to answer recursion Application 3, Question 4
 *
 * @author     Theodore Predua
 *
 * @version    1, 2019-04-15
 */
public class EscapeMaze
{
	/**
	 * Recursive search algorithm to find the exit of a given maze
	 *
	 * @param      maze             The maze as a 2d array of 1s and 0s
	 * @param      currentPosition  The current position to check
	 *
	 * @return     true if there is a path from the start to the end, false
	 *             otherwise
	 */
	public static boolean traverseMaze(int[][] maze, Point currentPosition)
	{
		try
		{
			if (maze[currentPosition.y][currentPosition.x] == 1) // if the current space is a wall
				return false;
			if (currentPosition.y == maze.length - 1 || currentPosition.x == maze.length - 1) // if the current square is an exit square
				return true;

			maze[currentPosition.y][currentPosition.x] = 1; // set this position to a wall to prevent infinite loops and rechecking the same path multiple times
			// travel in the four possible directions
			return traverseMaze(maze, new Point(currentPosition.x + 1, currentPosition.y)) ||
					traverseMaze(maze, new Point(currentPosition.x - 1, currentPosition.y)) ||
					traverseMaze(maze, new Point(currentPosition.x, currentPosition.y + 1)) ||
					traverseMaze(maze, new Point(currentPosition.x, currentPosition.y - 1));
		}
		catch (ArrayIndexOutOfBoundsException e) // catch when the attempt to traverse is oustide the array (ie negative indicies)
		{
			maze[currentPosition.y][currentPosition.x] = 1; // set this position to a wall to prevent infinite loops and rechecking the same path multiple times
			return false;
		}
	}

	/**
	 * Overloaded method to run the recursive solution. This version finds the
	 * starting points of the maze
	 *
	 * @param      maze  The maze as a 2d array of 1s and 0s
	 *
	 * @return     true if there is a path from the start to the end, false
	 *             otherwise
	 */
	public static boolean traverseMaze(int[][] maze)
	{
		boolean result = false;
		for (int i = 0; i < maze[0].length; i++) // horizontal entrances
			if (result) // end recursion if a path is found
				break;
			else if (maze[0][i] == 0) // if this is an entrance call the traverse maze funciton
				result |= traverseMaze(maze, new Point(i, 0));

		for (int i = 0; i < maze.length; i++) // vertical entrances
			if (result) // end recursion if a path is found
				break;
			else if (maze[i][0] == 0) // if this is an entrance call the traverse maze funciton
				result |= traverseMaze(maze, new Point(0, i));

		return result;
	}

	/**
	 * Main function to test the recursive function
	 *
	 * @param      args  The commandline arguments (not used)
	 */
	public static void main(String[] args)
	{
		int[][] maze = {{1, 1, 1, 0, 1}, 	// XXX.X
						{0, 0, 0, 1, 1}, 	// ...XX
						{1, 0, 1, 0, 1}, 	// X.X.X
						{0, 1, 0, 0, 1},	// .X..X
						{1, 1, 1, 0, 1}}; 	// XXX.X
		System.out.println(traverseMaze(maze));
		
	}
}