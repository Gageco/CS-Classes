import java.util.Scanner;

/**
 * Lesson 9: Activity
 * 
 * @author CS121 Instructors
 * @version Fall 2018
 */
public class StringComparison
{
	public static void main(String[] args)
	{
		final String CODE_WORD = "peanut";
		
		// Compare constant to variable with the same value
		String myWord = "peanut";
		//At line 17 CODE_WORD and myWord is equal to peanut, id=17
 		if(CODE_WORD == myWord)
		{
			System.out.println("Access granted!");
		}
		else
		{
			System.out.println("Access denied!");
		}
		//3) It doesn't go into the else statement, because it has already finished the first 'if' part
		// Now use scanner to read the same word from the user and compare
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the code word: ");
		String input = scan.nextLine();
		//6)The value of CODE_WORD, myWord, and input are all "peanut", though input has an id of 36
		if(input.equals(CODE_WORD))
		{
			System.out.println("Access granted!");
		}
		else
		{
			System.out.println("Access denied!");
		}
		//7) It goes into the else block because input and CODE_WORD are all different
		//9) After changed line 33 with a .equals() call it works, accurately comparing the code word
		scan.close();
	}
}