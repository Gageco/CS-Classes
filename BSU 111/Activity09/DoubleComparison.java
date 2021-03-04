/**
 * Lesson 9: Activity
 * 
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class DoubleComparison
{
	public static void main(String[] args)
	{
		final double TOLERANCE = 0.0000000000000001;
		double result = 1.0 - 0.9;
		double expected = 0.1;
		
		//The result variable is 0.09999999999999998, they aren't the same because doubles can be a little tricky when storing short values
		if(Math.abs(result - expected) < TOLERANCE)
		{
			System.out.println("They are equal!");
		}
		else
		{
			System.out.println("They are not equal.");
		}
		//4) It goes into the else statement because they are not exactly the same
	}
}